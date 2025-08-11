package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaDTO;
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
    public List<MissoesDTO> listarMissoes(){

        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissoesPorId(@PathVariable Long id){

        return missoesService.listarMissoesPorId(id);
    }

    //POST - mandar requisicao para criar as missoes
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missaoDTO){

        return missoesService.criarMissoes(missaoDTO);
    }

    //PUT - mandar requisicao para alterar as missoes
    @PutMapping("/alterar{id}")
    public String alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        missoesService.atualizarMissao(id, missoesDTO);
        return "Missão ID: " + id +" alterado";
    }

    //Delete - mandar requisicao para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
        return "Missao ID:" + id + " deletada com sucesso";
    }




}
