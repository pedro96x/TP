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
import javax.swing.JOptionPane;
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


	CtrlReserva ctrlReserva = new CtrlReserva();
	private JPanel contentPane;
	private JTable table;

	ArrayList<Reserva> reservas = null; 


	
	public MisReservas(int idPersona) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 514, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 478, 260);
		contentPane.add(scrollPane);
		this.setIdPersona(idPersona);
		reservas = ctrlReserva.getReservasAFututoByIdPersona(idPersona);//Este método devuelve un array con las reservas realizadas 
																		//por la persona logeada con fechain posterior a la fecha actual.
		
		Object nombreColumnas[] = { "Id Reserva" , "Fecha Inicio", "Fecha Fin", "Detalle ", "Id de Auto"};
		Object datos[][] = new String[reservas.size()][nombreColumnas.length]; 
		

		for (int x = 0; x < reservas.size(); x++) {
			
			datos [x][0] = String.valueOf(reservas.get(x).getId());
			
			datos [x][1] = String.valueOf(reservas.get(x).getFechaIni());
			
			datos [x][2] = String.valueOf(reservas.get(x).getFechaFin());
			
			datos [x][3] = reservas.get(x).getDetalle();
			
			datos [x][4] = String.valueOf(reservas.get(x).getAutoReservado().getId());
			
						
			
		
		}
		
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel(datos,nombreColumnas));
		
		scrollPane.setViewportView(table);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAtras.setBounds(31, 268, 89, 23);
		contentPane.add(btnAtras);
		
		JButton btnCancelarReserva = new JButton("Cancelar Reserva");
		btnCancelarReserva.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(contentPane, "¿Esta seguro que desea cancelar la reserva?")==0){
					int row;
					row=table.getSelectedRow();
					int idRes;
					idRes=Integer.parseInt((String) table.getModel().getValueAt(row,0));
						
						ctrlReserva.deleteById(idRes);
						dispose();
						MisReservas mr = new MisReservas(idPersona);		
						mr.setVisible(true);
				}
				
				
				
				
			}
		});
		btnCancelarReserva.setForeground(Color.RED);
		btnCancelarReserva.setBounds(330, 268, 144, 23);
		contentPane.add(btnCancelarReserva);
		
		

		
		
		
	}
}
