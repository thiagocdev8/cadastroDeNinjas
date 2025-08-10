package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    //GET - mandar uma requisao para mostrar todas as missoes
    @GetMapping
    public String missoes(){
        return "Essa é a lista de missoes";
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
