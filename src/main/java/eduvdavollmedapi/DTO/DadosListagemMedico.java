package eduvdavollmedapi.DTO;

import eduvdavollmedapi.enums.Especialidade;
import eduvdavollmedapi.model.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}