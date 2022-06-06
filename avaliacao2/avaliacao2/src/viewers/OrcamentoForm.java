package viewers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.OrcamentoProcess;
import models.Orcamento;

public class OrcamentoForm extends JFrame implements ActionListener{

	private JPanel painel;
	private JLabel Id, fornecedor, produto, preco;
	private JTextField tfId, tfFornecedor, tfProduto, tfPreco;
	private JButton adicionar, alterar, excluir, buscar;
	private JTextArea verResultado;
	private int autoId = OrcamentoProcess.orcamentos.get(OrcamentoProcess.orcamentos.size() - 1).getId() + 1;
	private String texto = "";
	
	
	OrcamentoForm(){
		setTitle("Tela de usuario");
		setBounds(450, 100, 800, 600);
		painel = new JPanel();
		painel.setBackground(new Color(199, 199, 199));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		Id = new JLabel("Id");
		Id.setBounds(20, 55, 120, 30);
		tfId = new JTextField();
		tfId.setBounds(140, 55, 255, 30);
		tfId.setEditable(false);
		tfId.setText("" + autoId );
		
		fornecedor = new JLabel("Fornecedor: ");
		fornecedor.setBounds(20, 95, 120, 30);
		tfFornecedor = new JTextField();
		tfFornecedor.setBounds(140, 95, 255, 30);
		
		produto = new JLabel("Produto: ");
		produto.setBounds(20, 130, 120, 30);
		tfProduto = new JTextField();
		tfProduto.setBounds(140, 130, 255, 30);
		
		preco = new JLabel("Preço: ");
		preco.setBounds(20, 170, 120, 30);
		tfPreco = new JTextField();
		tfPreco.setBounds(140, 170, 255, 30);
		
		adicionar = new JButton("Adicionar");
		buscar = new JButton("Buscar");
		alterar = new JButton("Alterar");
		excluir = new JButton("Apagar");
		adicionar.setBounds(500, 55, 110, 30);
		buscar.setBounds(500, 100, 110, 30);
		excluir.setBounds(500, 150, 110, 30);
		excluir.setEnabled(false);
		alterar.setBounds(500, 200, 110, 30);
		
		verResultado = new JTextArea();
		verResultado.setBounds(10, 280, 760, 250);
		verResultado.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		comparar();
		preencherAreaDeTexto();
		verResultado.setEditable(false);
		
		painel.add(Id);
		painel.add(tfId);
		
		painel.add(fornecedor);
		painel.add(tfFornecedor);
		
		painel.add(produto);
		painel.add(tfProduto);
		
		painel.add(preco);
		painel.add(tfPreco);
		
		painel.add(adicionar);
		painel.add(alterar);
		painel.add(excluir);
		painel.add(buscar);
		painel.add(verResultado);
		adicionar.addActionListener(this);
		alterar.addActionListener(this);
		buscar.addActionListener(this);
		excluir.addActionListener(this);
	}
	
	private void adicionar() {
		
		if (tfFornecedor.getText().length() != 0 && tfProduto.getText().length() !=0 && tfPreco.getText().length() !=0) {
			
			OrcamentoProcess.orcamentos.add(new Orcamento(autoId, tfFornecedor.getText().toString(), tfProduto.getText().toString(),
					Double.parseDouble(tfPreco.getText().replace(",", ".")), false));
			
		} else {
			JOptionPane.showMessageDialog(this, "Please, preenche com todas as informações.");
		}
		
		tfId.setText("" + (OrcamentoProcess.orcamentos.get(OrcamentoProcess.orcamentos.size() - 1).getId() + 1));
		limpar();
		comparar();
		preencherAreaDeTexto();
		OrcamentoProcess.salvar();
	}
	
	private void buscar() {
		String entrada = JOptionPane.showInputDialog(this,"Digite o id da Manutenção");

		boolean isNumeric = true;
		if (entrada != null) {
			for (int i = 0; i < entrada.length(); i++) {
				if (!Character.isDigit(entrada.charAt(i))) {
					isNumeric = false;
				}
			}
		}else {
			isNumeric = false;
		}
		if (isNumeric) {
			int id = Integer.parseInt(entrada);
			
			boolean achou = false;
			for (Orcamento orcamento : OrcamentoProcess.orcamentos) {
				if (orcamento.getId() == id) {
					achou = true;
					int indice = OrcamentoProcess.orcamentos.indexOf(orcamento);
					tfId.setText(OrcamentoProcess.orcamentos.get(indice).getId("s"));
					tfFornecedor.setText(OrcamentoProcess.orcamentos.get(indice).getFornecedor());
					tfProduto.setText(OrcamentoProcess.orcamentos.get(indice).getProduto());
					tfPreco.setText(OrcamentoProcess.orcamentos.get(indice).getPreço("s"));
					OrcamentoProcess.salvar();
					adicionar.setEnabled(false);
					alterar.setEnabled(true);
					excluir.setEnabled(true);
					break;
				}
			}
			
			if (!achou) {
				JOptionPane.showMessageDialog(this, "Seu ID não foi encontrado");
			}
				
			
		}

	}
	
	private void alterar() {
		int id = Integer.parseInt(tfId.getText());
		int indice = -1;
		
		for (Orcamento orca : OrcamentoProcess.orcamentos) {
			if(orca.getId() == id) {
			indice = OrcamentoProcess.orcamentos.indexOf(orca);
		}
	}
		if (tfFornecedor.getText().length() != 0 && tfProduto.getText().length() !=0 && tfPreco.getText().length() !=0) {

			OrcamentoProcess.orcamentos.set(indice, new Orcamento(Integer.parseInt(tfId.getText().toString()), tfFornecedor.getText().toString(),
					tfProduto.getText().toString(),Double.parseDouble(tfPreco.getText().toString().replace(",", ".")), false));
			comparar();
			preencherAreaDeTexto();
			limpar();
		} else {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos por favor");
		}
		adicionar.setEnabled(true);
		alterar.setEnabled(false);
		excluir.setEnabled(false);
		tfId.setText("" + (OrcamentoProcess.orcamentos.get(OrcamentoProcess.orcamentos.size() - 1).getId() + 1));
		
		OrcamentoProcess.salvar();
		
	}
	
	private void excluir(){
		int id = Integer.parseInt(tfId.getText());
		int indice = -1;
		for (Orcamento orca : OrcamentoProcess.orcamentos) {
			if (orca.getId() == id) {
				indice = OrcamentoProcess.orcamentos.indexOf(orca);
			}
		}
		
		OrcamentoProcess.orcamentos.remove(indice);
		comparar();
		preencherAreaDeTexto();
		limpar();
		adicionar.setEnabled(true);
		alterar.setEnabled(false);
		excluir.setEnabled(false);
		OrcamentoProcess.salvar();
		tfId.setText("" + (OrcamentoProcess.orcamentos.get(OrcamentoProcess.orcamentos.size() - 1).getId() + 1));
		
	}
	
	private void preencherAreaDeTexto() {
		texto = "";
		for (Orcamento p : OrcamentoProcess.orcamentos) {
			texto += p.toString()+"\n";
		}
		verResultado.setText(texto);
	}
	
	private void limpar() {
		tfFornecedor.setText(null);
		tfProduto.setText(null);
		tfPreco.setText(null);
	}
	
	public void comparar() {
		for (Orcamento orcamento : OrcamentoProcess.orcamentos) {
			OrcamentoProcess.compararProdutos(orcamento.getProduto());
			}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adicionar) {
			adicionar();
		}
		if (e.getSource() == buscar) {
			buscar();
		}
		if (e.getSource() == alterar) {
			alterar();
		}
		if (e.getSource() == excluir) {
			excluir();
		}
		
	}
	
	public static void main(String args[]) throws ParseException{
		OrcamentoProcess.abrir();
		new OrcamentoForm().setVisible(true);
	}
}