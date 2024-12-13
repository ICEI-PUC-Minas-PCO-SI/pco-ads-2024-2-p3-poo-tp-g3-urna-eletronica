package urna_eletronica.urna.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import urna_eletronica.urna.Entity.ResultadoPartido;

public interface ResultadoPartidoRepository extends JpaRepository<ResultadoPartido, Long> {
  
}
