package com.springframework.assignmentspringboot.controllers;

import com.springframework.assignmentspringboot.services.DataParserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class DataInputController {
    private final DataParserService dataParserService;

    public DataInputController(DataParserService dataParserService) {
        this.dataParserService = dataParserService;
    }

    @PostMapping("/fileinput")
    public String fileUploader(@RequestParam(name = "file") MultipartFile file) throws IOException {


        dataParserService.ParseData(file);


        return "successfully uploaded";
    }


}
