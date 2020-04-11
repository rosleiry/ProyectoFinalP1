package logico;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.data.category.*;

import visual.ListaComponentes;
import visual.Pedidos;

import org.jfree.chart.plot.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Grafica {
	private final JButton btnNewButton = new JButton("VOLVER");

	public Grafica() {
		
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		final String componente1= "Disco duro";
		final String componente2= "Tarjeta madre";
		final String componente3= "Procesador";
		final String componente4= "Memoria RAM";
    
		//hay que hacer un metodo que sume las cantidades de cada componente sin tomar en cuenta marca
		
    	for(Componente c : Tienda.getInstance().getComponentes()) {
    		if(c instanceof HardDrive) {
    			data.addValue(c.getCantDisponible(), componente1, "");
    		}
    	}
    	for(Componente c : Tienda.getInstance().getComponentes()) {
    		if(c instanceof MotherBoard) {
    			data.addValue(c.getCantDisponible(), componente2, "");
    		}
    	}
    	for(Componente c : Tienda.getInstance().getComponentes()) {
    		if(c instanceof Processor) {
    			data.addValue(c.getCantDisponible(), componente3, "");
    		}
    	}
    	for(Componente c : Tienda.getInstance().getComponentes()) {
    		if(c instanceof RAM) {
    			data.addValue(c.getCantDisponible(), componente4, "");
    		}
    	}
		
		
		/*data.addValue(10, componente1, "");
		data.addValue(10, componente2, "");
		data.addValue(10, componente3, "");
		data.addValue(10, componente4, "");*/
		
		JFreeChart grafica = ChartFactory.createBarChart3D("CANTIDAD DE COMPONENTES SEGUN TIPO", "", "Cantidad", data, PlotOrientation.VERTICAL, true, true, false);
	
		ChartPanel contenedor = new ChartPanel(grafica);
		contenedor.setBackground(SystemColor.menu);
		JFrame ventana = new JFrame("Tienda de computadoras RORO/Grafica");
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(Grafica.class.getResource("/iconos/logo256.png")));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().add(contenedor);
		contenedor.setLayout(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVolverActionPerformed(arg0);
			}
		});
		btnNewButton.setBounds(0, 381, 87, 23);
		contenedor.add(btnNewButton);
		ventana.setSize(665,443);
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		
	}
	
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {
        ListaComponentes ped = new ListaComponentes();
        ped.setVisible(true);
    }


	public static void main(String[] args) {
		new Grafica();
	}

}
