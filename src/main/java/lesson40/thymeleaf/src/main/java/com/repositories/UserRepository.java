package com.repositories;

import com.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Person, String> {
    Optional<Person> findPersonByEmail(String email);
}
