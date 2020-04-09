package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Usuario;
import logico.Tienda;

import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static Object[] fila;
	private JTextField txtBuscarClientePor;
	private static DefaultTableModel tableModel;
	private int cedula;
	


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Usuarios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tienda.getInstance().guardarDatos();
			}
		});
		setTitle("Tienda de computadoras RORO/Listar clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/iconos/logo256.png")));
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
		panel_1.setForeground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 634, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEncabezado = new JLabel("LISTAR CLIENTES");
		lblEncabezado.setForeground(new Color(255, 255, 255));
		lblEncabezado.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblEncabezado.setBounds(10, 0, 542, 65);
		panel_1.add(lblEncabezado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 64, 634, 329);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 50, 614, 235);
		panel_2.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				if(table.getSelectedRow()>=0){
	
					int index = table.getSelectedRow();
					cedula = (int)table.getModel().getValueAt(index, 0);
					
				}
			}
		});
		tableModel = new DefaultTableModel();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00E9dula:", "Nombre:", "Tel\u00E9fono:", "Direcci\u00F3n:"
			}
		));
		cargar(0);
		scrollPane.setViewportView(table);
		panel_3.setLayout(gl_panel_3);

		JButton btnVolverMenu = new JButton("VOLVER");
		btnVolverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolverAMenuActionPerformed(e);
			}
		});
		btnVolverMenu.setIcon(null);
		btnVolverMenu.setBounds(534, 295, 90, 23);
		panel_2.add(btnVolverMenu);
		
		txtBuscarClientePor = new JTextField();
		txtBuscarClientePor.setBounds(10, 11, 204, 20);
		panel_2.add(txtBuscarClientePor);
		txtBuscarClientePor.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("BUSCAR");
		btnBuscarCliente.setIcon(null);
		btnBuscarCliente.setBounds(220, 10, 89, 23);
		panel_2.add(btnBuscarCliente);
	}
	
    private void btnVolverAMenuActionPerformed(java.awt.event.ActionEvent evt) {
        MenuPrincipal menuP = new MenuPrincipal();
        menuP.setVisible(true);
        this.dispose();
    }
    
	public static void cargar(int selection) {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		switch (selection) {
		case 0:
			for (Usuario aux : Tienda.getInstance().getUsuarios()) {
				fila[0] = aux.getCedula();
				fila[1] = aux.getNombre();
				fila[2] = aux.getTelefono();
				fila[3] = aux.getDireccion();
				tableModel.addRow(fila);
			}

		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		
		 columnModel.getColumn(0).setPreferredWidth(60);
		 columnModel.getColumn(1).setPreferredWidth(180);
		 columnModel.getColumn(2).setPreferredWidth(150);
		 columnModel.getColumn(3).setPreferredWidth(150);
		
		
		
	}
	}
}
