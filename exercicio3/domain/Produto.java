package exercicio3.domain;

public class Produto {

	private String nome;
	private String descricao;
	private Float valor;
	
	public Produto( String nome, String descricao, Float valor ) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao( String descricao ) {
		this.descricao = descricao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor( Float valor ) {
		this.valor = valor;
	}
}
