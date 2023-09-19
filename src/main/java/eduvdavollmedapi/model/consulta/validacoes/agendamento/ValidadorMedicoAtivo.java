package eduvdavollmedapi.model.consulta.validacoes.agendamento;

import eduvdavollmedapi.DTO.DadosAgendamentoConsulta;
import eduvdavollmedapi.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }

        var medicoAtivo = repository.findAtivoById(dados.idMedico());
        if(! medicoAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluído");
        }
    }
}
