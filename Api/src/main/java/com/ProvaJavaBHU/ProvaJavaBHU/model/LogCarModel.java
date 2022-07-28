package com.ProvaJavaBHU.ProvaJavaBHU.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class LogCarModel {

    @Id
    private String id;
    private LocalDateTime data_hora;
    private String car_id;

    public LogCarModel() {
    }

    public LogCarModel(String id, LocalDateTime data_hora, String car_id) {
        this.id = id;
        this.data_hora = data_hora;
        this.car_id = car_id;
    }
    public LogCarModel( LocalDateTime data_hora,String car_id) {
        this.data_hora = data_hora;
        this.car_id = car_id;
    }

}
