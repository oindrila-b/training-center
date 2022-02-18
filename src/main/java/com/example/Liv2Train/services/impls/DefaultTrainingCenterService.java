package com.example.Liv2Train.services.impls;

import com.example.Liv2Train.entities.AddressEntity;
import com.example.Liv2Train.entities.TrainingCenterEntity;
import com.example.Liv2Train.models.TrainingCenter;
import com.example.Liv2Train.repositories.AddressRepository;
import com.example.Liv2Train.repositories.TrainingCenterRepository;
import com.example.Liv2Train.services.TrainingCenterService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class DefaultTrainingCenterService implements TrainingCenterService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    private void init() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();
    }

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    public TrainingCenter createTrainingCenter(final TrainingCenter trainingCenter) {
        log.info("TC: {}", trainingCenter);
        TrainingCenterEntity trainingCenterEntity = objectMapper.convertValue(trainingCenter, TrainingCenterEntity.class);
        trainingCenterEntity.setCreatedOn(LocalDateTime.now());
        trainingCenterEntity = trainingCenterRepository.save(trainingCenterEntity);

        AddressEntity addressEntity = objectMapper.convertValue(trainingCenter.getAddress(), AddressEntity.class);
        addressEntity.setTrainingCenter(trainingCenterEntity);
        addressEntity.setCreatedOn(LocalDateTime.now());
        addressEntity = addressRepository.save(addressEntity);

        final TrainingCenterEntity tc = trainingCenterRepository.getById(trainingCenterEntity.getId());
        return objectMapper.convertValue(tc, TrainingCenter.class);
    }

    @Override
    public List<TrainingCenter> getAll() {
        log.info("Getting All..");
        final List<TrainingCenter> trainingCenters = new ArrayList<>();
        trainingCenterRepository.findAll().forEach((tc) -> {
            log.info("TC: {}", tc);
            final TrainingCenter t = objectMapper.convertValue(tc, TrainingCenter.class);
            trainingCenters.add(t);
        });
        log.info("Retrieved All: {}", trainingCenters);
        return trainingCenters;
    }
}
