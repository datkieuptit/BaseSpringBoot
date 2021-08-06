package com.laptrinhjavaweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity(name = "catagory")
@Table
@AllArgsConstructor
@NoArgsConstructor
public class CatagoryEntity  extends BaseEntity{

        @Column(name = "code")
        private String code;

        @Column(name = "name")
        private String name;

        //TODO : 1 category có nhiều/list bài báo
        @OneToMany(mappedBy = "catagory")
        //@JsonIgnore
        private List<NewsEntity> news = new ArrayList<>();
}
