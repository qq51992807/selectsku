package com.yang.selectsku.dao;

import com.yang.selectsku.entity.tbItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tbItemRepository  extends JpaRepository<tbItem, Long> {

    tbItem findById(String id);
}
