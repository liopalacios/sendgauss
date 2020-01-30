package com.monitorgps.service.sendgauss.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListResponseGauss {
    private List<ResponseGauss> Recibidos;
}
