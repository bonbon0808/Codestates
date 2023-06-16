package com.codestates.response;

import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class FieldError implements Error{
    private String field;
    private String rejectedValue;
    private String reason;

    private FieldError(String field, String rejectedValue, String reason) {
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.reason = reason;
    }

    public static List<Error> of(BindingResult bindingResult) {
        final List<org.springframework.validation.FieldError> fieldErrors =
                bindingResult.getFieldErrors();
        // TODO Convert 공통화
        return fieldErrors.stream()
                .map(error -> new FieldError(
                        error.getField(),
                        error.getRejectedValue() == null ?
                                "" : error.getRejectedValue().toString(),
                        error.getDefaultMessage()))
                .collect(Collectors.toList());
    }
}
