package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class ABMTipoAuto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCantMaxReservas;
	private JLabel lblCantMaxDe;
	private JTextField txtLimiteMaxTiempo;
	private JLabel lblHs;
	private JButton btnAtras;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JButton btnBuscar;
	private JLabel lblDiasDeAnticipacion;
	private JTextField txtDiasAntNec;
	private JLabel lblDias;
	private JLabel lblId;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMTipoAuto frame = new ABMTipoAuto();
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
	public ABMTipoAuto() {
		setTitle("ABM Tipo de Auto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(53, 17, 159, 14);
		contentPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(218, 14, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCantidadMaximaDe = new JLabel("Cant. max. de reservas:");
		lblCantidadMaximaDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadMaximaDe.setBounds(70, 49, 142, 14);
		contentPane.add(lblCantidadMaximaDe);
		
		txtCantMaxReservas = new JTextField();
		txtCantMaxReservas.setColumns(10);
		txtCantMaxReservas.setBounds(218, 46, 60, 20);
		contentPane.add(txtCantMaxReservas);
		
		lblCantMaxDe = new JLabel("Limite max. de tiempo de reserva:");
		lblCantMaxDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantMaxDe.setBounds(18, 79, 194, 14);
		contentPane.add(lblCantMaxDe);
		
		txtLimiteMaxTiempo = new JTextField();
		txtLimiteMaxTiempo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLimiteMaxTiempo.setColumns(10);
		txtLimiteMaxTiempo.setBounds(218, 77, 43, 20);
		contentPane.add(txtLimiteMaxTiempo);
		
		lblHs = new JLabel("Hs.");
		lblHs.setBounds(273, 79, 46, 14);
		contentPane.add(lblHs);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtras);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(0, 128, 0));
		btnGuardar.setBounds(335, 227, 89, 23);
		contentPane.add(btnGuardar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(Color.RED);
		btnBorrar.setBounds(184, 227, 89, 23);
		contentPane.add(btnBorrar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(335, 13, 89, 23);
		contentPane.add(btnBuscar);
		
		lblDiasDeAnticipacion = new JLabel("Dias de anticipacion necesarios:");
		lblDiasDeAnticipacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiasDeAnticipacion.setBounds(18, 110, 194, 14);
		contentPane.add(lblDiasDeAnticipacion);
		
		txtDiasAntNec = new JTextField();
		txtDiasAntNec.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDiasAntNec.setColumns(10);
		txtDiasAntNec.setBounds(218, 108, 43, 20);
		contentPane.add(txtDiasAntNec);
		
		lblDias = new JLabel("Dias");
		lblDias.setBounds(273, 105, 46, 14);
		contentPane.add(lblDias);
		
		lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(53, 141, 159, 14);
		contentPane.add(lblId);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(218, 138, 86, 20);
		contentPane.add(txtID);
	}

}
