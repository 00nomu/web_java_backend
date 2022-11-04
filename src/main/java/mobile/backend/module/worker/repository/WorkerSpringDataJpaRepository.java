package mobile.backend.module.worker.repository;

import mobile.backend.module.worker.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkerSpringDataJpaRepository extends JpaRepository<Worker, Integer> {

    Optional<Worker> findByWorkerIndex(int id);

    List<Worker> findAllByWorkerCustomerCode(String workerCustomerCode);
}
