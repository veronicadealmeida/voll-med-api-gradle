package eduvdavollmedapi.model.consulta.validacoes.agendamento;

import eduvdavollmedapi.DTO.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsulta dados);
}