package urna_eletronica.urna.Entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Eleitor extends Usuario {
  private boolean votou;
}
