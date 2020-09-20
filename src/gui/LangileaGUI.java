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

public class LangileaGUI extends JFrame {

	private static BLFacade appFacadeInterface;
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JButton jButtonCreateQuery = null;
	private JButton jButtonQueryQueries = null;

	protected JLabel jLabelSelectOption;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnLogout;
	private JLabel lblLangilea;
	private JButton langileDeleteFee;
	private JButton btnCreateFee;

	private JButton btnGertaeraBikoiztu;

	private JButton btnDeleteEvent;

	private JButton btnDeleteQuestion;

	private JButton btnDeleteUser;

	private JLabel label;
	
	private Image cesped;

	private JButton btnNewButton_2=null;

	/**
	 * This is the default constructor
	 */
	public LangileaGUI() {
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
		this.setSize(800, 725);
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
			jContentPane.setLayout(null);
			jContentPane.add(getBtnLogout());
			jContentPane.add(getBoton3());
			jContentPane.add(getBoton2());
			jContentPane.add(getPanel());
			jContentPane.add(getLblLangilea());
			jContentPane.add(getLblNewLabel());

			btnCreateFee = new JButton(ResourceBundle.getBundle("Etiquetas").getString("CreateFee")); //$NON-NLS-1$ //$NON-NLS-2$
			btnCreateFee.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnCreateFee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					CreateFeesGUI createFees = new CreateFeesGUI();
					createFees.setVisible(true);

				}
			});
			btnCreateFee.setBounds(12, 393, 370, 60);
			jContentPane.add(btnCreateFee);

			langileDeleteFee = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DeleteFee")); //$NON-NLS-1$ //$NON-NLS-2$
			langileDeleteFee.setFont(new Font("Tahoma", Font.PLAIN, 24));
			langileDeleteFee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					DeleteFeesGUI deleteFees = new DeleteFeesGUI();
					deleteFees.setVisible(true);

				}
			});
			langileDeleteFee.setBounds(412, 393, 370, 60);
			jContentPane.add(langileDeleteFee);

			btnNewButton_2=new JButton();
			btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnNewButton_2.setText(ResourceBundle.getBundle("Etiquetas").getString("PutResult"));  //$NON-NLS-1$ //$NON-NLS-2$
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					PutResultGUI putResult = new PutResultGUI();
					putResult.setVisible(true);

				}
			});
			btnNewButton_2.setBounds(12, 534, 770, 60);
			jContentPane.add(btnNewButton_2);
			
			btnDeleteEvent = new JButton(ResourceBundle.getBundle("Etiquetas").getString("deleteEvent")); //$NON-NLS-1$ //$NON-NLS-2$
			btnDeleteEvent.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnDeleteEvent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DeleteEventsGUI delevent = new DeleteEventsGUI();
					delevent.setVisible(true);
				}
			});
			btnDeleteEvent.setBounds(412, 247, 370, 60);
			jContentPane.add(btnDeleteEvent);
			
			btnDeleteQuestion = new JButton(ResourceBundle.getBundle("Etiquetas").getString("deleteQuestion")); //$NON-NLS-1$ //$NON-NLS-2$
			btnDeleteQuestion.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnDeleteQuestion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DeleteQuestionsGUI delquestion = new DeleteQuestionsGUI();
					delquestion.setVisible(true);
				}
			});
			btnDeleteQuestion.setBounds(412, 320, 370, 60);
			jContentPane.add(btnDeleteQuestion);
			
			
			jContentPane.add(getBtnGertaeraBikoiztu());
			jContentPane.add(getBtnDeleteUser());
			jContentPane.add(getLabel());
			
		}
		return jContentPane;
	}

	/**
	 * This method initializes boton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton2() {
		if (jButtonCreateQuery == null) {
			jButtonCreateQuery = new JButton();
			jButtonCreateQuery.setFont(new Font("Tahoma", Font.PLAIN, 24));
			jButtonCreateQuery.setBounds(12, 320, 370, 60);
			jButtonCreateQuery.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
			jButtonCreateQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					CreateQuestionGUI createQuestion = new CreateQuestionGUI();
					createQuestion.setVisible(true);

				}
			});
		}
		return jButtonCreateQuery;
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
			jButtonQueryQueries.setBounds(12, 174, 770, 60);
			jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
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
			panel.setBounds(210, 634, 380, 43);
			panel.add(getRdbtnNewRadioButton_1());
			panel.add(getRdbtnNewRadioButton_2());
			panel.add(getRdbtnNewRadioButton());
		}
		return panel;
	}

	private void redibujar() {
		jLabelSelectOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
		jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
		jButtonCreateQuery.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
		btnLogout.setText(ResourceBundle.getBundle("Etiquetas").getString("Logout"));
		lblLangilea.setText(ResourceBundle.getBundle("Etiquetas").getString("Worker"));
		langileDeleteFee.setText(ResourceBundle.getBundle("Etiquetas").getString("DeleteFee"));
		btnCreateFee.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateFee"));
		btnGertaeraBikoiztu.setText(ResourceBundle.getBundle("Etiquetas").getString("GertaeraBikoiztu"));
		btnNewButton_2.setText(ResourceBundle.getBundle("Etiquetas").getString("PutResult"));
		btnDeleteUser.setText(ResourceBundle.getBundle("Etiquetas").getString("DeleteUser"));
		btnDeleteQuestion.setText(ResourceBundle.getBundle("Etiquetas").getString("deleteQuestion"));
		btnDeleteEvent.setText(ResourceBundle.getBundle("Etiquetas").getString("deleteEvent"));

		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}

	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Logout")); //$NON-NLS-1$ //$NON-NLS-2$
			btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//					----------------------------------------------------
					UnRegisteredGUI HasieraPantaila = new UnRegisteredGUI();
					HasieraPantaila.setVisible(true);
					dispose();
					//					----------------------------------------------------
				}
			});
			btnLogout.setBackground(Color.ORANGE);
			btnLogout.setForeground(Color.BLUE);
			btnLogout.setBounds(562, 86, 220, 60);
		}
		return btnLogout;
	}
	
	private JButton getBtnGertaeraBikoiztu() {
		if (btnGertaeraBikoiztu == null) {
			btnGertaeraBikoiztu = new JButton(ResourceBundle.getBundle("Etiquetas").getString("GertaeraBikoiztu")); //$NON-NLS-1$ //$NON-NLS-2$
			btnGertaeraBikoiztu.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnGertaeraBikoiztu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GertaeraBatBikoiztuGUI gertaeraBi = new GertaeraBatBikoiztuGUI();
					gertaeraBi.setVisible(true);
				}
			});
			btnGertaeraBikoiztu.setBounds(12, 247, 370, 60);
		}
		return btnGertaeraBikoiztu;
	}
	
	private JButton getBtnDeleteUser() {
		if (btnDeleteUser == null) {
			btnDeleteUser = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DeleteUser")); //$NON-NLS-1$ //$NON-NLS-2$
			btnDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnDeleteUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DeleteErabiltzaileaGUI deleteUser = new DeleteErabiltzaileaGUI();
					deleteUser.setVisible(true);
					deleteUser.setLocationRelativeTo(null);
				}
			});
			btnDeleteUser.setBounds(12, 466, 770, 55);

		}
		return btnDeleteUser;
	}

	private JLabel getLblLangilea() {
		if (lblLangilea == null) {
			lblLangilea = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Worker")); //$NON-NLS-1$ //$NON-NLS-2$
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
			label.setBounds(0, 0, 794, 690);

			cesped = new ImageIcon(this.getClass().getResource("/cesped.jpg")).getImage().getScaledInstance(794, 690, Image.SCALE_DEFAULT);;
			label.setIcon(new ImageIcon(cesped));
		}
		return label;
	}
} // @jve:decl-index=0:visual-constraint="0,0"

