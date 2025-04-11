package ru.pas.zhukov.thinkpadnavigator.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Generation;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Model;

import java.util.Objects;

import static ru.pas.zhukov.thinkpadnavigator.common.Constant.LENOVO_THINKPAD;

@UtilityClass
public class FullNameUtils {

    public static String buildModelFullName(Model model) {
        final StringBuilder fullNameBuilder = new StringBuilder();
        fullNameBuilder.append(LENOVO_THINKPAD);
        fullNameBuilder.append(StringUtils.SPACE);
        fullNameBuilder.append(model.getModelSeries());
        if (model.getModelNumber() != null) {
            fullNameBuilder.append(model.getModelNumber());
        }
        if (model.getModelName() != null) {
            fullNameBuilder.append(StringUtils.SPACE);
            fullNameBuilder.append(model.getModelName());
        }
        return fullNameBuilder.toString();
    }

    public static String buildGenerationFullName(Generation generation) {
        final StringBuilder fullNameBuilder = new StringBuilder();
        fullNameBuilder.append(LENOVO_THINKPAD);
        fullNameBuilder.append(StringUtils.SPACE);
        fullNameBuilder.append(generation.getModel().getModelSeries());
        if (generation.getModel().getModelNumber() != null) {
            fullNameBuilder.append(generation.getModel().getModelNumber());
        }
        if (Objects.equals(generation.getGenerationType(), "old")) {
            fullNameBuilder.append(generation.getGenerationNumber());
        }
        if (generation.getPostfix() != null) {
            fullNameBuilder.append(generation.getPostfix());
        }
        if (generation.getModel().getModelName() != null) {
            fullNameBuilder.append(StringUtils.SPACE);
            fullNameBuilder.append(generation.getModel().getModelName());
        }
        if (Objects.equals(generation.getGenerationType(), "new")) {
            fullNameBuilder.append(StringUtils.SPACE);
            fullNameBuilder.append("Gen");
            fullNameBuilder.append(StringUtils.SPACE);
            fullNameBuilder.append(generation.getGenerationNumber());
        }
        return fullNameBuilder.toString();
    }
}
