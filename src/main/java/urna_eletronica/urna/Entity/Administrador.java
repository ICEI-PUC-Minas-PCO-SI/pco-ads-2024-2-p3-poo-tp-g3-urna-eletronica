package urna_eletronica.urna.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import urna_eletronica.urna.VO.AdministradorVo;

@Data
@Entity
@DiscriminatorValue("Administrador")
public class Administrador extends Usuario {
  private String funcao;
  private boolean temAcessoTotal;
  private boolean podeAlterarPleitos;
  private boolean podeGerenciarCandidatos;
  private boolean podeVerResultados;

  public Administrador(String _nome, String _email, String _senha,
   String _cpf, String _funcao, boolean _temAcessoTotal, boolean _podeAlterarPleitos,
   boolean _podeGerenciarCandidatos, boolean _podeVerResultados, Integer idade){
     super(_nome, _email, _senha, _cpf, idade);

    this.funcao = _funcao;
    this.temAcessoTotal = _temAcessoTotal;
    this.podeAlterarPleitos =  _podeAlterarPleitos;
    this.podeGerenciarCandidatos = _podeGerenciarCandidatos;
    this.podeVerResultados = _podeVerResultados;

    }

    public Administrador(){}

    public AdministradorVo toVo(){
      AdministradorVo vo = new AdministradorVo();
      vo.setCpf(getCpf());
      vo.setEmail(getEmail());
      vo.setFuncao(getFuncao());
      vo.setNome(getNome());
      vo.setId(getId());
      vo.setTemAcessoTotal(temAcessoTotal);
      return vo;
    }
}
