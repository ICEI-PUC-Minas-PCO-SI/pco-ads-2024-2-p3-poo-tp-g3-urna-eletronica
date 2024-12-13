package urna_eletronica.urna.VO;

import lombok.Data;

@Data
public  class UsuarioVo {  
  private Long id;
  private String nome;
  private String email;
  private String senha;
  private String cpf;
  private Integer idade;

  public UsuarioVo(){}
  public UsuarioVo(String _nome, String _email, String _senha, String _cpf, Integer idade){
    this.nome = _nome;
    this.email = _email;
    this.senha = _senha;
    this.cpf = _cpf;
    this.idade = idade;
  }



}
