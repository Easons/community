package com.pangpan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author pangpan
 * @date 2021-02-17
 */
@Entity
@Data
@ApiModel("图书实体")
public class Book {
    @Id
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("图书名")
    private String name;
    @ApiModelProperty("作者")
    private String author;


}
