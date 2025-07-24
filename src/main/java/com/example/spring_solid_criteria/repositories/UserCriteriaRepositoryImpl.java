package com.example.spring_solid_criteria.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.spring_solid_criteria.dto.params.UserRepositoryParamsDto;
import com.example.spring_solid_criteria.entity.User;
import com.example.spring_solid_criteria.interfaces.IUserCriteriaRepository;
import com.example.spring_solid_criteria.interfaces.IUserRepository;

@Repository
public class UserCriteriaRepositoryImpl implements IUserCriteriaRepository  {

    private final IUserRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public UserCriteriaRepositoryImpl(IUserRepository repository) {
        this.repository = repository;
    }

    private List<User> index(UserRepositoryParamsDto criteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getId() != null) {
            predicates.add(cb.equal(root.get("id"), criteria.getId()));
        }
        if (criteria.getName() != null && !criteria.getName().isBlank()) {
            predicates.add(cb.like(cb.lower(root.get("username")), "%" + criteria.getName().toLowerCase() + "%"));
        }
        if (criteria.getEmail() != null && !criteria.getEmail().isBlank()) {
            predicates.add(cb.like(cb.lower(root.get("email")), "%" + criteria.getEmail().toLowerCase() + "%"));
        }
        if (criteria.getIsActive() != null) {
            predicates.add(cb.equal(root.get("isActive"), criteria.getIsActive()));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<User> q = entityManager.createQuery(query);
        if (criteria.getLimit() != 0) {
            q.setMaxResults(criteria.getLimit());
        }
        if (criteria.getOffset() != 0) {
            q.setFirstResult(criteria.getOffset());
        }

        return q.getResultList();
    }

    @Override
    public List<User> FindAll(UserRepositoryParamsDto criteria) {
        return this.index(criteria);
    }

    @Override
    public Optional<User> FindOne(UserRepositoryParamsDto criteria) {
        List<User> users = this.index(criteria);
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    @Override
    public User Insert(User entity) {
        return repository.save(entity);
    }

    @Override
    public List<User> InsertAll(List<User> entities) {
        return repository.saveAll(entities);
    }

    /**
     * Update satu entitas berdasarkan ID
     */
    // @Override
    // public User Update(Long id, User updatedEntity) {
    //     return repository.findById(id).map(existing -> {
    //         if (updatedEntity.getName() != null) {
    //             existing.setName(updatedEntity.getName());
    //         }
    //         if (updatedEntity.getEmail() != null) {
    //             existing.setEmail(updatedEntity.getEmail());
    //         }
    //         return repository.save(existing);
    //     }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    // }

    /**
     * Update massal berdasarkan kondisi tertentu
     */
    @Override
    public int Update(User updatedFields, UserRepositoryParamsDto condition) {
        List<User> users = this.index(condition);

        for (User user : users) {
            if (updatedFields.getName() != null) {
                user.setName(updatedFields.getName());
            }
            if (updatedFields.getEmail() != null) {
                user.setEmail(updatedFields.getEmail());
            }
        }

        repository.saveAll(users);
        return users.size();
    }

    @Override
    public boolean Delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
