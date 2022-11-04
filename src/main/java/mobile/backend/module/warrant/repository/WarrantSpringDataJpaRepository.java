package mobile.backend.module.warrant.repository;

import mobile.backend.module.warrant.Warrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WarrantSpringDataJpaRepository extends JpaRepository<Warrant, Integer> {

    Optional<Warrant> findByWarrantIndex(int id);

    void deleteByWarrantIndex(int warrantId);

    @Modifying
    @Query("update Warrant w set w.warrantLookupStatus = 1 where w.warrantIndex = :warrantIndex")
    void updateLookupComplete(@Param("warrantIndex") int warrantIndex);
}
