package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET - mandar uma requisao para mostrar todas as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //POST - mandar requisicao para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "missao criada";
    }

    //PUT - mandar requisicao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "missão alterada";
    }

    //Delete - mandar requisicao para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }




}
