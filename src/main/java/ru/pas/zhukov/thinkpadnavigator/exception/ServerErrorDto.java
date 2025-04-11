package ru.pas.zhukov.thinkpadnavigator.exception;

import java.time.LocalDateTime;

public record ServerErrorDto(String message,
                             String detailedMessage,
                             LocalDateTime dateTime) {
}
