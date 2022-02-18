package com.example.Liv2Train;

import com.example.Liv2Train.entities.AddressEntity;
import com.example.Liv2Train.entities.TrainingCenterEntity;
import com.example.Liv2Train.repositories.AddressRepository;
import com.example.Liv2Train.repositories.TrainingCenterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@Slf4j
public class Liv2TrainApplication {

	@Autowired
	private TrainingCenterRepository trainingCenterRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(Liv2TrainApplication.class, args);
	}

}
