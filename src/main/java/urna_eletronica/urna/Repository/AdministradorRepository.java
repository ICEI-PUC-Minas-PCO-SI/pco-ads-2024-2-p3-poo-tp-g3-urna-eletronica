package urna_eletronica.urna.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import urna_eletronica.urna.Entity.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
  
}
