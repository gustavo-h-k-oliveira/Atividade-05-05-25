package application.record;

import application.model.Questao;

import java.util.List;

public record QuestaoDTO(long id, String enunciado, List<OpcaoDTO> opcoes, long categoriaId) {
    public QuestaoDTO(Questao model) {
        this(
            model.getId(),
            model.getEnunciado(),
            model.getOpcoes().stream().map(OpcaoDTO::new).toList(),
            model.getCategoria().getId()
        );
    }
}