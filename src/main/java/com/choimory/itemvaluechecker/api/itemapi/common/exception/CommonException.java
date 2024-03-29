package com.choimory.itemvaluechecker.api.itemapi.common.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@RequiredArgsConstructor
public class CommonException extends RuntimeException {
    private final HttpStatus status;
    private final int code;
    private final String message;
}
