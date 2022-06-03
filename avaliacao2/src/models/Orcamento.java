package models;

import java.util.Iterator;
import java.util.Objects;

public class Orcamento {
	
	private int id;
	private String fornecedor;
	private String produto;
	private Double pre�o;
	private boolean maisBarato;
	
	public Orcamento(int id, String fornecedor, String produto, double pre�o, boolean maisBarato) {
		this.id = id;
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.pre�o = pre�o;
		this.maisBarato = maisBarato;
	}
	
	public Orcamento(String linha) {
		String[] temp = linha.split(";");
		this.id = Integer.parseInt(temp[0]);
		this.fornecedor = temp[1];
		this.produto = temp[2];
		this.pre�o = Double.parseDouble(temp[3]);
		this.maisBarato = false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Double getPre�o() {
		return pre�o;
	}
	public void setPre�o(Double pre�o) {
		this.pre�o = pre�o;
	}
	public boolean isMaisBarato() {
		return maisBarato;
	}
	public void setMaisBarato(boolean maisBarato) {
		this.maisBarato = maisBarato;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, id, maisBarato, pre�o, produto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		return Objects.equals(fornecedor, other.fornecedor) && id == other.id && maisBarato == other.maisBarato
				&& Objects.equals(pre�o, other.pre�o) && Objects.equals(produto, other.produto);
	}
	
	@Override
	public String toString() {
		return id + "\t" + fornecedor + "\t" + produto + "\t" + pre�o
				+ "\t"+ maisBarato;
	}

	public String toCSV() {
		return id + ";" + fornecedor + ";" + produto + ";" + pre�o + ";"+ maisBarato;
	}
	
}
