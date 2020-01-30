package com.monitorgps.service.sendgauss.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name = "tb_alerta_activa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AlertaActivaEntity implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_alerta_activa_id_alerta_activa_seq")
    @Column(name = "id_alerta_activa")
    private Long id;

    @Column(name = "fec_inicio_rec")
    private Date fecinicio;

    @Column(name = "fec_actualiza_rec")
    private Date fecact;

    @Column(name = "fec_registro")
    private Date fecreg;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private VehiculoEntity vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_recorrido")
    private RecorridoEntity recorrido;

    @ManyToOne
    @JoinColumn(name = "id_alerta")
    private AlertaEntity alerta;

    @Column(name = "valor_alerta")
    private Double valor;

    @Column(name = "fec_envio_gauss")
    private Date fecenvgauss;
}
