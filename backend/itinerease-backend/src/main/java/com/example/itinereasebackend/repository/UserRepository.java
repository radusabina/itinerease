package com.example.itinereasebackend.repository;

import com.example.itinereasebackend.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    void deleteByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    @Query(value="select * from public.user u where u.phone_number = :phone_number",nativeQuery=true)
    Optional<User> findByPhone_number(String phone_number);
}
