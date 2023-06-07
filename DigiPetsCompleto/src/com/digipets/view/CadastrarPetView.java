
package com.digipets.view;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.digipets.controller.AnimalController;
import com.digipets.controller.TutorController;
import com.digipets.controller.ExceptionDAO;
import com.digipets.dao.ClienteDAO;
import com.digipets.model.Tutor;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class CadastrarPetView extends javax.swing.JFrame {
	private JComboBox<String> jCBNomeTutor;
	private List<Tutor> clientesCombo;
	/**
	 * Creates new form CadastrarPetView
	 */
	public CadastrarPetView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarPetView.class.getResource("/imagens/animal-care.png")));
		initComponents();
		PreencherCombo();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
                       
	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jTFNome = new javax.swing.JTextField();
		jTFRaca = new javax.swing.JTextField();
		jTFEspecie = new javax.swing.JTextField();
		jCBNomeTutor = new JComboBox<String>();
		jButton1 = new javax.swing.JButton();
		jBTNCadastrar = new javax.swing.JButton();
		jBTNCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPet();
			}
		});
		jLabel4 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		jTFNome.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTFNomeActionPerformed(evt);
			}
		});

		jButton1.setIcon(new ImageIcon(CadastrarPetView.class.getResource("/imagens/de-volta.png"))); // NOI18N
		jButton1.setText("Voltar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jBTNCadastrar.setIcon(new ImageIcon(CadastrarPetView.class.getResource("/imagens/salvar.png"))); // NOI18N
		jBTNCadastrar.setText("Salvar");

		jLabel4.setText("Sexo:");

		jLabel2.setText("Raça:");

		jLabel1.setText("Nome:");

		jLabel5.setText("Tutor:");

		jLabel6.setText("Especie:");
		
		machoRadioButton = new JRadioButton("Macho");
		buttonGroup.add(machoRadioButton);
		
		femeaRadioButton = new JRadioButton("Femea");
		buttonGroup.add(femeaRadioButton);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jLabel4)
						.addComponent(jLabel2)
						.addComponent(jLabel1)
						.addComponent(jLabel5)
						.addComponent(jLabel6))
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jTFNome, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addComponent(jCBNomeTutor, 0, 169, Short.MAX_VALUE)
								.addComponent(jTFRaca, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addComponent(jTFEspecie, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
						.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
							.addGap(30)
							.addComponent(machoRadioButton)
							.addGap(18)
							.addComponent(femeaRadioButton)))
					.addContainerGap(34, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(38)
					.addComponent(jBTNCadastrar)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(jButton1)
					.addGap(53))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jCBNomeTutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5))
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTFNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTFRaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel4)
						.addComponent(machoRadioButton)
						.addComponent(femeaRadioButton))
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTFEspecie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel6))
					.addGap(19)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton1)
						.addComponent(jBTNCadastrar))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		pack();
	}// </editor-fold>                        

	private void jTFNomeActionPerformed(java.awt.event.ActionEvent evt) {                                        
	}                                       

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		CadastrarPetView.this.dispose();
		HomeView frame = new HomeView();
		frame.setVisible(true);
	}      

	public void PreencherCombo() {
		try {
			ClienteDAO cliente = new ClienteDAO();
			clientesCombo = cliente.comboMostra();

			for (Tutor c : clientesCombo) {
				jCBNomeTutor.addItem(c.getNome());
			}
		} catch (ExceptionDAO | SQLException e) {
			e.printStackTrace();
		}
	}

	public void cadastrarPet() {
		boolean sucesso;
		try {
			new TutorController();
			String nome = jTFNome.getText();
			String raca = jTFRaca.getText();
			String especie = jTFEspecie.getText();
			String sexo = null;
			if (machoRadioButton.isSelected()) {
				sexo = machoRadioButton.getText();
            }else if(femeaRadioButton.isSelected()) {
            	sexo = femeaRadioButton.getText();
            }

			String cboValor2 =  (String)jCBNomeTutor.getSelectedItem();
			int idTutor = 0;
			for(Tutor cli : clientesCombo) {
		        if(cli.getNome() == cboValor2) {
		        	idTutor = cli.getId();
		        }
			}
			sucesso = AnimalController.CreateAnimal(nome, raca, sexo, especie, idTutor);
			System.out.println(sucesso);
			if (sucesso == true) {
				JOptionPane.showMessageDialog(null, "Pet cadastrado com sucesso");
			} else if (nome.length() <= 0 || raca.length() <= 0 || especie.length() <= 0 || sexo.length() <= 0 
					|| cboValor2 == null) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			} 
			
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar pet");
		}
	}

	/**
	 * @param args the command line arguments
	 */
	//    public static void HomeView(String args[]) {
	//        /* Set the Nimbus look and feel */
	//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	//         */
	//        try {
	//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	//                if ("Nimbus".equals(info.getName())) {
	//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	//                    break;
	//                }
	//            }
	//        } catch (ClassNotFoundException ex) {
	//            java.util.logging.Logger.getLogger(CadastrarPetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (InstantiationException ex) {
	//            java.util.logging.Logger.getLogger(CadastrarPetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (IllegalAccessException ex) {
	//            java.util.logging.Logger.getLogger(CadastrarPetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	//            java.util.logging.Logger.getLogger(CadastrarPetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        }
	//        //</editor-fold>
	//
	//        /* Create and display the form */
	//        java.awt.EventQueue.invokeLater(new Runnable() {
	//            public void run() {
	//                new CadastrarPetView().setVisible(true);
	//            }
	//        });
	//    }

	// Variables declaration - do not modify                     
	private javax.swing.JButton jBTNCadastrar;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTFEspecie;
	private javax.swing.JTextField jTFNome;
	private javax.swing.JTextField jTFRaca;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton machoRadioButton;
	private JRadioButton femeaRadioButton;
}
