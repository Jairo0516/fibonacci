package com.fibonacci.domain.repository;

import com.fibonacci.domain.entity.Fibonacci;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FibonacciRepository extends CrudRepository<Fibonacci, Integer> {

    Fibonacci getAllById(@Param("id") Integer id);
}
