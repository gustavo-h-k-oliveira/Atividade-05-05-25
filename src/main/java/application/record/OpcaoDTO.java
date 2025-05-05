package application.record;

import application.model.Opcao;

public record OpcaoDTO(long id, String descricao, boolean isCorreta) {
    public OpcaoDTO(Opcao model) {
        this(model.getId(), model.getDescricao(), model.isCorreta());
    }
}
