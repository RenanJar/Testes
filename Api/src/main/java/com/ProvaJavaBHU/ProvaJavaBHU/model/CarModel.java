package com.ProvaJavaBHU.ProvaJavaBHU.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
public class CarModel {
    @Id
    private String _id;

    private String title;

    private String brand;

    private String price;

    private Long age;

    private Long __v;

    @Override
    public String toString() {
        return "CarModel{" +
                "_id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", age=" + age +
                ", __v=" + __v +
                '}';
    }
}
