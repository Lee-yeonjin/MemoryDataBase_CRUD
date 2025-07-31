package com.example.memorydb.user.db;

import java.util.List;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByScoreGreaterThan(int score);
}