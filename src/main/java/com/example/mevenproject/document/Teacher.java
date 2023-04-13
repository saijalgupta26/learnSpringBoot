package com.example.mevenproject.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Teacher {

    private String name;
    private  String email;
    private String address;

}
