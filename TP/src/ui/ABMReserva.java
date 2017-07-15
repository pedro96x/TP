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
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtDetalle;
	private JTextField txtCantHoras;

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
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(10, 45, 46, 14);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(66, 42, 68, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(200, 42, 39, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setBounds(144, 45, 46, 14);
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
					res.setFecha(Date.valueOf(txtFecha.getText()));	
					res.setCantHorasReserv(Integer.parseInt(txtCantHoras.getText()));
					
					
					
					
					
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
		
		txtCantHoras = new JTextField();
		txtCantHoras.setColumns(10);
		txtCantHoras.setBounds(210, 73, 89, 20);
		contentPane.add(txtCantHoras);
		
		JLabel lblCantHorasA = new JLabel("Cant. horas a reservar:");
		lblCantHorasA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantHorasA.setBounds(39, 76, 161, 14);
		contentPane.add(lblCantHorasA);
		
		JButton btnVerificarFecha = new JButton("Verificar fecha");
		btnVerificarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				ArrayList <TipoAuto> autosDisponibles = controladorReserva.getAutosDisponibles(); //A esto le mandas la fecha, la cantidad de horas y tipo de auto y te devuelve los autos disponibles para esa fecha 
				
			}
		});
		btnVerificarFecha.setBounds(369, 166, 125, 23);
		contentPane.add(btnVerificarFecha);
		
	}
}
