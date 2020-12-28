package com.yang.selectsku.dao;

import com.yang.selectsku.entity.Jditem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JditemRepository extends JpaRepository<Jditem, Long> {

    Jditem findById(String id);
}
