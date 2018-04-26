package guiMetod;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class panelBurb extends JPanel {
	JTextField textoBurb1;
	JTextField textoSel1;
	JComboBox cajaSelecc = new JComboBox();
	JRadioButton btnMs1 = new JRadioButton("Ms"), btnNs1 = new JRadioButton("Ns"),btnMs2 = new JRadioButton("Ms"),btnNs2 = new JRadioButton("Ns");
	JTextField textoLong1,textAleat;
	JLabel lblAleat, lblExtrem, lblBurbuj1, lblSeleccionDirecta1;
	JButton btnValores;
	JTable tablaValor;
	JCheckBox lblSeleccionDirecta, lblbu;
	JFrame frame1;
	TextArea textArea;
	
	public panelBurb(JFrame frame, TextArea textArea1) {
		frame1=frame;
		textArea=textArea1;
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, btnMs2, 252, SpringLayout.NORTH, frame.getContentPane());
		setLayout(springLayout);
		
		setBounds(400, 200, 948, 694);
		this.setLayout(springLayout);
		Auxiliar aux=new Auxiliar();

		JButton btnApartado1 = new JButton("Ejecutar");
		btnApartado1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobAp1();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnApartado1, 45, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnApartado1, 38, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnApartado1, 77, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnApartado1, 164, SpringLayout.WEST, frame.getContentPane());
		this.add(btnApartado1);

		JButton btnApartado2 = new JButton("Ejecutar");
		springLayout.putConstraint(SpringLayout.SOUTH, btnApartado2, -4, SpringLayout.NORTH, btnMs2);
		btnApartado2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aux.apartado2(null);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNs2, 4, SpringLayout.NORTH, btnApartado2);
		springLayout.putConstraint(SpringLayout.WEST, btnApartado2, 0, SpringLayout.WEST, btnApartado1);
		springLayout.putConstraint(SpringLayout.EAST, btnApartado2, 0, SpringLayout.EAST, btnApartado1);
		this.add(btnApartado2);


		btnMs1.setSelected(true);
		btnMs1.setVerticalAlignment(SwingConstants.BOTTOM);
		springLayout.putConstraint(SpringLayout.NORTH, btnMs1, 5, SpringLayout.NORTH, btnApartado1);
		springLayout.putConstraint(SpringLayout.WEST, btnMs1, 21, SpringLayout.EAST, btnApartado1);
		this.add(btnMs1);
		
		springLayout.putConstraint(SpringLayout.NORTH, btnNs1, 4, SpringLayout.NORTH, btnApartado1);
		springLayout.putConstraint(SpringLayout.WEST, btnNs1, 36, SpringLayout.EAST, btnMs1);
		btnNs1.setVerticalAlignment(SwingConstants.BOTTOM);
		this.add(btnNs1);
		btnMs2.setSelected(true);
		btnMs2.setVerticalAlignment(SwingConstants.BOTTOM);
		this.add(btnMs2);
		btnNs2.setVerticalAlignment(SwingConstants.BOTTOM);
		this.add(btnNs2);


		cajaSelecc.setModel(new DefaultComboBoxModel(new String[] {"Fuente Datos:", "Archivo", "Teclado", "Aleatorio"}));
		cajaSelecc.setToolTipText("Seleccionar desde donde se cargan los datos");
		springLayout.putConstraint(SpringLayout.NORTH, cajaSelecc, 50, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, cajaSelecc, 32, SpringLayout.EAST, btnNs1);
		springLayout.putConstraint(SpringLayout.EAST, cajaSelecc, 167, SpringLayout.EAST, btnNs1);
		this.add(cajaSelecc);

		textoBurb1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textoBurb1, 113, SpringLayout.WEST, frame.getContentPane());
		this.add(textoBurb1);
		textoBurb1.setColumns(10);

		lblBurbuj1 = new JLabel("Burbuja:");
		springLayout.putConstraint(SpringLayout.WEST, lblBurbuj1, 0, SpringLayout.WEST, textoBurb1);
		this.add(lblBurbuj1);

		textoSel1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textoSel1, 53, SpringLayout.SOUTH, btnNs1);
		springLayout.putConstraint(SpringLayout.NORTH, textoBurb1, 0, SpringLayout.NORTH, textoSel1);
		springLayout.putConstraint(SpringLayout.EAST, textoBurb1, -21, SpringLayout.WEST, textoSel1);
		springLayout.putConstraint(SpringLayout.WEST, textoSel1, 0, SpringLayout.WEST, btnNs1);
		springLayout.putConstraint(SpringLayout.EAST, textoSel1, 89, SpringLayout.EAST, btnNs1);
		this.add(textoSel1);
		textoSel1.setColumns(10);

		lblSeleccionDirecta1 = new JLabel("Seleccion Directa:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblSeleccionDirecta1, -6, SpringLayout.NORTH, textoSel1);
		springLayout.putConstraint(SpringLayout.NORTH, lblBurbuj1, 0, SpringLayout.NORTH, lblSeleccionDirecta1);
		springLayout.putConstraint(SpringLayout.WEST, lblSeleccionDirecta1, 0, SpringLayout.WEST, btnNs1);
		this.add(lblSeleccionDirecta1);

		JLabel lblTiempos = new JLabel("Tiempos:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTiempos, 3, SpringLayout.NORTH, textoBurb1);
		springLayout.putConstraint(SpringLayout.WEST, lblTiempos, 0, SpringLayout.WEST, btnApartado1);
		this.add(lblTiempos);

		JSeparator separator = new JSeparator();
		springLayout.putConstraint(SpringLayout.NORTH, separator, 18, SpringLayout.SOUTH, textoBurb1);
		springLayout.putConstraint(SpringLayout.WEST, separator, 12, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, separator, 19, SpringLayout.SOUTH, textoBurb1);
		springLayout.putConstraint(SpringLayout.EAST, separator, -12, SpringLayout.EAST, frame.getContentPane());
		this.add(separator);

		textoLong1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textoLong1, 0, SpringLayout.NORTH, textoBurb1);
		springLayout.putConstraint(SpringLayout.WEST, textoLong1, 26, SpringLayout.EAST, textoSel1);
		springLayout.putConstraint(SpringLayout.EAST, textoLong1, 152, SpringLayout.EAST, textoSel1);
		this.add(textoLong1);
		textoLong1.setColumns(10);

		JLabel lblLong1 = new JLabel("Longitud del array:");
		lblLong1.setToolTipText("");
		springLayout.putConstraint(SpringLayout.NORTH, lblLong1, 0, SpringLayout.NORTH, lblBurbuj1);
		springLayout.putConstraint(SpringLayout.WEST, lblLong1, 0, SpringLayout.WEST, textoLong1);
		this.add(lblLong1);

		textAleat = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textAleat, 6, SpringLayout.NORTH, btnApartado1);
		springLayout.putConstraint(SpringLayout.SOUTH, textAleat, 29, SpringLayout.NORTH, btnApartado1);
		springLayout.putConstraint(SpringLayout.EAST, textAleat, -156, SpringLayout.EAST, frame.getContentPane());
		this.add(textAleat);
		textAleat.setColumns(10);
		lblAleat = new JLabel("Introduzca longitud del array:");
		springLayout.putConstraint(SpringLayout.WEST, textAleat, 6, SpringLayout.EAST, lblAleat);
		springLayout.putConstraint(SpringLayout.NORTH, lblAleat, 9, SpringLayout.NORTH, btnApartado1);
		springLayout.putConstraint(SpringLayout.WEST, lblAleat, 58, SpringLayout.EAST, cajaSelecc);
		this.add(lblAleat);

		lblAleat.setVisible(false); textAleat.setVisible(false);

		btnValores = new JButton("Establecer Valores Array");
		springLayout.putConstraint(SpringLayout.WEST, btnValores, -200, SpringLayout.EAST, textAleat);
		btnValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearArray();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnValores, 5, SpringLayout.NORTH, btnApartado1);
		this.add(btnValores);

		JLabel lblApartado_1 = new JLabel("Apartado 2");
		springLayout.putConstraint(SpringLayout.WEST, lblApartado_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnApartado2, 20, SpringLayout.SOUTH, lblApartado_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblApartado_1, -466, SpringLayout.SOUTH, frame.getContentPane());
		this.add(lblApartado_1);

		JLabel lblApartado = new JLabel("Apartado 1");
		springLayout.putConstraint(SpringLayout.NORTH, lblApartado, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblApartado, 10, SpringLayout.WEST, frame.getContentPane());
		this.add(lblApartado);

		JLabel lblLongitudArray = new JLabel("Longitud Array");
		this.add(lblLongitudArray);

		tablaValor = new JTable();
		springLayout.putConstraint(SpringLayout.WEST, tablaValor, 74, SpringLayout.EAST, btnMs2);
		springLayout.putConstraint(SpringLayout.SOUTH, tablaValor, -228, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblLongitudArray, -6, SpringLayout.NORTH, tablaValor);
		tablaValor.setShowHorizontalLines(false);
		tablaValor.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
						"Longitud", "Burb", "Sel", "MenorT"
				}
				) {
			Class[] columnTypes = new Class[] {
					Integer.class, Long.class, Long.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaValor.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablaValor.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaValor.getColumnModel().getColumn(2).setPreferredWidth(100);
		this.add(tablaValor);

		lblbu = new JCheckBox("Burbuja");
		springLayout.putConstraint(SpringLayout.SOUTH, lblbu, -420, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, tablaValor, 0, SpringLayout.SOUTH, lblbu);
		lblbu.setSelected(true);
		springLayout.putConstraint(SpringLayout.EAST, lblLongitudArray, -45, SpringLayout.WEST, lblbu);
		this.add(lblbu);

		lblSeleccionDirecta = new JCheckBox("Seleccion Directa");
		lblSeleccionDirecta.setSelected(true);
		springLayout.putConstraint(SpringLayout.EAST, lblbu, -180, SpringLayout.EAST, lblSeleccionDirecta);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSeleccionDirecta, 0, SpringLayout.NORTH, tablaValor);
		this.add(lblSeleccionDirecta);

		JLabel lblMenorTiempo = new JLabel("Menor Tiempo");
		springLayout.putConstraint(SpringLayout.EAST, lblSeleccionDirecta, -35, SpringLayout.WEST, lblMenorTiempo);
		springLayout.putConstraint(SpringLayout.WEST, lblMenorTiempo, 530, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblMenorTiempo, -6, SpringLayout.NORTH, tablaValor);
		this.add(lblMenorTiempo);

		JButton btnExtremo = new JButton("MODO EXTREMO");
		springLayout.putConstraint(SpringLayout.EAST, tablaValor, -52, SpringLayout.WEST, btnExtremo);
		springLayout.putConstraint(SpringLayout.NORTH, btnExtremo, 176, SpringLayout.SOUTH, separator);
		springLayout.putConstraint(SpringLayout.SOUTH, btnExtremo, -271, SpringLayout.SOUTH, frame.getContentPane());
		btnExtremo.setBackground(new Color(255, 0, 0));
		springLayout.putConstraint(SpringLayout.WEST, btnExtremo, 0, SpringLayout.WEST, textAleat);
		springLayout.putConstraint(SpringLayout.EAST, btnExtremo, 0, SpringLayout.EAST, separator);

		this.add(btnExtremo);

		lblExtrem = new JLabel("\u00A1MODO EXTREMO ACTIVADO!");
		lblExtrem.setVisible(false);
		lblExtrem.setForeground(new Color(255, 0, 0));
		springLayout.putConstraint(SpringLayout.NORTH, lblExtrem, -7, SpringLayout.NORTH, btnApartado2);
		springLayout.putConstraint(SpringLayout.WEST, lblExtrem, 55, SpringLayout.EAST, btnNs2);
		lblExtrem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 26));
		this.add(lblExtrem);
		btnValores.setVisible(false);

		btnExtremo.addActionListener(new ActionListener() {
			int contExtr=0;
			public void actionPerformed(ActionEvent arg0) {
				lblExtrem.setVisible(true);
				switch(contExtr) {
				case 0:lblExtrem.setText("\u00A1MODO EXTREMO ACTIVADO!");contExtr++;
				break;
				case 1:lblExtrem.setText("No lo puedes desactivar");contExtr++;
				break;
				case 2:lblExtrem.setText("No insistas...");contExtr++;
				break;
				case 3:lblExtrem.setVisible(false);contExtr=0; 
				break;
				}
			}
		});
		/*selecMsNs();
		modSelecc();*/

	}

	public void modSelecc(){
		cajaSelecc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(cajaSelecc.getSelectedIndex()){
				case 0:
					btnValores.setVisible(false);
					lblAleat.setVisible(false); textAleat.setVisible(false);
					break;

				case 1:
					btnValores.setVisible(false);
					lblAleat.setVisible(false); textAleat.setVisible(false);
					break;
				case 2:
					btnValores.setVisible(true);
					lblAleat.setVisible(false); textAleat.setVisible(false);
					break;
				case 3:
					btnValores.setVisible(false);
					lblAleat.setVisible(true); textAleat.setVisible(true);
					break;
				}
			}
		});
	}

	public void selecMsNs() {
		btnMs1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNs1.isSelected()) {
					btnNs1.setSelected(false);
					btnMs1.setSelected(true);
				}
				if(!btnNs1.isSelected()) {
					btnMs1.setSelected(true);
				}
			}
		});
		btnNs1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNs1.isSelected()) {
					btnMs1.setSelected(false);
					btnNs1.setSelected(true);
				}
				if(!btnMs1.isSelected()) {
					btnNs1.setSelected(true);
				}
			}
		});
		btnMs2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNs2.isSelected()) {
					btnNs2.setSelected(false);
					btnMs2.setSelected(true);
				}
				if(!btnNs2.isSelected()) {
					btnMs2.setSelected(true);
				}
			}
		});
		btnNs2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNs2.isSelected()) {
					btnMs2.setSelected(false);
					btnNs2.setSelected(true);
				}
				if(!btnMs2.isSelected()) {
					btnNs2.setSelected(true);
				}
			}
		});
	}

	public char get_time(int op) {
		char opt='n';
		switch(op) {
		case 1: if(btnMs1.isSelected()) { opt='m'; }else {opt='n';}
		break;

		case 2: if(btnMs2.isSelected()) { opt='m'; }else {opt='n';}
		break;
		}

		return opt;
	}

	public String get_FormVec() {
		String forma=null;

		switch(cajaSelecc.getSelectedIndex()){
		case 1:forma="F"; appende("Se cargara el archivo que contiene el vector.");
		break;
		case 2:forma="T"; appende("Se cargaran los datos desde teclado.");
		break;
		case 3:forma="A"; appende("Se cargaran los datos de forma aleatoria.");
		break;
		}
		return forma;
	}

	public void appende(String texto) {
		//textArea.append(texto+"\n");
	}

	public void comprobAp1() {
		if(cajaSelecc.getSelectedIndex()==0) {
			appende("Opcion para cargar datos incorrecta");
		}else {
			Auxiliar aux=new Auxiliar();
			aux.apartado1(this);
		}

	}

	public void crearArray() {
		VecNum vec=new VecNum(frame1);
		//vec.main(null,this); 
	}

	public int comprobarEnt(String opcion) {
		boolean correcto=true;
		int numero=0;
		try{
			opcion=textAleat.getText();
			numero=Integer.parseInt(opcion);
			correcto=true;
		}catch(NumberFormatException e){
			appende("Introduzca un numero entero");
			correcto=false;
		}
		return numero;
	}
}
