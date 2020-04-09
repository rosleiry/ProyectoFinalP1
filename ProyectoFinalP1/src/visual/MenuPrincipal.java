package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Button;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tienda.getInstance().guardarDatos();
			}
		});
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("Tienda de computadoras RORO/Menu principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/iconos/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 432);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 634, 393);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
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
		btnComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnComponentesActionPerformed(e);
			}
		});
		btnComponentes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos/componentes64.png")));
		btnComponentes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnComponentes.setBounds(0, 0, 211, 333);
		panel_2.add(btnComponentes);
		
		JButton btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUsuariosActionPerformed(e);
			}
		});
		btnUsuarios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos/user64.png")));
		btnUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUsuarios.setBounds(209, 0, 214, 333);
		panel_2.add(btnUsuarios);
		
		JButton btnPedidos = new JButton("PEDIDOS");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPedidosActionPerformed(e);
			}
		});
		btnPedidos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos/pedidos64.png")));
		btnPedidos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPedidos.setBounds(420, 0, 214, 333);
		panel_2.add(btnPedidos);
	}
	
    private void btnComponentesActionPerformed(java.awt.event.ActionEvent evt) {
        MenuComponentes comp = new MenuComponentes();
        comp.setVisible(true);
        this.dispose();
    }
    
    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {
        Usuarios user = new Usuarios();
        user.setVisible(true);
        this.dispose();
    }
    
    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {
        Pedidos ped = new Pedidos();
        ped.setVisible(true);
        this.dispose();
    }
    
}
