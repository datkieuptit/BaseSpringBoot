package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class AbstractDTO<T> {
    private Long id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    //TODO : Danh sach doi tuong quan ly , VD : danh sach news
    private ArrayList<T> listResult = new ArrayList<>();
}
