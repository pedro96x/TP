package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controladores.CtrlReserva;
import data.DataReserva;
import entidades.Reserva;
import tablas.TablaReservas;

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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

public class MisReservas extends JFrame {
	public int idPersona;
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

//	DataReserva dataRes = new DataReserva();
	CtrlReserva ctrlReserva = new CtrlReserva();
	private JPanel contentPane;
	private JTable table;
//	ArrayList<Reserva> reservas = ctrlReserva.getReservas();
	ArrayList<Reserva> reservas = ctrlReserva.getReservasByIdPersona(idPersona);

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
		setBounds(100, 100, 510, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 65, 328, 138);
		contentPane.add(scrollPane);
		
		Object nombreColumnas[] = { "fecha in", "fecha fin", "detalle ", "id de auto"};
		Object datos[][] = new String[reservas.size()][nombreColumnas.length]; 
		
		
		for (int x = 0; x < reservas.size(); x++) {
			
			datos [x][0] = String.valueOf(reservas.get(x).getFechaIni());
			
			datos [x][1] = String.valueOf(reservas.get(x).getFechaFin());
			
			datos [x][2] = reservas.get(x).getDetalle();
			
			datos [x][3] = String.valueOf(reservas.get(x).getAutoReservado().getId());
			
						
			
		
		}
		
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel(datos,nombreColumnas));
		
		scrollPane.setViewportView(table);
		
		

		
		
		
	}

	
}
