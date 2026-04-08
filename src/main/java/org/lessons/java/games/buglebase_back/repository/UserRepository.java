package org.lessons.java.games.buglebase_back.repository;

import java.util.Optional;

import org.lessons.java.games.buglebase_back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
