package com.springframework.assignmentspringboot.services;

import com.springframework.assignmentspringboot.domain.DataTable;
import com.springframework.assignmentspringboot.repository.DataRepository;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service

public class DataParserServiceImpl implements DataParserService {

    private  final DataRepository dataRepository;

    public DataParserServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public String ParseData(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        CsvParserSettings csvParserSettings = new CsvParserSettings();
        csvParserSettings.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(csvParserSettings);
        List<Record> data = parser.parseAllRecords(inputStream);
        ArrayList arrayList = new ArrayList();
        data.forEach(record -> {
            DataTable dataTable = new DataTable();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD/MM/YYYY");
            dataTable.setName(record.getString("name"));
            dataTable.setCompany(record.getString("company"));
            dataTable.setCode(record.getString("code"));
            dataTable.setSupplier(record.getString("supplier"));
            dataTable.setBatch(record.getString("batch"));
            dataTable.setStock(Long.parseLong(record.getString("stock")));
            dataTable.setDeal(Long.parseLong(record.getString("deal")));
            dataTable.setFree(Long.parseLong(record.getString("free")));
            dataTable.setMrp(Float.parseFloat(record.getString("mrp")));
            dataTable.setRate(Float.parseFloat(record.getString("rate")));
            try {
                dataTable.setExp(simpleDateFormat.parse(record.getString("exp")));
            } catch (ParseException e) {
                try {
                    dataTable.setExp(simpleDateFormat.parse("01/01/1900"));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
            arrayList.add(dataTable);
        });
        dataRepository.saveAll(arrayList);
        return "data";
    }
}
