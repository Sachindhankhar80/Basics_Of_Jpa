package com.example.jpause;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="Student_info")   // with the help of this annotation we can name the tables of our own

public class Student {

    @Id
    int rollno;

//    @Column(name="Student_name") // we can put the name of coloum like table
    String name;
    int age;

}
