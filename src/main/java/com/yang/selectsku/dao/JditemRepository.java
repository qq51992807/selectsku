package com.yang.selectsku.dao;

import com.yang.selectsku.entity.Jditem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface JditemRepository extends JpaRepository<Jditem, Long> {

    Jditem findById(String id);


    @Query(value = "select * from jditem  where by_user = ?1", nativeQuery = true)
    List<Jditem> findByUserId(int userId);
}
