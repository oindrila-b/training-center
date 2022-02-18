package com.example.Liv2Train.services;

import com.example.Liv2Train.models.TrainingCenter;

import java.util.List;

public interface TrainingCenterService {

    TrainingCenter createTrainingCenter(final TrainingCenter trainingCenter);
    List<TrainingCenter> getAll();
}
