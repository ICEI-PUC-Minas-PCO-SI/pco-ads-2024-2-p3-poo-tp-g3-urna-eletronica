package urna_eletronica.urna.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import urna_eletronica.urna.Entity.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
  
}
