package exercicios.hamburgueria.domain;

import java.util.List;

import exercicios.hamburgueria.enumeration.MetodoParamentoEnum;
import exercicios.hamburgueria.enumeration.StatusPedidoEnum;

public class Pedido {

	private Integer numeroPedido;
	private Cliente cliente;
	private List< Produto >  produtos;
	private MetodoParamentoEnum metodoPagamento;
	private StatusPedidoEnum status;
	private Boolean isRetirada;
	private String data;

	public Pedido( Integer numeroPedido, List< Produto > produtos, 
			StatusPedidoEnum status, MetodoParamentoEnum metodoPagamento, 
			Boolean isRetirada, Cliente cliente, String data ) {
		this.numeroPedido = numeroPedido;
		this.produtos = produtos;
		this.status = status;
		this.metodoPagamento = metodoPagamento;
		this.isRetirada = isRetirada;
		this.cliente = cliente;
		this.data = data;
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido( Integer numeroPedido ) {
		this.numeroPedido = numeroPedido;
	}
	public List< Produto > getProdutos() {
		return produtos;
	}
	public void setProdutos( List< Produto > produtos ) {
		this.produtos = produtos;
	}
	public StatusPedidoEnum getStatus() {
		return status;
	}
	public void setStatus( StatusPedidoEnum status ) {
		this.status = status;
	}

	public MetodoParamentoEnum getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento( MetodoParamentoEnum metodoPagamento ) {
		this.metodoPagamento = metodoPagamento;
	}

	public Boolean getIsRetirada() {
		return isRetirada;
	}

	public void setIsRetirada( Boolean isRetirada ) {
		this.isRetirada = isRetirada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente( Cliente cliente ) {
		this.cliente = cliente;
	}

	public String getData() {
		return data;
	}

	public void setData( String data ) {
		this.data = data;
	}

}
