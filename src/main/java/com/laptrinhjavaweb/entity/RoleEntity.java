package com.laptrinhjavaweb.entity;

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
@Entity(name = "role")
@Table
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity extends BaseEntity{

        @Column(name = "code")
        private String code;

        @Column(name = "name")
        private String name;

        // TODO : 1 thằng role có 1 nhiều/list user;
        @ManyToMany(mappedBy = "roles")
        private List<UserEntity> users = new ArrayList<>();

}
