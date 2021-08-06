package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface INewService {
    NewDTO save(NewDTO newDTO);
    //NewDTO update(NewDTO newDTO);
    void delete(long[] ids);
    List<NewDTO> findAll();
    List<NewDTO> findAll(Pageable pageable);
    int totalItem();
}
