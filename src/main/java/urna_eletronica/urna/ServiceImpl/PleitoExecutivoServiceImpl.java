package urna_eletronica.urna.ServiceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urna_eletronica.urna.Entity.Candidato;
import urna_eletronica.urna.Entity.PleitoExecutivo;
import urna_eletronica.urna.Entity.Voto;
import urna_eletronica.urna.Repository.PleitoExecutivoRepository;
import urna_eletronica.urna.Repository.VotoRepository;
import urna_eletronica.urna.Services.PleitoExecutivoService;
import urna_eletronica.urna.VO.PleitoExecutivoVo;
import urna_eletronica.urna.VO.ResultadoPleitoVo;

@Service
public class PleitoExecutivoServiceImpl implements PleitoExecutivoService {

  @Autowired private VotoRepository votoRepository;
  @Autowired private PleitoExecutivoRepository pleitoExecutivoRepository;

  private PleitoExecutivo toEntity(PleitoExecutivoVo vo){
    PleitoExecutivo pleito = new PleitoExecutivo(new Date(), vo.getDataFim(), vo.getVagasDisponiveis(), vo.getMinimoParaSegundoTurno(), vo.getNome());
    return pleito;
  }

  @Override
  public String cadastrarPleitoExecutivo(PleitoExecutivoVo vo) {
    try {
      pleitoExecutivoRepository.save(toEntity(vo));
      return ("Cadastro salvo com sucesso!");
    } catch (Exception e) {
      System.err.println("Erro ao salvar o objeto: " + e.getMessage());
      e.printStackTrace();
    }
    return "Cadastro não foi feito";

  }

  @Override
  public ResultadoPleitoVo apurarResultadoPrimeiroTurno(Long _id) {
    Optional<PleitoExecutivo> pleitoExecutivo = pleitoExecutivoRepository.findById(_id);
    List<Voto> votos = votoRepository.findByPleito(pleitoExecutivo.get());
    
    long totalVotos = votos.size();
    long maioriaSimples = totalVotos / 2;

    
    Map<Candidato, Long> votosPorCandidato = votos.stream()
        .collect(Collectors.groupingBy(Voto::getCandidato, Collectors.counting()));

    
    Candidato vencedor = null;
    for (Map.Entry<Candidato, Long> entry : votosPorCandidato.entrySet()) {
        if (entry.getValue() > maioriaSimples) {
            vencedor = entry.getKey();
            break;
        }
    }

    
    if (vencedor != null) {
        return new ResultadoPleitoVo(vencedor, true); 
    }

    
    List<Candidato> doisMaisVotados = votosPorCandidato.entrySet().stream()
        .sorted(Map.Entry.<Candidato, Long>comparingByValue().reversed())
        .limit(2)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());

    return new ResultadoPleitoVo(doisMaisVotados, false); 
}

  @Override
  public List<PleitoExecutivoVo> findAll() {
    List<PleitoExecutivo> list = pleitoExecutivoRepository.findAll();
    return list.stream().map(PleitoExecutivo::toVo).toList();
  }

  
  public List<Candidato> calcuCandidatosSegundoTurno(Map<Candidato, Integer> votosPorCandidato, PleitoExecutivo pleito) {
    List<Candidato> candidatosPrimeiroTurno = new ArrayList<>();
    
    // Filtra os candidatos que têm votos suficientes para o segundo turno
    votosPorCandidato.entrySet().stream()
      .filter(entry -> entry.getValue() >= pleito.getMinimoParaSegundoTurno())
      .forEach(entry -> candidatosPrimeiroTurno.add(entry.getKey()));
    
    // Ordena os candidatos por número de votos para os dois primeiros
    candidatosPrimeiroTurno.sort(Comparator.comparingInt(votosPorCandidato::get).reversed());
    
    // Retorna os dois primeiros candidatos, ou a lista completa se houver menos de dois
    return candidatosPrimeiroTurno.size() > 1 ? candidatosPrimeiroTurno.subList(0, 2) : candidatosPrimeiroTurno;
  }
  


private Candidato determinarVencendorSegundoTurno(List<Candidato> candidatosSegundoTurno) {
  if (candidatosSegundoTurno.size() < 2) {
    throw new IllegalStateException("Não há candidatos suficientes para o segundo turno.");
  }
  
  Candidato candidato1 = candidatosSegundoTurno.get(0);
  Candidato candidato2 = candidatosSegundoTurno.get(1);
  
  // Simples comparação de votos
  // if (candidato1.getVotos() > candidato2.getVotos()) {
  //   return candidato1;
  // } else if (candidato2.getVotos() > candidato1.getVotos()) {
  //   return candidato2;
  // } else {
    // Empate: maior idade decide
    return candidato1.getIdade() > candidato2.getIdade() ? candidato1 : candidato2;
  }
}



