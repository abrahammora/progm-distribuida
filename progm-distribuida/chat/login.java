import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frame = new JFrame();
		//frame.setBounds(100, 100, 257, 300);
		frame.setSize(250,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setBounds(43, 105, 122, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAlias = new JLabel("Alias:");
		lblAlias.setBounds(43, 80, 46, 14);
		frame.getContentPane().add(lblAlias);
		cliente1 custome = new cliente1();
		JButton btnIniciarChat = new JButton("Iniciar Chat");
		btnIniciarChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String alias=textField.getText();
				if(textField.getText()!=null) {
					JOptionPane.showMessageDialog(null,"Bienvenido");
					System.out.println(alias);
					custome.setVisible(true);
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(null,"Debes Escribir un Alias","Mensaje Error",JOptionPane.ERROR_MESSAGE);
					System.out.println(alias);
				}
			}
		});
		btnIniciarChat.setBounds(43, 171, 122, 23);
		frame.getContentPane().add(btnIniciarChat);
		
		frame.setVisible(true);
		
	}

}
