package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;

    private String dificuldade;

    //OneToMany - One mission to Many ninjas
    @OneToMany(mappedBy = "missoes") // Foreign key
    private List<NinjaModel> ninjas;


}
