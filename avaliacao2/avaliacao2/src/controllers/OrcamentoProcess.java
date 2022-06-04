package controllers;

import java.util.ArrayList;
import java.util.Iterator;

import models.Orcamento;
import models.OrcamentoDAO;

public class OrcamentoProcess {
	
	public static ArrayList<Orcamento> orcamentos = new ArrayList<>();
	private static OrcamentoDAO od = new OrcamentoDAO();
	
	public static void compararProdutos(String produto) {
		int indexBarato = 0;
		double barato = 9999999;
		for (Orcamento orcamento : orcamentos) {
			if (orcamento.getProduto().equals(produto) && orcamento.getPreço() < barato) {
			indexBarato = orcamentos.indexOf(orcamento);
			barato = orcamento.getPreço();
			}
		}
		
		for (Orcamento orcamento : orcamentos) {
			if (orcamentos.indexOf(orcamento) == indexBarato) {
				orcamento.setBarato(true);
			} else if(orcamento.getProduto() == produto){
				orcamento.setBarato(false);
			}
		}
	}
	public static void abrir() {
		orcamentos = od.ler();
	}
	
	public static void salvar() {
		od.escrever(orcamentos);
	}
}