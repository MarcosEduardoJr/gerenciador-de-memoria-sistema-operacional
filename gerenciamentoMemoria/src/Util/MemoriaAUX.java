package Util;

public class MemoriaAUX {
	
	private int idP;
	private int idM;
	private int tamanho;
	
	public MemoriaAUX(int idp, int tamanho, int idm){
		setIdP(idp);
		setTamanho(tamanho);
		setIdm(idm);
	}
	
	public MemoriaAUX(){
		
	}
	
	public int getIdp() {
		return idP;
	}
	public void setIdP(int id) {
		this.idP = id;
	}
	public int getIdm() {
		return idM;
	}
	public void setIdm(int id) {
		this.idM = id;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return "MemoriaAUX [idP=" + idP + ", idM=" + idM + ", tamanho=" + tamanho + "]";
	}

	

}
