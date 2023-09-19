package eduvdavollmedapi.model.consulta.validacoes.agendamento;

import eduvdavollmedapi.DTO.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferecaEmMinutos = Duration.between(agora,dataConsulta).toMinutes();


        if ( diferecaEmMinutos < 30 ) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }
    }
}
