package ui;
import controladores.CtrlLogin;
import entidades.Persona;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private CtrlLogin ctrl=new CtrlLogin();

	private JPanel contentPane;
	private JPasswordField passFieldPass;
	private JTextField txtUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(10, 134, 65, 14);
		contentPane.add(lblUser);
		
		JLabel lblPass = new JLabel("Pass:");
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setBounds(10, 173, 65, 14);
		contentPane.add(lblPass);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Persona p = new Persona();
				p.setUser(txtUser.getText());
				p.setPass(passFieldPass.getText());
				Persona per=null;
				per =ctrl.compara(p);
				if (per == null){JOptionPane.showMessageDialog(contentPane, "Usuario o contraseña incorrectos");}
				
				if(per!=null){
						JOptionPane.showMessageDialog(contentPane, "Login realizado exitosamente");
						
						Menu menu = new Menu();
						menu.setVisible(true);
						menu.setPersona(per);
						menu.setIdPersona(per.getId());
						
						
						
						
						}
					
							
				
			}
		});
		btnIngresar.setBounds(335, 172, 89, 23);
		contentPane.add(btnIngresar);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(105, 222, 213, 14);
		contentPane.add(label);
		
		passFieldPass = new JPasswordField();
		passFieldPass.setBounds(105, 173, 213, 20);
		contentPane.add(passFieldPass);
		
		txtUser = new JTextField();
		txtUser.setBounds(105, 131, 213, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
	}

	
}
