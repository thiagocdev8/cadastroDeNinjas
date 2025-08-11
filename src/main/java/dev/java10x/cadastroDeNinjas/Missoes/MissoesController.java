package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){

        List<MissoesDTO> missoes =  missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);

    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id){

        MissoesDTO missao = missoesService.listarMissoesPorId(id);
        if(missao != null){
            return ResponseEntity.ok(missao);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão ID: " + id + " não encontrada");
        }
    }

    //POST - mandar requisicao para criar as missoes
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missaoDTO){
        MissoesDTO novaMissao = missoesService.criarMissoes(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNome()
                + " | ID: " + novaMissao.getId());
    }

    //PUT - mandar requisicao para alterar as missoes
    @PutMapping("/alterar{id}")
    public ResponseEntity<String> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        if(missoesService.listarMissoesPorId(id) != null){
            missoesService.atualizarMissao(id, missoesDTO);
            return ResponseEntity.ok().body("Missão ID: " + id + " alterado");
        }
       else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão ID: " + id + " não encontrada");
        }

    }

    //Delete - mandar requisicao para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if(missoesService.listarMissoesPorId(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok().body("Missao ID: " + id +  " deletada com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão ID: " + id + " não encontrada");
        }

    }




}
