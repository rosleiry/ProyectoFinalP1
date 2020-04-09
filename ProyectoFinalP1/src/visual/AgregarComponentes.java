package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import logico.Componente;
import logico.HardDrive;
import logico.MotherBoard;
import logico.Processor;
import logico.RAM;
import logico.Tienda;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AgregarComponentes extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtNumSerie;
	private JTextField txtPrecio;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtModelo;
	private JTextField txtAlmacenamiento;
	private JTextField txtModeloMother;
	private JTextField txtTipoSocket;
	private JTextField txtModeloProcesador;
	private JTextField txtTipoSocketProcesador;
	private JTextField txtCantidad;
	private JComboBox cmbTipoDrive;
	private JComboBox cmbConexion;
	private JComboBox cmbTipoMemoria;
	private JSpinner spnCantidadMemoria;
	private JSpinner spnVelProcesador;
	private JComboBox cmbTipoMemoriaMother;
	private JComboBox cmbDiscos;
	private JSpinner spnCantidadDiscos;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AgregarComponentes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tienda.getInstance().guardarDatos();
			}
		});
		setResizable(false);
		setTitle("Tienda de computadoras/Agregar componentes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarComponentes.class.getResource("/iconos/logo256.png")));
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
		panel_1.setBounds(0, 0, 634, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COMPONENTES");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(23, 0, 611, 65);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 64, 634, 329);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panelDiscoDuro = new JPanel();
		panelDiscoDuro.setBounds(10, 148, 601, 143);
		panel_2.add(panelDiscoDuro);
		panelDiscoDuro.setLayout(null);
		panelDiscoDuro.setVisible(true);
		
		
		JLabel lblModeloDiscoDuro = new JLabel("Modelo:");
		lblModeloDiscoDuro.setBounds(10, 11, 82, 14);
		panelDiscoDuro.add(lblModeloDiscoDuro);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(58, 8, 533, 20);
		panelDiscoDuro.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Almacenamiento:");
		lblNewLabel_6.setBounds(10, 50, 127, 14);
		panelDiscoDuro.add(lblNewLabel_6);
		
		txtAlmacenamiento = new JTextField();
		txtAlmacenamiento.setBounds(116, 47, 173, 20);
		panelDiscoDuro.add(txtAlmacenamiento);
		txtAlmacenamiento.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Tipo:");
		lblNewLabel_7.setBounds(323, 50, 43, 14);
		panelDiscoDuro.add(lblNewLabel_7);
		
		cmbTipoDrive = new JComboBox();
		cmbTipoDrive.setBounds(359, 46, 111, 22);
		panelDiscoDuro.add(cmbTipoDrive);
		cmbTipoDrive.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "SSD", "HDD"}));
		
		JLabel lblNewLabel_8 = new JLabel("Conexion:");
		lblNewLabel_8.setBounds(10, 89, 98, 14);
		panelDiscoDuro.add(lblNewLabel_8);
		
		cmbConexion = new JComboBox();
		cmbConexion.setBounds(75, 85, 127, 22);
		panelDiscoDuro.add(cmbConexion);
		cmbConexion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "IDE", "SATA", "SATA-2", "SATA-3", "M.2"}));
		
		JPanel panelRAM = new JPanel();
		panelRAM.setBounds(10, 148, 601, 143);
		panel_2.add(panelRAM);
		panelRAM.setLayout(null);
		panelRAM.setVisible(false);
		
		JLabel lblNewLabel_9 = new JLabel("Tipo de memoria:");
		lblNewLabel_9.setBounds(10, 21, 122, 22);
		panelRAM.add(lblNewLabel_9);
		
		cmbTipoMemoria = new JComboBox();
		cmbTipoMemoria.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "DDR1", "DDR2", "DDR3", "DDR4"}));
		cmbTipoMemoria.setBounds(119, 21, 157, 22);
		panelRAM.add(cmbTipoMemoria);
		
		JLabel lblNewLabel_10 = new JLabel("Cantidad de memoria:");
		lblNewLabel_10.setBounds(10, 65, 157, 14);
		panelRAM.add(lblNewLabel_10);
		
		spnCantidadMemoria = new JSpinner();
		spnCantidadMemoria.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantidadMemoria.setBounds(140, 62, 147, 20);
		panelRAM.add(spnCantidadMemoria);
		
		JPanel panelProcesador = new JPanel();
		panelProcesador.setBounds(10, 148, 601, 143);
		panel_2.add(panelProcesador);
		panelProcesador.setLayout(null);
		panelProcesador.setVisible(false);
		
		JLabel lblNewLabel_11 = new JLabel("Modelo:");
		lblNewLabel_11.setBounds(10, 28, 127, 14);
		panelProcesador.add(lblNewLabel_11);
		
		txtModeloProcesador = new JTextField();
		txtModeloProcesador.setBounds(78, 25, 513, 20);
		panelProcesador.add(txtModeloProcesador);
		txtModeloProcesador.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Velocidad del Procesador");
		lblNewLabel_12.setBounds(10, 75, 153, 14);
		panelProcesador.add(lblNewLabel_12);
		
		spnVelProcesador = new JSpinner();
		spnVelProcesador.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnVelProcesador.setBounds(162, 72, 75, 20);
		panelProcesador.add(spnVelProcesador);
		
		JLabel lblNewLabel_13 = new JLabel("Ghz");
		lblNewLabel_13.setBounds(244, 75, 46, 14);
		panelProcesador.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Tipo de Socket:");
		lblNewLabel_14.setBounds(306, 75, 108, 14);
		panelProcesador.add(lblNewLabel_14);
		
		txtTipoSocketProcesador = new JTextField();
		txtTipoSocketProcesador.setBounds(401, 72, 139, 20);
		panelProcesador.add(txtTipoSocketProcesador);
		txtTipoSocketProcesador.setColumns(10);
		
		JPanel panelTarjetaMadre = new JPanel();
		panelTarjetaMadre.setBounds(10, 148, 601, 143);
		panel_2.add(panelTarjetaMadre);
		panelTarjetaMadre.setLayout(null);
		panelTarjetaMadre.setVisible(false);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 11, 139, 14);
		panelTarjetaMadre.add(lblModelo);
		
		txtModeloMother = new JTextField();
		txtModeloMother.setColumns(10);
		txtModeloMother.setBounds(58, 11, 533, 20);
		panelTarjetaMadre.add(txtModeloMother);
		
		JLabel lblTipoSocket = new JLabel("Tipo de Socket:");
		lblTipoSocket.setBounds(10, 52, 162, 14);
		panelTarjetaMadre.add(lblTipoSocket);
		
		txtTipoSocket = new JTextField();
		txtTipoSocket.setBounds(102, 49, 119, 20);
		panelTarjetaMadre.add(txtTipoSocket);
		txtTipoSocket.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de memoria compatible:");
		lblNewLabel_1.setBounds(231, 52, 191, 14);
		panelTarjetaMadre.add(lblNewLabel_1);
		
		cmbTipoMemoriaMother = new JComboBox();
		cmbTipoMemoriaMother.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "DDR1", "DDR2", "DDR3", "DDR4"}));
		cmbTipoMemoriaMother.setBounds(404, 48, 187, 22);
		panelTarjetaMadre.add(cmbTipoMemoriaMother);
		
		JLabel lblDiscoDuro = new JLabel("Conexiones de Discos Duros:");
		lblDiscoDuro.setBounds(10, 90, 263, 14);
		panelTarjetaMadre.add(lblDiscoDuro);
		
		cmbDiscos = new JComboBox();
		cmbDiscos.setBounds(177, 86, 137, 22);
		panelTarjetaMadre.add(cmbDiscos);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad:");
		lblNewLabel_5.setBounds(346, 90, 191, 14);
		panelTarjetaMadre.add(lblNewLabel_5);
		
		spnCantidadDiscos = new JSpinner();
		spnCantidadDiscos.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantidadDiscos.setBounds(404, 87, 60, 20);
		panelTarjetaMadre.add(spnCantidadDiscos);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 11, 603, 61);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero de serie:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 11, 96, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(319, 36, 46, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Marca:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 36, 90, 14);
		panel_3.add(lblNewLabel_4);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(107, 33, 187, 20);
		panel_3.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtNumSerie = new JTextField();
		txtNumSerie.setEditable(false);
		txtNumSerie.setBounds(107, 8, 187, 20);
		panel_3.add(txtNumSerie);
		txtNumSerie.setColumns(10);
		txtNumSerie.setText(String.valueOf(Tienda.getInstance().getSerialComponente()));
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(375, 33, 218, 20);
		panel_3.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(303, 0, 1, 76);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("Cantidad:");
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_15.setBounds(319, 11, 76, 14);
		panel_3.add(lblNewLabel_15);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(375, 8, 218, 20);
		panel_3.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnAgregar = new JButton("AGREGAR");
		
		btnAgregar.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnAgregar.setBounds(535, 295, 89, 23);
		panel_2.add(btnAgregar);
		
		JButton btnVolverMenu = new JButton("VOLVER");
		btnVolverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVolverMenuActionPerformed(arg0);
			}
		});
		btnVolverMenu.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnVolverMenu.setBounds(443, 295, 89, 23);
		panel_2.add(btnVolverMenu);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "TIPO DE COMPONENTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 83, 603, 54);
		panel_2.add(panel_5);
		
		JRadioButton btnDiscoDuro = new JRadioButton("Disco duro");
		btnDiscoDuro.setSelected(true);
		buttonGroup.add(btnDiscoDuro);
		btnDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDiscoDuro.setVisible(true);
				panelRAM.setVisible(false);
				panelTarjetaMadre.setVisible(false);
				panelProcesador.setVisible(false);
				
			}
		});
		btnDiscoDuro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDiscoDuro.setBounds(35, 22, 109, 23);
		panel_5.add(btnDiscoDuro);
		
		JRadioButton btnTarjetaMadre = new JRadioButton("Tarjeta madre");
		btnTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDiscoDuro.setVisible(false);
				panelRAM.setVisible(false);
				panelTarjetaMadre.setVisible(true);
				panelProcesador.setVisible(false);
			}
		});
		buttonGroup.add(btnTarjetaMadre);
		btnTarjetaMadre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnTarjetaMadre.setBounds(179, 22, 109, 23);
		panel_5.add(btnTarjetaMadre);
		
		JRadioButton btnProcesador = new JRadioButton("Procesador");
		btnProcesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDiscoDuro.setVisible(false);
				panelRAM.setVisible(false);
				panelTarjetaMadre.setVisible(false);
				panelProcesador.setVisible(true);
			}
		});
		buttonGroup.add(btnProcesador);
		btnProcesador.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnProcesador.setBounds(323, 22, 109, 23);
		panel_5.add(btnProcesador);
		
		JRadioButton btnMemoriaRam = new JRadioButton("Memoria RAM");
		btnMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDiscoDuro.setVisible(false);
				panelRAM.setVisible(true);
				panelTarjetaMadre.setVisible(false);
				panelProcesador.setVisible(false);
			}
		});
		buttonGroup.add(btnMemoriaRam);
		btnMemoriaRam.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnMemoriaRam.setBounds(467, 22, 109, 23);
		panel_5.add(btnMemoriaRam);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Componente aux = null;
				
				float precio = Float.valueOf(txtPrecio.getText());
				String marca = txtMarca.getText();
				int cantidad = Integer.valueOf(txtCantidad.getText());
				
				
				if(btnDiscoDuro.isSelected()) {
					String modelo = txtModelo.getText();
					int capacidad = Integer.valueOf(txtAlmacenamiento.getText());
					String TipoConexion = (String) cmbConexion.getSelectedItem();
					String TipoDrive = (String) cmbTipoDrive.getSelectedItem();
					aux = new HardDrive(cantidad, precio, marca, modelo, TipoDrive, capacidad, TipoConexion);
				}
				if(btnMemoriaRam.isSelected()) {
					int cantMemoria = (int) spnCantidadMemoria.getValue();
					String tipoMemoria = (String) cmbTipoMemoria.getSelectedItem();
					
					aux = new RAM(cantidad, precio, marca, cantMemoria,tipoMemoria); 
				}
				if(btnProcesador.isSelected()) {
					String modelo = txtModeloProcesador.getText();
					String tipoSocket = txtTipoSocketProcesador.getText();
					float velProcesador = (float) spnVelProcesador.getValue();
					
					aux = new Processor(cantidad, precio, marca, modelo, tipoSocket, velProcesador);
				}
				
				if(btnTarjetaMadre.isSelected()) {
					String tipoSocket = txtTipoSocket.getText();
					String modelo = txtModeloMother.getText();
					String tipoMemoria = (String) cmbTipoMemoriaMother.getSelectedItem();
					
					aux = new MotherBoard(cantidad, precio, marca, tipoSocket, modelo, tipoMemoria);
				}
				Tienda.getInstance().agregarComponente(aux);
				JOptionPane.showMessageDialog(null, "Componente Guardado", "Notificación", JOptionPane.INFORMATION_MESSAGE);
				reset();
			}
		});
		
	}
	
    private void reset() {
    	txtNumSerie.setText(String.valueOf(Tienda.getInstance().getSerialComponente()));
    	txtPrecio.setText("");
    	txtMarca.setText("");
    	txtCantidad.setText("");
    	txtModelo.setText("");
    	txtModeloMother.setText("");
    	txtModeloProcesador.setText("");
    	txtTipoSocket.setText("");
    	txtAlmacenamiento.setText("");
    	cmbConexion.setSelectedItem("<Seleccionar>");
    	cmbTipoDrive.setSelectedItem("<Seleccionar>");
    	spnCantidadMemoria.setValue(((SpinnerNumberModel) spnCantidadMemoria.getModel()).getMinimum());
    	cmbTipoMemoria.setSelectedItem("<Seleccionar>");
    	txtTipoSocketProcesador.setText("");
    	spnVelProcesador.setValue(((SpinnerNumberModel) spnVelProcesador.getModel()).getMinimum());
    	cmbTipoMemoriaMother.setSelectedItem("<Seleccionar>");
    	
		
	}

	private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {
        MenuComponentes menuC = new MenuComponentes();
        menuC.setVisible(true);
        this.dispose();
    }
}
