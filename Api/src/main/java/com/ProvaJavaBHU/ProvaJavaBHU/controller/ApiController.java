package com.ProvaJavaBHU.ProvaJavaBHU.controller;

import com.ProvaJavaBHU.ProvaJavaBHU.DTO.MensagenNewCarDTO;
import com.ProvaJavaBHU.ProvaJavaBHU.model.CarModel;
import com.ProvaJavaBHU.ProvaJavaBHU.model.LogCarModel;
import com.ProvaJavaBHU.ProvaJavaBHU.repository.LogCarRepository;
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
    private ModelMapper modelMapper;

    @Autowired
    private LogCarRepository logCarRepository;

    @Value("${urlApiExterna}")
    String urlApiExterna;

    @Value("${qeueNewCar}")
    String qeueNewCar;


    @GetMapping ("/listCars")
    public ResponseEntity<List<CarModel>> getallcars(){
        RestTemplate restTemplate= new RestTemplate();
        var listcar = restTemplate.getForEntity(urlApiExterna,CarModel[].class).getBody();
        return ResponseEntity.ok(Arrays.asList(listcar));
    }

    @GetMapping ("/logs")
    public ResponseEntity<List<LogCarModel>> getalllogs(){
        return ResponseEntity.ok(logCarRepository.findAll());
    }

    @PostMapping("/createCar")
    public ResponseEntity <CarModel> postCreateCar (@RequestBody CarModel car){

        RestTemplate restTemplate= new RestTemplate();

        logCarRepository.save(new LogCarModel(LocalDateTime.now(),car.get_id()));

        MensagenNewCarDTO mensagenNewCarDTO = modelMapper.map(car,MensagenNewCarDTO.class);

        mensagenService.enviaMensagem(qeueNewCar,mensagenNewCarDTO.toString());
        
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(restTemplate.postForObject(urlApiExterna,car,CarModel.class));
    }

    @PostMapping("/teste")
    public ResponseEntity<MensagenNewCarDTO> postCreateCar (@RequestBody MensagenNewCarDTO mensagem) {
        mensagenService.enviaMensagem(qeueNewCar,mensagem.toString());
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
    }






}
