package com.example.spring_solid_criteria.interfaces;

import java.util.List;

import com.example.spring_solid_criteria.dto.params.UserRepositoryParamsDto;
import com.example.spring_solid_criteria.dto.request.UserRequestDto;
import com.example.spring_solid_criteria.dto.response.UserRepositoryResDto;

public interface IUserService {
    List<UserRepositoryResDto> getAllUsers();
    UserRepositoryResDto getUserById(Long id);
    UserRepositoryResDto createUser(UserRequestDto request);
    UserRepositoryResDto updateUser(Long id, UserRequestDto request);
    void deleteUser(Long id);

    List<UserRepositoryResDto> getUsersByCriteria(UserRepositoryParamsDto params);
}
