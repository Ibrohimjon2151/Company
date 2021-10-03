package com.example.task1.entity;

import com.example.task1.entity.abstractClass.AbcIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Company extends AbcIdEntity {
    private String direktoName;

    @OneToOne
    private Address address;


}
