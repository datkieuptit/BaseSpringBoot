package com.laptrinhjavaweb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity(name = "new")
@Table
@AllArgsConstructor
@NoArgsConstructor
public class NewsEntity extends BaseEntity {

    @Column (name =  "title")
    private String title;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "shortDescription")
    private String shortDescription;

    @Column(name = "content")
    private String content;

    // TODO : nhiều bài báo có 1 catagogy ( category_id_
    @ManyToOne
    @JoinColumn(name = "catagory_id")
    private CatagoryEntity catagory;
}
