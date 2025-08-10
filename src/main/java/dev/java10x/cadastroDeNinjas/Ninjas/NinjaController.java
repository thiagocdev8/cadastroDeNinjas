package dev.java10x.cadastroDeNinjas.Ninjas;

import org.springframework.data.jpa.repository.JpaRepository;
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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // procurar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    //alterar dado do ninja (UPDATE)
    @PutMapping("/alterar/id")
    public String alterarNinjaPorId(){
        return "Ninja alterado";
    }

    //deletar ninja (DELETE
   @DeleteMapping("/deletar/{id}")
    public String deleteNinjaPorId(@PathVariable Long id) {
        ninjaService.deleteNinjaPorId(id);
        return "Ninja ID: "+ id + " deletado.";
    }


}
