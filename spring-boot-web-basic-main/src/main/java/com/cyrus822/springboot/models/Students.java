package com.cyrus822.springboot.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Students implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="stdId", nullable = false, length = 8, unique = true)
    private String stdId;

    @Column(name="stdName", nullable = false, length = 100)
    private String stdName;

    @Column(name="phoneNumber", nullable = true, length = 100)
    private String phone;

    @Column(name="emailAddr", nullable = true, length = 255)
    @Email(message = "Please provide a valid email address")
    private String emailAddr;

    @Column(name="dateOfBirth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;
}