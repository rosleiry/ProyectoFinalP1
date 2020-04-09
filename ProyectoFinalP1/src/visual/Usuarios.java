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
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtBuscarClientePor;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios frame = new Usuarios();
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
	public Usuarios() {
		setTitle("Tienda de computadoras RORO/Listar clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/iconos/logo256.png")));
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
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setForeground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 634, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTAR CLIENTES");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 0, 542, 65);
		panel_1.add(lblNewLabel);
		
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre:", "C\u00E9dula:", "Direcci\u00F3n:"
			}
		));
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
		
		JButton btnNewButton_1 = new JButton("BUSCAR");
		btnNewButton_1.setIcon(null);
		btnNewButton_1.setBounds(220, 10, 89, 23);
		panel_2.add(btnNewButton_1);
	}
	
    private void btnVolverAMenuActionPerformed(java.awt.event.ActionEvent evt) {
        MenuPrincipal menuP = new MenuPrincipal();
        menuP.setVisible(true);
        this.dispose();
    }
}
