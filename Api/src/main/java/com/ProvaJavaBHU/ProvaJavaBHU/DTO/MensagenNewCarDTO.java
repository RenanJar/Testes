package com.ProvaJavaBHU.ProvaJavaBHU.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MensagenNewCarDTO implements Serializable{

    private String _id;

    private String title;

    private String brand;

    private String price;

    private Long age;

    private Long __v;

    @Override
    public String toString() {
        return "MensagenNewCarDTO{" +
                ", title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", age=" + age +
                '}';
    }

}
