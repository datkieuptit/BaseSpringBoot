package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CatagoryEntity;
import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.repository.CatagoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewService implements INewService {
   @Autowired
   private NewRepository newRepository ;
   @Autowired
   private CatagoryRepository catagoryRepository;
   @Autowired
   private NewConverter newConverter;

   @Override
   public NewDTO save(NewDTO newDTO) {
      NewsEntity newsEntity = new NewsEntity();
      if(newDTO.getId() != null){
         NewsEntity oldNew = newRepository.findOneById(newDTO.getId()) ;
         newsEntity = newConverter.toEntity(newDTO,oldNew);
      }
      else {
         newsEntity = newConverter.toEntity(newDTO);
      }
      CatagoryEntity catagoryEntity = catagoryRepository.findOneByCode(newDTO.getCatagoryCode());
      newsEntity.setCatagory(catagoryEntity);
      newRepository.save(newsEntity);
      return newConverter.toDTO(newsEntity);
   }

   @Override
   public void delete (long[] ids) {
      for(long item : ids){
         newRepository.deleteById(item);
      }
   }

   @Override
   public List<NewDTO> findAll() {
      List<NewDTO> results = new ArrayList<>();
      List<NewsEntity> entities = newRepository.findAll();
      for(NewsEntity item  : entities){
         NewDTO newDTO = newConverter.toDTO(item);
         results.add(newDTO);
      }
      return results;
   }


   @Override
   public List<NewDTO> findAll(Pageable pageable) {
      List<NewDTO> results = new ArrayList<>();
      List<NewsEntity> entities = newRepository.findAll(pageable).getContent();
      for(NewsEntity item  : entities){
         NewDTO newDTO = newConverter.toDTO(item);
         results.add(newDTO);
      }
      return results;
   }

   @Override
   public int totalItem() {
      return (int) newRepository.count();
   }


//   @Override
//   public NewDTO update(NewDTO newDTO) {
//      NewsEntity oldNew = newRepository.findOneById(newDTO.getId()) ;
//      NewsEntity newsEntity = newConverter.toEntity(newDTO,oldNew);
//      CatagoryEntity catagoryEntity = catagoryRepository.findOneByCode(newDTO.getCatagoryCode());
//      newsEntity.setCatagory(catagoryEntity);
//      newRepository.save(newsEntity);
//      return newConverter.toDTO(newsEntity);
//   }


}
