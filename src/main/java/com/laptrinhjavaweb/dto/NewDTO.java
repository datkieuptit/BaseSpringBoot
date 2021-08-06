package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewDTO extends AbstractDTO<NewDTO>{
    private String title;
    private String content;
    private String shortDescription;
    private String catagoryCode;
    private String thumbnail;
}
