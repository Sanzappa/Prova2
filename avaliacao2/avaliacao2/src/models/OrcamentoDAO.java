package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrcamentoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String path =  "./dados/Registro.csv";
	
	public ArrayList<Orcamento> ler(){
		ArrayList<Orcamento> linhas = new ArrayList<Orcamento>();
		Orcamento orcamento;
		
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while (linha != null) {
				orcamento = new Orcamento(linha);
				linhas.add(orcamento);
				linha = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return linhas;
	}
	
	public void escrever(ArrayList<Orcamento> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(path));
			
			for (Orcamento manu : linhas) {
				bw.write(manu.toCSV() + "\r\n");
			}
			
			bw.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}	
	}
	
}