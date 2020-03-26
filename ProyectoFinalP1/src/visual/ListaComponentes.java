package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Button;
import javax.swing.JScrollBar;
import java.awt.Checkbox;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class ListaComponentes extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaComponentes frame = new ListaComponentes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setForeground(new Color(47, 79, 79));
		panel.setBounds(0, 72, 163, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Button button = new Button("DISCOS DUROS");
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button.setBackground(new Color(0, 0, 51));
		button.setBounds(0, 0, 161, 33);
		panel.add(button);
		
		Button button_1 = new Button("PERIFERICOS");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button_1.setBackground(new Color(0, 0, 51));
		button_1.setBounds(0, 78, 161, 33);
		panel.add(button_1);
		
		Button button_2 = new Button("PROCESADORES");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button_2.setBackground(new Color(0, 0, 51));
		button_2.setBounds(0, 117, 161, 33);
		panel.add(button_2);
		
		Button button_3 = new Button("MEMORIAS RAM");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button_3.setBackground(new Color(0, 0, 51));
		button_3.setBounds(0, 39, 161, 33);
		panel.add(button_3);
		
		Button button_4 = new Button("TARJETAS MADRE");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button_4.setBackground(new Color(0, 0, 51));
		button_4.setBounds(0, 156, 161, 33);
		panel.add(button_4);
		
		Button button_5 = new Button("VOLVER");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button_5.setBackground(new Color(0, 0, 51));
		button_5.setBounds(0, 195, 161, 33);
		panel.add(button_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		panel_1.setBounds(0, 0, 634, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("COMPONENTES");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(20, 0, 614, 61);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setBounds(164, 64, 470, 329);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtBuscar = new JTextField();
		txtBuscar.setEditable(false);
		txtBuscar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtBuscar.setBounds(10, 11, 310, 25);
		panel_2.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenar por", "Precio menor a mayor", "Precio mayor a menor", "Recomendados", "Popular"}));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox.setBounds(330, 13, 130, 20);
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		panel_3.setBounds(0, 44, 470, 285);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(443, 0, 17, 285);
		panel_3.add(scrollBar);
	}
}
