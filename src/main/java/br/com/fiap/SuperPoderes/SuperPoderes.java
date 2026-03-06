package br.com.fiap.SuperPoderes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "superpoder")
public class SuperPoderes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Integer nivel_inutilidade;
}
