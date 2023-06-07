
package com.digipets.view;
import javax.swing.GroupLayout.Alignment;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import com.digipets.controller.ExceptionDAO;
import com.digipets.controller.VacinaController;
import com.digipets.dao.AnimalDAO;
import com.digipets.dao.ClienteDAO;
import com.digipets.model.Animal;
import com.digipets.model.Tutor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class AlterarVacinaView extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JButton jButtonVoltar;
	private JButton jButtonSalvar;
	private JLabel jLabelNome;
	private JLabel jLabelDataAplicacao;
	private JPanel jPanelAlterarVacinaView;
	private JTextField jTextFieldNome;
	private JFormattedTextField jTextFieldDataAplicacao;
	private int vacinaId;
	private int animalId;
	private String vacinaNome;
	private String vacinaData;
	
	public AlterarVacinaView(int vacinaId, String vacinaNome, String vacinaData, int animalId) {
		this.vacinaId = vacinaId;
		this.vacinaNome = vacinaNome;
		this.vacinaData = vacinaData;
		this.animalId = animalId;
		initComponents();
		this.setSize(350, 250);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
              
	private void initComponents() {
		jPanelAlterarVacinaView = new JPanel();
		jPanelAlterarVacinaView.setBorder(new TitledBorder("Alterar vacina"));
		jPanelAlterarVacinaView.setLayout(new GridLayout(1, 2));
		
		jLabelNome = new JLabel("Nome :");
		jTextFieldNome = new JTextField();
		jTextFieldNome.setText(vacinaNome);
		
		jLabelDataAplicacao = new JLabel("Data aplicação :");
		jButtonSalvar = new JButton("Salvar");
		jButtonVoltar = new JButton("Voltar");
		
		SetIcon();
		SetEventListener();
		SetConfiguration();
	}                                     
	
	private void SetIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlterarVacinaView.class.getResource("/imagens/animal-care.png")));
		jButtonSalvar.setIcon(new ImageIcon(AlterarVacinaView.class.getResource("/imagens/salvar.png")));
		jButtonVoltar.setIcon(new ImageIcon(AlterarVacinaView.class.getResource("/imagens/de-volta.png")));
	}
	
	private void SetEventListener() {
		jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AlterarVacina(vacinaId);
			}
		});

		jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonVoltarActionPerformed(evt);
			}
		});
		
		jTextFieldDataAplicacao = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		
		jTextFieldDataAplicacao.setText(vacinaData);
		
		jTextFieldDataAplicacao.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
			      {
			        JOptionPane.showMessageDialog(null, "Please Enter Valid");
			        e.consume();
			      }
			    }
		});
	}
	
	private void jButtonVoltarActionPerformed(ActionEvent evt) {                                           
		AlterarVacinaView.this.dispose();
		new ConsultarCarteiraView().setVisible(true);
	}                                          

	private void jButtonSalvarActionPerformed(ActionEvent evt) {                                         
		//alterarVacina();
	}   

	/*public void alterarVacina() {
		boolean sucesso;
		try {
			VacinaControl vacinaControl = new VacinaControl();
			String dia,mes,ano, dataFinal;
			String nome = jTFNome.getText();
			dataFinal = formattedTextField.getText();
			jCBIdVacina.getSelectedItem();
			
				dataFinal = dia + "/" + mes +"/" + ano;
				if(jCBIdVacina.getSelectedItem() == null) {
					int cboVacina = 0;
					sucesso = VacinaControl.alterarVacina(nome,dataFinal, cboVacina);
					if (sucesso == true) {

						JOptionPane.showMessageDialog(null, "Vacina alterado com sucesso");

					} else if ( cboVacina == 0) {
						JOptionPane.showMessageDialog(null, "Nenhum ID de vacina selecionado");
					}

				}else {
					int cboVacina = (int) jCBIdVacina.getSelectedItem();

					sucesso = VacinaControl.alterarVacina(nome,dataFinal, cboVacina);
					if (sucesso == true) {

						JOptionPane.showMessageDialog(null, "Vacina alterado com sucesso");

					} else if (nome.length() <= 0 || dataFinal.length() <= 0|| cboVacina == 0) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					}
				}}
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao alterar Vacina");
		}
	}*/
	
	private void AlterarVacina(int vacinaId) {
		try {
			VacinaController controller = new VacinaController();
			String nome = jTextFieldNome.getText();
			String data = jTextFieldDataAplicacao.getText();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			formatter.parse(data);
			if(controller.updateVacina(vacinaId, nome, data, animalId))
				JOptionPane.showMessageDialog(null, "Vacina alterada com sucesso");
			 else if (nome.length() <= 0 || data.length() <= 0) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			}
			 else {
				 throw new Exception();
			 }
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Vacina");
		}
	}
	
	private void SetConfiguration() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		javax.swing.GroupLayout gl_jPanelAlterarVacinaView = new javax.swing.GroupLayout(jPanelAlterarVacinaView);
		gl_jPanelAlterarVacinaView.setHorizontalGroup(
			gl_jPanelAlterarVacinaView.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanelAlterarVacinaView.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_jPanelAlterarVacinaView.createParallelGroup(Alignment.TRAILING)
						.addComponent(jButtonSalvar)
						.addComponent(jLabelDataAplicacao)
						.addComponent(jLabelNome))
					.addGap(35)
					.addGroup(gl_jPanelAlterarVacinaView.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(jTextFieldDataAplicacao)
						.addComponent(jTextFieldNome, GroupLayout.DEFAULT_SIZE, 120, GroupLayout.DEFAULT_SIZE)
						.addComponent(jButtonVoltar))
					.addGap(35))
		);
		gl_jPanelAlterarVacinaView.setVerticalGroup(
			gl_jPanelAlterarVacinaView.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelAlterarVacinaView.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_jPanelAlterarVacinaView.createParallelGroup(Alignment.TRAILING)
						.addComponent(jTextFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabelNome))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jPanelAlterarVacinaView.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTextFieldDataAplicacao, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabelDataAplicacao))
					.addGap(50)
					.addGroup(gl_jPanelAlterarVacinaView.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButtonVoltar)
						.addComponent(jButtonSalvar))
					.addGap(15))
		);
		
		jPanelAlterarVacinaView.setLayout(gl_jPanelAlterarVacinaView);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelAlterarVacinaView, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelAlterarVacinaView, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
		);
		getContentPane().setLayout(layout);

		pack();
	}
}
