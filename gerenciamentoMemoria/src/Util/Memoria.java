package Util;

public class Memoria {
	private Integer idProcesso;

	private String estado;
	private Integer particaoBase;
	private Integer particaoFinal;

	Memoria(String estado, Integer particaoBase, Integer particaoFinal, Integer id) {
		this.idProcesso = id;
		this.estado = estado;
		this.particaoBase = particaoBase;
		this.particaoFinal = particaoFinal;

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

	public Integer getParticaoBase() {
		return particaoBase;
	}

	public void setParticaoBase(Integer particaoBase) {
		this.particaoBase = particaoBase;
	}

	public Integer getParticaoFinal() {
		return particaoFinal;
	}

	public void setParticaoFinal(Integer particaoFinal) {
		this.particaoFinal = particaoFinal;
	}

}
