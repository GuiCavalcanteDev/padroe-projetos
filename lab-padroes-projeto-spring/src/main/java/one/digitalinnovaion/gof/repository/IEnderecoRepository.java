package one.digitalinnovaion.gof.repository;

import one.digitalinnovaion.gof.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnderecoRepository extends JpaRepository<Endereco, String> {
}
