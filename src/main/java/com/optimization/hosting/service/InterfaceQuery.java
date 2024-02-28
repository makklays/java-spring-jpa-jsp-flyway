package com.optimization.hosting.service;

import com.optimization.hosting.model.Query;

import java.util.List;

public interface InterfaceQuery {
    List<Query> getAllQueries();
    Query getQueryById(Integer id);

    boolean addQuery(Query query);
    boolean updateQuery(Query query);
    boolean deleteQuery(Integer id);
}

