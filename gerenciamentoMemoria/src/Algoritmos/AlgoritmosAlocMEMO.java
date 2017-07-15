package Algoritmos;

import java.util.ArrayList;

import Util.Memoria;
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

		resetDATA();
		FristFIT(MemoriaLIDA, ProcessosLIDOS);
		resetDATA();

	}

	public static void FristFIT(ArrayList<Memoria> Memoria, ArrayList<Processo> Processos) {

		boolean stop = false;
		int tamanhoM = -1;
		ProcessoN auxN = new ProcessoN();

		while (!stop) {

			for (Processo processo : Processos) {

				for (Memoria memoriaI : Memoria) {

					tamanhoM = memoriaI.getTamanho();
					tamanhoM = (tamanhoM < 0 ? -tamanhoM : tamanhoM);

					if ((memoriaI.getEstado().equals("H")) && (processo.getComputacao() <= tamanhoM)
							&& (processo.getVisitado() == 0)) {

						memoriaI.setEstado("P");
						memoriaI.setIdProcesso(processo.getId());
						processo.setAlocado(1);
						processo.setVisitado(1);

					}

				}

			}

			stop = true;

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
