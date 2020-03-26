package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Inicio extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Inicio dialog = new Inicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Inicio() {
		setBounds(100, 100, 650, 432);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 153, 0));
			panel.setBounds(0, 0, 634, 61);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("BIENVENIDO");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
				lblNewLabel.setBounds(0, 0, 634, 61);
				panel.add(lblNewLabel);
			}
			
			JLabel lblNewLabel_2 = new JLabel("esto lo podemos quitar");
			lblNewLabel_2.setBounds(413, 11, 173, 14);
			panel.add(lblNewLabel_2);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(204, 204, 204));
			panel.setBounds(0, 60, 634, 333);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JButton btnNewButton = new JButton("COMENZAR");
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnNewButton.setBounds(513, 299, 111, 23);
			panel.add(btnNewButton);
			
			JLabel lblNewLabel_1 = new JLabel("logo");
			lblNewLabel_1.setBounds(247, 111, 46, 14);
			panel.add(lblNewLabel_1);
		}
	}
}
