package com.cyrus822.u5.basicweb.models;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SessionScope
public class Contacts implements Serializable{
    private String name;
    private String phone;
    private String email;
    private int id;
}
