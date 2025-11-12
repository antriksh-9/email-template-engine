package com.email_template_engine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailTemplate {
    private String subject;
    private String htmlContent;
    private String textContent;
    private String templateName;
    private String locale;
}
