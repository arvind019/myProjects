package com.microservices.moviecatalogservice.repository;

import com.microservices.moviecatalogservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUserName(final String userName);

    UserEntity findByUserId(final Integer userId);
}
