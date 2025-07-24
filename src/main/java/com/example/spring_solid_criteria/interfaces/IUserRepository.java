package com.example.spring_solid_criteria.interfaces;

import com.example.spring_solid_criteria.dto.params.UserRepositoryParamsDto;
import com.example.spring_solid_criteria.entity.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    List<User> findByEmailContainingIgnoreCase(String email);

    boolean existsByName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.active = true WHERE u.active = false")
    int activateAllInactiveUsers();

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.active = :active WHERE u.name = :name")
    int updateIsActiveByUsername(@Param("username") String name, @Param("active") boolean active);

}
