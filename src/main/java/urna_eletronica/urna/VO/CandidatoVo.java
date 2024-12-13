package urna_eletronica.urna.VO;

import lombok.Data;

@Data
public class CandidatoVo extends UsuarioVo {
  private PartidoVo partidoVo;
  private String cargoDisputado;
  private PleitoVo pleitoVo;
  private Integer codigo;

  public CandidatoVo(String _nome, String _email, String _senha, String _cpf, Integer idade){
    super(_nome, _email, _senha, _cpf, idade);
  }

  public CandidatoVo(){}
}
