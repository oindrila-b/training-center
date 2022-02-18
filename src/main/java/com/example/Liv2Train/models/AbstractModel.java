package com.example.Liv2Train.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class AbstractModel {

    private Long id;
    private LocalDateTime createdOn;
}
