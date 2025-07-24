package com.example.spring_solid_criteria.interfaces;

import com.example.spring_solid_criteria.dto.params.UserRepositoryParamsDto;
import com.example.spring_solid_criteria.entity.User;

public interface IUserCriteriaRepository extends IBaseCreateriaRepository<User, UserRepositoryParamsDto> {
    // bisa ditambah method kriteria spesifik jika perlu
}
