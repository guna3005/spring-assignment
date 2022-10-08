package com.springframework.assignmentspringboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class DataTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String code;

    public String name;

    public String batch;

    public Long stock;

    public Long deal;

    public Long free;

    public Float mrp;

    public Float rate;

    public Date exp;

    public String company;

    public String supplier;

}
