package io.github.tacehex.jadmin.demo.repository;

import io.github.tacehex.jadmin.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}