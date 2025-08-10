package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesMapper missoesMapper;
    private final MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }

    //listar todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //listar missoes por id
    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    //criar missoes
    public MissoesDTO criarMissoes(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    //deletar missoes
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
}
