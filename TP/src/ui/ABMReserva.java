package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.CtrlReserva;
import controladores.CtrlTipoAuto;
import entidades.Auto;
import entidades.Reserva;
import entidades.TipoAuto;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class ABMReserva extends JFrame {

	private JPanel contentPane;
	private JTextField txtFechaIni;
	private JTextField txtFechaFin;
	private JTextField txtDetalle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMReserva frame = new ABMReserva();
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
	public ABMReserva() {
		CtrlReserva controladorReserva=new CtrlReserva();
		CtrlTipoAuto controladorTipoAuto = new CtrlTipoAuto();
		 
		ArrayList <TipoAuto> arrayTiposAutos = controladorTipoAuto.getArrayList();
		
		//ArrayList <TipoAuto> autosDisponibles = controladorReserva.getAutosDisponibles();
		
		setTitle("ABM Reserva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Tipo");
		comboBox.setBounds(66, 11, 292, 20);
		comboBox.addItem("Seleccione tipo ");
//		comboBox.addItem("Renault Scenic");
//		comboBox.addItem("Ford focus 2014");
//		comboBox.addItem("Ford focus 2015");
		 for (TipoAuto tipoAuto : arrayTiposAutos){
			 comboBox.addItem(tipoAuto.getNombre());
		 }
		
		
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("Tipo:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 14, 46, 14);
		contentPane.add(label);
		
		JLabel lblFecha = new JLabel("Fecha inicio:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(10, 45, 95, 14);
		contentPane.add(lblFecha);
		
		txtFechaIni = new JTextField();
		txtFechaIni.setBounds(115, 42, 68, 20);
		contentPane.add(txtFechaIni);
		txtFechaIni.setColumns(10);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setBounds(323, 42, 62, 20);
		contentPane.add(txtFechaFin);
		txtFechaFin.setColumns(10);
		
		JLabel lblHora = new JLabel("Fecha fin:");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setBounds(236, 45, 77, 14);
		contentPane.add(lblHora);
		
		txtDetalle = new JTextField();
		txtDetalle.setHorizontalAlignment(SwingConstants.LEFT);
		txtDetalle.setBounds(66, 139, 292, 17);
		contentPane.add(txtDetalle);
		txtDetalle.setColumns(10);
		
		JLabel lblDetalle = new JLabel("Detalle:");
		lblDetalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDetalle.setBounds(10, 141, 46, 14);
		contentPane.add(lblDetalle);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(66, 167, 292, 20);
		
//		 for (Auto auto : autosDisponibles){
//			 comboBox.addItem(auto.getNombre());
//		 }
		
		
		
		contentPane.add(comboBox2);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				Reserva res = new Reserva (); 
				
				
				if("Seleccione tipo " == comboBox.getSelectedItem()){
					JOptionPane.showMessageDialog(null,
						    "No selecciono ningun tipo", 
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else{
				 for (TipoAuto tipoAuto : arrayTiposAutos){
				if (tipoAuto.getNombre() == comboBox.getSelectedItem()){
					
					res.setDetalle(txtDetalle.getText());	
					res.setFechaIni(Date.valueOf(txtFechaIni.getText()));	
					
					
					
					
					
					
					controladorReserva.setReserva(res);									}
				 											}
				    }
			}
		});
		btnReservar.setBounds(335, 227, 89, 23);
		contentPane.add(btnReservar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtras);
		
		JButton btnVerificarFecha = new JButton("Verificar fecha");
		btnVerificarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				ArrayList <TipoAuto> autosDisponibles = controladorReserva.getAutosDisponibles(); //A esto le mandas la fecha, la cantidad de horas y tipo de auto y te devuelve los autos disponibles para esa fecha 
				for (TipoAuto tipoAuto : arrayTiposAutos){
					if (tipoAuto.getNombre() == comboBox.getSelectedItem()){
				
				ArrayList<Auto> autosdisponibles = controladorReserva.getAutosDisponibles(Date.valueOf(txtFechaIni.getText()), Date.valueOf(txtFechaFin.getText()), tipoAuto );
				for (Auto auto : autosdisponibles){
					 comboBox2.addItem(auto.getNombre());
				 }
				
					}
			}
		}});
		btnVerificarFecha.setBounds(369, 166, 125, 23);
		contentPane.add(btnVerificarFecha);
		
	}
}
