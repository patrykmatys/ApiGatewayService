package org.thesis.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String address;
}
