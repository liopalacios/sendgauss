package com.monitorgps.service.sendgauss.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGauss {
    private String response;
    private String timestamp;
    private String message;
    private String error;
}
