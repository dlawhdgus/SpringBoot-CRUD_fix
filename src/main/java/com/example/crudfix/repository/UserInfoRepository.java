package com.example.crudfix.repository;

import com.example.crudfix.domain.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    boolean existsById(String id);

    Optional<UserInfo> findById(String id);
}