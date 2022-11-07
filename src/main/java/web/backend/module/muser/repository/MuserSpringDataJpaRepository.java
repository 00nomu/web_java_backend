package web.backend.module.muser.repository;

import web.backend.module.muser.Muser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MuserSpringDataJpaRepository extends JpaRepository<Muser, Integer> {

    Optional<Muser> findByMuserIndex(int id);

    Optional<Muser> findByMuserId(String id);

    Optional<Muser> findByMuserIdAndMuserPassword(String id, String password);

    void deleteByMuserId(String muserId);
}
