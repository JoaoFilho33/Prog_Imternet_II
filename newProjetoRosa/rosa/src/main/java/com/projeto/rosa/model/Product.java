package com.projeto.rosa.model;

import com.projeto.rosa.StatusEnum;

public class Product {
    private Long id;
    private String name;
    private StatusEnum status;


    public Product(Long id, String name, StatusEnum status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Product(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
