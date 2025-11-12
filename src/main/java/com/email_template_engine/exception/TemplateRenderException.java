package com.email_template_engine.exception;

public class TemplateRenderException extends RuntimeException{
    public TemplateRenderException(String message) {
        super(message);
    }

    public TemplateRenderException(String message, Throwable cause){
        super(message, cause);
    }
}
