package ru.pas.zhukov.thinkpadnavigator.common;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class Constant {

    public static final String LENOVO = "Lenovo";

    public static final String THINKPAD = "ThinkPad";

    public static final String LENOVO_THINKPAD = LENOVO + StringUtils.SPACE + THINKPAD;
}
