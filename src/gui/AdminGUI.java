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

public class AdminGUI extends JFrame {

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
	private JButton btnDeletefee=null;
	private JButton btnNewButton_2=null;
	private JButton btnNewButton_1=null;
	private JButton btnNewButton=null;
	private JButton btnDeleteQuestion;
	private JButton btnDeleteEvent;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnLogout;
	private JLabel lblAdmin;
	private JButton btnProfit=null;
	private JButton btnDeleteUser;
	private JButton btnGertaeraBikoiztu;
	private JLabel label;

	private Image cesped;

	/**
	 * This is the default constructor
	 */
	public AdminGUI() {
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
		this.setSize(887, 725);
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
			jContentPane.add(getBoton2());
			jContentPane.add(getPanel());
			jContentPane.add(getLblAdmin());

			btnNewButton=new JButton();
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnNewButton.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateFee"));  //$NON-NLS-1$ //$NON-NLS-2$
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CreateFeesGUI createFees = new CreateFeesGUI();
					createFees.setVisible(true);

				}
			});
			btnNewButton.setBounds(12, 393, 370, 60);
			jContentPane.add(btnNewButton);

			btnNewButton_1=new JButton();
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnNewButton_1.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateWorker"));//$NON-NLS-1$ //$NON-NLS-2$
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					CreateWorkerGUI createWorker = new CreateWorkerGUI();
					createWorker.setVisible(true);

				}
			});
			btnNewButton_1.setBounds(12, 466, 370, 55);
			jContentPane.add(btnNewButton_1);

			btnNewButton_2=new JButton();
			btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnNewButton_2.setText(ResourceBundle.getBundle("Etiquetas").getString("PutResult"));  //$NON-NLS-1$ //$NON-NLS-2$
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					PutResultGUI putResult = new PutResultGUI();
					putResult.setVisible(true);

				}
			});
			btnNewButton_2.setBounds(12, 534, 858, 60);
			jContentPane.add(btnNewButton_2);

			btnDeletefee=new JButton();
			btnDeletefee.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnDeletefee.setText(ResourceBundle.getBundle("Etiquetas").getString("DeleteFee")); //$NON-NLS-1$ //$NON-NLS-2$
			btnDeletefee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					DeleteFeesGUI deleteFees = new DeleteFeesGUI();
					deleteFees.setVisible(true);

				}
			});
			btnDeletefee.setBounds(500, 393, 370, 60);
			jContentPane.add(btnDeletefee);
			jContentPane.add(getBtnProfit());

			btnDeleteQuestion = new JButton(ResourceBundle.getBundle("Etiquetas").getString("deleteQuestion")); //$NON-NLS-1$ //$NON-NLS-2$
			btnDeleteQuestion.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnDeleteQuestion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DeleteQuestionsGUI delquestion = new DeleteQuestionsGUI();
					delquestion.setVisible(true);
				}
			});
			btnDeleteQuestion.setBounds(500, 320, 370, 60);
			jContentPane.add(btnDeleteQuestion);
			jContentPane.add(getBtnDeleteUser());

			btnDeleteEvent = new JButton(ResourceBundle.getBundle("Etiquetas").getString("deleteEvent")); //$NON-NLS-1$ //$NON-NLS-2$
			btnDeleteEvent.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnDeleteEvent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DeleteEventsGUI delevent = new DeleteEventsGUI();
					delevent.setVisible(true);
				}
			});
			btnDeleteEvent.setBounds(500, 249, 370, 60);
			jContentPane.add(btnDeleteEvent);
			jContentPane.add(getBtnGertaeraBikoiztu());
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
			jButtonQueryQueries.setBounds(12, 174, 858, 60);
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
			panel.setBounds(210, 634, 458, 43);
			panel.add(getRdbtnNewRadioButton_1());
			panel.add(getRdbtnNewRadioButton_2());
			panel.add(getRdbtnNewRadioButton());
		}
		return panel;
	}

	private void redibujar() {
		jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
		jButtonCreateQuery.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
		btnLogout.setText(ResourceBundle.getBundle("Etiquetas").getString("Logout"));
		lblAdmin.setText(ResourceBundle.getBundle("Etiquetas").getString("Admin"));
		btnDeletefee.setText(ResourceBundle.getBundle("Etiquetas").getString("DeleteFee"));
		btnNewButton_2.setText(ResourceBundle.getBundle("Etiquetas").getString("PutResult"));
		btnNewButton_1.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateWorker"));
		btnNewButton.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateFee"));
		btnProfit.setText(ResourceBundle.getBundle("Etiquetas").getString("Profit"));
		btnDeleteUser.setText(ResourceBundle.getBundle("Etiquetas").getString("DeleteUser"));
		btnDeleteQuestion.setText(ResourceBundle.getBundle("Etiquetas").getString("deleteQuestion"));
		btnDeleteEvent.setText(ResourceBundle.getBundle("Etiquetas").getString("deleteEvent"));
		btnGertaeraBikoiztu.setText(ResourceBundle.getBundle("Etiquetas").getString("GertaeraBikoiztu"));

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
			btnLogout.setBounds(650, 84, 220, 60);
		}
		return btnLogout;
	}

	private JLabel getLblAdmin() {
		if (lblAdmin == null) {
			lblAdmin = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Admin")); //$NON-NLS-1$ //$NON-NLS-2$
			lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdmin.setForeground(Color.PINK);
			lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblAdmin.setBounds(12, 0, 858, 43);
		}
		return lblAdmin;
	}
	private JButton getBtnProfit() {
		if (btnProfit == null) {
			btnProfit = new JButton();
			btnProfit.setBackground(Color.ORANGE);
			btnProfit.setForeground(Color.BLUE);
			btnProfit.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnProfit.setText(ResourceBundle.getBundle("Etiquetas").getString("Profit")); //$NON-NLS-1$ //$NON-NLS-2$
			btnProfit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, ResourceBundle.getBundle("Etiquetas").getString("SistemarenIrabaziak") + "  " + Float.toString(getBusinessLogic().getIrabazia())+"\u20ac", "Bets",JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnProfit.setBounds(12, 86, 220, 60);
		}
		return btnProfit;
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
			btnDeleteUser.setBounds(500, 466, 370, 55);

		}
		return btnDeleteUser;
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
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel(); //$NON-NLS-1$ //$NON-NLS-2$
			label.setBounds(0, 0, 900, 725);

			cesped = new ImageIcon(this.getClass().getResource("/Thanos.jpg")).getImage().getScaledInstance(910, 725, Image.SCALE_SMOOTH);;
			label.setIcon(new ImageIcon(cesped));
		}
		return label;
	}
} // @jve:decl-index=0:visual-constraint="0,0"

