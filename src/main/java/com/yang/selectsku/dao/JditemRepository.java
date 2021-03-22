package com.yang.selectsku.dao;

import com.yang.selectsku.entity.Jditem;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JditemRepository extends JpaRepository<Jditem, Long> {
    Jditem findById(String paramString);

    @Query(value = "select * from jditem  where by_user = ?1", nativeQuery = true)
    List<Jditem> findByUserId(int paramInt);

    @Query(value = "select * from jditem where by_user = ?1 and status=1", nativeQuery = true)
    List<Jditem> findByIdAndStatus(int paramInt);

    @Modifying
    @Transactional
    @Query(value = " update jditem set status = ?2 where id = ?1", nativeQuery = true)
    int modifyStatus(Long paramLong, int paramInt);
}
