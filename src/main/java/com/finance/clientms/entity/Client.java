package com.finance.clientms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@Document(collection = "client")
public class Client {
    @Id
    private String id;
    private String documentIdentityType;
    private String documentIdentityNumber;
    private String name;
    private Type type;
    private String gender;
    private String phoneNumber;
    private String address;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    public Client(String documentIdentityType, String documentIdentityNumber, String name, Type type, String gender, String phoneNumber, String address, String email, Date birthdate, Date createAt) {
        this.documentIdentityType = documentIdentityType;
        this.documentIdentityNumber = documentIdentityNumber;
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.birthdate = birthdate;
        this.createAt = createAt;
    }
}
