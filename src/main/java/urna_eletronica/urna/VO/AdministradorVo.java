package urna_eletronica.urna.VO;

import lombok.Data;

@Data
public class AdministradorVo extends UsuarioVo {
  private String funcao;
  private boolean temAcessoTotal;
  private boolean podeAlterarPleitos;
  private boolean podeGerenciarCandidatos;
  private boolean podeVerResultados;

  public AdministradorVo(
    String _nome, String _email, String _senha, String _cpf, String _funcao,
    boolean _temAcessoTotal, boolean _podeAlterarPleitos,
    boolean _podeGerenciarCandidatos, boolean _podeVerResultados, Integer idade
  ){
    super(_nome, _email, _senha, _cpf, idade);
    this.funcao = _funcao;
    this.temAcessoTotal = _temAcessoTotal;
    this.podeAlterarPleitos = _podeAlterarPleitos;
    this.podeGerenciarCandidatos = _podeAlterarPleitos;
    this.podeVerResultados = _podeVerResultados;
  }

  public AdministradorVo(){}

}
