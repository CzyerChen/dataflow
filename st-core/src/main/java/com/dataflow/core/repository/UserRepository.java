package com.dataflow.core.repository;


import com.dataflow.common.domain.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPO,Integer> {
    UserPO findByIdAndDeleted(int id, boolean deleted);
}
