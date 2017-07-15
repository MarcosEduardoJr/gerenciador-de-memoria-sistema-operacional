package Util;

public class ProcessoN {
	
	private int id;
	private int tamanho;
	
	public ProcessoN(int id, int tamanho){
		setId(id);
		setTamanho(tamanho);
	}
	
	public ProcessoN(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public String toString() {
		return "id: " + id + ", tamanho: " + tamanho;
	}
	
	

}
