package com.choimory.itemvaluechecker.api.itemapi.common.dto.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class CommonResponse<T> {
    @Builder.Default
    private final int status = 0;
    private final String message;
    @JsonUnwrapped
    private final T data;
}
