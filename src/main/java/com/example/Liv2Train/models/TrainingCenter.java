package com.example.Liv2Train.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TrainingCenter extends AbstractModel {

    @NotNull(message = "centerName cannot be null")
    @NotEmpty(message = "centerName cannot be empty")
    @NotBlank(message = "centerName cannot be blank")
    @Size(max = 40)
    private String centerName;

    @NotNull(message = "centerCode cannot be null")
    @NotEmpty(message = "centerCode cannot be empty")
    @NotBlank(message = "centerCode cannot be blank")
    @Size(max = 12)
    private String centerCode;

    private Integer studentCapacity;

    private List<String> coursesOffered;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    private  String centerEmail;

    @NotNull(message = "phone cannot be null")
    @NotEmpty(message = "phone cannot be empty")
    @NotBlank(message = "phone cannot be blank")
     private String centerPhone;

    @NotNull(message = "Address cannot be null")
    private Address address;
}
