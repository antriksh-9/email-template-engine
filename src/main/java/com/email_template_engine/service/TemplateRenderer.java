package com.email_template_engine.service;

import com.email_template_engine.model.TemplateContext;

public interface TemplateRenderer {
    String render(TemplateContext context);
    boolean supports(TemplateContext context);
}
