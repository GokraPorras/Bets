package gui;

/**
 * @author Software Engineering teachers
 */

import javax.swing.*;


import businessLogic.BLFacade;
import domain.Admin;
import domain.Erabiltzailea;
import domain.Langilea;
import domain.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnRegisteredGUI extends JFrame {

	private static BLFacade appFacadeInterface;
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

	public static String erab = null;

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JButton jButtonQueryQueries = null;
	private JLabel jLabelSelectOption;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;
	private JTextField textField;
	private JLabel label;
	private JLabel label_1;
	private Image img;
	private Image img1;
	private JLabel lblezDaukazuKontu=null;
	private JButton btnSortuKontuBerria=null;
	private JButton btnSartu=null;


	/**
	 * This is the default constructor
	 */
	public UnRegisteredGUI() {
		super();
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					//if (ConfigXML.getInstance().isBusinessLogicLocal()) facade.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Error: "+e1.toString()+" , probably problems with Business Logic or Database");
				}
				System.exit(1);
			}
		});

		initialize();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		// this.setSize(271, 295);
		this.setSize(800, 450);
		this.setLocationRelativeTo(null);
		this.setContentPane(getJContentPane());
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setBackground(Color.DARK_GRAY);
			jContentPane.setLayout(null);
			jContentPane.add(getBoton3());
			jContentPane.add(getPanel());
			jContentPane.add(getLblNewLabel());
			jContentPane.add(getPasswordField());
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textField.setBounds(12, 13, 100, 25);
			jContentPane.add(textField);
			textField.setColumns(10);

			btnSartu=new JButton();
			btnSartu.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnSartu.setText(ResourceBundle.getBundle("Etiquetas").getString("Sartu")); //$NON-NLS-1$ //$NON-NLS-2$
			btnSartu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//	Login
					try {
						String izena = textField.getText();
						String pass = new String(passwordField.getPassword());
						if(!getBusinessLogic().isRegister(izena, pass)) JOptionPane.showMessageDialog(null, ResourceBundle.getBundle("Etiquetas").getString("LoginError"),"Login Error",JOptionPane.ERROR_MESSAGE);
						else {
							User user = getBusinessLogic().getUser(izena);
							if (user instanceof Admin) {
								AdminGUI admin = new AdminGUI();
								admin.setVisible(true);
							}
							else if(user instanceof Langilea) {
								LangileaGUI langilea = new LangileaGUI();
								langilea.setVisible(true);
							}
							else if(user instanceof Erabiltzailea) {
								gui.UnRegisteredGUI.erab = user.getErabizena();
								ErabiltzaileaGUI erabiltzailea = new ErabiltzaileaGUI();
								erabiltzailea.setVisible(true);
							}
							dispose();
						}
					}
					catch(Exception e1) {
					}

				}});
			btnSartu.setBounds(237, 13, 103, 25);
			jContentPane.add(btnSartu);

			lblezDaukazuKontu=new JLabel();
			lblezDaukazuKontu.setHorizontalAlignment(SwingConstants.RIGHT);
			lblezDaukazuKontu.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblezDaukazuKontu.setText(ResourceBundle.getBundle("Etiquetas").getString("EzDaukazuKontuBat?")); //$NON-NLS-1$ //$NON-NLS-2$
			lblezDaukazuKontu.setForeground(Color.WHITE);
			lblezDaukazuKontu.setBounds(385, 13, 195, 25);
			jContentPane.add(lblezDaukazuKontu);

			btnSortuKontuBerria=new JButton();
			btnSortuKontuBerria.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnSortuKontuBerria.setText(ResourceBundle.getBundle("Etiquetas").getString("SortuKontuBerria")); //$NON-NLS-1$ //$NON-NLS-2$
			btnSortuKontuBerria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					RegisterGUI register = new RegisterGUI();
					register.setVisible(true);
					dispose();

				}
			});
			btnSortuKontuBerria.setBounds(592, 13, 190, 25);
			jContentPane.add(btnSortuKontuBerria);
			label = new JLabel("");
			label.setBackground(Color.BLUE);

			img = new ImageIcon(this.getClass().getResource("/8758208b9b9c88c.jpg")).getImage().getScaledInstance(794,371, Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(img));

			label_1 = new JLabel(); //$NON-NLS-1$ //$NON-NLS-2$
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(336, 123, 134, 60);


			img1 = new ImageIcon(this.getClass().getResource("/ikurriña.jpg")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			label_1.setIcon(new ImageIcon(img1));


			jContentPane.add(label_1);
			label.setBounds(0,50,794,365);
			jContentPane.add(label);


		}
		return jContentPane;
	}

	/**
	 * This method initializes boton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton3() {
		if (jButtonQueryQueries == null) {
			jButtonQueryQueries = new JButton();
			jButtonQueryQueries.setFont(new Font("Tahoma", Font.PLAIN, 24));
			jButtonQueryQueries.setBounds(162, 196, 477, 60);
			jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
			jButtonQueryQueries.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					FindQuestionsGUI findQuestion = new FindQuestionsGUI();
					findQuestion.setVisible(true);

				}
			});
		}
		return jButtonQueryQueries;
	}

	private JLabel getLblNewLabel() {
		if (jLabelSelectOption == null) {
			jLabelSelectOption = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
			jLabelSelectOption.setBounds(162, 61, 477, 60);
			jLabelSelectOption.setFont(new Font("Tahoma", Font.BOLD, 30));
			jLabelSelectOption.setForeground(Color.BLACK);
			jLabelSelectOption.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelSelectOption;
	}

	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("English");
			rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnNewRadioButton.setBackground(Color.WHITE);
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					img1 = new ImageIcon(this.getClass().getResource("/bandera-inglesa.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					label_1.setIcon(new ImageIcon(img1));
					Locale.setDefault(new Locale("en"));
					System.out.println("Locale: "+Locale.getDefault());
					redibujar();				}
			});
			buttonGroup.add(rdbtnNewRadioButton);
		}
		return rdbtnNewRadioButton;
	}

	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("Euskara");
			rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnNewRadioButton_1.setBackground(Color.WHITE);
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Locale.setDefault(new Locale("eus"));
					img1 = new ImageIcon(this.getClass().getResource("/ikurriña.jpg")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
					label_1.setIcon(new ImageIcon(img1));
					System.out.println("Locale: "+Locale.getDefault());
					redibujar();				}
			});
			buttonGroup.add(rdbtnNewRadioButton_1);
		}
		return rdbtnNewRadioButton_1;
	}

	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("Castellano");
			rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnNewRadioButton_2.setBackground(Color.WHITE);
			rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					img1 = new ImageIcon(this.getClass().getResource("/spanishflag.jpg")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					label_1.setIcon(new ImageIcon(img1));
					Locale.setDefault(new Locale("es"));
					System.out.println("Locale: "+Locale.getDefault());
					redibujar();
				}
			});
			buttonGroup.add(rdbtnNewRadioButton_2);
		}
		return rdbtnNewRadioButton_2;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setForeground(Color.WHITE);
			panel.setBackground(Color.WHITE);
			panel.setBounds(210, 269, 380, 43);
			panel.add(getRdbtnNewRadioButton_1());
			panel.add(getRdbtnNewRadioButton_2());
			panel.add(getRdbtnNewRadioButton());
		}
		return panel;
	}

	private void redibujar() {
		jLabelSelectOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
		jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
		btnSartu.setText(ResourceBundle.getBundle("Etiquetas").getString("Sartu"));
		lblezDaukazuKontu.setText(ResourceBundle.getBundle("Etiquetas").getString("EzDaukazuKontuBat?"));
		btnSortuKontuBerria.setText(ResourceBundle.getBundle("Etiquetas").getString("SortuKontuBerria"));
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
			passwordField.setBounds(125, 13, 100, 25);
		}
		return passwordField;
	}
} // @jve:decl-index=0:visual-constraint="0,0"

