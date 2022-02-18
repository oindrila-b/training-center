package com.example.Liv2Train.entities;

import com.example.Liv2Train.constants.EntityName;
import com.example.Liv2Train.constants.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity(name = EntityName.ADDRESS)
@Table(name = TableName.ADDRESS)
public class AddressEntity extends AbstractEntity {

    @Column(name = "detailed_address", nullable = false)
    private String detailedAddress;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "pincode", nullable = false)
    private String pinCode;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "training_center_id",  referencedColumnName = "id",  unique = true)
    @JsonIgnore
    private TrainingCenterEntity trainingCenter;
}
