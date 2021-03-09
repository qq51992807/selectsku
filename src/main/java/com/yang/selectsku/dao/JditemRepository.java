package com.yang.selectsku.dao;

import com.yang.selectsku.entity.Jditem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface JditemRepository extends JpaRepository<Jditem, Long> {

    Jditem findById(String id);


    @Query(value = "select * from jditem  where by_user = ?1", nativeQuery = true)
    List<Jditem> findByUserId(int userId);

    @Query(value = "select * from jditem where by_user = ?1 and status=1",nativeQuery =true )
    List<Jditem> findByIdAndStatus(int userId);

    @Modifying
    @Transactional
    @Query(value = " update jditem set status = ?2 where id = ?1",nativeQuery = true)
    int modifyStatus(Long id,int status);

}
