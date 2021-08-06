package com.laptrinhjavaweb.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "user")
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity  extends BaseEntity{
        @Column(name = "username")
        private String userName;

        @Column(name = "password")
        private String passWord;

        @Column(name = "fullname")
        private String fullName;

        @Column(name = "status")
        private int status;

        // TODO : 1 thằng user có 1 nhiều/list role;
        @ManyToMany
        // TODO : Tạo bảng chung .
        @JoinTable(name =  "user_role",
                        joinColumns = @JoinColumn(name = "user_id"),
                        inverseJoinColumns = @JoinColumn(name = "role_id"))
        private List<RoleEntity> roles =new ArrayList<>();

}
