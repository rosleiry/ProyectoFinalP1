package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Componente;
import logico.HardDrive;
import logico.MotherBoard;
import logico.Processor;
import logico.RAM;
import logico.Tienda;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ListaComponentes extends JFrame {

	private static Object[] filaDisco;
	private static Object[] filaMother;
	private static Object[] filaProces;
	private static Object[] filaRam;
	private JPanel contentPane;
	private static JTable tableDiscosDuros;
	private static JTable tableRAM;
	private static JTable tableProcesador;
	private static JTable tableTarjetaMadre;
	private static DefaultTableModel tableModelDiscosDuros;
	private static DefaultTableModel tableModelRAM;
	private static DefaultTableModel tableModelProcesador;
	private static DefaultTableModel tableModelTarjetaMadre;
	private JButton btnInfo;
	private JButton btnBorrar;
	private Componente c = null;
	private int selectedRow = -1;
	private JLabel lblTitulo;

	/**
	 * Launch the application.
	 */


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
		setBounds(100, 100, 916, 601);
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
		panelBotones.setBounds(0, 64, 166, 498);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);
		
		JButton btnDiscosDuros = new JButton("DISCOS DUROS");
		btnDiscosDuros.setHorizontalAlignment(SwingConstants.LEFT);
		btnDiscosDuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblTitulo.setText("Discos Duros");
				btnInfo.setEnabled(false);
				panelDiscoDuro.setVisible(true);
				panelRAM.setVisible(false);
				panelTarjetaMadre.setVisible(false);
				panelProcesador.setVisible(false);
				cargarDiscoduro();
				
			}
		});
		btnDiscosDuros.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/harddrive.png")));
		btnDiscosDuros.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDiscosDuros.setBounds(0, 0, 166, 99);
		panelBotones.add(btnDiscosDuros);
		
		JButton btnMemoriasRam = new JButton("MEMORIAS RAM");
		btnMemoriasRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblTitulo.setText("Memorias Ram");
				btnInfo.setEnabled(false);
				panelDiscoDuro.setVisible(false);
				panelRAM.setVisible(true);
				panelTarjetaMadre.setVisible(false);
				panelProcesador.setVisible(false);
				cargarRam();
			}
		});
		btnMemoriasRam.setHorizontalAlignment(SwingConstants.LEFT);
		btnMemoriasRam.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/ram-memory.png")));
		btnMemoriasRam.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnMemoriasRam.setBounds(0, 99, 166, 99);
		panelBotones.add(btnMemoriasRam);
		
		JButton btnProcesadores = new JButton("PROCESADORES");
		btnProcesadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitulo.setText("Procesadores");
				btnInfo.setEnabled(false);
				panelDiscoDuro.setVisible(false);
				panelRAM.setVisible(false);
				panelTarjetaMadre.setVisible(false);
				panelProcesador.setVisible(true);
				cargarProcesador();
			}
		});
		btnProcesadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnProcesadores.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/processor.png")));
		btnProcesadores.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnProcesadores.setBounds(0, 198, 166, 100);
		panelBotones.add(btnProcesadores);
		
		JButton btnTarjetasMadre = new JButton("TARJETAS MADRE");
		btnTarjetasMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitulo.setText("Tarjetas Madre");
				btnInfo.setEnabled(false);
				panelDiscoDuro.setVisible(false);
				panelRAM.setVisible(false);
				panelTarjetaMadre.setVisible(true);
				panelProcesador.setVisible(false);
				cargarMotherBoard();
			}
		});
		btnTarjetasMadre.setHorizontalAlignment(SwingConstants.LEFT);
		btnTarjetasMadre.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/motherboard.png")));
		btnTarjetasMadre.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnTarjetasMadre.setBounds(0, 298, 166, 99);
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
		btnVolverAMenu.setBounds(0, 397, 166, 99);
		panelBotones.add(btnVolverAMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 817, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("COMPONENTES");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(20, 0, 614, 61);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setBounds(164, 64, 736, 498);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		panel_3.setBounds(0, 44, 735, 454);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		//JPanel panelDiscoDuro = new JPanel();
		panelDiscoDuro.setBounds(0, 0, 738, 455);
		panel_3.add(panelDiscoDuro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		GroupLayout gl_panelDiscoDuro = new GroupLayout(panelDiscoDuro);
		gl_panelDiscoDuro.setHorizontalGroup(
			gl_panelDiscoDuro.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
		);
		gl_panelDiscoDuro.setVerticalGroup(
			gl_panelDiscoDuro.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
		);
		
		tableDiscosDuros = new JTable();
		tableModelDiscosDuros = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 2 || column == 1;
			}
			
		};
		String[] columnDiscoDuro = {"N\u00FAm serie:", "Disponibles:", "Precio:", "Marca:", "Modelo:", "Almacenamiento:", "Tipo conexi\u00F3n:"};
		tableModelDiscosDuros.setColumnIdentifiers(columnDiscoDuro);
		tableDiscosDuros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tableDiscosDuros.getSelectedRow();
				if(selectedRow > -1) {
					btnInfo.setEnabled(true);
					btnBorrar.setEnabled(true);
					c = Tienda.getInstance().buscarComponentebySerial((int) tableDiscosDuros.getValueAt(selectedRow, 0));
				}
			}
		});
		cargarDiscoduro();
		
		scrollPane.setViewportView(tableDiscosDuros);
		panelDiscoDuro.setLayout(gl_panelDiscoDuro);
		
		//JPanel panelRAM = new JPanel();
		panelRAM.setBounds(0, 0, 738, 455);
		panel_3.add(panelRAM);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
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
		tableRAM.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableModelRAM = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 2 || column == 1;
			}
			
		};
		String[] columnRam = {"N\u00FAm serie:", "Cantidad:", "Precio:", "Marca:", "Cant memoria:", "Tipo memoria:"};
		tableModelRAM.setColumnIdentifiers(columnRam);
		tableRAM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tableRAM.getSelectedRow();
				if(selectedRow > -1) {
					btnInfo.setEnabled(true);
					btnBorrar.setEnabled(true);
					c = Tienda.getInstance().buscarComponentebySerial((int) tableRAM.getValueAt(selectedRow, 0));
				}
			}
		});
		
		scrollPane_1.setViewportView(tableRAM);
		panelRAM.setLayout(gl_panelRAM);
		
		//JPanel panelProcesador = new JPanel();
		panelProcesador.setBounds(0, 0, 738, 455);
		panel_3.add(panelProcesador);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setEnabled(false);
		GroupLayout gl_panelProcesador = new GroupLayout(panelProcesador);
		gl_panelProcesador.setHorizontalGroup(
			gl_panelProcesador.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
		);
		gl_panelProcesador.setVerticalGroup(
			gl_panelProcesador.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
		);
		
		tableProcesador = new JTable();
		tableProcesador.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableModelProcesador = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 2 || column == 1;
			}
			
		};
		String[] columnProc = { "N\u00FAm serie:", "Cantidad:", "Precio:", "Marca:", "Modelo:", "Tipo socket:", "Velocidad:"};
		tableModelProcesador.setColumnIdentifiers(columnProc);
		tableProcesador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tableProcesador.getSelectedRow();
				if(selectedRow > -1) {
					btnInfo.setEnabled(true);
					btnBorrar.setEnabled(true);
					c = Tienda.getInstance().buscarComponentebySerial((int) tableProcesador.getValueAt(selectedRow, 0));
				}
			}
		});
		
		scrollPane_2.setViewportView(tableProcesador);
		panelProcesador.setLayout(gl_panelProcesador);
		
		//JPanel panelTarjetaMadre = new JPanel();
		panelTarjetaMadre.setBounds(0, 0, 738, 455);
		panel_3.add(panelTarjetaMadre);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setEnabled(false);
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
		tableTarjetaMadre.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableModelTarjetaMadre = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 2 || column == 1;
			}
			
		};
		String[] columnMother = {"N\u00FAm serie:", "Cantidad:", "Precio:", "Marca:","Modelo:", "Tipo socket:" , "Tipo RAM:", "Conexi\u00F3n Disco Duro:"};
		tableModelTarjetaMadre.setColumnIdentifiers(columnMother);
		tableTarjetaMadre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tableTarjetaMadre.getSelectedRow();
				if(selectedRow > -1) {
					btnInfo.setEnabled(true);
					btnBorrar.setEnabled(true);
					c = Tienda.getInstance().buscarComponentebySerial((int) tableTarjetaMadre.getValueAt(selectedRow, 0));
				}
			}
		});
		
		
		scrollPane_3.setViewportView(tableTarjetaMadre);
		panelTarjetaMadre.setLayout(gl_panelTarjetaMadre);
		
		btnInfo = new JButton("Editar");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Para editar un Componente de doble click en la cantidad o el precio.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnInfo.setBounds(496, 10, 110, 23);
		btnInfo.setEnabled(false);
		panel_2.add(btnInfo);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Esta seguro desea eliminar este Componente: ", "Eliminar", JOptionPane.WARNING_MESSAGE);
				if(option == 0) {
					Tienda.getInstance().getComponentes().remove(c);
					
					if(panelDiscoDuro.isVisible()) {
						cargarDiscoduro();
					}else if(panelRAM.isVisible()) {
						cargarRam();
					}else if(panelProcesador.isVisible()) {
						cargarProcesador();
					}else {
						cargarMotherBoard();
					}
					
					btnBorrar.setEnabled(false);
					btnInfo.setEnabled(false);
				}
			}
		});
		btnBorrar.setEnabled(false);
		btnBorrar.setBounds(616, 10, 110, 23);
		
		panel_2.add(btnBorrar);
		
		lblTitulo = new JLabel("Discos Duros");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(25, 10, 435, 23);
		panel_2.add(lblTitulo);
	}
	
    private void btnVolverAMenuActionPerformed(java.awt.event.ActionEvent evt) {
        MenuComponentes menuP = new MenuComponentes();
        menuP.setVisible(true);
        this.dispose();
    }
    
    public static void cargarDiscoduro () {
    	
    	tableModelDiscosDuros.setRowCount(0);
    	filaDisco = new Object[tableModelDiscosDuros.getColumnCount()];
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	for(Componente c : Tienda.getInstance().getComponentes()) {	
    		if(c instanceof HardDrive) {
    			String precio = formatter.format(c.getPrecioComp());
    			filaDisco[0] = c.getNumSerie();
    			filaDisco[1] = c.getCantDisponible();
        		filaDisco[2] = precio;
        		filaDisco[3] = c.getMarca();
        		filaDisco[4] = ((HardDrive) c).getModelo();
    			filaDisco[5] = ((HardDrive) c).getCapacidadAl();
    			filaDisco[6] = ((HardDrive) c).getTipoConexion();
    			tableModelDiscosDuros.addRow(filaDisco);
    		}
    	}
    	
    	tableDiscosDuros.setModel(tableModelDiscosDuros);
    	tableDiscosDuros.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	tableDiscosDuros.getTableHeader().setReorderingAllowed(false);
    	
    	
    }
    public static void cargarRam () {
    	tableModelRAM.setRowCount(0);
    	filaRam = new Object[tableModelRAM.getColumnCount()];
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	for(Componente c : Tienda.getInstance().getComponentes()) {
    		if(c instanceof RAM) {
    			String precio = formatter.format(c.getPrecioComp());
    			filaRam[0] = c.getNumSerie();
    			filaRam[1] = c.getCantDisponible();
        		filaRam[2] = precio;
        		filaRam[3] = c.getMarca();
        		filaRam[4] = ((RAM) c).getCantMemoria();
    			filaRam[5] = ((RAM) c).getTipoMemoria();
    			tableModelRAM.addRow(filaRam);
    		}
    	}
    	
    	tableRAM.setModel(tableModelRAM);
    	tableRAM.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	tableRAM.getTableHeader().setReorderingAllowed(false);
    }
    
    public static void cargarProcesador () {
    	tableModelProcesador.setRowCount(0);
    	filaProces= new Object[tableModelProcesador.getColumnCount()];
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	for(Componente c : Tienda.getInstance().getComponentes()) {
    		if(c instanceof Processor) {
    			String precio = formatter.format(c.getPrecioComp());
    			filaProces[0] = c.getNumSerie();
    			filaProces[1] = c.getCantDisponible();
    			filaProces[2] = precio;
    			filaProces[3] = c.getMarca();
    			filaProces[4] = ((Processor) c).getModelo();
    			filaProces[5] = ((Processor) c).getTipoSocket();
    			filaProces[6] = ((Processor) c).getVelDelProc();
    			tableModelProcesador.addRow(filaProces);
    		}
    	}
    	
    	tableProcesador.setModel(tableModelProcesador);
    	tableProcesador.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	tableProcesador.getTableHeader().setReorderingAllowed(false);
    }
    
    public static void cargarMotherBoard () {
    	tableModelTarjetaMadre.setRowCount(0);
    	filaMother = new Object[tableModelTarjetaMadre.getColumnCount()];
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	for(Componente c : Tienda.getInstance().getComponentes()) {
    		if(c instanceof MotherBoard) {
    			String precio = formatter.format(c.getPrecioComp());
    			filaMother[0] = c.getNumSerie();
    			filaMother[1] = c.getCantDisponible();
    			filaMother[2] = precio;
    			filaMother[3] = c.getMarca();
    			filaMother[4] = ((MotherBoard) c).getModelo();
    			filaMother[5] = ((MotherBoard) c).getTipoSocket();
    			filaMother[6] = ((MotherBoard) c).getTipoMemoriaRam();
    			filaMother[7] = ((MotherBoard) c).getConexionHD();
    			tableModelTarjetaMadre.addRow(filaMother);
    		}
    	}
    	
    	tableTarjetaMadre.setModel(tableModelTarjetaMadre);
    	tableTarjetaMadre.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	tableTarjetaMadre.getTableHeader().setReorderingAllowed(false);
    	
    	
    }
}
