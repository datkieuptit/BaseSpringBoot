package com.laptrinhjavaweb.repository;


import com.laptrinhjavaweb.entity.CatagoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepository extends JpaRepository<CatagoryEntity,Long> {
    CatagoryEntity findOneByCode(String code);
}
