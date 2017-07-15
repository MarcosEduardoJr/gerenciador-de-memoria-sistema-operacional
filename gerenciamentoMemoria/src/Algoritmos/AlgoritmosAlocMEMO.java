package Algoritmos;

import java.util.ArrayList;

import Util.Memoria;
import Util.Processo;
import Util.Arquivo;

public class AlgoritmosAlocMEMO {

	private static final String txtMemoria = "entrada/entrada-memoria.txt";
	private static final String txtProcessos = "entrada/entrada-processos.txt";
	private static Arquivo a = new Arquivo();

	public static void main(String[] args) {

		

		ArrayList<Memoria> Memoria = (ArrayList<Memoria>) a.lerArquivo(txtMemoria);
		ArrayList<Processo> Processos = (ArrayList<Processo>) a.lerArquivo(txtProcessos);

		apresentacao(Memoria, Processos);
		
		// --- daqui pra frente eh so meter bala
		firstFit(Memoria, Processos);
		apresentacaoResultado("First Fit", Memoria, Processos);
		limparSujeira(Memoria, Processos);
		
	}

	public static void firstFit(ArrayList<Memoria> Memoria, ArrayList<Processo> Processos) {
		Boolean tudoAlocado = true;

		for (Processo processo : Processos) {

			for (Memoria memoria : Memoria) {
				int tamanho = memoria.getParticaoBase() - memoria.getParticaoFinal();
				tamanho = (tamanho < 0 ? -tamanho : tamanho); // tamanho
																// positivo
				// System.out.println(tamanho);
				if ((memoria.getEstado().equals("H")) && (processo.getComputacao() <= tamanho)
						&& (processo.getVisitado() != 1)) {
					memoria.setEstado("P");
					memoria.setIdProcesso(processo.getId());
					processo.setAlocado(1);
					processo.setVisitado(1);
				}
			}
		}
		
		a.arquivoSaida("Algoritmo FIRST-FIT","FIRST-FIT");

	}
	
	

	public static void apresentacaoResultado(String Algoritmo, ArrayList<Memoria> Memoria,
			ArrayList<Processo> Processos) {
		System.out.println("");
		System.out.println("------ " + Algoritmo + "----------");
		System.out.println("");
		System.out.print("Estado | Particao base | particao final | IDProcesso");
		System.out.print("      ");
		System.out.print("ID Processo  |   Alocado | Tamanho");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		Boolean acabouMemoria = false;
		Boolean acabouProcesso = false;
		for (int i = 0;; i++) {
			if (i < Memoria.size()) {
				System.out.print(Memoria.get(i).getEstado() + "      |        " + Memoria.get(i).getParticaoBase()
						+ "        | " + Memoria.get(i).getParticaoFinal() + "            |      "
						+ Memoria.get(i).getIdProcesso() + "                  ");

			} else {
				acabouMemoria = true;
			}

			if (i < Processos.size()) {
				if (Processos.get(i).getAlocado() == 0) {
					System.out.print("  " + Processos.get(i).getId() + "  |  " + "Não" + " | "
							+ Processos.get(i).getComputacao());
				} else {
					System.out.print("  " + Processos.get(i).getId() + " |  " + "Sim" + " | "
							+ Processos.get(i).getComputacao());
				}

			} else {
				acabouProcesso = true;
			}
			if (acabouMemoria && acabouProcesso) {

				break;
			}
			System.out.println("");
			System.out.print("----------------------------------------------------");
			System.out.print("");
			System.out.print("          ----------------------------");
			System.out.println("");
		}

	}

	public static void limparSujeira(ArrayList<Memoria> Memoria, ArrayList<Processo> Processos) {

		for (Memoria m : Memoria) {
			m.setEstado("H");
			m.setIdProcesso(0);
		}
		for (Processo p : Processos) {
			p.setAlocado(0);

		}

	}

	public static void apresentacao(ArrayList<Memoria> Memoria, ArrayList<Processo> Processos) {

		System.out.println("Estado |   Particao base | particao final");
		System.out.println("--------------------------------------");
		for (Memoria m : Memoria) {
			System.out.println(
					m.getEstado() + "      |        " + m.getParticaoBase() + "        | " + m.getParticaoFinal());
			System.out.println("--------------------------------------");
		}

		System.out.println("Computacao |   Alocado | Visitado");
		System.out.println("--------------------------------------");
		for (Processo p : Processos) {
			System.out.println(p.getComputacao() + "      |        " + p.getAlocado() + "        | " + p.getVisitado());
			System.out.println("--------------------------------------");
		}

	}

}
