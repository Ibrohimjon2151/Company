package com.example.task1.entity;

import com.example.task1.entity.abstractClass.AbcIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Worker extends AbcIdEntity {
    private String phoneNummber;

    @OneToOne
    private Address address;

    @ManyToOne
    private Department department;
}
