package com.springframework.assignmentspringboot.repository;

import com.springframework.assignmentspringboot.domain.DataTable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DataRepository extends JpaRepository<DataTable , Long> {

    @Query("SELECT C FROM DataTable C")
    List<DataTable> findAll(PageRequest pageRequest);
    @Query("SELECT C FROM DataTable C WHERE C.supplier LIKE %?1%")
    List<DataTable> findAllByName(String name, PageRequest pageRequest);

    @Query("SELECT C FROM DataTable C WHERE C.supplier LIKE %?1% AND CURRENT_TIMESTAMP < C.exp")
    List<DataTable> findBySupplierExpiry(String name, PageRequest pageRequest);

    @Query("SELECT C FROM DataTable C WHERE CURRENT_TIMESTAMP < C.exp")
    List<DataTable> findByExpiry(PageRequest pageRequest);

    @Query("SELECT C FROM DataTable C WHERE C.supplier LIKE %?1% AND C.name LIKE %?2% AND CURRENT_TIMESTAMP < C.exp")
    List<DataTable> findBySupplierProductExpiry(String name,String product, PageRequest pageRequest);

    @Query("SELECT C FROM DataTable C WHERE C.supplier LIKE %?1% AND C.name LIKE %?2%")
    List<DataTable> findBySupplierProduct(String name,String product, PageRequest pageRequest);

    @Query("SELECT C FROM DataTable C WHERE C.name LIKE %?1%  AND CURRENT_TIMESTAMP < C.exp")
    List<DataTable> findByProductExpiry(String product, PageRequest pageRequest);

    @Query("SELECT C FROM DataTable C WHERE C.name LIKE %?1%")
    List<DataTable> findByProduct(String product, PageRequest pageRequest);

}
