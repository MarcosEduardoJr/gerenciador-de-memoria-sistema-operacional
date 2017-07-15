package Util;

public class Processo {
	private Integer id;
	private Integer computacao;
	private Integer alocado;
	private Integer visitado;

	Processo(Integer computacao, Integer alocado, Integer visitado, Integer id) {
		this.id = id;
		this.computacao = computacao;
		this.alocado = alocado;
		this.visitado = visitado;
	}
	
	public Processo(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getComputacao() {
		return computacao;
	}

	public void setComputacao(Integer computacao) {
		this.computacao = computacao;
	}

	public Integer getAlocado() {
		return alocado;
	}

	public void setAlocado(Integer alocado) {
		this.alocado = alocado;
	}

	public Integer getVisitado() {
		return visitado;
	}

	public void setVisitado(Integer visitado) {
		this.visitado = visitado;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", computacao=" + computacao + ", alocado=" + alocado + ", visitado=" + visitado
				+ "]";
	}
	
	

}
