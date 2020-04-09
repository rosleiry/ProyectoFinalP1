package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuComponentes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuComponentes frame = new MenuComponentes();
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
	public MenuComponentes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tienda.getInstance().guardarDatos();
			}
		});
		setTitle("Tienda de computadoras RORO/Menu componentes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuComponentes.class.getResource("/iconos/logo256.png")));
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
		panel_1.setBounds(82, 0, 552, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COMPONENTES");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 0, 511, 65);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 64, 634, 329);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnVerComponentes = new JButton("VER");
		btnVerComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVerComponentesActionPerformed(arg0);
			}
		});
		btnVerComponentes.setIcon(new ImageIcon(MenuComponentes.class.getResource("/iconos/buscar.png")));
		btnVerComponentes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnVerComponentes.setBounds(0, 0, 318, 329);
		panel_2.add(btnVerComponentes);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarCompActionPerformed(e);
			}
		});
		btnAgregar.setIcon(new ImageIcon(MenuComponentes.class.getResource("/iconos/add.png")));
		btnAgregar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAgregar.setBounds(317, 0, 317, 329);
		panel_2.add(btnAgregar);
		
		JButton btnVolverMenuPrincipal = new JButton("");
		btnVolverMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVolverMenuPrincipalActionPerformed(arg0);
			}
		});
		btnVolverMenuPrincipal.setIcon(new ImageIcon(MenuComponentes.class.getResource("/iconos/return.png")));
		btnVolverMenuPrincipal.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnVolverMenuPrincipal.setBounds(0, 0, 82, 65);
		panel.add(btnVolverMenuPrincipal);
	}
	   private void btnVolverMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {
		   MenuPrincipal menuP = new MenuPrincipal();
	        menuP.setVisible(true);
	        this.dispose();
	    }
	   private void btnVerComponentesActionPerformed(java.awt.event.ActionEvent evt) {
	        ListaComponentes menuP = new ListaComponentes();
	        menuP.setVisible(true);
	        this.dispose();
	    }
	    private void btnAgregarCompActionPerformed(java.awt.event.ActionEvent evt) {
	        AgregarComponentes add = new AgregarComponentes();
	        add.setVisible(true);
	        this.dispose();
	    }
	   
}
