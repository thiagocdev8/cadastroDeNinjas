package dev.java10x.cadastroDeNinjas.Ninjas;


import dev.java10x.cadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;


//entity ele transforma uma classe em uma entidade do banco de DADOS
//JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "age")
    private int idade;

    // @ManyToOne - Many ninjas to One missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //foreign key
    private MissoesModel missoes;


}
