package gui;

/**
 * @author Software Engineering teachers
 */

import javax.swing.*;

import businessLogic.BLFacade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErabiltzaileaGUI extends JFrame {

	private static BLFacade appFacadeInterface;
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

	protected static boolean irekita = false;

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JButton jButtonQueryQueries = null;

	protected JLabel jLabelSelectOption;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnLogout;
	private JLabel lblLangilea;
	private JButton btnNewButton;
	private JButton btnMugimenduak;

	private Image cesped;
	private JLabel label;
	private JButton btnNewButton_1;

	/**
	 * This is the default constructor
	 */
	public ErabiltzaileaGUI() {
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
		this.setSize(800, 500);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
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
			jContentPane.setLayout(null);
			jContentPane.add(getBtnLogout());
			jContentPane.add(getBoton3());
			jContentPane.add(getPanel());
			jContentPane.add(getLblLangilea());

			btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MoneyInsert")); //$NON-NLS-1$ //$NON-NLS-2$
			btnNewButton.setBackground(Color.ORANGE);
			btnNewButton.setForeground(Color.BLUE);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if(irekita==false) {
						InsertMoneyGUI insertMoney = new InsertMoneyGUI();
						insertMoney.setLocationRelativeTo(null);
						insertMoney.setVisible(true);
						irekita=true;
					}

				}
			});
			btnNewButton.setBounds(606, 84, 175, 33);
			jContentPane.add(btnNewButton);

			btnMugimenduak = new JButton(ResourceBundle.getBundle("Etiquetas").getString("SeeMovements")); //$NON-NLS-1$ //$NON-NLS-2$
			btnMugimenduak.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnMugimenduak.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					SeeMugimenduakGUI seeMugimenduak = new SeeMugimenduakGUI();
					seeMugimenduak.setVisible(true);
					seeMugimenduak.setLocationRelativeTo(null);

				}
			});
			btnMugimenduak.setBounds(341, 321, 441, 60);
			jContentPane.add(btnMugimenduak);
			jContentPane.add(getBtnNewButton_1());
			jContentPane.add(getLblNewLabel());
			jContentPane.add(getLabel());

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
			jButtonQueryQueries.setBounds(341, 175, 441, 60);
			jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("SingleResBet"));
			jButtonQueryQueries.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					FindQuestionsGUI findQuestions = new FindQuestionsGUI();
					findQuestions.setVisible(true);

				}
			});
		}
		return jButtonQueryQueries;
	}

	private JLabel getLblNewLabel() {
		if (jLabelSelectOption == null) {
			jLabelSelectOption = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
			jLabelSelectOption.setBounds(12, 86, 770, 60);
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
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Locale.setDefault(new Locale("eus"));
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
			rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
			panel.setBounds(207, 409, 380, 43);
			panel.add(getRdbtnNewRadioButton_1());
			panel.add(getRdbtnNewRadioButton_2());
			panel.add(getRdbtnNewRadioButton());
		}
		return panel;
	}

	private void redibujar() {
		jLabelSelectOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
		jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("SingleResBet"));
		btnMugimenduak.setText(ResourceBundle.getBundle("Etiquetas").getString("SeeMovements"));
		btnLogout.setText(ResourceBundle.getBundle("Etiquetas").getString("Logout"));
		lblLangilea.setText(ResourceBundle.getBundle("Etiquetas").getString("Welcomeu")+" "+gui.UnRegisteredGUI.erab);
		btnNewButton.setText(ResourceBundle.getBundle("Etiquetas").getString("MoneyInsert"));
		btnNewButton_1.setText(ResourceBundle.getBundle("Etiquetas").getString("MultipleResBet"));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}

	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Logout")); //$NON-NLS-1$ //$NON-NLS-2$
			btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//					----------------------------------------------------
					gui.UnRegisteredGUI.erab = null;
					UnRegisteredGUI HasieraPantaila = new UnRegisteredGUI();
					HasieraPantaila.setVisible(true);
					dispose();
					//					----------------------------------------------------
				}
			});
			btnLogout.setBackground(Color.ORANGE);
			btnLogout.setForeground(Color.BLUE);
			btnLogout.setBounds(596, 131, 185, 33);
		}
		return btnLogout;
	}
	private JLabel getLblLangilea() {
		if (lblLangilea == null) {
			lblLangilea = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Welcomeu")+" "+gui.UnRegisteredGUI.erab); //$NON-NLS-1$ //$NON-NLS-2$
			lblLangilea.setHorizontalAlignment(SwingConstants.CENTER);
			lblLangilea.setForeground(Color.PINK);
			lblLangilea.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblLangilea.setBounds(12, 13, 770, 60);
		}
		return lblLangilea;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel(); //$NON-NLS-1$ //$NON-NLS-2$
			label.setBounds(0, 0, 794, 465);

			cesped = new ImageIcon(this.getClass().getResource("/atleta.jpg")).getImage().getScaledInstance(794, 465, Image.SCALE_SMOOTH);;
			label.setIcon(new ImageIcon(cesped));
		}
		return label;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton(); //$NON-NLS-1$ //$NON-NLS-2$
			btnNewButton_1.setText(ResourceBundle.getBundle("Etiquetas").getString("MultipleResBet"));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					ApustuAnitzaGUI ApustuAnitza = new ApustuAnitzaGUI();
					ApustuAnitza.setVisible(true);

				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnNewButton_1.setBounds(341, 248, 441, 60);
		}
		return btnNewButton_1;
	}
} // @jve:decl-index=0:visual-constraint="0,0"

