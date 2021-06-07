package com.lee.pract.xdemoredis2021529.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
@Getter
@Setter
@ToString
public class Lee implements Serializable {

    private Integer id;

    private String name;

}
