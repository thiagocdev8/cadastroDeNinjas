package dev.java10x.cadastroDeNinjas.Ninjas;

import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }


    //adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome()
                + " | ID: " + novoNinja.getId());

    }

    //mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // procurar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if(ninja != null){
            ninjaService.listarNinjasPorId(id);
            return ResponseEntity.ok(ninja);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja ID: " + id +  " não encontrado");
        }
    }

    //alterar dado do ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.atualizarNinja(id, ninjaDTO);
            return ResponseEntity.ok().body("Ninja ID: " + id + " alterado");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja ID: " + id + " não encontrado");
        }

    }

    //deletar ninja (DELETE
   @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteNinjaPorId(@PathVariable Long id) {
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deleteNinjaPorId(id);
            return ResponseEntity.ok("Ninja #" + id + " deletado com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja ID: " + id + " nao encontrado");
        }
    }


}
