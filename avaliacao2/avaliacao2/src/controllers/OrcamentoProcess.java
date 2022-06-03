package controllers;

import java.util.ArrayList;
import java.util.Iterator;

import models.Orcamento;
import models.OrcamentoDAO;

public class OrcamentoProcess {
	
	public static ArrayList<Orcamento> orcamentos = new ArrayList<>();
	private static OrcamentoDAO od = new OrcamentoDAO();
	
	public void compararProdutos(String produto) {
		int barato = 0;
		double precoBarato = 99999;
		for (Orcamento orcamento : orcamentos) {
		if (orcamento.getProduto() == produto && orcamento.getPreço() < precoBarato) {
			barato = orcamentos.indexOf(orcamento);
			precoBarato = orcamento.getPreço();
			}
		}
		
		orcamentos.get(barato).setMaisBarato(true);
	}
	public static void abrir() {
		orcamentos = od.ler();
	}
	
	public static void salvar() {
		od.escrever(orcamentos);
	}
}