package models;

import java.util.Iterator;
import java.util.Objects;

public class Orcamento {
	
	private int id;
	private String fornecedor;
	private String produto;
	private Double preço;
	private boolean barato;
	
	public Orcamento(int id, String fornecedor, String produto, double preço, boolean barato) {
		this.id = id;
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.preço = preço;
		this.barato = barato;
	}
	
	public Orcamento(String linha) {
		String[] temp = linha.split(";");
		this.id = Integer.parseInt(temp[0]);
		this.fornecedor = temp[1];
		this.produto = temp[2];
		this.preço = Double.parseDouble(temp[3]);
		this.barato = false;
	}
	
	public String getId(String s) {
		return String.format("%d", id);
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
	public String getPreço(String s) {
		return String.format("%.2f", preço);
	}
	
	public double getPreço() {
		return preço;
	}
	
	public void setPreço(Double preço) {
		this.preço = preço;
	}
	public boolean isMaisBarato() {
		return barato;
	}
	public void setBarato(boolean barato) {
		this.barato = barato;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, id, barato, preço, produto);
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
		return Objects.equals(fornecedor, other.fornecedor) && id == other.id && barato == other.barato
				&& Double.doubleToLongBits(preço) == Double.doubleToLongBits(other.preço) && Objects.equals(produto, other.produto);
	}
	
	@Override
	public String toString() {
		return id + "\t" + fornecedor + "\t" + produto + "\t" + String.format("%.2f",preço)
				+ "\t"+ barato;
	}
	public String toCSV() {
		return id + ";" + fornecedor + ";" + produto + ";" + preço + ";"+ barato;
	}
}