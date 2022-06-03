package models;

import java.util.Iterator;
import java.util.Objects;

public class Orcamento {
	
	private int id;
	private String fornecedor;
	private String produto;
	private Double preço;
	private boolean maisBarato;
	
	public Orcamento(int id, String fornecedor, String produto, double preço, boolean maisBarato) {
		this.id = id;
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.preço = preço;
		this.maisBarato = maisBarato;
	}
	
	public Orcamento(String linha) {
		String[] temp = linha.split(";");
		this.id = Integer.parseInt(temp[0]);
		this.fornecedor = temp[1];
		this.produto = temp[2];
		this.preço = Double.parseDouble(temp[3]);
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
	public Double getPreço() {
		return preço;
	}
	public void setPreço(Double preço) {
		this.preço = preço;
	}
	public boolean isMaisBarato() {
		return maisBarato;
	}
	public void setMaisBarato(boolean maisBarato) {
		this.maisBarato = maisBarato;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, id, maisBarato, preço, produto);
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
				&& Objects.equals(preço, other.preço) && Objects.equals(produto, other.produto);
	}
	
	@Override
	public String toString() {
		return id + "\t" + fornecedor + "\t" + produto + "\t" + preço
				+ "\t"+ maisBarato;
	}

	public String toCSV() {
		return id + ";" + fornecedor + ";" + produto + ";" + preço + ";"+ maisBarato;
	}
	
}
