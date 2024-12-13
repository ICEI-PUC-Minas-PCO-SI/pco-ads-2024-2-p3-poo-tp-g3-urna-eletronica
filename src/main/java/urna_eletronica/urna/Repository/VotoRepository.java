package urna_eletronica.urna.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import urna_eletronica.urna.Entity.Candidato;
import urna_eletronica.urna.Entity.Pleito;
import urna_eletronica.urna.Entity.Voto;


@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
  
  @Query(value = "SELECT * FROM voto WHERE cpf = :cpf AND pleito_id = :pleitoId", nativeQuery = true)
  Optional<Voto> findByCpf(@Param("cpf") String cpf, @Param("pleitoId") Long pleitoId);

  List<Voto> findByPleito(Pleito pleito);

  long countByCandidato(Candidato candidato);


}
