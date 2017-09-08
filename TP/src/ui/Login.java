package ui;
import controladores.CtrlLogin;
import entidades.Persona;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Font;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		setBounds(100, 100, 323, 133);
		contentPane = new JPanel();
		
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(0, 14, 46, 14);
		contentPane.add(lblUser);
		
		JLabel lblPass = new JLabel("Pass:");
		lblPass.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setBounds(0, 56, 46, 14);
		contentPane.add(lblPass);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnIngresar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				btnIngresarClick();
			}
		});
		btnIngresar.setBounds(194, 52, 103, 23);
		contentPane.add(btnIngresar);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(105, 222, 213, 14);
		contentPane.add(label);
		
		passFieldPass = new JPasswordField();
		passFieldPass.setFont(new Font("Consolas", Font.PLAIN, 12));
		passFieldPass.setEchoChar('*');
		passFieldPass.setBounds(56, 56, 108, 20);
		contentPane.add(passFieldPass);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtUser.setText("admin");
		txtUser.setBounds(56, 14, 108, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
	}
	
	private void btnIngresarClick(){
		Persona p = new Persona();
		p.setUser(txtUser.getText());
		p.setPass(passFieldPass.getText());
		Persona per=null;
		per =ctrl.compara(p);
		if (per == null){JOptionPane.showMessageDialog(contentPane, "Usuario o contraseña incorrectos");}
		
		if(per!=null){
			Menu menu = new Menu();
			menu.setVisible(true);
			menu.setPersona(per);
			menu.setIdPersona(per.getId());		
		}
	}
}
