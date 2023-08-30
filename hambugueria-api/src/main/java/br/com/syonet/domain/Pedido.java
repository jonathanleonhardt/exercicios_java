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
@Table( name = "pedido" )
public class Pedido {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "descricao" )
    private String descricao;

    @Column( name = "status" )
    private StatusEnum status;

    @Column( name = "data" )
    private Long data;

    @ManyToOne
    @JoinColumn( name = "id_hamburgueria", referencedColumnName = "id", nullable = false )
    private Hamburgueria hamburgueria;

}
