package mobile.backend.module.user.repository;

import mobile.backend.module.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSpringDataJpaRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserIndex(int id);

    Optional<User> findByUserId(String id);

    Optional<User> findByUserIdAndUserPassword(String id, String password);

    void deleteByUserId(String userId);
}
