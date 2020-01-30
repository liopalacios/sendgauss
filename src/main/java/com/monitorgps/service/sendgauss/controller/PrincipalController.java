package com.monitorgps.service.sendgauss.controller;

import com.monitorgps.service.sendgauss.bean.ListResponseGauss;
import com.monitorgps.service.sendgauss.service.GaussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PrincipalController {

    @Autowired
    GaussService gaussService;

    @RequestMapping(value = {"/sendTracklog"}, method = RequestMethod.GET)
    public ListResponseGauss sendGauss(){
        return null;
    }

}
