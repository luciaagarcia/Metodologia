package guiMetod;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IGPrincip {

	JFrame frame;
	TextArea textArea;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IGPrincip window = new IGPrincip();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public IGPrincip() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 200, 948, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(menuBar);
		
		JButton btnPrac1 = new JButton("Burbuja/SD");
		menuBar.add(btnPrac1);
		
		JButton btnPrac2 = new JButton("Fibonacci");
		menuBar.add(btnPrac2);
		
		JButton btnNewButton_2 = new JButton("New button");
		menuBar.add(btnNewButton_2);
		
		panelBurb burb=new panelBurb(frame, textArea);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, menuBar);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 432, SpringLayout.SOUTH, menuBar);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		
	
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, menuBar);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 432, SpringLayout.SOUTH, menuBar);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_1);

		
		JLabel lbl1 = new JLabel("panel 1");
		panel_1.add(lbl1);
		panel.setVisible(false);

		btnPrac1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
				panel_1.setVisible(false);
			}
		});				

		
		btnPrac2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		
	
		JPanel panelText = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelText, 5, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panelText, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelText, 0, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelText, 930, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panelText);
		SpringLayout sl_panelText = new SpringLayout();
		panelText.setLayout(sl_panelText);
		
		textArea = new TextArea(); 
		textArea.setFont(new Font("Consolas", Font.PLAIN, 13));
		sl_panelText.putConstraint(SpringLayout.NORTH, textArea, 0, SpringLayout.NORTH, panelText);
		sl_panelText.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST,panelText);
		sl_panelText.putConstraint(SpringLayout.SOUTH, textArea, 0, SpringLayout.SOUTH, panelText);
		sl_panelText.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, panelText);
		
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);
		panelText.add(textArea);
	}
}
