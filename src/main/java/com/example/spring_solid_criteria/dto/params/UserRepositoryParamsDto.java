package com.example.spring_solid_criteria.dto.params;

import com.example.spring_solid_criteria.dto.BaseParamPaginationDto;

public class UserRepositoryParamsDto extends BaseParamPaginationDto {
    private Integer id;
    private String name;
    private String email;
    private Boolean isActive;

    public UserRepositoryParamsDto() {}

    // Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
