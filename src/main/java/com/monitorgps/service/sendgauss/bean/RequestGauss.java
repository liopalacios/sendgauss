package com.monitorgps.service.sendgauss.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestGauss {
    private String start;
    private String end;
    private String vehicleCode;
    private String driverCode;
    private String alertName;

    private Double latitude;
    private Double longitude;
    private Double altitude;
    private String metricUnit;
    private ItemRequest serializadMetadata;

    private Double value;
    private String externalUID;

    private String type;
    private String tags;

}
