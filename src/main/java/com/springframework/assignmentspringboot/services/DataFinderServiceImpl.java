package com.springframework.assignmentspringboot.services;

import com.springframework.assignmentspringboot.domain.DataTable;
import com.springframework.assignmentspringboot.repository.DataRepository;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class DataFinderServiceImpl implements DataFinderService {

    private final DataRepository dataRepository;

    public DataFinderServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public List<DataTable> findAllByName(String name) {
        return null;
    }
}
