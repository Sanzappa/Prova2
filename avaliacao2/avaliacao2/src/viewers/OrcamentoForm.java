package viewers;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.OrcamentoProcess;

public class OrcamentoForm extends JFrame{

	private JPanel painel;
	private JLabel Id, fornecedor, produto, preco;
	private JTextField tfId, tfFornecedor, tfProduto, tfPreco;
	private JButton adicionar, alterar, excluir, buscar;
	private JTextArea texto;
	private int autoId = OrcamentoProcess.orcamentos.get(OrcamentoProcess.orcamentos.size() - 1).getId() + 1;
	
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
		
		texto = new JTextArea();
		texto.setBounds(10, 280, 760, 250);
		texto.setEnabled(true);
		texto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		texto.setEnabled(false); 
		
		
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
		painel.add(texto);
		
	}
	
	public static void main(String args[]) throws ParseException{
		OrcamentoProcess.abrir();
		new OrcamentoForm().setVisible(true);
	}
}