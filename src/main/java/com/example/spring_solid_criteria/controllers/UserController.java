package com.example.spring_solid_criteria.controllers;

import com.example.spring_solid_criteria.common.BaseApiResponse;
import com.example.spring_solid_criteria.dto.BaseApiResponseDto;
import com.example.spring_solid_criteria.dto.request.UserRequestDto;
import com.example.spring_solid_criteria.dto.response.UserRepositoryResDto;
import com.example.spring_solid_criteria.interfaces.IUserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    // ✅ Get all users
    @GetMapping
    public ResponseEntity<BaseApiResponseDto<List<UserRepositoryResDto>>> getAllUsers() {
        List<UserRepositoryResDto> users = userService.getAllUsers();
        return BaseApiResponse.success(users, "Data pengguna ditemukan");
    }

    // ✅ Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<BaseApiResponseDto<UserRepositoryResDto>> getUserById(@PathVariable Long id) {
        UserRepositoryResDto user = userService.getUserById(id);
        return BaseApiResponse.success(user, "Data pengguna ditemukan");
    }

    // ✅ Create user
    @PostMapping
    public ResponseEntity<BaseApiResponseDto<UserRepositoryResDto>> createUser(@RequestBody UserRequestDto request) {
        UserRepositoryResDto user = userService.createUser(request);
        return BaseApiResponse.success(user, "Pengguna berhasil dibuat");
    }

    // ✅ Update user
    @PutMapping("/{id}")
    public ResponseEntity<BaseApiResponseDto<UserRepositoryResDto>> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto request
    ) {
        UserRepositoryResDto updated = userService.updateUser(id, request);
        return BaseApiResponse.success(updated, "Pengguna berhasil diperbarui");
    }

    // ✅ Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseApiResponseDto<Object>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return BaseApiResponse.success(null, "Pengguna berhasil dihapus");
    }
}
