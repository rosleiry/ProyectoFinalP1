package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
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

public class AgregarComponentes extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtNumSerie;
	private JTextField txtPrecio;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarComponentes frame = new AgregarComponentes();
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
	public AgregarComponentes() {
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
		panel_2.setBounds(0, 64, 634, 329);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 11, 614, 61);
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
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(375, 33, 229, 20);
		panel_3.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(303, 0, 1, 76);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
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
		
		JLabel lblNewLabel_5 = new JLabel("OPCIONES DEL COMPONENTE EN ESPECIFICO");
		lblNewLabel_5.setBounds(10, 148, 338, 14);
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "TIPO DE COMPONENTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 83, 614, 54);
		panel_2.add(panel_5);
		
		JRadioButton btnDiscoDuro = new JRadioButton("Disco duro");
		buttonGroup.add(btnDiscoDuro);
		btnDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDiscoDuro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDiscoDuro.setBounds(35, 22, 109, 23);
		panel_5.add(btnDiscoDuro);
		
		JRadioButton btnTarjetaMadre = new JRadioButton("Tarjeta madre");
		buttonGroup.add(btnTarjetaMadre);
		btnTarjetaMadre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnTarjetaMadre.setBounds(179, 22, 109, 23);
		panel_5.add(btnTarjetaMadre);
		
		JRadioButton btnProcesador = new JRadioButton("Procesador");
		buttonGroup.add(btnProcesador);
		btnProcesador.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnProcesador.setBounds(323, 22, 109, 23);
		panel_5.add(btnProcesador);
		
		JRadioButton btnMemoriaRam = new JRadioButton("Memoria RAM");
		buttonGroup.add(btnMemoriaRam);
		btnMemoriaRam.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnMemoriaRam.setBounds(467, 22, 109, 23);
		panel_5.add(btnMemoriaRam);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		lblNewLabel_1.setBounds(20, 173, 46, 14);
		panel_2.add(lblNewLabel_1);
	}
	
    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {
        MenuComponentes menuC = new MenuComponentes();
        menuC.setVisible(true);
        this.dispose();
    }
}
