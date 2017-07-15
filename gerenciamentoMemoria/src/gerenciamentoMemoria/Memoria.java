package gerenciamentoMemoria;

public class Memoria {

	private String estado;
	private Integer particaoBase;
	private Integer particaoFinal;

	Memoria(String estado, Integer particaoBase, Integer particaoFinal) {

		this.estado = estado;
		this.particaoBase = particaoBase;
		this.particaoFinal = particaoFinal;

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
