package com.mvc.mvc_ohm.controller;


import com.mvc.mvc_ohm.dto.ResponseData;
import com.mvc.mvc_ohm.entity.DataCPUEntity;
import com.mvc.mvc_ohm.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpuapi")
public class SystemController {

    @Autowired
    SystemService service;


    @PostMapping("/insertdata")
    public ResponseEntity<ResponseData> SystemCpuMethod(@RequestBody DataCPUEntity dataCPUEntity){

        ResponseData responseData = service.insertData(dataCPUEnti ty);

        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @GetMapping("/getdata")
    public ResponseEntity<ResponseData> getData(){

        ResponseData responseData = service.getData();
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}
