package Util;

public class Memoria {
	private Integer idProcesso;

	private String estado;
	private Integer inicio;
	private Integer tamanho;

	Memoria(String estado, Integer inicio, Integer tamanho, Integer id) {
		this.idProcesso = id;
		this.estado = estado;
		this.inicio = inicio;
		this.tamanho = tamanho;

	}

	public Integer getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Integer id) {
		this.idProcesso = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getInicio() {
		return inicio;
	}

	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return "(id processo:"+idProcesso+"),"+ estado + "," + inicio + "," + tamanho;
	}

}
