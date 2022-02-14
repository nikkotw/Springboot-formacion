package com.example.formacion_test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.formacion_test.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    
}
