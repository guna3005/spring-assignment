package com.springframework.assignmentspringboot.controllers;


import com.springframework.assignmentspringboot.domain.DataTable;
import com.springframework.assignmentspringboot.repository.DataRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
public class DataDisplayController {
    private final  DataRepository dataRepository;

    public DataDisplayController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @RequestMapping("/supplier/{name}")
    public List<DataTable> findBySupplier(@PathVariable("name") String name,
                                          @RequestParam(name = "exp",defaultValue = "false") boolean exp,

                                            @RequestParam(name = "product",defaultValue = "") String product){


        if(product.length() > 0){
            if(exp){
                return dataRepository.findBySupplierProductExpiry(name.toUpperCase(),product.toUpperCase());
            }
            System.out.println("product = !!!!!!!!!!!!!!!!!!!!!!!!!!!!" + product);
            return dataRepository.findBySupplierProduct(name.toUpperCase(),product.toUpperCase());
        }
        if(exp){
            return dataRepository.findBySupplierExpiry(name.toUpperCase());
        }
        return dataRepository.findAllByName(name.toUpperCase());

    }

    @RequestMapping("/supplier")
    public List<DataTable> findAllSuppliers(@RequestParam(name = "exp",defaultValue = "false") boolean exp,
                                            @RequestParam(name = "product",defaultValue = "") String product)  {

        if(product.length() > 0){
            if(exp){
                return dataRepository.findByProductExpiry(product.toUpperCase());
            }
            return dataRepository.findByProduct(product.toUpperCase());
        }
        if(exp){
            return dataRepository.findByExpiry();
        }
        return dataRepository.findAll();
     }

}
