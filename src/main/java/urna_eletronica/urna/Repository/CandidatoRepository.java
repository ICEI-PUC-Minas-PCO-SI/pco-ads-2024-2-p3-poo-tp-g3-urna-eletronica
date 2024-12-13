package urna_eletronica.urna.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import urna_eletronica.urna.Entity.Candidato;
@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
  
  @Query(value = "SELECT * FROM usuario u WHERE u.pleito_id = :id", nativeQuery = true)
  List<Candidato> findAllCandidatosPleito(@Param("id") Long id);

  @Query(value = "SELECT * FROM USUARIO u where u.codigo = :codigo", nativeQuery = true)
  Optional<Candidato> findByCodigo(@Param("codigo") Integer codigo);

}
