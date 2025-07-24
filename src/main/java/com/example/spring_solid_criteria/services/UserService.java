package com.example.spring_solid_criteria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_solid_criteria.dto.params.UserRepositoryParamsDto;
import com.example.spring_solid_criteria.dto.request.UserRequestDto;
import com.example.spring_solid_criteria.dto.response.UserRepositoryResDto;
import com.example.spring_solid_criteria.entity.User;
import com.example.spring_solid_criteria.exceptions.BaseException;
import com.example.spring_solid_criteria.interfaces.IUserCriteriaRepository;
import com.example.spring_solid_criteria.interfaces.IUserRepository;
import com.example.spring_solid_criteria.interfaces.IUserService;

@Service
public class UserService implements IUserService{
    private final IUserRepository userRepositoryJpa;
    private final IUserCriteriaRepository userRepositoryCriteria;

    public UserService(IUserRepository userRepositoryJpa, IUserCriteriaRepository userRepositoryCriteria) {
        this.userRepositoryJpa = userRepositoryJpa;
        this.userRepositoryCriteria = userRepositoryCriteria;
    }

    public List<UserRepositoryResDto> getUsersByCriteria(UserRepositoryParamsDto params) {
        return userRepositoryCriteria.FindAll(params).stream()
                .map(u -> new UserRepositoryResDto(u.getId(), u.getName(), u.getEmail()))
                .toList();
    }

    @Override
    public List<UserRepositoryResDto> getAllUsers() {
        return userRepositoryJpa.findAll().stream()
                .map(u -> new UserRepositoryResDto(u.getId(), u.getName(), u.getEmail()))
                .toList();
    }

    @Override
    public UserRepositoryResDto getUserById(Long id) {
        User user = userRepositoryJpa.findById(id)
                .orElseThrow(() -> BaseException.badRequest("data not id found!"));
        return new UserRepositoryResDto(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public UserRepositoryResDto createUser(UserRequestDto request) {
        // Validasi input (bad request)
        if (request.name == null || request.name.isBlank()) {
            throw BaseException.badRequest("Nama tidak boleh kosong");
        }
        if (request.email == null || request.email.isBlank()) {
            throw BaseException.badRequest("Email tidak boleh kosong");
        }

        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);

        User saved = userRepositoryCriteria.Insert(user);

        if (saved == null || saved.getId() == null) {
            throw BaseException.internalError("Gagal menyimpan data pengguna");
        }

        return new UserRepositoryResDto(saved.getId(), saved.getName(), saved.getEmail());
    }


    @Override
    public UserRepositoryResDto updateUser(Long id, UserRequestDto request) {
        User user = userRepositoryJpa.findById(id)
                .orElseThrow(() -> BaseException.badRequest("[UpdatedUser] - Data user not found!"));

        user.setName(request.name);
        user.setEmail(request.email);
        userRepositoryJpa.save(user);
        return new UserRepositoryResDto(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public void deleteUser(Long id) {
        userRepositoryJpa.deleteById(id);
    }
}
