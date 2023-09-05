package com.example.crudfix.repository;

import com.example.crudfix.domain.entity.MoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoreInfoRepository extends JpaRepository<MoreInfo, Integer> {
}
