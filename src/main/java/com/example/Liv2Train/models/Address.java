package com.example.Liv2Train.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Address  extends AbstractModel{

    @NotNull(message = "detailedAddress cannot be null")
    @NotEmpty(message = "detailedAddress cannot be empty")
    @NotBlank
    private String detailedAddress;

    @NotNull(message = "city cannot be null")
    @NotEmpty(message = "city cannot be empty")
    @NotBlank
    private String city;

    @NotNull(message = "state cannot be null")
    @NotEmpty(message = "state cannot be empty")
    @NotBlank
    private String state;

    @NotNull(message = "pincode cannot be null")
    @NotEmpty(message = "pincode cannot be empty")
    @NotBlank
    private String pinCode;
}
