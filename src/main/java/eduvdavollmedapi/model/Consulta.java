package eduvdavollmedapi.model;

import eduvdavollmedapi.enums.MotivoCancelamento;
import eduvdavollmedapi.model.Medico;
import eduvdavollmedapi.model.Paciente;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "voll_consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@SecurityRequirement(name = "bearer-key")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;

    public void cancelar(MotivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }
}