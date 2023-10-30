package com.craftgirlsss.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.craftgirlsss.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
} 