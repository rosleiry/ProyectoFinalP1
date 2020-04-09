package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;

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
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaComponentes extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tableDiscosDuros;
	private JTable tableRAM;
	private JTable tableProcesador;
	private JTable tableTarjetaMadre;


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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tienda.getInstance().guardarDatos();
			}
		});
		setTitle("Tienda de computadoras RORO/Listar componentes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaComponentes.class.getResource("/iconos/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 432);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelDiscoDuro = new JPanel();
		JPanel panelRAM = new JPanel();
		JPanel panelTarjetaMadre = new JPanel();
		JPanel panelProcesador = new JPanel();
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.LIGHT_GRAY);
		panelBotones.setForeground(new Color(47, 79, 79));
		panelBotones.setBounds(0, 64, 166, 329);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);
		
		JButton btnDiscosDuros = new JButton("DISCOS DUROS");
		btnDiscosDuros.setHorizontalAlignment(SwingConstants.LEFT);
		btnDiscosDuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDiscoDuro.setVisible(true);
				panelRAM.setVisible(false);
				panelTarjetaMadre.setVisible(false);
				panelProcesador.setVisible(false);
	
			}
		});
		btnDiscosDuros.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/harddrive.png")));
		btnDiscosDuros.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDiscosDuros.setBounds(0, 0, 166, 65);
		panelBotones.add(btnDiscosDuros);
		
		JButton btnMemoriasRam = new JButton("MEMORIAS RAM");
		btnMemoriasRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDiscoDuro.setVisible(false);
				panelRAM.setVisible(true);
				panelTarjetaMadre.setVisible(false);
				panelProcesador.setVisible(false);
			}
		});
		btnMemoriasRam.setHorizontalAlignment(SwingConstants.LEFT);
		btnMemoriasRam.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/ram-memory.png")));
		btnMemoriasRam.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnMemoriasRam.setBounds(0, 65, 166, 65);
		panelBotones.add(btnMemoriasRam);
		
		JButton btnProcesadores = new JButton("PROCESADORES");
		btnProcesadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDiscoDuro.setVisible(false);
				panelRAM.setVisible(false);
				panelTarjetaMadre.setVisible(false);
				panelProcesador.setVisible(true);
			}
		});
		btnProcesadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnProcesadores.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/processor.png")));
		btnProcesadores.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnProcesadores.setBounds(0, 130, 166, 66);
		panelBotones.add(btnProcesadores);
		
		JButton btnTarjetasMadre = new JButton("TARJETAS MADRE");
		btnTarjetasMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDiscoDuro.setVisible(false);
				panelRAM.setVisible(false);
				panelTarjetaMadre.setVisible(true);
				panelProcesador.setVisible(false);
			}
		});
		btnTarjetasMadre.setHorizontalAlignment(SwingConstants.LEFT);
		btnTarjetasMadre.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/motherboard.png")));
		btnTarjetasMadre.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnTarjetasMadre.setBounds(0, 196, 166, 66);
		panelBotones.add(btnTarjetasMadre);
		
		JButton btnVolverAMenu = new JButton("");
		btnVolverAMenu.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/return.png")));
		btnVolverAMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolverAMenuActionPerformed(e);
			}
		});
		btnVolverAMenu.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolverAMenu.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnVolverAMenu.setBounds(0, 262, 166, 65);
		panelBotones.add(btnVolverAMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
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
		
		JComboBox cbxFiltrar = new JComboBox();
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenar por", "Precio menor a mayor", "Precio mayor a menor", "Recomendados", "Popular"}));
		cbxFiltrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cbxFiltrar.setBounds(330, 13, 130, 20);
		panel_2.add(cbxFiltrar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		panel_3.setBounds(0, 44, 470, 285);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		//JPanel panelDiscoDuro = new JPanel();
		panelDiscoDuro.setBounds(0, 0, 470, 285);
		panel_3.add(panelDiscoDuro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		GroupLayout gl_panelDiscoDuro = new GroupLayout(panelDiscoDuro);
		gl_panelDiscoDuro.setHorizontalGroup(
			gl_panelDiscoDuro.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
		);
		gl_panelDiscoDuro.setVerticalGroup(
			gl_panelDiscoDuro.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
		);
		
		tableDiscosDuros = new JTable();
		tableDiscosDuros.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00FAm serie:", "Disponibles:", "Precio:", "Marca:", "Modelo:", "Almacenamiento:", "Tipo conexi\u00F3n:"
			}
		));
		scrollPane.setViewportView(tableDiscosDuros);
		panelDiscoDuro.setLayout(gl_panelDiscoDuro);
		
		//JPanel panelRAM = new JPanel();
		panelRAM.setBounds(0, 0, 470, 285);
		panel_3.add(panelRAM);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panelRAM = new GroupLayout(panelRAM);
		gl_panelRAM.setHorizontalGroup(
			gl_panelRAM.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
		);
		gl_panelRAM.setVerticalGroup(
			gl_panelRAM.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
		);
		
		tableRAM = new JTable();
		tableRAM.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00FAm serie:", "Cantidad:", "Precio:", "Marca:", "Cant memoria:", "Tipo memoria:"
			}
		));
		scrollPane_1.setViewportView(tableRAM);
		panelRAM.setLayout(gl_panelRAM);
		
		//JPanel panelProcesador = new JPanel();
		panelProcesador.setBounds(0, 0, 470, 285);
		panel_3.add(panelProcesador);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panelProcesador = new GroupLayout(panelProcesador);
		gl_panelProcesador.setHorizontalGroup(
			gl_panelProcesador.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
		);
		gl_panelProcesador.setVerticalGroup(
			gl_panelProcesador.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
		);
		
		tableProcesador = new JTable();
		tableProcesador.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00FAm serie:", "Cantidad:", "Precio:", "Marca:", "Modelo:", "Tipo socket:", "Velocidad:"
			}
		));
		scrollPane_2.setViewportView(tableProcesador);
		panelProcesador.setLayout(gl_panelProcesador);
		
		//JPanel panelTarjetaMadre = new JPanel();
		panelTarjetaMadre.setBounds(0, 0, 470, 285);
		panel_3.add(panelTarjetaMadre);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panelTarjetaMadre = new GroupLayout(panelTarjetaMadre);
		gl_panelTarjetaMadre.setHorizontalGroup(
			gl_panelTarjetaMadre.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
		);
		gl_panelTarjetaMadre.setVerticalGroup(
			gl_panelTarjetaMadre.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
		);
		
		tableTarjetaMadre = new JTable();
		tableTarjetaMadre.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00FAm serie:", "Cantidad:", "Precio:", "Marca:", "Tipo socket:", "Modelo:", "Tipo RAM:", "Conexi\u00F3n:"
			}
		));
		scrollPane_3.setViewportView(tableTarjetaMadre);
		panelTarjetaMadre.setLayout(gl_panelTarjetaMadre);
	}
	
    private void btnVolverAMenuActionPerformed(java.awt.event.ActionEvent evt) {
        MenuComponentes menuP = new MenuComponentes();
        menuP.setVisible(true);
        this.dispose();
    }
    

}
