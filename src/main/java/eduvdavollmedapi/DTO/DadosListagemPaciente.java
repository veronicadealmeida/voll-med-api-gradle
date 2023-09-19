package eduvdavollmedapi.DTO;

import eduvdavollmedapi.model.Paciente;

public record DadosListagemPaciente(Long id, String nome, String email, String cpf, String telefone) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }
}
