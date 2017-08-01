package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.CtrlTipoAuto;
import entidades.Auto;
import entidades.TipoAuto;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton btnBuscarPorID;
	private JLabel lblDiasDeAnticipacion;
	private JTextField txtDiasAntNec;
	private JLabel lblDias;
	private JTextField txtBuscaID;


	public ABMTipoAuto() {
		setTitle("ABM Tipo de Auto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(53, 17, 159, 14);
		contentPane.add(lblNewLabel);
		
	
		CtrlTipoAuto controlador = new CtrlTipoAuto();
		
		txtBuscaID = new JTextField();
		txtBuscaID.setFont(new Font("Consolas", Font.PLAIN, 11));
		txtBuscaID.setColumns(10);
		txtBuscaID.setBounds(218, 140, 86, 20);
		contentPane.add(txtBuscaID);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Consolas", Font.PLAIN, 11));
		txtNombre.setBounds(218, 14, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCantMaxReservas = new JTextField();
		txtCantMaxReservas.setFont(new Font("Consolas", Font.PLAIN, 11));
		txtCantMaxReservas.setColumns(10);
		txtCantMaxReservas.setBounds(218, 46, 60, 20);
		contentPane.add(txtCantMaxReservas);
		
		txtLimiteMaxTiempo = new JTextField();
		txtLimiteMaxTiempo.setFont(new Font("Consolas", Font.PLAIN, 11));
		txtLimiteMaxTiempo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLimiteMaxTiempo.setColumns(10);
		txtLimiteMaxTiempo.setBounds(218, 77, 43, 20);
		contentPane.add(txtLimiteMaxTiempo);
		
		txtDiasAntNec = new JTextField();
		txtDiasAntNec.setFont(new Font("Consolas", Font.PLAIN, 11));
		txtDiasAntNec.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDiasAntNec.setColumns(10);
		txtDiasAntNec.setBounds(218, 108, 43, 20);
		contentPane.add(txtDiasAntNec);
		
		
		JLabel lblCantidadMaximaDe = new JLabel("Cant. max. de reservas:");
		lblCantidadMaximaDe.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblCantidadMaximaDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadMaximaDe.setBounds(70, 49, 142, 14);
		contentPane.add(lblCantidadMaximaDe);

		
		lblCantMaxDe = new JLabel("Limite max. de tiempo de reserva:");
		lblCantMaxDe.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblCantMaxDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantMaxDe.setBounds(0, 81, 209, 14);
		contentPane.add(lblCantMaxDe);

		
		lblHs = new JLabel("Hs.");
		lblHs.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblHs.setBounds(273, 79, 46, 14);
		contentPane.add(lblHs);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(12, 218, 89, 23);
		contentPane.add(btnAtras);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoAuto tipoauto = new TipoAuto();
				tipoauto.setNombre(txtNombre.getText());
				tipoauto.setCantMaxReservas(Integer.parseInt(txtCantMaxReservas.getText()));
				tipoauto.setLimMaxDeTiempoDeReserva(Integer.parseInt(txtLimiteMaxTiempo.getText()));
				tipoauto.setMinDiasDeAnti(Integer.parseInt(txtDiasAntNec.getText()));
				controlador.alta(tipoauto);
				//meto comentario para commitiar nomas 
			}
		});
		btnGuardar.setForeground(new Color(0, 128, 0));
		btnGuardar.setBounds(424, 218, 89, 23);
		contentPane.add(btnGuardar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlador.baja(Integer.parseInt(txtBuscaID.getText()));
			}
		});
		btnBorrar.setForeground(Color.RED);
		btnBorrar.setBounds(215, 218, 89, 23);
		contentPane.add(btnBorrar);
		
		btnBuscarPorID = new JButton("Buscar por ID");
		btnBuscarPorID.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnBuscarPorID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoAuto tipoauto = controlador.getByID(Integer.parseInt(txtBuscaID.getText()));
				txtNombre.setText(tipoauto.getNombre());
				txtCantMaxReservas.setText(Integer.toString(tipoauto.getCantMaxReservas()));
				txtLimiteMaxTiempo.setText(Integer.toString(tipoauto.getLimMaxDeTiempoDeReserva()));
				txtDiasAntNec.setText(Integer.toString(tipoauto.getMinDiasDeAnti()));
			}
		});
		btnBuscarPorID.setBounds(316, 139, 121, 23);
		contentPane.add(btnBuscarPorID);
		
		lblDiasDeAnticipacion = new JLabel("Dias de anticipacion necesarios:");
		lblDiasDeAnticipacion.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblDiasDeAnticipacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiasDeAnticipacion.setBounds(18, 110, 194, 14);
		contentPane.add(lblDiasDeAnticipacion);
		
		lblDias = new JLabel("Dias");
		lblDias.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblDias.setBounds(271, 110, 46, 14);
		contentPane.add(lblDias);
	
		
		JLabel label = new JLabel("ID:");
		label.setFont(new Font("Consolas", Font.PLAIN, 11));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(53, 143, 159, 14);
		contentPane.add(label);
	}
}
