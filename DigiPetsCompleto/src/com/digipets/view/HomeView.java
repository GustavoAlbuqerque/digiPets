
package com.digipets.view;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class HomeView extends javax.swing.JFrame {

	public HomeView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeView.class.getResource("/imagens/animal-care.png")));
		initComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
                      
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuClientesCadastra = new javax.swing.JMenuItem();
		jMenuPetsCadastra = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuClientesConsult = new javax.swing.JMenuItem();
		jMenuCarteiraPetConsult = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 277, Short.MAX_VALUE)
				);

		jMenu1.setIcon(new ImageIcon(HomeView.class.getResource("/imagens/registro.png"))); // NOI18N
		jMenu1.setText("Cadastro");

		jMenuClientesCadastra.setIcon(new ImageIcon(HomeView.class.getResource("/imagens/avatar-de-perfil.png"))); // NOI18N
		jMenuClientesCadastra.setText("Clientes");
		jMenuClientesCadastra.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuClientesCadastraActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuClientesCadastra);

		jMenuPetsCadastra.setIcon(new ImageIcon(HomeView.class.getResource("/imagens/patas.png"))); // NOI18N
		jMenuPetsCadastra.setText("Pets");
		jMenuPetsCadastra.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuPetsCadastraActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuPetsCadastra);

		jMenuBar1.add(jMenu1);

		jMenu2.setIcon(new ImageIcon(HomeView.class.getResource("/imagens/marketing-de-busca.png"))); // NOI18N
		jMenu2.setText("Consulta");

		jMenuClientesConsult.setIcon(new ImageIcon(HomeView.class.getResource("/imagens/avatar-de-perfil.png"))); // NOI18N
		jMenuClientesConsult.setText("Clientes");
		jMenuClientesConsult.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuClientesConsultActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuClientesConsult);

		jMenuCarteiraPetConsult.setIcon(new ImageIcon(HomeView.class.getResource("/imagens/vacinacao.png"))); // NOI18N
		jMenuCarteiraPetConsult.setText("Carteira do pet");
		jMenuCarteiraPetConsult.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuCarteiraPetConsultActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuCarteiraPetConsult);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack();
	}                   

	private void jMenuClientesConsultActionPerformed(java.awt.event.ActionEvent evt) {
		HomeView.this.dispose();
		ConsultarClienteView frame = new ConsultarClienteView();
		frame.setVisible(true);
	}                                                    

	private void jMenuClientesCadastraActionPerformed(java.awt.event.ActionEvent evt) {
		HomeView.this.dispose();
		CadastrarClienteView frame = new CadastrarClienteView();
		frame.setVisible(true);
	}                                                     

	private void jMenuPetsCadastraActionPerformed(java.awt.event.ActionEvent evt) {
		HomeView.this.dispose();
		CadastrarPetView frame = new CadastrarPetView();
		frame.setVisible(true);

	}                                                 

	private void jMenuCarteiraPetConsultActionPerformed(java.awt.event.ActionEvent evt) {
		HomeView.this.dispose();
		ConsultarCarteiraView frame = new ConsultarCarteiraView();
		frame.setVisible(true);
	}                                                       

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new HomeView().setVisible(true);
			}
		});
	}    
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuCarteiraPetConsult;
	private javax.swing.JMenuItem jMenuClientesCadastra;
	private javax.swing.JMenuItem jMenuClientesConsult;
	private javax.swing.JMenuItem jMenuPetsCadastra;
	private javax.swing.JPanel jPanel1;               
}
