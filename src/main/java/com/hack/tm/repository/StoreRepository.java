package com.hack.tm.repository;

import com.hack.tm.domain.Store;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

    /**
     * 위치 주변 가게 목록 반환
     * @param hname 동
     * @return
     */
    List<Store> findByAddress_Hname(String hname);




}
