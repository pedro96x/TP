package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.CtrlAuto;
import controladores.CtrlTipoAuto;
import entidades.*;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMAuto extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtID;
	private JLabel lblTipo;
	private JButton btnGuardar;
	private JButton btnBuscar;
	private JButton btnBorrar;
	private JButton btnAtras;
	private JLabel lblBuscarPorId;


	public ABMAuto() {
		
		CtrlAuto controlador = new CtrlAuto();
		Auto auto = new Auto();
		CtrlTipoAuto controladorTipoAuto = new CtrlTipoAuto();
		 
		ArrayList <TipoAuto> arrayTiposAutos = controladorTipoAuto.getArrayList();
		
		setTitle("ABM Auto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Consolas", Font.PLAIN, 11));
		txtDescripcion.setBounds(132, 11, 292, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Consolas", Font.PLAIN, 11));
		txtID.setBounds(132, 124, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcion.setBounds(36, 14, 86, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(76, 127, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBoxTipoAuto = new JComboBox();
		comboBoxTipoAuto.setFont(new Font("Consolas", Font.PLAIN, 11));
		comboBoxTipoAuto.setToolTipText("Tipo");
		comboBoxTipoAuto.setBounds(132, 42, 292, 20);
		comboBoxTipoAuto.addItem("Seleccione tipo ");
//		comboBoxTipoAuto.addItem("Renault Scenic");
//		comboBoxTipoAuto.addItem("Ford focus 2014");
//		comboBoxTipoAuto.addItem("Ford focus 2015");
		
		
		 
		 for (TipoAuto tipoAuto : arrayTiposAutos){
			 comboBoxTipoAuto.addItem(tipoAuto.getNombre());
		 }
		contentPane.add(comboBoxTipoAuto);
		
		
		
		
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(76, 45, 46, 14);
		contentPane.add(lblTipo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				if("Seleccione tipo " == comboBoxTipoAuto.getSelectedItem()){
					JOptionPane.showMessageDialog(null,
						    "No selecciono ningun tipo", 
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else{
				 for (TipoAuto tipoAuto : arrayTiposAutos){
				if (tipoAuto.getNombre() == comboBoxTipoAuto.getSelectedItem()){
					auto.setNombre(txtDescripcion.getText());	
					auto.setTipo(tipoAuto);									
					controlador.setAuto(auto);									}
				 											}
				    }
				
			}
		});
		btnGuardar.setForeground(new Color(0, 128, 0));
		btnGuardar.setBounds(335, 227, 89, 23);
		contentPane.add(btnGuardar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Auto auto = new Auto();
				auto = controlador.getByID(Integer.parseInt(txtID.getText()));
				txtDescripcion.setText(auto.getNombre());
			}
		});
		btnBuscar.setBounds(228, 123, 89, 23);
		contentPane.add(btnBuscar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controlador.baja(Integer.parseInt(txtID.getText()));
				
				
			}
		});
		btnBorrar.setForeground(Color.RED);
		btnBorrar.setBounds(119, 227, 89, 23);
		contentPane.add(btnBorrar);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAtras.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtras);
		
		lblBuscarPorId = new JLabel("Buscar por ID:");
		lblBuscarPorId.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblBuscarPorId.setBounds(76, 102, 86, 14);
		contentPane.add(lblBuscarPorId);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("Seleccione tipo " == comboBoxTipoAuto.getSelectedItem()){
					JOptionPane.showMessageDialog(null,
						    "No selecciono ningun tipo", 
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else{
				 for (TipoAuto tipoAuto : arrayTiposAutos){
				if (tipoAuto.getNombre() == comboBoxTipoAuto.getSelectedItem()){
					auto.setNombre(txtDescripcion.getText());	
					auto.setTipo(tipoAuto);
					auto.setId(Integer.parseInt(txtID.getText()));
					controlador.actualizar(auto);									}
				 											}
				    }
				
			}
		});
		btnActualizar.setBounds(228, 227, 97, 23);
		contentPane.add(btnActualizar);
		
	}
}

