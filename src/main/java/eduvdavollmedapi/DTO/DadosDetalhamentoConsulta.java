package eduvdavollmedapi.DTO;

import eduvdavollmedapi.model.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long idPaciente, Long idMedico, LocalDateTime data) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(),consulta.getPaciente().getId(), consulta.getMedico().getId(),consulta.getData());
    }
}
