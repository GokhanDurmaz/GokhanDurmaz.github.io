package com.demo.ans.model;

/**
 * Created by gokhan on 11/5/21.
 * @author gokhan
 * @since 2021/11/05
 */

public class GithubResponseModel extends ResponseModel{
    private String name;
    private String surname;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
