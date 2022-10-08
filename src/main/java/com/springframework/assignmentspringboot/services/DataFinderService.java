package com.springframework.assignmentspringboot.services;

import com.springframework.assignmentspringboot.domain.DataTable;

import java.util.List;

public interface DataFinderService{
    List<DataTable> findAllByName(String name);
}
