package cafecito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cafecito.model.Licencia;

public interface LicenciaRepository extends JpaRepository<Licencia, Long> {
    Optional<Licencia> findByHwid(String hwid);
}
