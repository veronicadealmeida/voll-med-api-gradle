package eduvdavollmedapi.DTO;

import eduvdavollmedapi.enums.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo) {
}