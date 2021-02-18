package com.pangpan.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author pangpan
 * @date 2021-02-17
 */
@Entity
@Data
public class Book {
    @Id
    private Integer id;
    private String name;
    private String author;


}
