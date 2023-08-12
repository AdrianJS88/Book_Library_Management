package com.application.courselibrary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="email",length = 100,nullable = false,unique = true)
    private String email;
    @Column(name="password",length = 50,nullable = false)
    private String password;
    @Column(name="phone_num",length = 50,nullable = false)
    private String phone_num;

    @Column(name="name",length = 50,nullable = false)
    private  String name;
@DateTimeFormat(pattern = "dd/mm/yyyy ")
    @Column(name="date")
    private Date date;


}
