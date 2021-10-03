package com.example.task1.entity;

import com.example.task1.entity.abstractClass.AbcIdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Address extends AbcIdEntity {
    private int homeNummber;
}
