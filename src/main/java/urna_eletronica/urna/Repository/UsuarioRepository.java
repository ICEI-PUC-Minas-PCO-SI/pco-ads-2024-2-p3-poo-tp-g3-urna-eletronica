package urna_eletronica.urna.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import urna_eletronica.urna.Entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
  boolean existsByCpf(String cpf);
   @Query(value = "SELECT * FROM usuario u WHERE u.cpf = :cpf AND u.senha = :senha", nativeQuery = true)
    Optional<Usuario> findByCpfAndSenha(@Param("cpf") String cpf, @Param("senha") String senha);
    
}
