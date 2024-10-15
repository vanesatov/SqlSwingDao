package org.example.models;

import lombok.Data;

import java.io.Serializable;

@Data

public class Game implements Serializable {
    private Integer id;
    private String title;
    private String platform;
    private Integer year;
    private String description;
}
