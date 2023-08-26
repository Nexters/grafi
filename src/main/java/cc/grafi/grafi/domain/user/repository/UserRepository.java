package cc.grafi.grafi.domain.user.repository;

import cc.grafi.grafi.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(String id);
}
