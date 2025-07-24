package com.example.spring_solid_criteria.dto.response;

public class UserRepositoryResDto {
    public Long id;
    public String name;
    public String email;

    public UserRepositoryResDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
