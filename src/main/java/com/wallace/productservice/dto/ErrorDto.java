package com.wallace.productservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class ErrorDto {
    private final int status;
    private final String message;
}
