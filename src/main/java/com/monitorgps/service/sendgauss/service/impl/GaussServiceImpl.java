package com.monitorgps.service.sendgauss.service.impl;

import com.google.gson.Gson;
import com.monitorgps.service.sendgauss.bean.ItemRequest;
import com.monitorgps.service.sendgauss.bean.ListRequestGauss;
import com.monitorgps.service.sendgauss.bean.ListResponseGauss;
import com.monitorgps.service.sendgauss.bean.RequestGauss;
import com.monitorgps.service.sendgauss.model.AlertaActivaEntity;
import com.monitorgps.service.sendgauss.repository.AlertaActivaRepository;
import com.monitorgps.service.sendgauss.service.GaussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GaussServiceImpl implements GaussService {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    AlertaActivaRepository alertaActivaRepository;
    @Override
    public ListResponseGauss sendEvents(Date horaant, Date horaact) {
        Pageable pageable = PageRequest.of(0,300);
        final String uri_events = "http://testing.gausscontrol.com:8080/processor/events/tasktrigger/upload";
        List<AlertaActivaEntity>alertaActivaEntities = alertaActivaRepository
                .findAllByFecenvgaussAndFecregBetween(null,horaant,horaact,pageable);
        System.out.println(alertaActivaEntities.size());
        //List<Object[]> objects = alertaActivaRepository.getListEventsByMinute(horaant,horaact);
        //System.out.println(objects);
        List<RequestGauss> requestGausses = convertActivaEntity(alertaActivaEntities);
        RestTemplate restTemplate = new RestTemplate();
        //ListRequestGauss listRequestGauss = new ListRequestGauss(requestGausses);
        ResponseEntity<String> str = restTemplate.postForEntity(uri_events,requestGausses, String.class);

        Gson gson = new Gson();
        //ListResponseGauss listResponseGauss = gson.fromJson(str.getBody(),ListResponseGauss.class);
        /*if(str.getStatusCodeValue()==200){
            System.out.println("EL ENVIO FUE CORRECTO "+horaact+"  "+horaant);
            System.out.println(listResponseGauss);

        }*/
        return null;
    }

    private List<RequestGauss> convertActivaEntity(List<AlertaActivaEntity> alertaActivaEntities) {
        List<RequestGauss>requestGausses = new ArrayList<>();
        RequestGauss gauss = null;
        for (AlertaActivaEntity entity: alertaActivaEntities) {
            gauss = new RequestGauss();
            gauss.setStart(entity.getFecinicio().toString());
            gauss.setEnd(entity.getFecact().toString());
            gauss.setVehicleCode(entity.getVehiculo().getPlaca());
            gauss.setDriverCode(entity.getRecorrido().getIdchofer().toString());
            gauss.setAlertName(entity.getAlerta().getDescripcion());
            gauss.setLatitude(Double.parseDouble(entity.getRecorrido().getLatitud()));
            gauss.setLongitude(Double.parseDouble(entity.getRecorrido().getLongitud()));
            gauss.setAltitude(entity.getRecorrido().getAltitud());
            gauss.setMetricUnit(entity.getAlerta().getUnidad());
            gauss.setValue(entity.getValor());
            gauss.setExternalUID(entity.getId().toString());
            gauss.setSerializadMetadata(ItemRequest.builder().speed(entity.getRecorrido().getVelocidad()).build());
            requestGausses.add(gauss);
        }
        return requestGausses;
    }

    private List<RequestGauss> convertObjects(List<Object[]> objects) {
        List<RequestGauss> requestGausses = new ArrayList<>();
        RequestGauss requestGauss = null;
        for(Object[] obj : objects){
            System.out.println(obj);
            requestGauss = new RequestGauss();
            requestGauss.setStart(simpleDateFormat.format(obj[0]));
            requestGauss.setEnd(simpleDateFormat.format(obj[1]));
            requestGauss.setVehicleCode((String) obj[2]);
            requestGauss.setDriverCode((String)  obj[3].toString());
            requestGauss.setAlertName((String) obj[4]);
            requestGauss.setLatitude(Double.parseDouble(obj[5].toString()));
            requestGauss.setLongitude(Double.parseDouble(obj[6].toString()));
            requestGauss.setAltitude(Double.parseDouble(obj[7].toString()));
            requestGauss.setMetricUnit((String) obj[8]);
            requestGauss.setValue((Double) obj[9]);

            requestGauss.setSerializadMetadata(ItemRequest.builder().speed((Double)obj[10]).build());
            requestGauss.setExternalUID((String) obj[11].toString());

            requestGauss.setType("");
            requestGauss.setTags("");
            requestGausses.add(requestGauss);
        }
        return requestGausses;
    }
}
