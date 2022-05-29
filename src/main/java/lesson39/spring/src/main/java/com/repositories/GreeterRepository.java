package com.repositories;

import com.models.Greeter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GreeterRepository extends CrudRepository<Greeter, String> {
    List<Greeter> findByTarget(String target);
}
