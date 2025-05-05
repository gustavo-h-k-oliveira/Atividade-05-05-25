package application.model;

import application.record.QuestaoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "questoes")
@Getter
@Setter
@NoArgsConstructor
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String enunciado;

    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL)
    private List<Opcao> opcoes;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Questao(QuestaoDTO dto, Categoria categoria) {
        this.id = dto.id();
        this.enunciado = dto.enunciado();
        this.categoria = categoria;
    }
}
