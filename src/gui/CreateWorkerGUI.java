package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import businessLogic.BLFacade;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CreateWorkerGUI extends JFrame {

	private static BLFacade appFacadeInterface;
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JButton btnAtzera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateWorkerGUI createWorker = new CreateWorkerGUI();
					createWorker.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateWorkerGUI() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(338, 102, 200, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblLangilearenErabiltzaileIzena = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("WorkerUserName"));
		lblLangilearenErabiltzaileIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblLangilearenErabiltzaileIzena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLangilearenErabiltzaileIzena.setBounds(29, 99, 297, 30);
		contentPane.add(lblLangilearenErabiltzaileIzena);

		JLabel lblPasahitza = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Pasahitza"));
		lblPasahitza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPasahitza.setBounds(29, 142, 297, 30);
		contentPane.add(lblPasahitza);
		lblPasahitza.setText(ResourceBundle.getBundle("Etiquetas").getString("Pasahitza")+":");
		JLabel lblPasahitzaErrepikatu = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("ErrepikatuPasahitza")+":");
		lblPasahitzaErrepikatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasahitzaErrepikatu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPasahitzaErrepikatu.setBounds(29, 185, 297, 30);
		contentPane.add(lblPasahitzaErrepikatu);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(338, 145, 200, 25);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField_1.setBounds(338, 188, 200, 25);
		contentPane.add(passwordField_1);

		JButton btnErregistratu = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Erregistratu"));
		btnErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				label.setForeground(Color.RED);
				label.setText("");
				String izena = textField_1.getText();
				String erabizena = textField.getText();	
				String pass = new String(passwordField.getPassword());
				String pass1 = new String(passwordField_1.getPassword());

				if(pass.length() == 0 || erabizena.length() == 0) {
					label.setText(ResourceBundle.getBundle("Etiquetas").getString("PassUserDigit"));
				}

				else if(!(pass.compareTo(pass1)==0)) {
					label.setText(ResourceBundle.getBundle("Etiquetas").getString("SamePass"));
				}

				else if(!getBusinessLogic().Register(true, izena, "", "", erabizena, pass, "", "", "", "", "", "", "", "", "")) {
					label.setText(ResourceBundle.getBundle("Etiquetas").getString("UserAlreadyExists"));
				}

				else {
					
					label.setForeground(Color.GREEN);
					label.setText(ResourceBundle.getBundle("Etiquetas").getString("createWorkerSuccesfull"));
				}

			}

		});
		btnErregistratu.setBounds(29, 297, 180, 40);
		contentPane.add(btnErregistratu);

		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(12, 241, 576, 30);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setBounds(338, 59, 200, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblLang = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("WorkerName"));
		lblLang.setHorizontalAlignment(SwingConstants.CENTER);
		lblLang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLang.setBounds(29, 56, 297, 30);
		contentPane.add(lblLang);

		btnAtzera = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Back"));
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();

			}
		});
		btnAtzera.setBounds(390, 297, 180, 40);
		contentPane.add(btnAtzera);

		JLabel label_1 = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("CreateWorker"));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 13, 576, 30);
		contentPane.add(label_1);
	}
}
