package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Pedidos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos frame = new Pedidos();
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
	public Pedidos() {
		setTitle("Tienda de computadoras RORO/ Menu pedidos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pedidos.class.getResource("/iconos/logo256.png")));
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
		panel_1.setBounds(80, 0, 554, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PEDIDOS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 0, 544, 65);
		panel_1.add(lblNewLabel);
		
		JButton buttonVolver = new JButton("");
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVolverMenuPrincipalActionPerformed(arg0);
			}
		});
		buttonVolver.setIcon(new ImageIcon(Pedidos.class.getResource("/iconos/return.png")));
		buttonVolver.setFont(new Font("Times New Roman", Font.BOLD, 25));
		buttonVolver.setBounds(0, 0, 82, 65);
		panel.add(buttonVolver);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 64, 634, 329);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnHacerPedido = new JButton("HACER PEDIDO");
		btnHacerPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarPedidosActionPerformed(e);
			}
		});
		btnHacerPedido.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnHacerPedido.setIcon(new ImageIcon(Pedidos.class.getResource("/iconos/add.png")));
		btnHacerPedido.setBounds(0, 0, 317, 329);
		panel_2.add(btnHacerPedido);
		
		JButton btnVerPedidos = new JButton("LISTAR PEDIDOS");
		btnVerPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVerPedidosActionPerformed(e);
			}
		});
		btnVerPedidos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnVerPedidos.setIcon(new ImageIcon(Pedidos.class.getResource("/iconos/buscar.png")));
		btnVerPedidos.setBounds(317, 0, 317, 329);
		panel_2.add(btnVerPedidos);
	}
	
	   private void btnVolverMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {
		   MenuPrincipal menuP = new MenuPrincipal();
	        menuP.setVisible(true);
	        this.dispose();
	    }
	   
	   private void btnAgregarPedidosActionPerformed(java.awt.event.ActionEvent evt){
		   AgregarPedidos add = null;
		try {
			add = new AgregarPedidos();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   add.setVisible(true);
	        this.dispose();
	    }
	   
	   private void btnVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {
		   ListaPedidos ver = new ListaPedidos();
		   ver.setVisible(true);
	        this.dispose();
	    }

}
