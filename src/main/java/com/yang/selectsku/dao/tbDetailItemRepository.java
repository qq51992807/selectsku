package com.yang.selectsku.dao;

import com.yang.selectsku.entity.tbDetailItem;
import com.yang.selectsku.entity.tbItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface tbDetailItemRepository extends JpaRepository<tbDetailItem, Long> {

    tbItem findById(String id);
    @Query(value = "select * from tb_detail_item  where by_user = ?1", nativeQuery = true)
    List<tbDetailItem> findByUserId(int userId);
}
