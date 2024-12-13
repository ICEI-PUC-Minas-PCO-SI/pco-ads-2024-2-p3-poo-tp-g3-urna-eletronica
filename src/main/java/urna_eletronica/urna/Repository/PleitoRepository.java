package urna_eletronica.urna.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import urna_eletronica.urna.Entity.Pleito;

public interface PleitoRepository extends JpaRepository<Pleito, Long> {
  
}
