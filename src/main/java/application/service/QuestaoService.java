package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Categoria;
import application.model.Opcao;
import application.model.Questao;
import application.record.QuestaoDTO;
import application.repository.CategoriaRepository;
import application.repository.QuestaoRepository;

import java.util.List;

@Service
public class QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepo;

    @Autowired
    private CategoriaRepository categoriaRepo;

    public Iterable<QuestaoDTO> getAll() {
        return questaoRepo.findAll().stream().map(QuestaoDTO::new).toList();
    }

    public QuestaoDTO insert(QuestaoDTO dto) {
        Categoria categoria = categoriaRepo.findById(dto.categoriaId())
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Questao questao = new Questao(dto, categoria);
        List<Opcao> opcoes = dto.opcoes().stream()
            .map(opcaoDTO -> new Opcao(opcaoDTO, questao))
            .toList();

        questao.setOpcoes(opcoes);
        return new QuestaoDTO(questaoRepo.save(questao));
    }
}
