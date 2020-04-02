package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaComponentes extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaComponentes.class.getResource("/iconos/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(new Color(47, 79, 79));
		panel.setBounds(0, 64, 166, 329);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDiscosDuros = new JButton("DISCOS DUROS");
		btnDiscosDuros.setHorizontalAlignment(SwingConstants.LEFT);
		btnDiscosDuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDiscosDuros.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/harddrive.png")));
		btnDiscosDuros.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDiscosDuros.setBounds(0, 0, 166, 54);
		panel.add(btnDiscosDuros);
		
		JButton btnMemoriasRam = new JButton("MEMORIAS RAM");
		btnMemoriasRam.setHorizontalAlignment(SwingConstants.LEFT);
		btnMemoriasRam.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/ram-memory.png")));
		btnMemoriasRam.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnMemoriasRam.setBounds(0, 54, 166, 54);
		panel.add(btnMemoriasRam);
		
		JButton btnPerifericos = new JButton("PERIFERICOS");
		btnPerifericos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPerifericos.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnPerifericos.setBounds(0, 108, 166, 54);
		panel.add(btnPerifericos);
		
		JButton btnProcesadores = new JButton("PROCESADORES");
		btnProcesadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnProcesadores.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/processor.png")));
		btnProcesadores.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnProcesadores.setBounds(0, 162, 166, 54);
		panel.add(btnProcesadores);
		
		JButton btnTarjetasMadre = new JButton("TARJETAS MADRE");
		btnTarjetasMadre.setHorizontalAlignment(SwingConstants.LEFT);
		btnTarjetasMadre.setIcon(new ImageIcon(ListaComponentes.class.getResource("/iconos/motherboard.png")));
		btnTarjetasMadre.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnTarjetasMadre.setBounds(0, 216, 166, 54);
		panel.add(btnTarjetasMadre);
		
		JButton btnVolverAMenu = new JButton("VOLVER A MENU");
		btnVolverAMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolverAMenuActionPerformed(e);
			}
		});
		btnVolverAMenu.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolverAMenu.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnVolverAMenu.setBounds(0, 270, 166, 59);
		panel.add(btnVolverAMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenar por", "Precio menor a mayor", "Precio mayor a menor", "Recomendados", "Popular"}));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox.setBounds(330, 13, 130, 20);
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		panel_3.setBounds(0, 44, 470, 285);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(443, 0, 17, 285);
		panel_3.add(scrollBar);
	}
	
    private void btnVolverAMenuActionPerformed(java.awt.event.ActionEvent evt) {
        MenuPrincipal menuP = new MenuPrincipal();
        menuP.setVisible(true);
        this.dispose();
    }
}
