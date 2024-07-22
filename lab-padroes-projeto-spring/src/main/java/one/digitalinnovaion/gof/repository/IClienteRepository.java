package one.digitalinnovaion.gof.repository;

import one.digitalinnovaion.gof.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<ClienteModel, Long> {
}
