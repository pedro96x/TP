package ui;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Persona;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Menu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int idPersona;
	public int getIdPersona() {
		return idPersona;
	}

	
	
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	
	public void setPersona(Persona per) {
		textFieldNombre.setText(per.getNombre());
		textFieldApellido.setText(per.getApellido());
		
		this.setIdPersona(per.getId());
		
	}
public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}


	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(543, 11, 101, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldApellido.setEditable(false);
		textFieldApellido.setBounds(654, 11, 93, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JButton btnGestionarPersonas = new JButton("Gestionar Personas");
		btnGestionarPersonas.setFont(new Font("Consolas", Font.BOLD, 12));
		btnGestionarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ABMPersona gestPers = new ABMPersona();
				
				gestPers.setVisible(true);
				
			}
		});
		btnGestionarPersonas.setBounds(142, 145, 502, 33);
		contentPane.add(btnGestionarPersonas);
		
		JButton btnGestionarTiposDe = new JButton("Gestionar Tipos de Auto");
		btnGestionarTiposDe.setFont(new Font("Consolas", Font.BOLD, 12));
		btnGestionarTiposDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMTipoAuto gestTipo = new ABMTipoAuto();
				gestTipo.setVisible(true);
			}
		});
		btnGestionarTiposDe.setBounds(142, 189, 502, 33);
		contentPane.add(btnGestionarTiposDe);
		
		JButton btnGestionarAuto = new JButton("Gestionar Autos");
		btnGestionarAuto.setFont(new Font("Consolas", Font.BOLD, 12));
		btnGestionarAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMAuto gestAuto = new ABMAuto();
				gestAuto.setVisible(true);
			}
		});
		btnGestionarAuto.setBounds(142, 233, 502, 33);
		contentPane.add(btnGestionarAuto);
		
		JButton btnGestionarReservas = new JButton("Gestionar Reservas");
		btnGestionarReservas.setFont(new Font("Consolas", Font.BOLD, 12));
		btnGestionarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMReserva gestRes = new ABMReserva();
				gestRes.setVisible(true);
				gestRes.setPersona(getIdPersona());
				
			}
		});
		btnGestionarReservas.setBounds(142, 277, 502, 33);
		contentPane.add(btnGestionarReservas);
		
		JButton btnMisReservas = new JButton("Mis Reservas");
		btnMisReservas.setFont(new Font("Consolas", Font.BOLD, 12));
		btnMisReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MisReservas mr = new MisReservas(idPersona);
				mr.setVisible(true);
				
			}
		});
		btnMisReservas.setBounds(142, 357, 502, 33);
		contentPane.add(btnMisReservas);
	}

	
}
