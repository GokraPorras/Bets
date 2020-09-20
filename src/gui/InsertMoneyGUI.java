package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import businessLogic.BLFacade;
import domain.Erabiltzailea;
import exceptions.MaximumMoneyInserted;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class InsertMoneyGUI extends JFrame {

	private static BLFacade appFacadeInterface;
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

	private static Erabiltzailea erabiltzailea;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JLabel lblZenbatDiruSartu;
	private JButton btnSartu;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertMoneyGUI frame = new InsertMoneyGUI();
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
	public InsertMoneyGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblZenbatDiruSartu = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("HowMoneyInsert"));
		lblZenbatDiruSartu.setHorizontalAlignment(SwingConstants.CENTER);
		lblZenbatDiruSartu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblZenbatDiruSartu.setBounds(0, 29, 300, 20);
		contentPane.add(lblZenbatDiruSartu);

		textField = new JTextField();
		textField.setBounds(37, 71, 215, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		final JLabel labelMsg = new JLabel("New label");
		labelMsg.setHorizontalAlignment(SwingConstants.CENTER);
		labelMsg.setBounds(37, 50, 215, 14);
		labelMsg.setForeground(Color.red);
		contentPane.add(labelMsg);

		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(10, 149, 280, 40);

		// erabiltzailea gordetzen da
		erabiltzailea = getBusinessLogic().getErabiltzailea(gui.UnRegisteredGUI.erab);

		label.setText(ResourceBundle.getBundle("Etiquetas").getString("YourMoney")+" "+Float.toString(getBusinessLogic().getDirua(erabiltzailea))+" "+"\u20ac");
		contentPane.add(label);
		btnSartu = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MoneyInsert"));
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				labelMsg.setForeground(Color.red);
				try {
					//Displays an exception if the query field is empty
					String inputQuery= textField.getText();

					if (inputQuery.length()>0) {

						//It could be to trigger an exception if the introduced string is not a number
						float inputPrice = Float.parseFloat(textField.getText());

						if (inputPrice<=0) labelMsg.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrorNumber"));
						else {
							getBusinessLogic().addDirua(erabiltzailea, inputPrice);

							labelMsg.setForeground(Color.GREEN);
							labelMsg.setText(ResourceBundle.getBundle("Etiquetas").getString("CorrectDeposit"));
							label.setText(ResourceBundle.getBundle("Etiquetas").getString("YourMoney")+" "+Float.toString(getBusinessLogic().getDirua(erabiltzailea))+" "+"\u20ac");
						}

					} else
						labelMsg.setText(ResourceBundle.getBundle("Etiquetas").getString("DepositSomething"));
				}

				catch (java.lang.NumberFormatException e1) {
					labelMsg.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrorNumber"));
				}catch (MaximumMoneyInserted e1) {
					labelMsg.setText(ResourceBundle.getBundle("Etiquetas").getString("MaxMoneyInsert"));
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnSartu.setBounds(26, 115, 127, 23);
		contentPane.add(btnSartu);
		labelMsg.setText("");
		JButton btnAtzera = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Back"));
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				gui.ErabiltzaileaGUI.irekita = false;
				dispose();

			}
		});
		btnAtzera.setBounds(163, 115, 114, 23);
		contentPane.add(btnAtzera);
	}
}
