
package com.softtek.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    // Student a Entity having
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false) //for custom name and not null
    private String fName;
    @Column(name = "last_name", nullable = false)
    private String lName;
    private String email; //will create column name as of the field i.e. email if not assigned



    public Student(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }
}
