BEGIN;

-- Шаг 1: Создаем временную таблицу для групп дубликатов с учетом postfix
CREATE TEMP TABLE duplicate_groups AS
SELECT
    model_id,
    generation_number,
    LOWER(original_name) AS lower_name,
    postfix, -- Учитываем postfix
    MIN(id) AS main_id
FROM generation
GROUP BY -- Группируем по всем значимым полям, включая postfix
         model_id,
         generation_number,
         LOWER(original_name),
         postfix
HAVING COUNT(*) > 1;

-- Шаг 2: Создаем временную таблицу с дубликатами (учитываем postfix)
CREATE TEMP TABLE duplicates AS
SELECT
    g.id AS duplicate_id,
    dg.main_id
FROM generation g
         JOIN duplicate_groups dg
              ON g.model_id = dg.model_id
                  AND g.generation_number = dg.generation_number
                  AND LOWER(g.original_name) = dg.lower_name
                  AND g.postfix IS NOT DISTINCT FROM dg.postfix -- Сравнение с NULL
WHERE g.id != dg.main_id;

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