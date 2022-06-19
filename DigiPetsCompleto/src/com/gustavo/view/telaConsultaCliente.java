/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gustavo.view;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.gustavo.control.AnimaisControl;
import com.gustavo.control.ClienteControl;
import com.gustavo.control.ExceptionDAO;
import com.gustavo.model.Animais;
import com.gustavo.model.Cliente;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 *
 * @author Gusta
 */
public class telaConsultaCliente extends javax.swing.JFrame {

	/**
	 * Creates new form telaConsultaCliente
	 */
	public telaConsultaCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(telaConsultaCliente.class.getResource("/imagens/animal-care.png")));
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
		jTFCpf = new javax.swing.JTextField();
		jBTNconsultar = new javax.swing.JButton();
		jBTNconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(jTFCpf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "O CPF não pode estar vazio ");
					}else {
						pesquisar();
						pesquisaPet();
					}
				} catch (ExceptionDAO e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		jScrollPane1 = new javax.swing.JScrollPane();
		jTBConsultaCliente = new javax.swing.JTable();
		jBTNVoltar = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTBPet = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setIcon(new ImageIcon(telaConsultaCliente.class.getResource("/imagens/patas.png")));
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setIcon(new ImageIcon(telaConsultaCliente.class.getResource("/imagens/avatar-de-perfil.png")));

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		jLabel1.setText("CPF do cliente:");

		jBTNconsultar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gusta\\Documents\\NetBeansProjects\\FrontEndDesktop\\src\\main\\java\\imagens\\procurar.png")); // NOI18N
		jBTNconsultar.setText("Consultar");

		jTBConsultaCliente.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"CPF", "Nome", "Endereço"
				}
				));
		jScrollPane1.setViewportView(jTBConsultaCliente);

		jBTNVoltar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gusta\\Documents\\NetBeansProjects\\FrontEndDesktop\\src\\main\\java\\imagens\\de-volta.png")); // NOI18N
		jBTNVoltar.setText("Voltar");
		jBTNVoltar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBTNVoltarActionPerformed(evt);
			}
		});

		jTBPet.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"ID ", "Nome ", "Especie", "Raça ", "Sexo "
				}
				));
		jScrollPane2.setViewportView(jTBPet);

		jLabel2.setText("Pet");

		jLabel3.setText("Cliente");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jLabel1)
														.addGap(18, 18, 18)
														.addComponent(jTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(jBTNconsultar)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jBTNVoltar))
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(308, 308, 308)
										.addComponent(jLabel2))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(303, 303, 303)
										.addComponent(jLabel3)))
						.addContainerGap(21, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(11, 11, 11)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(jTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jBTNconsultar)
								.addComponent(jBTNVoltar))
						.addGap(12, 12, 12)
						.addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(22, 22, 22)
						.addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(34, Short.MAX_VALUE))
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
				.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack();
	}// </editor-fold>                        

	private void jBTNVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                           
		// TODO add your handling code here:
		telaConsultaCliente.this.dispose();
		main frame = new main();
		frame.setVisible(true);
	}                              
	public void pesquisar() throws ExceptionDAO {
		DefaultTableModel tableModel = (DefaultTableModel) jTBConsultaCliente.getModel();

		ClienteControl clienteControl = new ClienteControl();
		tableModel.setRowCount(0);
		try {
			String id = jTFCpf.getText();
			ArrayList<Cliente> cliente = clienteControl.listarCliente(id);

			cliente.forEach((Cliente clientes) -> {
				tableModel.addRow(new Object[] { clientes.getCpf(), clientes.getNome(),
						clientes.getEndereco() });
			});


			if (id.length()< 0 && id != null) {
				JOptionPane.showMessageDialog(null, "Nenhum dado informado para pesquisa");
			}
			jTBConsultaCliente.setModel(tableModel);

			if(jTBConsultaCliente.getRowCount()==0 ) {
				JOptionPane.showMessageDialog(null, "CPF não encontrado ");
			}
		} catch (SQLException f) {
		}
		catch (ExceptionDAO f) {
			f.printStackTrace();
		}
	}
	public void pesquisaPet() {
		DefaultTableModel tableModel = (DefaultTableModel) jTBPet.getModel();
		try {
			String id = jTFCpf.getText();
			AnimaisControl animaisControl = new AnimaisControl();

			ArrayList<Animais> animal = animaisControl.listarAnimaisClienteCompleto(id);
			animal.forEach((Animais animais) -> {
				tableModel.addRow(new Object[] { animais.getIdPet(), animais.getNome(),
						animais.getEspecie(), animais.getRaca(), animais.getSexo()});

			});
			jTBPet.setModel(tableModel);
			if(jTBConsultaCliente.getRowCount()==0 ) {
				JOptionPane.showMessageDialog(null, "Nenhum pet encontrado ");
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
	//            java.util.logging.Logger.getLogger(telaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (InstantiationException ex) {
	//            java.util.logging.Logger.getLogger(telaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (IllegalAccessException ex) {
	//            java.util.logging.Logger.getLogger(telaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	//            java.util.logging.Logger.getLogger(telaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        }
	//        //</editor-fold>
	//
	//        /* Create and display the form */
	//        java.awt.EventQueue.invokeLater(new Runnable() {
	//            public void run() {
	//                new telaConsultaCliente().setVisible(true);
	//            }
	//        });
	//    }

	// Variables declaration - do not modify                     
	private javax.swing.JButton jBTNVoltar;
	private javax.swing.JButton jBTNconsultar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTBConsultaCliente;
	private javax.swing.JTable jTBPet;
	private javax.swing.JTextField jTFCpf;
	// End of variables declaration                   
}