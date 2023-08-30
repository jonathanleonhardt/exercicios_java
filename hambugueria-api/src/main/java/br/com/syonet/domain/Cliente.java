package br.com.syonet.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table( name = "cliente" )
public class Cliente {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "nome" )
    private String nome;

    @Column( name = "email" )
    private String email;

    @Column( name = "documento" )
    private String documento;

    @ManyToOne
    @JoinColumn( name = "id_hamburgueria", referencedColumnName = "id", nullable = false )
    private Hamburgueria hamburgueria;

}
