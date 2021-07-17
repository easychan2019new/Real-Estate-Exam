package com.alexande.realestateexam.dao;

import com.alexande.realestateexam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUid(String uid);
}
