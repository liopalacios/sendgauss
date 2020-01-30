package com.monitorgps.service.sendgauss.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListRequestGauss {
    private List<RequestGauss> items;
}
