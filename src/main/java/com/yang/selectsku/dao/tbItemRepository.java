package com.yang.selectsku.dao;

import com.yang.selectsku.entity.Jditem;
import com.yang.selectsku.entity.tbItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface tbItemRepository  extends JpaRepository<tbItem, Long> {

    tbItem findById(String id);
    @Query(value = "select * from tb_item  where by_user = ?1", nativeQuery = true)
    List<tbItem> findByUserId(int userId);
}
