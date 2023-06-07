
package com.digipets.view;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.digipets.controller.ExceptionDAO;
import com.digipets.controller.VacinaController;
import com.digipets.dao.VacinaDAO;
import com.digipets.model.Vacina;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ExcluirVacinaView extends javax.swing.JFrame {

	public ExcluirVacinaView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ExcluirVacinaView.class.getResource("/imagens/animal-care.png")));
		initComponents();
		//PreencherCombo();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
                       
	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jBTNCadastrar = new javax.swing.JButton();
		jBTNCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//excluirVacina();
			}
		});
		jBTNVoltar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		jLabel2.setText("ID Vacina:");

		jBTNCadastrar.setIcon(new ImageIcon(ExcluirVacinaView.class.getResource("/imagens/excluir.png"))); // NOI18N
		jBTNCadastrar.setText("Excluir");

		jBTNVoltar.setIcon(new ImageIcon(ExcluirVacinaView.class.getResource("/imagens/de-volta.png"))); // NOI18N
		jBTNVoltar.setText("Voltar");
		jBTNVoltar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBTNVoltarActionPerformed(evt);
			}
		});

		jCBIdVacina = new JComboBox<Integer>();

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(15)
						.addComponent(jBTNCadastrar)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jBTNVoltar)
						.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(42)
						.addComponent(jCBIdVacina, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(44, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(79)
						.addComponent(jLabel2)
						.addContainerGap(116, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(22)
						.addComponent(jLabel2)
						.addGap(18)
						.addComponent(jCBIdVacina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jBTNVoltar)
								.addComponent(jBTNCadastrar)))
				);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);

		pack();
	}// </editor-fold>                        
	/*public void PreencherCombo() {
		try {
			VacinaDAO vacina = new VacinaDAO();

			for (Vacina v : vacina.carregandoID()) {
				jCBIdVacina.addItem(v.getCodigo());
			}

		} catch (ExceptionDAO | SQLException e) {
			e.printStackTrace();
		}
	}*/
	private void jBTNVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                           
		// TODO add your handling code here:
		ExcluirVacinaView.this.dispose();
		ConsultarCarteiraView frame = new ConsultarCarteiraView();
		frame.setVisible(true);
	}                            
	/*public void excluirVacina() {
		boolean sucesso;
		try {
			new VacinaController();
			if(jCBIdVacina.getSelectedItem() == null) {
				int  cboValor2 = 0;
				System.out.println(cboValor2);

				sucesso = VacinaController.deletarVacina(cboValor2);
				if (sucesso == true) {
					JOptionPane.showMessageDialog(null, "Vacina excluida com sucesso");
				} 
				else {
					JOptionPane.showMessageDialog(null, "Nenhum id  de vacina selecionado");
				}
			}else {
				int  cboValor2 =  (int) jCBIdVacina.getSelectedItem();
				System.out.println(cboValor2);

				sucesso = VacinaController.deletarVacina(cboValor2);
				if (sucesso == true) {
					JOptionPane.showMessageDialog(null, "Vacina excluida com sucesso");
				} 
				else {
					JOptionPane.showMessageDialog(null, "Nenhum id  de vacina selecionado");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao excluir vacina");
		}
	}
*/

	/**
	 * @param args the command line arguments
//     */
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
	//            java.util.logging.Logger.getLogger(telaAlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (InstantiationException ex) {
	//            java.util.logging.Logger.getLogger(telaAlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (IllegalAccessException ex) {
	//            java.util.logging.Logger.getLogger(telaAlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	//            java.util.logging.Logger.getLogger(telaAlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        }
	//        //</editor-fold>
	//        //</editor-fold>
	//        //</editor-fold>
	//        //</editor-fold>
	//
	//        /* Create and display the form */
	//        java.awt.EventQueue.invokeLater(new Runnable() {
	//            public void run() {
	//                new telaAlterarCliente().setVisible(true);
	//            }
	//        });
	//    }

	// Variables declaration - do not modify                     
	private javax.swing.JButton jBTNCadastrar;
	private javax.swing.JButton jBTNVoltar;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private JComboBox<Integer> jCBIdVacina;
	// End of variables declaration                   
}
