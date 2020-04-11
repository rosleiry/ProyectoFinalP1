package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Pedido;
import logico.Tienda;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

public class ListaPedidos extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static DefaultTableModel tableModelPedidos;
	private static Object[] fila;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ListaPedidos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tienda.getInstance().guardarDatos();
			}
		});
		setTitle("Tienda de computadoras RORO/Listar pedidos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaPedidos.class.getResource("/iconos/logo256.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 432);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 634, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTAR PEDIDOS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 0, 624, 65);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 65, 634, 328);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolverMenuPedidosActionPerformed(e);
			}
		});
		btnVolver.setBounds(535, 294, 89, 23);
		panel_1.add(btnVolver);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 614, 272);
		panel_1.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
		);
		
		table = new JTable();
		tableModelPedidos = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		String[] columnas = {"ID:", "C\u00E9dula cliente:", "Precio:", "Mano de obra:"};
		tableModelPedidos.setColumnIdentifiers(columnas);
		cargarPedidos();
		
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
	}
	
	  

	private static void cargarPedidos() {
		tableModelPedidos.setRowCount(0);
		fila = new Object[tableModelPedidos.getColumnCount()];
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		for(Pedido p: Tienda.getInstance().getPedidos()) {
			String precio = formatter.format(p.getPrecioPedido());
			fila[0] = p.getIDpedido();
			fila[1] = p.getCedulaUsuario();
			fila[2] = precio;
			fila[3] = p.getManoDeObra();
			tableModelPedidos.addRow(fila);
		}
		
		table.setModel(tableModelPedidos);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		
		columnModel.getColumn(0).setPreferredWidth(10);
	}



	private void btnVolverMenuPedidosActionPerformed(java.awt.event.ActionEvent evt) {
		   Pedidos volver = new Pedidos();
		   volver.setVisible(true);
	        this.dispose();
	    }
}
