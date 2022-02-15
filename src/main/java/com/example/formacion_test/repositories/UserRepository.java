package com.example.formacion_test.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.formacion_test.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {


 //Custom query
 @Query(value = "select * from usuario u where u.nombre like %:keyword% or u.email like %:keyword%", nativeQuery = true)
 List<User> findByKeyword(@Param("keyword") String keyword);
    
}
