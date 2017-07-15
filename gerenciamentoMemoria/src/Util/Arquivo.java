package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

	private BufferedWriter escritor = null;

	public ArrayList<?> lerArquivo(String FILENAME) {

		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<Memoria> mList = new ArrayList<Memoria>();
		ArrayList<Processo> ptList = new ArrayList<Processo>();
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));
			int idProceso = 1;
			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals("\n") && !sCurrentLine.equals("") && !sCurrentLine.equals(" ")) {
					if (sCurrentLine.contains(" ")) {
						String[] parts = sCurrentLine.split(" ");
						Memoria m = new Memoria(parts[0], new Integer(parts[1]), new Integer(parts[2]), 0);
						mList.add(m);
					} else {
						Processo p = new Processo(new Integer(sCurrentLine), 0, 0, idProceso);
						ptList.add(p);
						idProceso++;
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

	public void arquivoSaida(String texto, String algoritmo) {

		/**
		 * Método responsável por escrever os dados no arquivo de saída
		 */
		boolean key = false;

		try {
			if (new File("saida/" + algoritmo + ".txt").exists() == false) {

				new File("saida/" + algoritmo + ".txt").createNewFile();

			}
			if (!key) {
				escritor = new BufferedWriter(new FileWriter("saida/" + algoritmo + ".txt"));
				key = true;
			}

			escritor.append(texto + "\r\n");
			escritor.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
