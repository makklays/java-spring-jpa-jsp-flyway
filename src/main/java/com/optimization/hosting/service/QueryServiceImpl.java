package com.optimization.hosting.service;

import com.optimization.hosting.model.Query;
import com.optimization.hosting.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryServiceImpl implements InterfaceQuery {

    @Lazy
    @Autowired
    private QueryRepository queryRepository;

    @Override
    public List<Query> getAllQueries() {
        List<Query> list = new ArrayList<>();
        queryRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public Query getQueryById(Integer id) {
        return queryRepository.getById(id);
    }

    @Override
    public boolean addQuery(Query query) {
        Query q = queryRepository.save(query);
        if (q.getId() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateQuery(Query query) {
        Query q = queryRepository.save(query);
        if (q.getId() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteQuery(Integer id) {
        Query query = queryRepository.getById(id);
        if (query.getId() > 0) {
            queryRepository.delete(query);
            return true;
        } else {
            return false;
        }
    }
}

