package com.monitorgps.service.sendgauss.repository;

import com.monitorgps.service.sendgauss.model.AlertaActivaEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AlertaActivaRepository extends JpaRepository<AlertaActivaEntity,Long> {
    @Query(value = "select a.fecinicio,a.fecact,a.vehiculo.placa,r.idchofer,al.descripcion," +
            "r.latitud,r.longitud,r.altitud, al.unidad,a.valor, " +
            "r.velocidad,a.id " +
            "from AlertaActivaEntity a " +
            "left join a.recorrido r " +
            "left join a.alerta al " +
            "where a.fecreg >= :horaant and a.fecreg <= :horaact and a.fecenvgauss=null")
    List<Object[]> getListEventsByMinute(@Param("horaant") Date horaant, @Param("horaact") Date horaact);

    List<AlertaActivaEntity> findAllByFecenvgaussAndFecregBetween(Object o, Date horaant, Date horaact, Pageable pageable);
}