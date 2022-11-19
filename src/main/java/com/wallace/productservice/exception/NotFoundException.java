package com.wallace.productservice.exception;

public class NotFoundException extends RuntimeException{
    private static final long serialVersionUID = -290561548031344451L;

    public NotFoundException(String message) {
        super(message);
    }
}
