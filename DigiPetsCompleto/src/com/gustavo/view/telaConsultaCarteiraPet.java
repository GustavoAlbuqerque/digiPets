/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gustavo.view;
import javax.management.StringValueExp;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.gustavo.control.AnimaisControl;
import com.gustavo.control.ExceptionDAO;
import com.gustavo.control.VacinaControl;
import com.gustavo.model.Animais;
import com.gustavo.model.Vacina;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 *
 * @author Gusta
 */
public class telaConsultaCarteiraPet extends javax.swing.JFrame {

	/**
	 * Creates new form telaConsultaCarteiraPet
	 */
	public telaConsultaCarteiraPet() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(telaConsultaCarteiraPet.class.getResource("/imagens/animal-care.png")));
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jBTNBuscar = new javax.swing.JButton();
		jBTNBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisarPet();
					pesquisarVacina();

				} catch (ExceptionDAO e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setIcon(new ImageIcon(telaConsultaCarteiraPet.class.getResource("/imagens/patas.png")));
		jLabel6 = new javax.swing.JLabel();
		jBTNAdcionar = new javax.swing.JButton();
		jBTNAlterar = new javax.swing.JButton();
		jBTNExcluir = new javax.swing.JButton();
		jBTNExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaConsultaCarteiraPet.this.dispose();
				telaExcluirVacina frame = new telaExcluirVacina();
				frame.setVisible(true);
			}
		});
		jButton1 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		jLabel1.setText("ID Pet:");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"ID", "Nome", "Data Aplicação"
				}
				));
		jScrollPane1.setViewportView(jTable1);

		jBTNBuscar.setIcon(new ImageIcon(telaConsultaCarteiraPet.class.getResource("/imagens/procurar.png"))); // NOI18N
		jBTNBuscar.setText("Buscar");

		jLabel2.setText("Pet");

		jLabel6.setIcon(new ImageIcon(telaConsultaCarteiraPet.class.getResource("/imagens/vacinas.png"))); // NOI18N
		jLabel6.setText("Vacina");

		jBTNAdcionar.setIcon(new ImageIcon(telaConsultaCarteiraPet.class.getResource("/imagens/adicionar-botao.png"))); // NOI18N
		jBTNAdcionar.setText("Adicionar vacina");
		jBTNAdcionar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBTNAdcionarActionPerformed(evt);
			}
		});

		jBTNAlterar.setIcon(new ImageIcon(telaConsultaCarteiraPet.class.getResource("/imagens/editar.png"))); // NOI18N
		jBTNAlterar.setText("Alterar Vacina");
		jBTNAlterar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBTNAlterarActionPerformed(evt);
			}
		});

		jBTNExcluir.setIcon(new ImageIcon(telaConsultaCarteiraPet.class.getResource("/imagens/excluir.png"))); // NOI18N
		jBTNExcluir.setText("Excluir vacina");

		jButton1.setIcon(new ImageIcon(telaConsultaCarteiraPet.class.getResource("/imagens/de-volta.png"))); // NOI18N
		jButton1.setText("Voltar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"Nome", "Especie", "Raça", "Sexo"
				}
				));
		jScrollPane2.setViewportView(jTable2);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(6, 6, 6)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(2, 2, 2)
										.addComponent(jLabel1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(49, 49, 49)
										.addComponent(jBTNBuscar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton1))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addGap(168, 168, 168)
														.addComponent(jLabel2)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jBTNAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jBTNAdcionar)
												.addComponent(jBTNExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(12, 12, 12))
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(283, 283, 283)
						.addComponent(jLabel6)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addContainerGap(22, Short.MAX_VALUE)
										.addComponent(jButton1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jBTNAdcionar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jBTNAlterar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jBTNExcluir)
										.addGap(41, 41, 41))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(18, 18, 18)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1)
												.addComponent(jBTNBuscar))
										.addGap(18, 18, 18)
										.addComponent(jLabel2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(jLabel6)))
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(14, Short.MAX_VALUE))
				);

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
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);

		pack();
	}// </editor-fold>                        

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		// TODO add your handling code here:
		telaConsultaCarteiraPet.this.dispose();
		main frame = new main();
		frame.setVisible(true);
	}                                        

	private void jBTNAlterarActionPerformed(java.awt.event.ActionEvent evt) {                                            
		// TODO add your handling code here:
		telaConsultaCarteiraPet.this.setVisible(false);
		telaAlterarVacina frame = new telaAlterarVacina();
		frame.setVisible(true);
	}                                           

	private void jBTNAdcionarActionPerformed(java.awt.event.ActionEvent evt) {                                             
		// TODO add your handling code here:
		telaConsultaCarteiraPet.this.setVisible(false);
		telaCadastroVacina frame = new telaCadastroVacina();
		frame.setVisible(true);
	}              


	public void pesquisarPet() throws ExceptionDAO {
		DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
		AnimaisControl animaisControl = new AnimaisControl();
		tableModel.setRowCount(0);

		try {
			int id =0;
			id = Integer.parseInt(jTextField1.getText()) ;

			ArrayList<Animais> animal = animaisControl.listarAnimaisCliente(id);
			animal.forEach((animais) -> {
				tableModel.addRow(new Object[] { animais.getNome(), animais.getEspecie(),
						animais.getRaca(), animais.getSexo() });
			});
			if (id == 0) {
				JOptionPane.showMessageDialog(null, "Nenhum dado informado para pesquisa");
			}
			jTable2.setModel(tableModel);
			if(jTable2.getRowCount()==0 ) {
				JOptionPane.showMessageDialog(null, "ID não encontrado / Pet vazio");
			}
		} catch (SQLException f) {
			//			Logger.getLogger(TelaMaleta.class.getName()).log(Level.SEVERE, null, f);
		}
		catch (ExceptionDAO f) {
			f.printStackTrace();
		}
	}

	public void pesquisarVacina() throws ExceptionDAO {
		DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
		VacinaControl vacinaControl = new VacinaControl();
		tableModel.setRowCount(0);
		try {
			int id =0;
			id = Integer.parseInt(jTextField1.getText()) ;
			ArrayList<Vacina> vacina = vacinaControl.listarVacinaPet(id);
			vacina.forEach((Vacina vacinas) -> {
				tableModel.addRow(new Object[] { vacinas.getCodigo(), vacinas.getNome(),
						vacinas.getDataAplicacao() });
			});
			if (id==0) {
				JOptionPane.showMessageDialog(null, "Nenhum dado informado para pesquisa");
			}
			jTable1.setModel(tableModel);
			if(jTable1.getRowCount()==0 ) {
				JOptionPane.showMessageDialog(null, " Não tem vacina cadastrada");
			}
		} catch (SQLException f) {
		}
		catch (ExceptionDAO f) {
			f.printStackTrace();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	//    public static void main(String args[]) {
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
	//            java.util.logging.Logger.getLogger(telaConsultaCarteiraPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (InstantiationException ex) {
	//            java.util.logging.Logger.getLogger(telaConsultaCarteiraPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (IllegalAccessException ex) {
	//            java.util.logging.Logger.getLogger(telaConsultaCarteiraPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	//            java.util.logging.Logger.getLogger(telaConsultaCarteiraPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        }
	//        //</editor-fold>
	//
	//        /* Create and display the form */
	//        java.awt.EventQueue.invokeLater(new Runnable() {
	//            public void run() {
	//                new telaConsultaCarteiraPet().setVisible(true);
	//            }
	//        });
	//    }

	// Variables declaration - do not modify                     
	private javax.swing.JButton jBTNAdcionar;
	private javax.swing.JButton jBTNAlterar;
	private javax.swing.JButton jBTNBuscar;
	private javax.swing.JButton jBTNExcluir;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration                   
}