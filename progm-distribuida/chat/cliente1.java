import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.rmi.Naming;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class cliente1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField,textField_alias;
	private JLabel lblAlias;
	 static String ip;
	 static IObjetoRemoto objrem;

 	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ip=args[0];

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				String url;
				
				try {
						System.setProperty("java.security.policy","rmi.policy");
						System.setSecurityManager(new SecurityManager());
						url="rmi://"+args[0]+ ":2320/progm-distribuida";
						//IObjetoRemoto objrem = [IObjetoRemoto] Naming.lookup("rmi://localhost:2320/SistemasDistribuidos");
						objrem = (IObjetoRemoto) Naming.lookup(url);
						cliente1 frame = new cliente1();
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
	public cliente1() {
		String url;
		
		Caesar obj = new Caesar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setForeground(Color.BLACK);
		
		textArea.setBounds(10, 10, 414, 164);
		contentPane.add(textArea);

		lblAlias = new JLabel("Alias:");
		lblAlias.setBounds(10, 180, 46, 14);
		contentPane.add(lblAlias);

		textField_alias = new JTextField();
		textField_alias.setBounds(60,180,200,20);
		contentPane.add(textField_alias);
		textField_alias.setColumns(5);

		textField = new JTextField();
		textField.setBounds(10, 210, 263, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String msj1,msj2,alias1,alias2,cipher,desc,carpeta;		
					alias1 = textField_alias.getText().toString();	
					msj1 = textField.getText().toString();
					if(!alias1.equals("")){
						objrem.EnviaAlias(alias1,2);
						alias2 = objrem.RecibeAlias1();
						obj.setAlias2(alias2);
						objrem.EnviaMensaje(msj1,2);
						msj2 = objrem.RecibeMensaje1();
						textArea.append(alias1+":"+msj1+"\n");
						if(!msj2.equals("") && !alias2.equals(""))
							textArea.append(alias2+":"+msj2+"\n");
						
						

					}else{
						JOptionPane.showMessageDialog(null,"Debes Escribir un Alias","Mensaje Error",JOptionPane.ERROR_MESSAGE);
					
					}
					
					/*
					
					objrem.EnviaAlias(alias1,2);					
					alias2 = objrem.RecibeAlias1();
					setTitle(alias2);
					msj1 = textField.getText().toString();
					objrem.EnviaMensaje(msj1,2);
					msj2 = objrem.RecibeMensaje1();
					textArea.setText(alias2+":"+msj2+"\n");*/
				//objrem.EnviaAlias(textField_alias.getText().toString(),2);				
				//System.out.println(obj.getAlias1());
					textField_alias.setEditable(false);
					textField.setText("");
				}catch(Exception e){

				}
		
			}
		});
		btnEnviar.setBounds(304, 202, 89, 23);
		contentPane.add(btnEnviar);


		
						
		
	}
}
