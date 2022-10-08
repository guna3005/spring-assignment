package com.springframework.assignmentspringboot.services;


import com.univocity.parsers.common.record.Record;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DataParserService {
    String ParseData(MultipartFile file) throws IOException;
}
