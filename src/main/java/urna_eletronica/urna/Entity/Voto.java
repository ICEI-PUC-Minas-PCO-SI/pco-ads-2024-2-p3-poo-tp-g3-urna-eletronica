package urna_eletronica.urna.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Voto {
  
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Pleito pleito;
  
  @ManyToOne
  private Candidato candidato;

  private Date dataHora;

  private String cpf;

  private Integer votoNulo;

  private Integer votoBranco;
}
