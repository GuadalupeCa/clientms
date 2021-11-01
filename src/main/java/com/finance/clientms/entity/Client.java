package com.finance.clientms.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
@Data
@AllArgsConstructor
public class Client {
    @Id
    private String id;
    private String DNI;

    private String name;
    private String direction;
    private String phoneNumber;
    //    private Date createAt;
    //private ClientType clientType;

//    public Client(String DNI, String name, String direction, String phoneNumber){//,ClientType clientType) {
//        this.DNI = DNI;
//        this.name = name;
//        this.direction = direction;
//        this.phoneNumber = phoneNumber;
////        this.clientType=clientType;
//    }
}
