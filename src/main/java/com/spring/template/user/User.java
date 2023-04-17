package com.spring.template.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 45,nullable = false,name = "fname")
    private String fname;
    @Column(length = 45,nullable = false,name = "lname")
    private String lname;
    @Column(nullable = false,unique = true,length = 45,name = "email")
    private String email;
    @Column(length = 15,nullable = false,name = "pwd")
    private String pwd;
    @Column(nullable = false,name = "enabled")
    private boolean enabled;
}
