package urna_eletronica.urna.VO;

import java.util.Date;

import lombok.Data;

@Data
public class VotoVo {
  
  private Long id;
  private PleitoVo pleitoVo;
  private CandidatoVo candidatoVo;
  private Date data_hora;
  private String cpf;
  private Integer votoNulo;
  private Integer votoBranco;
}
