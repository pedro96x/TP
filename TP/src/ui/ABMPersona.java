package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.CtrlPersona;
import entidades.Persona;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JSlider;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ABMPersona extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtDNI;
	private JTextField txtUser;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMPersona frame = new ABMPersona();
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
	public ABMPersona() {
		setTitle("ABMC Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Persona p = new Persona();
		CtrlPersona controlador = new CtrlPersona();
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(33, 31, 66, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(33, 69, 66, 14);
		contentPane.add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(77, 109, 22, 14);
		contentPane.add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(108, 28, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(108, 66, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(108, 106, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		Label lblResultado = new Label("-");
		lblResultado.setAlignment(Label.CENTER);
		lblResultado.setBounds(119, 234, 62, 22);
		contentPane.add(lblResultado);

		JCheckBox chckbxHabilitado = new JCheckBox("Habilitado");
		chckbxHabilitado.setSelected(true);
		chckbxHabilitado.setBounds(342, 27, 97, 23);
		contentPane.add(chckbxHabilitado);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(0, 128, 0));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				p.setNombre(txtNombre.getText());
				p.setApellido(txtApellido.getText());
				p.setDni(Integer.parseInt(txtDni.getText()));
				p.setHabilitado(chckbxHabilitado.isSelected());
				p.setUser(txtUser.getText());
				p.setPass(txtPass.getText());
				controlador.alta(p);
				lblResultado.setText("Registrado");

			}
		});
		btnGuardar.setBounds(392, 291, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(Color.RED);
		btnBorrar.setBounds(178, 291, 89, 23);
		contentPane.add(btnBorrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(279, 291, 101, 23);
		contentPane.add(btnActualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(241, 105, 89, 23);
		contentPane.add(btnBuscar);
		
		JRadioButton rdbtnUsuario = new JRadioButton("Usuario");
		rdbtnUsuario.setSelected(true);
		rdbtnUsuario.setBounds(231, 31, 109, 23);
		contentPane.add(rdbtnUsuario);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setBounds(231, 53, 109, 23);
		contentPane.add(rdbtnAdministrador);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setBounds(231, 75, 109, 23);
		contentPane.add(rdbtnGerente);
		
		ButtonGroup group = new ButtonGroup(); //Esto hace que solo uno de los tres JRadioButton pueda ser seleccionado.
		group.add(rdbtnUsuario);
		group.add(rdbtnAdministrador);
		group.add(rdbtnGerente);
		
		Label lbl_ID = new Label("ID:");
		lbl_ID.setAlignment(Label.RIGHT);
		lbl_ID.setBounds(37, 137, 62, 22);
		contentPane.add(lbl_ID);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setBounds(108, 139, 86, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setBounds(231, 11, 46, 14);
		contentPane.add(lblTipo);
		
		Label lblUser = new Label("User:");
		lblUser.setAlignment(Label.RIGHT);
		lblUser.setBounds(37, 169, 62, 22);
		contentPane.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(108, 171, 86, 20);
		contentPane.add(txtUser);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(108, 203, 86, 20);
		contentPane.add(txtPass);
		
		Label lblPass = new Label("Pass:");
		lblPass.setAlignment(Label.RIGHT);
		lblPass.setBounds(37, 201, 62, 22);
		contentPane.add(lblPass);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 291, 89, 23);
		contentPane.add(btnAtras);
	}
}
