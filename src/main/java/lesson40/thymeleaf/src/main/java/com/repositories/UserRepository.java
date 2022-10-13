package com.repositories;

import com.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Person, String> {
    Optional<Person> findPersonByEmail(String email);
}
