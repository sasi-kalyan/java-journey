package io.mvc.pattern.demo.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorModel {

    private String code;
    private String message;

}
