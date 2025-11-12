package com.email_template_engine.model;

import java.util.Locale;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TemplateContext {
    private String templateName;
    private TemplateType templateType;
    private String locale;
    private Map<String, Object> variables;

    public Locale getLocaleObject() {
        if(locale == null || locale.isEmpty()) {
            return Locale.ENGLISH;
        }

        String[] parts=locale.split("_");
        if(parts.length==1) {
            return new Locale(parts[0]);

        } else if(parts.length==2) {
            return new Locale(parts[0],parts[1]);
        }
        return Locale.ENGLISH;
    }
}
