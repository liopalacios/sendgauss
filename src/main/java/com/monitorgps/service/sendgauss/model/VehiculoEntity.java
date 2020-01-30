package com.monitorgps.service.sendgauss.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tb_vehiculo")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoEntity implements Serializable {
    private static final long serialVersionUID = 5L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "tb_vehiculo_id_vehiculo_seq")
    @Column(name = "id_vehiculo")
    private Long id;

    @Column(name = "num_placa")
    private String placa;
}
