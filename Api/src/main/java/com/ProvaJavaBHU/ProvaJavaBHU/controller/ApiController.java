package com.ProvaJavaBHU.ProvaJavaBHU.controller;

import com.ProvaJavaBHU.ProvaJavaBHU.DTO.MensagenNewCarDTO;
import com.ProvaJavaBHU.ProvaJavaBHU.model.CarModel;
import com.ProvaJavaBHU.ProvaJavaBHU.model.LogCarModel;
import com.ProvaJavaBHU.ProvaJavaBHU.repository.LogCarRepository;
import com.ProvaJavaBHU.ProvaJavaBHU.service.ClientService;
import com.ProvaJavaBHU.ProvaJavaBHU.service.MensagenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {


    @Autowired
    MensagenService mensagenService;

    @Autowired
    LogCarRepository logCarRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClientService clientService;

    @Value("${qeueNewCar}")
    String qeueNewCar;

    @GetMapping ("/listCars")
    public ResponseEntity<List<CarModel>> getallcars(){
        return ResponseEntity.ok(clientService.getallCars());
    }

    @GetMapping ("/logs")
    public ResponseEntity<List<LogCarModel>> getalllogs(){
        return ResponseEntity.ok(clientService.getallLogs());
    }

    @PostMapping("/createCar")
    public ResponseEntity <CarModel> postCreateCar (@RequestBody CarModel car){

        CarModel request = clientService.createCar(car);

        logCarRepository.save(new LogCarModel(LocalDateTime.now(),request.get_id()));

        MensagenNewCarDTO mensagenNewCarDTO = modelMapper.map(car,MensagenNewCarDTO.class);

        mensagenService.enviaMensagem(qeueNewCar,mensagenNewCarDTO.toString());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }


}
