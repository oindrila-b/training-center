package com.example.Liv2Train.controllers;

import com.example.Liv2Train.exceptionhandlers.GlobalExceptionHandler;
import com.example.Liv2Train.models.TrainingCenter;
import com.example.Liv2Train.services.TrainingCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registration")
@Slf4j
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping
    public ResponseEntity<TrainingCenter> create(@Validated @RequestBody final TrainingCenter trainingCenter)  throws Exception{
        log.info("Received Training Center Req: {}", trainingCenter);
        final TrainingCenter tc = trainingCenterService.createTrainingCenter(trainingCenter);
        log.info("Created Training Center: {}", trainingCenter);
        return ResponseEntity.ok(tc);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAll() {
        return ResponseEntity.ok(trainingCenterService.getAll());
    }
}
