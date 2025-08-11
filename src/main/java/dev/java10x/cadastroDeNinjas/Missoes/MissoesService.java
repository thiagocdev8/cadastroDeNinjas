package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesMapper missoesMapper;
    private final MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }

    //listar todas as missoes
    public List<MissoesDTO> listarMissoes(){

        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //listar missoes por id
    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    //criar missoes
    public MissoesDTO criarMissoes(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    //atualizar missao
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }

        return null;
    }

    //deletar missoes
    public void deletarMissao(Long id){

        missoesRepository.deleteById(id);
    }
}
