package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import application.record.QuestaoDTO;
import application.service.QuestaoService;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {
    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public Iterable<QuestaoDTO> getAll() {
        return questaoService.getAll();
    }

    @PostMapping
    public QuestaoDTO insert(@RequestBody QuestaoDTO questao) {
        return questaoService.insert(questao);
    }
}
