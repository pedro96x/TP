package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Font;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMAuto frame = new ABMAuto();
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
	public ABMAuto() {
		setTitle("ABM Auto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(132, 11, 292, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtID = new JTextField();
		txtID.setBounds(132, 124, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcion.setBounds(36, 14, 86, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(76, 127, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBoxTipoAuto = new JComboBox();
		comboBoxTipoAuto.setToolTipText("Tipo");
		comboBoxTipoAuto.setBounds(132, 42, 292, 20);
		comboBoxTipoAuto.addItem("Seleccione tipo ");
		comboBoxTipoAuto.addItem("Renault Scenic");
		comboBoxTipoAuto.addItem("Ford focus 2014");
		comboBoxTipoAuto.addItem("Ford focus 2015");
		contentPane.add(comboBoxTipoAuto);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(76, 45, 46, 14);
		contentPane.add(lblTipo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(0, 128, 0));
		btnGuardar.setBounds(335, 227, 89, 23);
		contentPane.add(btnGuardar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(228, 123, 89, 23);
		contentPane.add(btnBuscar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(Color.RED);
		btnBorrar.setBounds(164, 227, 89, 23);
		contentPane.add(btnBorrar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtras);
		
		lblBuscarPorId = new JLabel("Buscar por ID:");
		lblBuscarPorId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscarPorId.setBounds(76, 102, 86, 14);
		contentPane.add(lblBuscarPorId);
		
	}
}
