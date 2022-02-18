package com.example.Liv2Train.repositories;

import com.example.Liv2Train.entities.TrainingCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenterEntity, Long> {
}
