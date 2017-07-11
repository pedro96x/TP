package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Component;
import javax.swing.JTable;

public class ABMReserva extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setTitle("ABM Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Tipo");
		comboBox.setBounds(66, 11, 292, 20);
		comboBox.addItem("Seleccione tipo ");
		comboBox.addItem("Renault Scenic");
		comboBox.addItem("Ford focus 2014");
		comboBox.addItem("Ford focus 2015");
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("Tipo:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 14, 46, 14);
		contentPane.add(label);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(10, 45, 46, 14);
		contentPane.add(lblFecha);
		
		textField = new JTextField();
		textField.setBounds(66, 42, 68, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 42, 39, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setBounds(144, 45, 46, 14);
		contentPane.add(lblHora);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setBounds(66, 82, 292, 17);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDetalle = new JLabel("Detalle:");
		lblDetalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDetalle.setBounds(10, 85, 46, 14);
		contentPane.add(lblDetalle);
		
	}
}
