package urna_eletronica.urna.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import urna_eletronica.urna.Entity.PleitoExecutivo;

@Repository
public interface PleitoExecutivoRepository extends JpaRepository<PleitoExecutivo, Long> {
  
  @Query(value = "SELECT COUNT(*) FROM voto WHERE candidato_id = :candidato_id", nativeQuery = true)
Integer contarVotosSimples(@Param("candidato_id") Long candidatoId);

}
