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
@Table( name = "item" )
public class Item {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "descricao" )
    private String descricao;

    @Column( name = "status" )
    private StatusEnum status;

    @ManyToOne
    @JoinColumn( name = "id_pedido", referencedColumnName = "id", nullable = false )
    private Pedido pedido;
    
}
