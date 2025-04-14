BEGIN;

-- Шаг 1: Создаем временную таблицу для групп дубликатов
CREATE TEMP TABLE duplicate_groups AS
SELECT
    model_id,
    generation_number,
    LOWER(original_name) AS lower_name,
    MIN(id) AS main_id
FROM generation
WHERE postfix IS NULL
GROUP BY
    model_id,
    generation_number,
    LOWER(original_name)
HAVING COUNT(*) > 1;

-- Шаг 2: Создаем временную таблицу с дубликатами
CREATE TEMP TABLE duplicates AS
SELECT
    g.id AS duplicate_id,
    dg.main_id
FROM generation g
         JOIN duplicate_groups dg
              ON g.model_id = dg.model_id
                  AND g.generation_number = dg.generation_number
                  AND LOWER(g.original_name) = dg.lower_name
WHERE
    g.postfix IS NULL
  AND g.id != dg.main_id;

-- Шаг 3: Обновляем ссылки в таблице configuration
UPDATE configuration
SET generation_id = d.main_id
FROM duplicates d
WHERE configuration.generation_id = d.duplicate_id;

-- Шаг 4: Удаляем дубликаты из generation
DELETE FROM generation
WHERE id IN (SELECT duplicate_id FROM duplicates);

COMMIT;

-- Очистка временных таблиц (опционально)
DROP TABLE IF EXISTS duplicate_groups, duplicates;
