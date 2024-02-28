package com.optimization.hosting.repository;

import com.optimization.hosting.model.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {

    Query getById(Integer id);
    List<Query> findByServiceId(Integer serviceId);
    List<Query> findByCategoryId(Integer categoryId);
}

