
package com.digipets.view;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import com.digipets.controller.TutorController;
import com.digipets.controller.VacinaController;
import com.digipets.exceptionHandler.CadastrarVacinaException;
import com.digipets.controller.AnimalController;
import com.digipets.model.Tutor;
import com.digipets.model.Animal;
import com.digipets.model.Vacina;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class ConsultarCarteiraView extends javax.swing.JFrame {
	String[] tutoresColunas = new String[] {"Nome", "CPF"};

	public ConsultarCarteiraView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultarCarteiraView.class.getResource("/imagens/animal-care.png")));
		initComponents();
		GetTutoresAllForTable();
		this.setSize(639, 382);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Carteirinha Pet");
	}
                     
	private void initComponents() {
		SetTopPanelConfiguration();
		SetMenuPanelConfiguration();
		SetTutorPanelConfiguration();
		SetAnimalPanelConfiguration();
		SetVacinaPanelConfiguration();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelBuscarEVoltar, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanelTutores, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanelMenu, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanelAnimais, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanelVacinas, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(jPanelBuscarEVoltar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jPanelTutores, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanelMenu, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jPanelVacinas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanelAnimais, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
					.addGap(4))
		);
		
		getContentPane().setLayout(groupLayout);

		pack();
	}// </editor-fold>                        

/*
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
	*/
	private void GetTutoresAllForTable() {
		TutorController tutorController = new TutorController();
		DefaultTableModel model = (DefaultTableModel)jTableTutores.getModel();
		try {
			ArrayList<Tutor> tutores = tutorController.getTutores();
			tutores.forEach((Tutor tutor) -> {
				model.addRow(new Object[] { tutor.getNome(), tutor.getCpf(), tutor.getId()});
			});
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private void GetTutoresLike(String busca) {
		TutorController tutorController = new TutorController();
		DefaultTableModel model = (DefaultTableModel)jTableTutores.getModel();
		while(model.getRowCount() > 0)
		{
		   model.removeRow(0);
		}
		try {
			ArrayList<Tutor> tutores = tutorController.getTutoresLike(busca);
			tutores.forEach((Tutor tutor) -> {
				model.addRow(new Object[] { tutor.getNome(), tutor.getCpf(), tutor.getId()});
			});
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private void GetPetsFromTutorId(int id) {
		DefaultTableModel model = (DefaultTableModel)jTableAnimais.getModel();		
		while(model.getRowCount() > 0)
		{
		   model.removeRow(0);
		}
		try {
			ArrayList<Animal> animais = AnimalController.GetAnimaisFromTutorId(id);
			animais.forEach((Animal animal) -> {
				model.addRow(new Object[] { animal.getNome(), animal.getRaca(), animal.getSexo(), animal.getEspecie(), animal.getIdPet()});
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void GetVacinasFromPetId(int id) {
		DefaultTableModel model = (DefaultTableModel)jTableVacinas.getModel();		
		while(model.getRowCount() > 0)
		{
		   model.removeRow(0);
		}
		try {
			VacinaController controller = new VacinaController();
			ArrayList<Vacina> vacinas = controller.GetVacinasByAnimalId(id);
			vacinas.forEach((Vacina vacina) -> {
				model.addRow(new Object[] { vacina.getNome(), vacina.getDataAplicacao(), vacina.getId(), vacina.getAnimalId()});
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void SetTopPanelConfiguration() {
		jPanelBuscarEVoltar = new JPanel();
		
		JTextField buscarTutor = new JTextField();
		JButton jButtonBuscar = new JButton("Buscar");
		jButtonBuscar.setIcon(new ImageIcon(ConsultarCarteiraView.class.getResource("/imagens/procurar.png")));
		
		jButtonBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					String stringbusca = buscarTutor.getText();
					TutorController tutorController = new TutorController();
					tutorController.getTutoresLike(stringbusca);
					GetTutoresLike(stringbusca);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}				
				//-----------------------------------------
			}
		});
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				HomeView view = new HomeView();
				view.setVisible(true);
			}
		});
		
		btnVoltar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnVoltar.setIcon(new ImageIcon(ConsultarCarteiraView.class.getResource("/imagens/de-volta.png")));
		
		buscarTutor.setHorizontalAlignment(SwingConstants.LEFT);
		jButtonBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		btnVoltar.setHorizontalAlignment(SwingConstants.CENTER);
				
		GroupLayout gl_jPanelBuscarEVoltar = new GroupLayout(jPanelBuscarEVoltar);
		gl_jPanelBuscarEVoltar.setHorizontalGroup(
			gl_jPanelBuscarEVoltar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelBuscarEVoltar.createSequentialGroup()
					.addGap(10)
					.addComponent(buscarTutor, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(jButtonBuscar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_jPanelBuscarEVoltar.setVerticalGroup(
			gl_jPanelBuscarEVoltar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanelBuscarEVoltar.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_jPanelBuscarEVoltar.createParallelGroup(Alignment.BASELINE)
						.addComponent(buscarTutor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButtonBuscar, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addGap(5))
		);
		jPanelBuscarEVoltar.setLayout(gl_jPanelBuscarEVoltar);
	}
	
	private void SetMenuPanelConfiguration() {
		jPanelMenu = new JPanel();
		jPanelMenu.setBorder(new TitledBorder("Menu"));
		
		JButton btnNovaVacina = new JButton("Nova vacina");
		btnNovaVacina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					if(jTableAnimais.getSelectedRow() == -1) {
						throw new CadastrarVacinaException();
					}
					int row = jTableAnimais.getSelectedRow();
					if(jTableAnimais.getModel().getValueAt(row, 4).toString() == null) {
						throw new CadastrarVacinaException();
					}
					String AnimalId = jTableAnimais.getModel().getValueAt(row, 4).toString();
					String AnimalNome = jTableAnimais.getModel().getValueAt(row, 0).toString();
					System.out.println(AnimalNome);
					CadastrarVacinaView view = new CadastrarVacinaView(Integer.parseInt(AnimalId), AnimalNome);
					view.setVisible(true);
					
					
					
				}
				catch (CadastrarVacinaException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				//-----------------------------------------
			}
		});
		btnNovaVacina.setIcon(new ImageIcon(ConsultarCarteiraView.class.getResource("/imagens/adicionar-botao.png")));
		
		JButton btnEditarVacina = new JButton("Editar vacina");
		btnEditarVacina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					if(jTableVacinas.getSelectedRow() == -1) {
						throw new CadastrarVacinaException();
					}
					int row = jTableVacinas.getSelectedRow();
					if(jTableVacinas.getModel().getValueAt(row, 2).toString() == null) {
						throw new CadastrarVacinaException();
					}
					String vacinaId = jTableVacinas.getModel().getValueAt(row, 2).toString();
					String animalId = jTableVacinas.getModel().getValueAt(row, 3).toString();
					String vacinaNome = jTableVacinas.getModel().getValueAt(row, 0).toString();
					String vacinaData = jTableVacinas.getModel().getValueAt(row, 1).toString();
					AlterarVacinaView view = new AlterarVacinaView(Integer.parseInt(vacinaId), vacinaNome, vacinaData, Integer.parseInt(animalId));
					view.setVisible(true);
					
				}
				catch (CadastrarVacinaException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				//-----------------------------------------
			}
		});
		btnEditarVacina.setIcon(new ImageIcon(ConsultarCarteiraView.class.getResource("/imagens/editar.png")));
		
		JButton btnExcluirVacina = new JButton("Excluir vacina");
		btnExcluirVacina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					if(jTableVacinas.getSelectedRow() == -1) {
						throw new CadastrarVacinaException();
					}
					int row = jTableVacinas.getSelectedRow();
					if(jTableVacinas.getModel().getValueAt(row, 2).toString() == null) {
						throw new CadastrarVacinaException();
					}
					String vacinaId = jTableVacinas.getModel().getValueAt(row, 2).toString();
					
					final JOptionPane pane = new JOptionPane();
					if (JOptionPane.showConfirmDialog(pane, "Deseja excluir a vacina?", "WARNING",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						ExcluirVacina(Integer.parseInt(vacinaId));
					} else {
						dispose();
					}					
				}
				catch (CadastrarVacinaException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				//-----------------------------------------
			}
		});
		
		btnExcluirVacina.setIcon(new ImageIcon(ConsultarCarteiraView.class.getResource("/imagens/excluir.png")));
		GroupLayout gl_jPanelMenu = new GroupLayout(jPanelMenu);
		
		gl_jPanelMenu.setHorizontalGroup(
			gl_jPanelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelMenu.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_jPanelMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanelMenu.createSequentialGroup()
							.addComponent(btnExcluirVacina, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addGap(30))
						.addGroup(gl_jPanelMenu.createSequentialGroup()
							.addGroup(gl_jPanelMenu.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanelMenu.createSequentialGroup()
									.addComponent(btnEditarVacina, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(btnNovaVacina, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
							.addGap(30))))
		);
		gl_jPanelMenu.setVerticalGroup(
			gl_jPanelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelMenu.createSequentialGroup()
					.addGap(10)
					.addComponent(btnNovaVacina, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnEditarVacina, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnExcluirVacina, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(10, Short.MAX_VALUE))
		);
		jPanelMenu.setLayout(gl_jPanelMenu);
	}
	
	private void ExcluirVacina(int vacinaId) {
		try {
			VacinaController controller = new VacinaController();
			if(controller.deleteVacina(vacinaId))
				JOptionPane.showMessageDialog(null, "Vacina excluida com sucesso");
			 else {
				 throw new Exception();
			 }
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir vacina");
		}
	}
	
	
	private void SetVacinaPanelConfiguration() {
		jPanelVacinas = new JPanel();
		JScrollPane jScrollPaneVacinas = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Vacinas");
		lblNewLabel.setIcon(new ImageIcon(ConsultarCarteiraView.class.getResource("/imagens/vacinas.png")));
		
		jTableVacinas = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
		};
		jTableVacinas.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
				},
				new String [] {
						"Nome", "Data de aplicação", "Id", "animalId"
				}
		));
		jTableVacinas.removeColumn(jTableVacinas.getColumnModel().getColumn(2));
		jTableVacinas.removeColumn(jTableVacinas.getColumnModel().getColumn(2));
		
		jScrollPaneVacinas.setViewportView(jTableVacinas);
		GroupLayout gl_jPanelVacinas = new GroupLayout(jPanelVacinas);
		gl_jPanelVacinas.setHorizontalGroup(
			gl_jPanelVacinas.createParallelGroup(Alignment.LEADING)
				.addComponent(jScrollPaneVacinas, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_jPanelVacinas.createSequentialGroup()
					.addContainerGap(83, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(74))
		);
		gl_jPanelVacinas.setVerticalGroup(
			gl_jPanelVacinas.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jPanelVacinas.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jScrollPaneVacinas, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
		);
		jPanelVacinas.setLayout(gl_jPanelVacinas);
	}

	private void SetAnimalPanelConfiguration() {
		jPanelAnimais = new JPanel();
		JScrollPane jScrollPaneAnimais = new JScrollPane();
		
		JLabel jLabelAnimais = new JLabel("Animais");
		jLabelAnimais.setIcon(new ImageIcon(ConsultarCarteiraView.class.getResource("/imagens/patas.png")));
		
		jTableAnimais = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
		};
		jTableAnimais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = jTableAnimais.getSelectedRow();
				String id = jTableAnimais.getModel().getValueAt(row, 4).toString();
				GetVacinasFromPetId(Integer.parseInt(id));
			}
		});
		jTableAnimais.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
				},
				new String [] {
						"Nome", "Raça", "Sexo", "Especie", "Id"
				}
		));
		jTableAnimais.removeColumn(jTableAnimais.getColumnModel().getColumn(4));
		
		jScrollPaneAnimais.setViewportView(jTableAnimais);
		GroupLayout gl_jPanelAnimais = new GroupLayout(jPanelAnimais);
		gl_jPanelAnimais.setHorizontalGroup(
			gl_jPanelAnimais.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelAnimais.createSequentialGroup()
					.addGap(177)
					.addComponent(jLabelAnimais)
					.addContainerGap(168, Short.MAX_VALUE))
				.addComponent(jScrollPaneAnimais, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
		);
		gl_jPanelAnimais.setVerticalGroup(
			gl_jPanelAnimais.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelAnimais.createSequentialGroup()
					.addGap(5)
					.addComponent(jLabelAnimais)
					.addGap(6)
					.addComponent(jScrollPaneAnimais, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
		);
		jPanelAnimais.setLayout(gl_jPanelAnimais);
	}
	
	private void SetTutorPanelConfiguration() {
		jPanelTutores = new JPanel();
		JScrollPane jScrollPaneTutores = new JScrollPane();
		
		JLabel jLabelTutores = new JLabel();
		jLabelTutores.setText("Tutores");
		jLabelTutores.setIcon(new ImageIcon(ConsultarCarteiraView.class.getResource("/imagens/avatar-de-perfil.png")));
		
		jTableTutores = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
		};
		jTableTutores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = jTableTutores.getSelectedRow();
				String id = jTableTutores.getModel().getValueAt(row, 2).toString();
				GetPetsFromTutorId(Integer.parseInt(id));
			}
		});
		jTableTutores.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
				},
				new String [] {
						"Nome", "CPF", "Id"
				}
		));
		
		jTableTutores.removeColumn(jTableTutores.getColumnModel().getColumn(2));
		
		jScrollPaneTutores.setViewportView(jTableTutores);
		GroupLayout gl_jPanelTutores = new GroupLayout(jPanelTutores);
		gl_jPanelTutores.setHorizontalGroup(
			gl_jPanelTutores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelTutores.createSequentialGroup()
					.addGap(171)
					.addComponent(jLabelTutores, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(171, Short.MAX_VALUE))
				.addComponent(jScrollPaneTutores, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
		);
		gl_jPanelTutores.setVerticalGroup(
			gl_jPanelTutores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelTutores.createSequentialGroup()
					.addComponent(jLabelTutores, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jScrollPaneTutores, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
		);
		jPanelTutores.setLayout(gl_jPanelTutores);
	}
		
	private JPanel jPanelAnimais;
	private JPanel jPanelMenu;
	private JPanel jPanelVacinas;
	private JPanel jPanelBuscarEVoltar;
	private JPanel jPanelTutores;	
	private JTable jTableTutores;
	private JTable jTableAnimais;
	private JTable jTableVacinas;
}
