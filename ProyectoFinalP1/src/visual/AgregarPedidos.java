package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Componente;
import logico.HardDrive;
import logico.Pedido;
import logico.Processor;
import logico.RAM;
import logico.Tienda;
import logico.Usuario;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.DefaultListModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.List;
import javax.swing.JScrollPane;

public class AgregarPedidos extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtCedula;
	private JTextField txtNombreCliente;
	private JTextField txtDireccionCliente;
	private JFormattedTextField txtTelefonoCliente;
	private JTextField tfTotalPedido;
	private JTextField txtManoObra;
	private JTextField txtNumFactura;
	private List listaCarrito;
	private List listaComponentes;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 */
	public AgregarPedidos() throws ParseException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tienda.getInstance().guardarDatos();
			}
		});
		setTitle("Tienda de computadoras RORO/Hacer pedido");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarPedidos.class.getResource("/iconos/logo256.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 468);
		setLocationRelativeTo(null);
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
		
		JLabel lblEncabezado = new JLabel("HACER PEDIDO");
		lblEncabezado.setForeground(new Color(255, 255, 255));
		lblEncabezado.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblEncabezado.setBounds(10, 0, 624, 65);
		panel_1.add(lblEncabezado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 65, 634, 364);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "BUSCAR CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 11, 614, 101);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCedula.setBounds(10, 21, 46, 14);
		panel_3.add(lblCedula);
		
		JLabel lblNombreCliente = new JLabel("Nombre:");
		lblNombreCliente.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNombreCliente.setBounds(10, 46, 46, 14);
		panel_3.add(lblNombreCliente);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDireccion.setBounds(10, 71, 59, 14);
		panel_3.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTelefono.setBounds(344, 46, 46, 14);
		panel_3.add(lblTelefono);
		
		//txtCedula = new JTextField();
		MaskFormatter maskCedula = new MaskFormatter("###-#######-#");
		txtCedula = new JFormattedTextField(maskCedula);
		txtCedula.setBounds(66, 18, 169, 20);
		panel_3.add(txtCedula);
		txtCedula.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("BUSCAR");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //VALIDAR CLIENTE AL HACER PEDIDO
				String cedula = txtCedula.getText();
				Usuario aux = Tienda.getInstance().buscarUsuariobyCedula(cedula);
				if(aux != null) {
					txtNombreCliente.setText(aux.getNombre()); 
					//txtNombreCliente.setEditable(false);
					txtDireccionCliente.setText(aux.getDireccion());
					//txtDireccionCliente.setEditable(false);
					txtTelefonoCliente.setText(aux.getTelefono());
					//txtTelefonoCliente.setEditable(false);
					JOptionPane.showMessageDialog(null, "Cliente existente", "Notificación", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					txtNombreCliente.setEnabled(true);
					txtDireccionCliente.setEnabled(true);
					txtNombreCliente.setText("");
					txtDireccionCliente.setText("");
					JOptionPane.showMessageDialog(null, "Cliente no existe.\n Por favor ingrese los datos", "Notificación", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		btnBuscarCliente.setBounds(245, 17, 89, 23);
		panel_3.add(btnBuscarCliente);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(66, 43, 268, 20);
		panel_3.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		txtDireccionCliente = new JTextField();
		txtDireccionCliente.setBounds(66, 68, 538, 20);
		panel_3.add(txtDireccionCliente);
		txtDireccionCliente.setColumns(10);
		
		//txtTelefonoCliente = new JTextField();
		MaskFormatter mask2 = new MaskFormatter("(###) ### - ####");
		txtTelefonoCliente = new JFormattedTextField(mask2);
		txtTelefonoCliente.setBounds(400, 43, 204, 20);
		panel_3.add(txtTelefonoCliente);
		txtTelefonoCliente.setColumns(10);
		


		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "FACTURA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 123, 614, 196);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnMoverACarrito = new JButton(">");
		btnMoverACarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccionado = listaComponentes.getSelectedItem().toString();
				listaCarrito.add(seleccionado);
				listaComponentes.remove(listaComponentes.getSelectedItem());
				setTotal();
			}
		});
		btnMoverACarrito.setBounds(279, 42, 54, 23);
		panel_4.add(btnMoverACarrito);
		
		JButton btnQuitarDeCarrito = new JButton("<");
		btnQuitarDeCarrito.setBounds(279, 76, 54, 23);
		panel_4.add(btnQuitarDeCarrito);
		
		JLabel lblComponentesDisp = new JLabel("Componentes disponibles:");
		lblComponentesDisp.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblComponentesDisp.setBounds(59, 17, 148, 14);
		panel_4.add(lblComponentesDisp);
		
		JLabel lblComponentesCarrito = new JLabel("Carrito:");
		lblComponentesCarrito.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblComponentesCarrito.setBounds(450, 17, 46, 14);
		panel_4.add(lblComponentesCarrito);
		
		tfTotalPedido = new JTextField();
		tfTotalPedido.setEditable(false);
		tfTotalPedido.setBounds(497, 165, 107, 20);
		panel_4.add(tfTotalPedido);
		tfTotalPedido.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTotal.setBounds(450, 168, 46, 14);
		panel_4.add(lblTotal);
		
		JLabel lblPreguntaEnsamblado = new JLabel("\u00BFDesea recibir el equipo ensamblado?");
		lblPreguntaEnsamblado.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPreguntaEnsamblado.setBounds(10, 139, 185, 14);
		panel_4.add(lblPreguntaEnsamblado);
		
		JButton btnSi = new JButton("");
		btnSi.setBackground(new Color(0, 204, 0));
		btnSi.setBounds(200, 135, 26, 23);
		panel_4.add(btnSi);
		
		JButton btnNo = new JButton("");
		btnNo.setBackground(new Color(255, 0, 0));
		btnNo.setBounds(236, 135, 26, 23);
		panel_4.add(btnNo);
		
		JLabel lblManoObra = new JLabel("Mano de obra:");
		lblManoObra.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblManoObra.setBounds(402, 139, 82, 14);
		panel_4.add(lblManoObra);
		
		txtManoObra = new JTextField();
		txtManoObra.setEditable(false);
		txtManoObra.setBounds(497, 134, 107, 20);
		panel_4.add(txtManoObra);
		txtManoObra.setColumns(10);
		
		JLabel lblNumFactura = new JLabel("N\u00FAmero de factura:");
		lblNumFactura.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNumFactura.setBounds(10, 168, 107, 14);
		panel_4.add(lblNumFactura);
		
		txtNumFactura = new JTextField();
		txtNumFactura.setEditable(false);
		txtNumFactura.setBounds(127, 165, 142, 20);
		txtNumFactura.setText(Integer.toString(Tienda.getInstance().getIDpedido()));
		panel_4.add(txtNumFactura);
		txtNumFactura.setColumns(10);
		
		listaComponentes = new List();
		listaComponentes.setBounds(10, 37, 259, 91);
		panel_4.add(listaComponentes);
		for ( Componente c : Tienda.getInstance().getComponentes()) {
			
			String tipo;
			if(c instanceof HardDrive) {
				tipo = "Disco Duro";
			}else if(c instanceof RAM) {
				tipo = "Ram";
			}else if(c instanceof Processor) {
				tipo = "Procesador";
			}else {
				tipo = "Tarjeta Madre";
			}
			
			
			String aux = c.getNumSerie() + " - " + c.getMarca() + " - " + tipo;
			listaComponentes.add(aux);
		}
		
		
		listaCarrito = new List();
		listaCarrito.setBounds(344, 37, 260, 91);
		panel_4.add(listaCarrito);
		
		JButton btnHacerPedido = new JButton("FACTURAR");
		btnHacerPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				Usuario aux = Tienda.getInstance().buscarUsuariobyCedula(cedula);
				
				if(aux == null) {
					String direccion = txtDireccionCliente.getText();
					String nombre = txtNombreCliente.getText();
					String telefono = txtTelefonoCliente.getText();
					
					aux = new Usuario(nombre, cedula, direccion, telefono);
					Tienda.getInstance().agregarUsuario(aux);
				}
				agregarPedido();
			}
		});
		btnHacerPedido.setBounds(535, 330, 89, 23);
		panel_2.add(btnHacerPedido);
		
		JButton btnVolverMenuPedido = new JButton("VOLVER");
		btnVolverMenuPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolverMenuPedidosActionPerformed(e);
			}
		});
		btnVolverMenuPedido.setBounds(436, 330, 89, 23);
		panel_2.add(btnVolverMenuPedido);
	}
	
	   private void setTotal() {
		   float total = 0;
			for(int i = 0; i< listaCarrito.getItemCount(); i++) {
				int pos = listaCarrito.getItem(i).indexOf(" -");
				String serial = listaCarrito.getItem(i).substring(0, pos);
				Componente c = Tienda.getInstance().buscarComponentebySerial(Integer.parseInt(serial));
				total += c.getPrecioComp();
			}
			
			tfTotalPedido.setText(String.valueOf(total));
		
	}
	   
	   private void agregarPedido() {
		   
		   String cedula = txtCedula.getText();
		   Pedido aux =new Pedido(cedula);
		   
		   for(int i = 0; i< listaCarrito.getItemCount(); i++) {
				int pos = listaCarrito.getItem(i).indexOf(" -");
				String serial = listaCarrito.getItem(i).substring(0, pos);
				Componente c = Tienda.getInstance().buscarComponentebySerial(Integer.parseInt(serial));
				aux.getComponentes().add(c);
		   }
		  
		  Tienda.getInstance().agregarPedido(aux);
		  JOptionPane.showMessageDialog(null, "Pedido Realizado", "Notificación", JOptionPane.INFORMATION_MESSAGE);

	   }

	private void btnVolverMenuPedidosActionPerformed(java.awt.event.ActionEvent evt) {
		   Pedidos volver = new Pedidos();
		   volver.setVisible(true);
	        this.dispose();
	    }
}
