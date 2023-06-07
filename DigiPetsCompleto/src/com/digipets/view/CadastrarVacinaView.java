
package com.digipets.view;
import javax.swing.GroupLayout.Alignment;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;

import com.digipets.controller.AnimalController;
import com.digipets.controller.ExceptionDAO;
import com.digipets.controller.VacinaController;
import com.digipets.dao.AnimalDAO;
import com.digipets.model.Animal;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CadastrarVacinaView extends javax.swing.JFrame {

	int idAnimal;
	String nomeAnimal;
	MaskFormatter formatter;
	public CadastrarVacinaView(int idAnimal, String nomeAnimal) throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarVacinaView.class.getResource("/imagens/animal-care.png")));
		this.idAnimal = idAnimal;
		this.nomeAnimal = nomeAnimal;
		this.formatter = new MaskFormatter("##/##/####");
		initComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setSize(350, 250);
		this.setTitle("Nova vacina");
	}
                       
	private void initComponents() {

		new javax.swing.JTextField();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jTFNomeVacina = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		
		jButtonNovaVacina = new javax.swing.JButton();
		jButtonNovaVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateVacina();
			}
		});

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel2.setText("Vacina aplicada:");

		jLabel3.setText("Data aplicação:");

		jButtonNovaVacina.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gusta\\Documents\\NetBeansProjects\\FrontEndDesktop\\src\\main\\java\\imagens\\salvar.png")); // NOI18N
		jButtonNovaVacina.setText("Salvar");
		
		jFormattedTextFieldDataApl = new JFormattedTextField(formatter);
		
		JLabel jLabelNomeAnimal = new JLabel("");
		jLabelNomeAnimal.setIcon(new ImageIcon(CadastrarVacinaView.class.getResource("/imagens/patas.png")));
		jLabelNomeAnimal.setText(" "+this.nomeAnimal);
		System.out.println(this.nomeAnimal);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(113)
					.addComponent(jButtonNovaVacina, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(43)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel3, Alignment.TRAILING)
						.addComponent(jLabel2, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jFormattedTextFieldDataApl, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
						.addComponent(jTFNomeVacina, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
					.addContainerGap(76, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
					.addContainerGap(115, Short.MAX_VALUE)
					.addComponent(jLabelNomeAnimal, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(108))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(17)
					.addComponent(jLabelNomeAnimal)
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel2)
						.addComponent(jTFNomeVacina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jFormattedTextFieldDataApl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(jButtonNovaVacina, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
		);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}                        

	public void CreateVacina() {
		try {
			VacinaController controller = new VacinaController();
			String nome = jTFNomeVacina.getText();
			String data = jFormattedTextFieldDataApl.getText();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			formatter.parse(data);
			if(controller.CreateVacina(nome, data, idAnimal))
				JOptionPane.showMessageDialog(null, "Vacina cadastrada com sucesso");
			 else if (nome.length() <= 0 || data.length() <= 0) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			}
			 else {
				 throw new Exception();
			 }
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar Vacina");
		}
	}
	
	private javax.swing.JButton jButtonNovaVacina;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTFNomeVacina;
	JFormattedTextField jFormattedTextFieldDataApl;
}
