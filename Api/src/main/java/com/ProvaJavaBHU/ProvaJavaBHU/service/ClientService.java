package com.ProvaJavaBHU.ProvaJavaBHU.service;

import com.ProvaJavaBHU.ProvaJavaBHU.model.CarModel;
import com.ProvaJavaBHU.ProvaJavaBHU.model.LogCarModel;
import com.ProvaJavaBHU.ProvaJavaBHU.repository.LogCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private LogCarRepository logCarRepository;

    @Value("${urlApiExterna}")
    String urlApiExterna;

    public List<CarModel> getallCars(){
        RestTemplate restTemplate= new RestTemplate();

        var listcar = restTemplate.getForEntity(urlApiExterna,CarModel[].class).getBody();

        return Arrays.asList(listcar);
    }

    public CarModel createCar(CarModel carModel){
        RestTemplate restTemplate= new RestTemplate();

        CarModel request = restTemplate.postForObject(urlApiExterna,carModel,CarModel.class);

        return request;
    }

    public List<LogCarModel> getallLogs(){
        return logCarRepository.findAll();
    }



}
