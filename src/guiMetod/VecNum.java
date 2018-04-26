package guiMetod;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.JMenuBar;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VecNum extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblIntrucc;
	private JPanel buttonPane;
	JTextArea textTecla ;
	JButton okButton;
	public static VecNum dialog;
	/**
	 * Launch the application.
	 * @param inter 
	 */
	public static void main(String[] args, IGrafica inter) {
		try {
			dialog = new VecNum(inter);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VecNum(JFrame frame1) {
		setResizable(false);
		setBounds(630, 300, 579, 190);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, contentPanel, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, contentPanel, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, contentPanel, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, contentPanel, 0, SpringLayout.WEST, getContentPane());
		getContentPane().setLayout(springLayout);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			buttonPane = new JPanel();
			springLayout.putConstraint(SpringLayout.NORTH, buttonPane, -33, SpringLayout.SOUTH, getContentPane());
			springLayout.putConstraint(SpringLayout.WEST, buttonPane, 0, SpringLayout.WEST, getContentPane());
			springLayout.putConstraint(SpringLayout.SOUTH, buttonPane, 0, SpringLayout.SOUTH, getContentPane());
			springLayout.putConstraint(SpringLayout.EAST, buttonPane, 0, SpringLayout.EAST, getContentPane());
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Auxiliar aux=new Auxiliar();
						aux.cargarDatosTeclado(frame1,textTecla);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(false);

					}
				});
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(false);

					}
				});
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
		
			lblIntrucc = new JLabel("Introduzca los numeros del array separados por un espacio:");
			springLayout.putConstraint(SpringLayout.NORTH, lblIntrucc, 10, SpringLayout.NORTH, getContentPane());
			springLayout.putConstraint(SpringLayout.WEST, lblIntrucc, 10, SpringLayout.WEST, getContentPane());
			getContentPane().add(lblIntrucc);
			

			textTecla = new JTextArea();
			springLayout.putConstraint(SpringLayout.NORTH, textTecla, 6, SpringLayout.SOUTH, lblIntrucc);
			springLayout.putConstraint(SpringLayout.WEST, textTecla, 10, SpringLayout.WEST, getContentPane());
			springLayout.putConstraint(SpringLayout.SOUTH, textTecla, -6, SpringLayout.NORTH, buttonPane);
			springLayout.putConstraint(SpringLayout.EAST, textTecla, 563, SpringLayout.WEST, getContentPane());
			textTecla.setLineWrap(true);
			getContentPane().add(textTecla);
		

	}
}
