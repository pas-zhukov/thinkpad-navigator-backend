package ru.pas.zhukov.thinkpadnavigator.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Model;

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
}
