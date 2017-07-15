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

	public static void firstFit(ArrayList<Memoria> strMemoria, ArrayList<Processo> strProcessos) {
		Boolean tudoAlocado = true;

		for (Processo processo : strProcessos) {
			for (Memoria memoria : strMemoria) {
				if (memoria.getEstado().equals("H")) {
					memoria.setEstado("P");
					memoria.setIdProcesso(processo.getId());

				}
			}
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

}
