package urna_eletronica.urna.ServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urna_eletronica.urna.Entity.Partido;
import urna_eletronica.urna.Entity.Pleito;
import urna_eletronica.urna.Entity.PleitoLegislativo;
import urna_eletronica.urna.Entity.ResultadoPartido;
import urna_eletronica.urna.Entity.Voto;
import urna_eletronica.urna.Repository.PleitoLegislativoRespository;
import urna_eletronica.urna.Repository.ResultadoPartidoRepository;
import urna_eletronica.urna.Repository.VotoRepository;
import urna_eletronica.urna.Services.PleitoLegislativoService;
import urna_eletronica.urna.VO.PleitoLegislativoVo;

@Service
public class PleitoLegislativoServiceImpl implements PleitoLegislativoService {

  @Autowired private ResultadoPartidoRepository resultadoPartidoRepository;
  @Autowired private VotoRepository votoRepository;
  @Autowired private PleitoLegislativoRespository pleitoLegislativoRespository;

  private PleitoLegislativo toEntity(PleitoLegislativoVo vo){
    PleitoLegislativo pleito = new  PleitoLegislativo(
      new Date(), vo.getDataFim(), vo.getVagasDisponiveis(),
      vo.getVotosValidos(), vo.getNome());
    return pleito;
  }
  

  @Override
  public String cadastraPleitoLegislativo(PleitoLegislativoVo vo) {
    PleitoLegislativo pleito = toEntity(vo);

    if(pleito != null){
      try {
        pleitoLegislativoRespository.save(pleito);
        return "Pleito Legislativo criado com sucesso";
      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Erro ao criar pleito");
      }
    }

    return "Pleito não foi criado";
  }

  @Override
  public List<PleitoLegislativoVo> findAll(){
    List<PleitoLegislativo> list = pleitoLegislativoRespository.findAll();
    return list.stream().map(PleitoLegislativo::toVo).toList();
  }

  @Override
public void apurarResultadosPleitoLegislativo(PleitoLegislativo pleito) {
    // 1. Calcular os votos válidos
    int votosValidos = calcularVotosValidos(pleito);
  
    pleito.setVotosValidos(votosValidos);

    // 2. Calcular o Quociente Eleitoral
    int quocienteEleitoral = calcularQuocienteEleitoral(pleito);
  
    pleito.setQuocienteEleitoral(quocienteEleitoral);

    // 3. Calcular o Quociente Partidário e distribuir cadeiras
    Map<Partido, Integer> cadeirasPorPartido = calcularCadeirasPartidos(pleito, quocienteEleitoral);

    // 4. Persistir os resultados ou retornar os dados
    salvarResultados(cadeirasPorPartido, pleito);
}

private int calcularVotosValidos(PleitoLegislativo pleito) {
    return votoRepository.findByPleito(pleito).size();
}

public int calcularQuocienteEleitoral(PleitoLegislativo pleito) {
    long votosValidos = votoRepository.findByPleito(pleito).size();
  
    return Math.toIntExact(votosValidos / pleito.getVagasDisponiveis());
}

public Map<Partido, Integer> calcularQuocientePartidário(PleitoLegislativo pleito) {
    int quocienteEleitoral = calcularQuocienteEleitoral(pleito);

    return calcularVotosPorPartido(pleito).entrySet().stream()
        .collect(Collectors.toMap(
            Map.Entry::getKey, // Partido
            entry -> entry.getValue() / quocienteEleitoral 
        ));
}



public Map<Partido, Integer> calcularVotosPorPartido(Pleito pleito) {
    List<Voto> votos = votoRepository.findByPleito(pleito); // Recupera todos os votos do pleito

    return votos.stream()
        .collect(Collectors.groupingBy(
            voto -> voto.getCandidato().getPartido(), // Agrupa os votos pelo partido do candidato
            Collectors.summingInt(voto -> 1) // Soma 1 para cada voto no grupo
        ));
}

public Map<Partido, Integer> calcularCadeirasPartidos(PleitoLegislativo pleito, int quocienteEleitoral) {

  Map<Partido, Integer> votosPorPartido = calcularVotosPorPartido(pleito);

    // Calcular o número de cadeiras para cada partido com base no quociente eleitoral
    Map<Partido, Integer> cadeirasPorPartido = new HashMap<>();
    for (Map.Entry<Partido, Integer> entry : votosPorPartido.entrySet()) {
        Partido partido = entry.getKey();
        int votosPartido = entry.getValue();
    

        if (quocienteEleitoral > 0) {
            int cadeiras = votosPartido / quocienteEleitoral;
            cadeirasPorPartido.put(partido, cadeiras);
        } else {

          System.err.println("Quociente eleitoral é zero, não é possível calcular cadeiras.");
        }
    }
    

    // Distribuir as cadeiras restantes, caso existam
    int vagasRestantes = pleito.getVagasDisponiveis() - cadeirasPorPartido.values().stream().mapToInt(Integer::intValue).sum();

    if (vagasRestantes > 0) {
        distribuirCadeirasRestantes(votosPorPartido, cadeirasPorPartido, vagasRestantes, quocienteEleitoral);
    }

    return cadeirasPorPartido;
}

private void distribuirCadeirasRestantes(Map<Partido, Integer> votosPorPartido, Map<Partido, Integer> cadeirasPorPartido, int vagasRestantes, int quocienteEleitoral) {

  List<Partido> partidosOrdenados = votosPorPartido.entrySet().stream()
        .sorted((a, b) -> {
            int restoA = a.getValue() % quocienteEleitoral;
            int restoB = b.getValue() % quocienteEleitoral;
            return Integer.compare(restoB, restoA); // Ordem decrescente
        })
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());

    // Distribuir as vagas restantes
    for (int i = 0; i < vagasRestantes; i++) {
        Partido partido = partidosOrdenados.get(i % partidosOrdenados.size());
        cadeirasPorPartido.put(partido, cadeirasPorPartido.getOrDefault(partido, 0) + 1);
    }
}

public void salvarResultados(Map<Partido, Integer> cadeirasPorPartido, Pleito pleito) {
    for (Map.Entry<Partido, Integer> entry : cadeirasPorPartido.entrySet()) {
        Partido partido = entry.getKey();
        Integer cadeiras = entry.getValue();

        // Criar o objeto ResultadoPartido
        ResultadoPartido resultado = new ResultadoPartido();
        resultado.setPleito(pleito);
        resultado.setPartido(partido);
        resultado.setCadeiras(cadeiras);

        // Persistir o resultado
        resultadoPartidoRepository.save(resultado);
    }
}


}
