# API com Autenticação

Partindo do projeto desenvolvido em aula ([security-tutorial-api-ex](https://github.com/marcoweb/security-tutorial-api-ex)), construa os artefatos (Modelo, DTO, Serviço, Controlador) necessários para gerenciar os modelos abaixo:

![Modelos](image.png)

## Modelos

### Categoria

* id: Long
* nome: String

### Opção

* id: Long
* descricao: String
* isCorreta: boolean
* questao: Questao

### Questão

* id: Long
* enunciado: String
* opcoes: List<Opcao>
* categoria: Categoria
