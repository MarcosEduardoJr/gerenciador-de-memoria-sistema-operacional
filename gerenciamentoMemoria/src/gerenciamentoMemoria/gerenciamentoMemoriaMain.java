package gerenciamentoMemoria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class gerenciamentoMemoriaMain {

	private static final String txtMemoria = "entrada/entrada-memoria.txt";
	private static final String txtProcessos = "entrada/entrada-processos.txt";

	public static void main(String[] args) {

		ArrayList<Memoria> Memoria = (ArrayList<Memoria>) lerArquivo(txtMemoria);
		ArrayList<Processo> Processos = (ArrayList<Processo>) lerArquivo(txtProcessos);

		apresentacao(Memoria, Processos);

		firstFit(Memoria, Processos);

	}

	public static void firstFit(ArrayList<Memoria> Memoria, ArrayList<Processo> Processos) {
		Boolean tudoAlocado = true;

		for (Processo processo : Processos) {
			processo.setVisitado(1);
			for (Memoria memoria : Memoria) {
				if (memoria.getEstado().equals("H")
						&& ((memoria.getParticaoBase() - memoria.getParticaoFinal()) <= processo.getComputacao())) {
					memoria.setEstado("P");
					memoria.setIdProcesso(processo.getId());
					processo.setAlocado(1);

				}
			}
		}

		apresentacaoResultado(Memoria, Processos);

	}

	public static void apresentacaoResultado(ArrayList<Memoria> Memoria, ArrayList<Processo> Processos) {
		System.out.println("");
		System.out.println("");
		System.out.print("Estado |   Particao base | particao final");
		System.out.print(" ----- |||| ----");
		System.out.print("Computacao |   Alocado ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		Boolean acabouMemoria = false;
		Boolean acabouProcesso = false;
		for (int i = 0;; i++) {
			if (i < Memoria.size()) {
				System.out.print(Memoria.get(i).getEstado() + "      |        " + Memoria.get(i).getParticaoBase()
						+ "        | " + Memoria.get(i).getParticaoFinal() + "                  ");

			} else {
				acabouMemoria = true;
			}
			
		
			
			if (i < Processos.size()) {
				if (Processos.get(i).getAlocado() == 0) {
					System.out.print("          " + Processos.get(i).getComputacao() + "  |  " + "não alocado" + "| ");
				} else {
					System.out.print("          " + Processos.get(i).getComputacao() + " |  " + "alocado" + "| ");
				}
				
			} else {
				acabouProcesso = true;
			}
			if (acabouMemoria && acabouProcesso) {

				break;
			}
			System.out.println("");
			System.out.print("--------------------------------------");
			System.out.print("        ");
			System.out.print("          ------------------------");
			System.out.println("");
		}

	}

	public static ArrayList<?> lerArquivo(String FILENAME) {

		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<Memoria> mList = new ArrayList<Memoria>();
		ArrayList<Processo> ptList = new ArrayList<Processo>();
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals("\n") && !sCurrentLine.equals("") && !sCurrentLine.equals(" ")) {
					if (sCurrentLine.contains(" ")) {
						String[] parts = sCurrentLine.split(" ");
						Memoria m = new Memoria(parts[0], new Integer(parts[1]), new Integer(parts[2]), 0);
						mList.add(m);
					} else {
						Processo p = new Processo(new Integer(sCurrentLine), 0, 0, 0);
						ptList.add(p);
					}

				}
			}

			if (br != null)
				br.close();

			if (fr != null)
				fr.close();

			if (!mList.isEmpty()) {
				return mList;
			} else {
				return ptList;
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());

			return null;

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
