package com.monitorgps.service.sendgauss.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tb_alerta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AlertaEntity implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "tb_alerta_id_alerta_seq")
    @Column(name = "id_alerta")
    private Long id;

    @Column(name = "des_alerta")
    private String descripcion;

    @Column(name = "unidad_alerta")
    private String unidad;

}
