package com.monitorgps.service.sendgauss.service;

import com.monitorgps.service.sendgauss.bean.ListResponseGauss;

import java.util.Date;

public interface GaussService {

    ListResponseGauss sendEvents(Date inicio, Date fin);
}
