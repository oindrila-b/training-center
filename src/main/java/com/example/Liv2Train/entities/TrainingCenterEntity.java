package com.example.Liv2Train.entities;

import com.example.Liv2Train.constants.EntityName;
import com.example.Liv2Train.constants.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity(name = EntityName.TRAINING_CENTER)
@Table(name = TableName.TRAINING_CENTER)
public class TrainingCenterEntity extends AbstractEntity {

    @Column(name = "center_name", nullable = false)
    private String centerName;

    @Column(name = "center_code", nullable = false)
    private String centerCode;

    @Column(name = "student_capacity")
    private Integer studentCapacity;

    @Column(name = "courses_offered")
    @CollectionTable(name = "courses_list",  joinColumns = @JoinColumn(name = "id"))
    @ElementCollection
    private List<String> coursesOffered;

    @Column(name = "center_email")
    private  String centerEmail;

    @Column(name = "center_phone", nullable = false)
    private String centerPhone;

    @OneToOne(mappedBy = "trainingCenter", cascade = CascadeType.ALL, orphanRemoval = true)
    private AddressEntity address;
}
