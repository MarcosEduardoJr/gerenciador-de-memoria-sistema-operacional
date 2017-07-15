package Algoritmos;

import java.util.ArrayList;

import Util.Memoria;
import Util.MemoriaAUX;
import Util.Processo;
import Util.ProcessoN;
import Util.Arquivo;

public class AlgoritmosAlocMEMO {

	private static final String txtMemoria = "entrada/entrada-memoria.txt";
	private static final String txtProcessos = "entrada/entrada-processos.txt";
	private static Arquivo a = new Arquivo();
	private static ArrayList<Memoria> MemoriaLIDA = new ArrayList<Memoria>();
	private static ArrayList<Processo> ProcessosLIDOS = new ArrayList<Processo>();
	private static ArrayList<ProcessoN> ProcessosNALOCADOS = new ArrayList<ProcessoN>();

	public static void main(String[] args) {

		System.out.println("PARA RODAR NOVAMENTE O PROGRAMA");
		System.out.println("DELETE TODOS OS ARQUIVOS DE SAIDA");
		System.out.println("");

		resetDATA();
		System.out.println("Rodando Frist Fit...");
		FristFIT(MemoriaLIDA, ProcessosLIDOS);
		System.out.println("Terminado");
		System.out.println("");
		resetDATA();
		System.out.println("Rodando Next Fit...");
		NextFIT(MemoriaLIDA, ProcessosLIDOS);
		System.out.println("Terminado");
		System.out.println("");
		resetDATA();
		System.out.println("Rodando Best Fit...");
		BestFIT(MemoriaLIDA, ProcessosLIDOS);
		System.out.println("Terminado");
		System.out.println("");
		resetDATA();
		System.out.println("Rodando Worst Fit...");
		WorstFIT(MemoriaLIDA, ProcessosLIDOS);
		System.out.println("Terminado");

		System.out.println("");
		resetDATA();

		System.out.println("PARA RODAR NOVAMENTE O PROGRAMA");
		System.out.println("DELETE TODOS OS ARQUIVOS DE SAIDA");

	}

	public static void FristFIT(ArrayList<Memoria> Memoria, ArrayList<Processo> Processos) {

		int tamanhoM = -1;
		ProcessoN auxN = new ProcessoN();

		for (Processo processo : Processos) {

			for (Memoria memoriaI : Memoria) {

				tamanhoM = memoriaI.getTamanho();
				tamanhoM = (tamanhoM < 0 ? -tamanhoM : tamanhoM);

				if ((memoriaI.getEstado().equals("H")) && (processo.getComputacao() <= tamanhoM)
						&& (processo.getAlocado() == 0)) {

					memoriaI.setEstado("P");
					memoriaI.setIdProcesso(processo.getId());
					processo.setAlocado(1);

				}

			}

		}

		for (Processo p : Processos) {
			if (p.getAlocado() == 0) {
				auxN.setId(p.getId());
				auxN.setTamanho(p.getComputacao());
				ProcessosNALOCADOS.add(auxN);
			}
			auxN = new ProcessoN();
		}

		escreverArquivo("FRIST-FIT");

	}

	public static void NextFIT(ArrayList<Memoria> Memoria, ArrayList<Processo> Processos) {

		int tamanhoM = -1;
		ProcessoN auxN = new ProcessoN();
		int num = 0;

		for (Processo processo : Processos) {

			for (int i = num; i < Memoria.size(); i++) {

				tamanhoM = Memoria.get(i).getTamanho();
				tamanhoM = (tamanhoM < 0 ? -tamanhoM : tamanhoM);

				if ((Memoria.get(i).getEstado().equals("H")) && (processo.getComputacao() <= tamanhoM)
						&& (processo.getAlocado() == 0)) {

					Memoria.get(i).setEstado("P");
					Memoria.get(i).setIdProcesso(processo.getId());
					processo.setAlocado(1);
					num = i;
				}

				if (i + 1 == Memoria.size()) {
					num = 0;
				}

			}
		}

		for (Processo p : Processos) {
			if (p.getAlocado() == 0) {
				auxN.setId(p.getId());
				auxN.setTamanho(p.getComputacao());
				ProcessosNALOCADOS.add(auxN);
			}
			auxN = new ProcessoN();
		}

		escreverArquivo("NEXT-FIT");

	}

	public static void BestFIT(ArrayList<Memoria> Memoria, ArrayList<Processo> Processos) {

		boolean key = false;
		int tamanhoMV = -1;
		ProcessoN auxN = new ProcessoN();
		ArrayList<MemoriaAUX> MemoriaV = new ArrayList<MemoriaAUX>();
		MemoriaAUX auxMV = new MemoriaAUX();

		for (int i = 0; i < Processos.size(); i++) {

			for (int j = 0; j < Memoria.size(); j++) {

				if ((Memoria.get(j).getEstado().equals("H"))
						&& ((Processos.get(i).getComputacao()) <= (Memoria.get(j).getTamanho()))
						&& (Processos.get(i).getAlocado() == 0)) {
					int x = Memoria.get(j).getTamanho();
					int y = Processos.get(i).getComputacao();
					tamanhoMV = x - y;
					auxMV.setIdP(Processos.get(i).getId());
					auxMV.setIdm(j);
					auxMV.setTamanho(tamanhoMV);
					MemoriaV.add(auxMV);
					auxMV = new MemoriaAUX();
					key = true;
				}

			}

			if (Processos.get(i).getAlocado() == 0 && key == true) {
				auxMV = MemoriaV.stream().min((p1, p2) -> Integer.compare(p1.getTamanho(), p2.getTamanho())).get();
				Processos.get(i).setAlocado(1);
				int idPR = auxMV.getIdp();
				int idME = auxMV.getIdm();
				Memoria.get(idME).setIdProcesso(idPR);
				Memoria.get(idME).setEstado("P");
				auxMV = new MemoriaAUX();
				MemoriaV.clear();
				key = false;
			}

		}

		for (Processo p : Processos) {
			if (p.getAlocado() == 0) {
				auxN = new ProcessoN(p.getId(), p.getComputacao());
				ProcessosNALOCADOS.add(auxN);
			}

		}

		escreverArquivo("BEST-FIT");

	}

	public static void WorstFIT(ArrayList<Memoria> Memoria, ArrayList<Processo> Processos) {

		boolean key = false;
		int tamanhoMV = -1;
		ProcessoN auxN = new ProcessoN();
		ArrayList<MemoriaAUX> MemoriaV = new ArrayList<MemoriaAUX>();
		MemoriaAUX auxMV = new MemoriaAUX();

		for (int i = 0; i < Processos.size(); i++) {

			for (int j = 0; j < Memoria.size(); j++) {

				if ((Memoria.get(j).getEstado().equals("H"))
						&& ((Processos.get(i).getComputacao()) <= (Memoria.get(j).getTamanho()))
						&& (Processos.get(i).getAlocado() == 0)) {
					int x = Memoria.get(j).getTamanho();
					int y = Processos.get(i).getComputacao();
					tamanhoMV = x - y;
					auxMV.setIdP(Processos.get(i).getId());
					auxMV.setIdm(j);
					auxMV.setTamanho(tamanhoMV);
					MemoriaV.add(auxMV);
					auxMV = new MemoriaAUX();
					key = true;
				}

			}

			if (Processos.get(i).getAlocado() == 0 && key == true) {
				auxMV = MemoriaV.stream().max((p1, p2) -> Integer.compare(p1.getTamanho(), p2.getTamanho())).get();
				// System.out.println(auxMV.toString());
				Processos.get(i).setAlocado(1);
				int idPR = auxMV.getIdp();
				int idME = auxMV.getIdm();
				Memoria.get(idME).setIdProcesso(idPR);
				Memoria.get(idME).setEstado("P");
				auxMV = new MemoriaAUX();
				MemoriaV.clear();
				key = false;
			}

		}

		for (Processo p : Processos) {
			if (p.getAlocado() == 0) {
				auxN = new ProcessoN(p.getId(), p.getComputacao());
				ProcessosNALOCADOS.add(auxN);
			}

		}

		escreverArquivo("WORST-FIT");

	}

	public static void escreverArquivo(String algoritmo) {

		a.arquivoSaida("Algoritmo " + algoritmo + "\r\n", algoritmo);
		for (Memoria m : MemoriaLIDA) {
			a.arquivoSaida(m.toString(), algoritmo);
		}

		a.arquivoSaida("\r\nPROCESSOS NÃO ALOCADOS / TAMANHO", algoritmo);

		for (ProcessoN pnl : ProcessosNALOCADOS) {
			a.arquivoSaida(pnl.toString(), algoritmo);
		}

	}

	public static void resetDATA() {

		MemoriaLIDA = (ArrayList<Memoria>) a.lerArquivo(txtMemoria);
		ProcessosLIDOS = (ArrayList<Processo>) a.lerArquivo(txtProcessos);
		ProcessosNALOCADOS = new ArrayList<ProcessoN>();

	}

}
