package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controladores.CtrlReserva;
import data.DataReserva;
import entidades.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JList;

public class MisReservas extends JFrame {
	int idPersona;
	DataReserva dataRes = new DataReserva();
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MisReservas frame = new MisReservas();
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
	public MisReservas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
	
		
		
		
		JButton btnMostrarReservas = new JButton("Mostrar Reservas");
		btnMostrarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Reserva> reservas = dataRes.getReservas();
				
				for (int i = 0; i < reservas.size(); i++) {
				if(reservas.get(i).getIdPersona()==getIdPersona()){
					
				}
				
					
				
			}
			}
		});
		btnMostrarReservas.setBounds(44, 5, 355, 23);
		contentPane.add(btnMostrarReservas);
		
		JList list = new JList();
		list.setBounds(44, 39, 355, 211);
		contentPane.add(list);
		
		
		
		
		

		
		
		
	}

	public void setPersona(int idPers) {
		setIdPersona(idPers);
		
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
}
