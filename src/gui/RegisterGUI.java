package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import businessLogic.BLFacade;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class RegisterGUI extends JFrame {

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
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JLabel lblInformazioPertsonala=null;
	private JLabel lblNan=null;
	private JLabel lblIzena=null;
	private JLabel lblAbizena=null;
	private JLabel lblAbizena_1=null;
	private JLabel lblHerrialdea=null;
	private JLabel lblHerria=null;
	private JLabel lblJaiotzedata=null;
	private JLabel lblKontakturakoInformazioa=null;
	private JLabel lblEmaila=null;
	private JLabel lblTelefonoZenbakia=null;
	private JLabel lblSarbideDatuak=null;
	private JLabel lblErabiltzaileIzena=null;
	private JLabel lblPasahitza=null;
	private JLabel lblErrepikatuPasahitza=null;
	private JLabel lblPostakodea=null;
	private JLabel lblProbintzia=null;
	private JLabel lblHelbidea=null;
	private JButton btnNewButton=null;
	private JButton btnErregistratu=null;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
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
	public RegisterGUI() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 730);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(156, 104, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(156, 137, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		lblIzena=new JLabel();
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIzena.setText(ResourceBundle.getBundle("Etiquetas").getString("Izena"));
		lblIzena.setBounds(30, 103, 114, 20);
		contentPane.add(lblIzena);
		lblAbizena=new JLabel();
		lblAbizena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAbizena.setText(ResourceBundle.getBundle("Etiquetas").getString("1.Abizena"));
		lblAbizena.setBounds(30, 136, 114, 20);
		contentPane.add(lblAbizena);

		textField_2 = new JTextField();
		textField_2.setBounds(156, 170, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		lblAbizena_1=new JLabel();
		lblAbizena_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAbizena_1.setText(ResourceBundle.getBundle("Etiquetas").getString("2.Abizena"));
		lblAbizena_1.setBounds(30, 169, 112, 20);
		contentPane.add(lblAbizena_1);
		lblInformazioPertsonala=new JLabel();
		lblInformazioPertsonala.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformazioPertsonala.setText(ResourceBundle.getBundle("Etiquetas").getString("InformazioPertsonala"));
		lblInformazioPertsonala.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInformazioPertsonala.setBounds(130, 37, 250, 33);
		contentPane.add(lblInformazioPertsonala);

		textField_3 = new JTextField();
		textField_3.setBounds(156, 203, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		lblNan=new JLabel();
		lblNan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNan.setText(ResourceBundle.getBundle("Etiquetas").getString("NAN"));
		lblNan.setBounds(30, 202, 112, 20);
		contentPane.add(lblNan);
		lblHerrialdea=new JLabel();
		lblHerrialdea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHerrialdea.setText(ResourceBundle.getBundle("Etiquetas").getString("Herrialdea"));
		lblHerrialdea.setBounds(30, 235, 112, 20);
		contentPane.add(lblHerrialdea);

		textField_4 = new JTextField();
		textField_4.setBounds(156, 236, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(156, 269, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		lblHerria=new JLabel();
		lblHerria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHerria.setText(ResourceBundle.getBundle("Etiquetas").getString("Herria"));
		lblHerria.setBounds(30, 268, 112, 20);
		contentPane.add(lblHerria);
		lblJaiotzedata=new JLabel();
		lblJaiotzedata.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJaiotzedata.setText(ResourceBundle.getBundle("Etiquetas").getString("Jaiotze-data"));
		lblJaiotzedata.setBounds(30, 301, 112, 20);
		contentPane.add(lblJaiotzedata);

		textField_6 = new JTextField();
		textField_6.setBounds(156, 302, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		lblKontakturakoInformazioa=new JLabel();
		lblKontakturakoInformazioa.setHorizontalAlignment(SwingConstants.CENTER);
		lblKontakturakoInformazioa.setText(ResourceBundle.getBundle("Etiquetas").getString("KontakturakoInformazioa"));
		lblKontakturakoInformazioa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblKontakturakoInformazioa.setBounds(143, 335, 231, 31);
		contentPane.add(lblKontakturakoInformazioa);
		lblEmaila=new JLabel();
		lblEmaila.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmaila.setText(ResourceBundle.getBundle("Etiquetas").getString("Email-a"));
		lblEmaila.setBounds(87, 379, 169, 20);
		contentPane.add(lblEmaila);

		textField_7 = new JTextField();
		textField_7.setBounds(268, 380, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(268, 413, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		lblTelefonoZenbakia=new JLabel();
		lblTelefonoZenbakia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefonoZenbakia.setText(ResourceBundle.getBundle("Etiquetas").getString("TelefonoZenbakia"));
		lblTelefonoZenbakia.setBounds(87, 412, 169, 20);
		contentPane.add(lblTelefonoZenbakia);
		lblSarbideDatuak=new JLabel();
		lblSarbideDatuak.setHorizontalAlignment(SwingConstants.CENTER);
		lblSarbideDatuak.setText(ResourceBundle.getBundle("Etiquetas").getString("SarbideDatuak"));
		lblSarbideDatuak.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSarbideDatuak.setBounds(176, 466, 152, 23);
		contentPane.add(lblSarbideDatuak);
		lblErabiltzaileIzena=new JLabel();
		lblErabiltzaileIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErabiltzaileIzena.setText(ResourceBundle.getBundle("Etiquetas").getString("ErabiltzaileIzena"));
		lblErabiltzaileIzena.setBounds(87, 502, 169, 20);
		contentPane.add(lblErabiltzaileIzena);

		textField_9 = new JTextField();
		textField_9.setBounds(268, 503, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(268, 536, 86, 20);
		contentPane.add(passwordField);
		lblPasahitza=new JLabel();
		lblPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPasahitza.setText(ResourceBundle.getBundle("Etiquetas").getString("Pasahitza"));
		lblPasahitza.setBounds(87, 535, 169, 20);
		contentPane.add(lblPasahitza);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(268, 569, 86, 20);
		contentPane.add(passwordField_1);
		lblErrepikatuPasahitza=new JLabel();
		lblErrepikatuPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrepikatuPasahitza.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrepikatuPasahitza"));
		lblErrepikatuPasahitza.setBounds(87, 568, 169, 20);
		contentPane.add(lblErrepikatuPasahitza);
		lblPostakodea=new JLabel();
		lblPostakodea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPostakodea.setText(ResourceBundle.getBundle("Etiquetas").getString("Posta-kodea"));
		lblPostakodea.setBounds(268, 103, 106, 20);
		contentPane.add(lblPostakodea);

		textField_10 = new JTextField();
		textField_10.setBounds(388, 104, 86, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(388, 137, 86, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		lblProbintzia=new JLabel();
		lblProbintzia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProbintzia.setText(ResourceBundle.getBundle("Etiquetas").getString("Probintzia"));
		lblProbintzia.setBounds(268, 136, 112, 20);
		contentPane.add(lblProbintzia);

		textField_12 = new JTextField();
		textField_12.setBounds(388, 170, 86, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		lblHelbidea=new JLabel();
		lblHelbidea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHelbidea.setText(ResourceBundle.getBundle("Etiquetas").getString("Helbidea"));
		lblHelbidea.setBounds(268, 169, 106, 20);
		contentPane.add(lblHelbidea);
		btnErregistratu=new JButton();
		btnErregistratu.setBackground(Color.ORANGE);
		btnErregistratu.setForeground(Color.BLUE);
		btnErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnErregistratu.setText(ResourceBundle.getBundle("Etiquetas").getString("Erregistratu"));
		btnErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String izena = textField.getText();
				String ab1 = textField_1.getText();
				String ab2 = textField_2.getText();
				String NAN= textField_3.getText();
				String herrialdea = textField_4.getText();
				String herria = textField_5.getText();
				String jd = textField_6.getText();
				String pd = textField_10.getText();
				String prob = textField_11.getText();
				String helb = textField_12.getText();
				String email= textField_7.getText();
				String tlf = textField_8.getText();
				String erabizena= textField_9.getText();
				String pass = new String(passwordField.getPassword());
				String pass1 = new String(passwordField_1.getPassword());

				label.setForeground(Color.RED);
				label.setText("");

				if(pass.length() == 0 || erabizena.length() == 0) {
					label.setText(ResourceBundle.getBundle("Etiquetas").getString("PassUserDigit"));
				}
				else if(!(pass.compareTo(pass1)==0)) {
					label.setText(ResourceBundle.getBundle("Etiquetas").getString("SamePass"));
				}
				//	Register
				else if(!getBusinessLogic().Register(false, izena, ab1, ab2, erabizena, pass, NAN, jd, email, tlf, helb, pd, herrialdea, prob, herria)) {
					label.setText(ResourceBundle.getBundle("Etiquetas").getString("UserAlreadyExists"));
				}
				else {
					;
					JOptionPane.showMessageDialog(null, erabizena+", "+ResourceBundle.getBundle("Etiquetas").getString("Welcome"));
					UnRegisteredGUI unregistered = new UnRegisteredGUI();
					unregistered.setVisible(true);
					dispose();
				}

			}
		});
		btnErregistratu.setBounds(270, 629, 155, 33);
		contentPane.add(btnErregistratu);
		btnNewButton=new JButton();
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setText(ResourceBundle.getBundle("Etiquetas").getString("Back"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				UnRegisteredGUI unregistered = new UnRegisteredGUI();
				unregistered.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setBounds(87, 629, 155, 33);
		contentPane.add(btnNewButton);

		label = new JLabel(); //$NON-NLS-1$ //$NON-NLS-2$
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(72, 602, 378, 14);
		contentPane.add(label);

		JButton btnExit = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close")); //$NON-NLS-1$ //$NON-NLS-2$
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(-1);
			}
		});
		btnExit.setBounds(426, 11, 73, 23);
		contentPane.add(btnExit);
		
		redibujar();
	}

	private void redibujar() {
		lblInformazioPertsonala.setText(ResourceBundle.getBundle("Etiquetas").getString("InformazioPertsonala"));
		lblNan.setText(ResourceBundle.getBundle("Etiquetas").getString("NAN"));
		lblIzena.setText(ResourceBundle.getBundle("Etiquetas").getString("Izena"));
		lblAbizena.setText(ResourceBundle.getBundle("Etiquetas").getString("1.Abizena"));
		lblAbizena_1.setText(ResourceBundle.getBundle("Etiquetas").getString("2.Abizena"));
		lblHerrialdea.setText(ResourceBundle.getBundle("Etiquetas").getString("Herrialdea"));
		lblHerria.setText(ResourceBundle.getBundle("Etiquetas").getString("Herria"));
		lblJaiotzedata.setText(ResourceBundle.getBundle("Etiquetas").getString("Jaiotze-data"));
		lblKontakturakoInformazioa.setText(ResourceBundle.getBundle("Etiquetas").getString("KontakturakoInformazioa"));
		lblEmaila.setText(ResourceBundle.getBundle("Etiquetas").getString("Email-a"));
		lblTelefonoZenbakia.setText(ResourceBundle.getBundle("Etiquetas").getString("TelefonoZenbakia"));
		lblSarbideDatuak.setText(ResourceBundle.getBundle("Etiquetas").getString("SarbideDatuak"));
		lblErabiltzaileIzena.setText(ResourceBundle.getBundle("Etiquetas").getString("ErabiltzaileIzena"));
		lblPasahitza.setText(ResourceBundle.getBundle("Etiquetas").getString("Pasahitza"));
		lblErrepikatuPasahitza.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrepikatuPasahitza"));
		lblPostakodea.setText(ResourceBundle.getBundle("Etiquetas").getString("Posta-kodea"));
		lblProbintzia.setText(ResourceBundle.getBundle("Etiquetas").getString("Probintzia"));
		lblHelbidea.setText(ResourceBundle.getBundle("Etiquetas").getString("Helbidea"));
		btnNewButton.setText(ResourceBundle.getBundle("Etiquetas").getString("Back"));
		btnErregistratu.setText(ResourceBundle.getBundle("Etiquetas").getString("Erregistratu"));
	}
}
