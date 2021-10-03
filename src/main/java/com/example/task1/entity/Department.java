package com.example.task1.entity;

import com.example.task1.entity.abstractClass.AbcIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Department extends AbcIdEntity {
    @ManyToOne
    private Company company;
}
