package com.example.spring_solid_criteria.interfaces;

import java.util.List;
import java.util.Optional;

public interface IBaseCreateriaRepository<Response, Params> {

    List<Response> FindAll(Params criteria);

    Optional<Response> FindOne(Params criteria);

    Response Insert(Response entity);

    List<Response> InsertAll(List<Response> entities);

    // Response Update(Long id, Response updatedEntity);

    // int UpdateByCondition(Response updatedFields, Params condition);
    int Update(Response updatedFields, Params condition);

    boolean Delete(Long id);
}