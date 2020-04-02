package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Button;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\git\\ProyectoFinalP1\\ProyectoFinalP1\\src\\iconos\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 634, 393);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		panel_1.setBounds(0, 0, 634, 61);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(27, 0, 607, 61);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 60, 634, 333);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnComponentes = new JButton("COMPONENTES");
		btnComponentes.setIcon(new ImageIcon("C:\\Users\\Administrator\\git\\ProyectoFinalP1\\ProyectoFinalP1\\src\\iconos\\componentes64.png"));
		btnComponentes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnComponentes.setBounds(0, 0, 211, 333);
		panel_2.add(btnComponentes);
		
		JButton btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setIcon(new ImageIcon("C:\\Users\\Administrator\\git\\ProyectoFinalP1\\ProyectoFinalP1\\src\\iconos\\user64.png"));
		btnUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUsuarios.setBounds(209, 0, 214, 333);
		panel_2.add(btnUsuarios);
		
		JButton btnPedidos = new JButton("PEDIDOS");
		btnPedidos.setIcon(new ImageIcon("C:\\Users\\Administrator\\git\\ProyectoFinalP1\\ProyectoFinalP1\\src\\iconos\\pedidos64.png"));
		btnPedidos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPedidos.setBounds(420, 0, 214, 333);
		panel_2.add(btnPedidos);
	}
}
