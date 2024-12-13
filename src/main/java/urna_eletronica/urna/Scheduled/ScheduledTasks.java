package urna_eletronica.urna.Scheduled;

import java.util.List;

// SLF4J para logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// Spring Framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import urna_eletronica.urna.Entity.PleitoLegislativo;
import urna_eletronica.urna.Repository.PleitoLegislativoRespository;
import urna_eletronica.urna.Services.PleitoLegislativoService;


@Component
public class ScheduledTasks {

    @Autowired private PleitoLegislativoService pleitoLegislativoService;
    @Autowired private PleitoLegislativoRespository pleitoLegislativoRepository;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(cron = "0 */1 * * * ?")
    public void apuracaoPleitoLegislativo() {
        logger.info("Iniciando apuração dos pleitos legislativos.");
        List<PleitoLegislativo> pleitos = pleitoLegislativoRepository.findAll();

        // for (PleitoLegislativo pleito : pleitos) {
        //     try 
        
        //         pleitoLegislativoService.apurarResultadosPleitoLegislativo(pleito);
        //         logger.info("Apuração concluída para o pleito: {}", pleito.getId());
        //     } catch (Exception e) {
        //         logger.error("Erro ao apurar resultados para o pleito: {}", pleito.getId(), e);
        //     }
        // }

        logger.info("Apuração dos pleitos legislativos finalizada.");
    }
}

