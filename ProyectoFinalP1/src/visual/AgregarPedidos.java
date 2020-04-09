package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarPedidos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField tfTotalPedido;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarPedidos frame = new AgregarPedidos();
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
	public AgregarPedidos() {
		setTitle("Tienda de computadoras RORO/Hacer pedido");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarPedidos.class.getResource("/iconos/logo256.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 634, 429);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 634, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HACER PEDIDO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 0, 624, 65);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 65, 634, 364);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "BUSCAR CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 11, 614, 101);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 21, 46, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 46, 46, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 71, 59, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(344, 46, 46, 14);
		panel_3.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(66, 18, 169, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 43, 268, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 68, 538, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(400, 43, 204, 20);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("BUSCAR");
		btnBuscarCliente.setBounds(245, 17, 89, 23);
		panel_3.add(btnBuscarCliente);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "FACTURA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 123, 614, 196);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.setBounds(279, 42, 54, 23);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.setBounds(279, 76, 54, 23);
		panel_4.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Componentes disponibles:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5.setBounds(59, 17, 148, 14);
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Carrito:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_6.setBounds(450, 17, 46, 14);
		panel_4.add(lblNewLabel_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 35, 259, 93);
		panel_4.add(panel_5);
		
		JList list = new JList();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(343, 35, 261, 93);
		panel_4.add(panel_6);
		
		JList list_1 = new JList();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addComponent(list_1, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addComponent(list_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
		);
		panel_6.setLayout(gl_panel_6);
		
		tfTotalPedido = new JTextField();
		tfTotalPedido.setEditable(false);
		tfTotalPedido.setBounds(497, 165, 107, 20);
		panel_4.add(tfTotalPedido);
		tfTotalPedido.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Total:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_7.setBounds(450, 168, 46, 14);
		panel_4.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u00BFDesea recibir el equipo ensamblado?");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 139, 185, 14);
		panel_4.add(lblNewLabel_8);
		
		JButton btnSi = new JButton("");
		btnSi.setBackground(new Color(0, 204, 0));
		btnSi.setBounds(200, 135, 26, 23);
		panel_4.add(btnSi);
		
		JButton btnNo = new JButton("");
		btnNo.setBackground(new Color(255, 0, 0));
		btnNo.setBounds(236, 135, 26, 23);
		panel_4.add(btnNo);
		
		JLabel lblNewLabel_9 = new JLabel("Mano de obra:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_9.setBounds(402, 139, 82, 14);
		panel_4.add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(497, 134, 107, 20);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("FACTURAR");
		btnNewButton_2.setBounds(535, 330, 89, 23);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VOLVER");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolverMenuPedidosActionPerformed(e);
			}
		});
		btnNewButton_3.setBounds(436, 330, 89, 23);
		panel_2.add(btnNewButton_3);
	}
	
	   private void btnVolverMenuPedidosActionPerformed(java.awt.event.ActionEvent evt) {
		   Pedidos volver = new Pedidos();
		   volver.setVisible(true);
	        this.dispose();
	    }
}
