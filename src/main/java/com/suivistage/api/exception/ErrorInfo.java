package com.suivistage.api.exception;

import java.util.List;

public record ErrorInfo(String code, String message, List<String> listErrors) {}
