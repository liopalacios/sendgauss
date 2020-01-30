package com.monitorgps.service.sendgauss.scheduler;

import com.monitorgps.service.sendgauss.service.GaussService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Configuration
@Slf4j
public class Scheduler {
    @Autowired
    GaussService gaussService;

    @Scheduled(cron = "${sendtracklog.scheduler.cron.sendEvent}" )
    public void sendEventTracklogs(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        Calendar inicio = Calendar.getInstance();
        cal.setTime(new Date());
        inicio.setTime(new Date());
        System.out.println(cal.getTime());
        cal.set(Calendar.MINUTE,cal.get(Calendar.MINUTE)-1);
        inicio.set(Calendar.HOUR,inicio.get(Calendar.HOUR)-6);
        System.out.println(cal.getTime());
        System.out.println(dateFormat.format(cal.getTime()));
        //gaussService.sendEvents();
        gaussService.sendEvents(inicio.getTime(),cal.getTime());
        //tracklogService.sendTracklog();

    }
}
