package models;

import java.util.Iterator;
import java.util.Objects;

public class Orcamento {
	
	private int id;
	private String fornecedor;
	private String produto;
	private Double pre�o;
	private boolean barato;
	
	public Orcamento(int id, String fornecedor, String produto, double pre�o, boolean barato) {
		this.id = id;
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.pre�o = pre�o;
		this.barato = barato;
	}
	
	public Orcamento(String linha) {
		String[] temp = linha.split(";");
		this.id = Integer.parseInt(temp[0]);
		this.fornecedor = temp[1];
		this.produto = temp[2];
		this.pre�o = Double.parseDouble(temp[3]);
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
	public String getPre�o(String s) {
		return String.format("%.2f", pre�o);
	}
	
	public double getPre�o() {
		return pre�o;
	}
	
	public void setPre�o(Double pre�o) {
		this.pre�o = pre�o;
	}
	public boolean isMaisBarato() {
		return barato;
	}
	public void setBarato(boolean barato) {
		this.barato = barato;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, id, barato, pre�o, produto);
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
				&& Double.doubleToLongBits(pre�o) == Double.doubleToLongBits(other.pre�o) && Objects.equals(produto, other.produto);
	}
	
	@Override
	public String toString() {
		return id + "\t" + fornecedor + "\t" + produto + "\t" + String.format("%.2f",pre�o)
				+ "\t"+ barato;
	}
	public String toCSV() {
		return id + ";" + fornecedor + ";" + produto + ";" + pre�o + ";"+ barato;
	}
}