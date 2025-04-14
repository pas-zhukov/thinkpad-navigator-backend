package ru.pas.zhukov.thinkpadnavigator.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import ru.pas.zhukov.thinkpadnavigator.common.model.GenerationType;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.GenerationEntity;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ModelEntity;

import java.util.Objects;

import static ru.pas.zhukov.thinkpadnavigator.common.Constant.LENOVO_THINKPAD;

@UtilityClass
public class FullNameUtils {

    public static String buildModelFullName(ModelEntity modelEntity) {
        final StringBuilder fullNameBuilder = new StringBuilder();
        fullNameBuilder.append(LENOVO_THINKPAD);
        fullNameBuilder.append(StringUtils.SPACE);
        fullNameBuilder.append(modelEntity.getSeries().getName());
        if (modelEntity.getModelNumber() != null) {
            fullNameBuilder.append(modelEntity.getModelNumber());
        }
        if (modelEntity.getModelName() != null) {
            fullNameBuilder.append(StringUtils.SPACE);
            fullNameBuilder.append(modelEntity.getModelName());
        }
        return fullNameBuilder.toString();
    }

    public static String buildGenerationFullName(GenerationEntity generationEntity) {
        final StringBuilder fullNameBuilder = new StringBuilder();
        fullNameBuilder.append(LENOVO_THINKPAD);
        fullNameBuilder.append(StringUtils.SPACE);
        fullNameBuilder.append(generationEntity.getModel().getSeries().getName());
        if (generationEntity.getModel().getModelNumber() != null) {
            fullNameBuilder.append(generationEntity.getModel().getModelNumber());
        }
        if (Objects.equals(generationEntity.getGenerationType(), GenerationType.OLD)) {
            fullNameBuilder.append(generationEntity.getGenerationNumber());
        }
        if (generationEntity.getPostfix() != null) {
            fullNameBuilder.append(generationEntity.getPostfix());
        }
        if (generationEntity.getModel().getModelName() != null) {
            fullNameBuilder.append(StringUtils.SPACE);
            fullNameBuilder.append(generationEntity.getModel().getModelName());
        }
        if (Objects.equals(generationEntity.getGenerationType(), GenerationType.NEW)) {
            fullNameBuilder.append(StringUtils.SPACE);
            fullNameBuilder.append("Gen");
            fullNameBuilder.append(StringUtils.SPACE);
            fullNameBuilder.append(generationEntity.getGenerationNumber());
        }
        return fullNameBuilder.toString();
    }

    public static String buildSeriesFullName(ModelEntity modelEntity) {
        final StringBuilder fullNameBuilder = new StringBuilder();
        fullNameBuilder.append(modelEntity.getSeries().getName());
        if (modelEntity.getModelNumber() != null) {
            fullNameBuilder.append(modelEntity.getModelNumber());
        }
        if (modelEntity.getGenerationType() == GenerationType.OLD) {
            fullNameBuilder.append("xx");
        }
        if (modelEntity.getModelName() != null) {
            fullNameBuilder.append(StringUtils.SPACE);
            fullNameBuilder.append(modelEntity.getModelName());
        }
        return fullNameBuilder.toString();
    }
}
