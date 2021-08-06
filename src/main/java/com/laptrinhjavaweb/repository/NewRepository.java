package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.CatagoryEntity;
import com.laptrinhjavaweb.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends JpaRepository<NewsEntity,Long> {
    NewsEntity findOneById(long id);
}
