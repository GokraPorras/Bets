package gui;

import java.text.DateFormat;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

import businessLogic.BLFacade;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import domain.Event;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

public class CreateQuestionGUI extends JFrame  {

	private static BLFacade appFacadeInterface;
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

	private static final long serialVersionUID = 1L;

	private JComboBox<Event> jComboBoxEvents=new JComboBox<Event>();
	DefaultComboBoxModel<Event> modelEvents=new DefaultComboBoxModel<Event>();

	private JLabel jLabelListOfEvents = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("ListEvents"));
	private JLabel jLabelQuery = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Query"));
	private JLabel jLabelMinBet = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("MinimumBetPrice"));
	private JLabel jLabelEventDate = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("EventDate"));


	private JTextField jTextFieldQuery = new JTextField();
	private JTextField jTextFieldPrice = new JTextField();
	private JCalendar jCalendar = new JCalendar();
	private Calendar calendarMio = null;

	private JScrollPane scrollPaneEvents = new JScrollPane();


	private JButton jButtonCreate = new JButton(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
	private JButton jButtonClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close"));
	private JLabel jLabelMsg = new JLabel();
	private JLabel jLabelError = new JLabel();


	public CreateQuestionGUI()
	{
		try
		{
			jbInit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception
	{
		this.setResizable(false);

		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(760, 500));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
		this.setLocationRelativeTo(null);
		jComboBoxEvents.setFont(new Font("Tahoma", Font.PLAIN, 16));

		jComboBoxEvents.setModel(modelEvents);
		jComboBoxEvents.setBounds(new Rectangle(384, 56, 350, 30));
		jLabelListOfEvents.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelListOfEvents.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabelListOfEvents.setBounds(new Rectangle(384, 13, 350, 30));
		jLabelQuery.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelQuery.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabelQuery.setBounds(new Rectangle(22, 319, 140, 30));
		jTextFieldQuery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldQuery.setBounds(new Rectangle(174, 319, 250, 30));
		jLabelMinBet.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelMinBet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabelMinBet.setBounds(new Rectangle(22, 362, 140, 30));
		jTextFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldPrice.setBounds(new Rectangle(174, 362, 140, 30));

		jCalendar.setBounds(new Rectangle(22, 56, 350, 250));
		scrollPaneEvents.setBounds(new Rectangle(25, 44, 346, 116));
		jButtonCreate.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jButtonCreate.setBounds(new Rectangle(32, 405, 180, 40));
		jButtonCreate.setEnabled(false);

		jButtonCreate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jButtonCreate_actionPerformed(e);
			}
		});
		jButtonClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jButtonClose.setBounds(new Rectangle(554, 405, 180, 40));
		jButtonClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jButtonClose_actionPerformed(e);
			}
		});
		jLabelMsg.setFont(new Font("Tahoma", Font.PLAIN, 16));

		jLabelMsg.setBounds(new Rectangle(436, 319, 300, 30));
		jLabelMsg.setForeground(Color.red);
		jLabelError.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//jLabelMsg.setSize(new Dimension(305, 20));

		jLabelError.setBounds(new Rectangle(326, 362, 400, 30));
		jLabelError.setForeground(Color.red);


		this.getContentPane().add(jLabelMsg, null);
		this.getContentPane().add(jLabelError, null);

		this.getContentPane().add(jButtonClose, null);
		this.getContentPane().add(jButtonCreate, null);
		this.getContentPane().add(jTextFieldQuery, null);
		this.getContentPane().add(jLabelQuery, null);
		this.getContentPane().add(jTextFieldPrice, null);

		this.getContentPane().add(jLabelMinBet, null);
		this.getContentPane().add(jLabelListOfEvents, null);
		this.getContentPane().add(jComboBoxEvents, null);

		this.getContentPane().add(jCalendar, null);
		jLabelEventDate.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEventDate.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jLabelEventDate.setBounds(new Rectangle(40, 15, 140, 25));
		jLabelEventDate.setBounds(22, 13, 350, 30);
		getContentPane().add(jLabelEventDate);

		// Code for JCalendar
		this.jCalendar.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent propertychangeevent)
			{
				if (propertychangeevent.getPropertyName().equals("locale"))
				{
					jCalendar.setLocale((Locale) propertychangeevent.getNewValue());
				}
				else if (propertychangeevent.getPropertyName().equals("calendar"))
				{
					calendarMio = (Calendar) propertychangeevent.getNewValue();
					DateFormat dateformat1 = DateFormat.getDateInstance(1, jCalendar.getLocale());
					jCalendar.setCalendar(calendarMio);
					Date firstDay=trim(new Date(jCalendar.getCalendar().getTime().getTime()));

					try {

						Vector<Event> events = getBusinessLogic().getEvents(firstDay);

						if (events.isEmpty() ) jLabelListOfEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("NoEvents")+ ": "+dateformat1.format(calendarMio.getTime()));
						else jLabelListOfEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("Events")+ ": "+dateformat1.format(calendarMio.getTime()));
						jComboBoxEvents.removeAllItems();
						System.out.println("Events "+events);

						for (Event ev:events)
							modelEvents.addElement(ev);
						jComboBoxEvents.repaint();

						if (events.size()==0)
							jButtonCreate.setEnabled(false);
						else
							jButtonCreate.setEnabled(true);

					} catch (Exception e1) {
						jLabelError.setText(e1.getMessage());
					}

				}
				paintDaysWithEvents(jCalendar);
			} 
		});
	}

	private Date trim(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		return calendar.getTime();
	}

	public static void paintDaysWithEvents(JCalendar jCalendar){
		// For each day in current month, it is checked if there are events, and in that case, the background color for that day is changed.

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(jCalendar.getDate());

		calendar.set(Calendar.DAY_OF_MONTH, 1);     
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);

		int offset=calendar.get(Calendar.DAY_OF_WEEK);
		if (Locale.getDefault().equals(new Locale("es"))) offset+=4;
		else	offset+=5;

		int month=calendar.get(Calendar.MONTH);

		while (month==calendar.get(Calendar.MONTH)){

			Vector<Event> events = getBusinessLogic().getEvents(calendar.getTime());

			if (events.size()>0) {
				// Obtain the component of the day in the panel of the DayChooser of the JCalendar.
				// The component is located after the decorator buttons of "Sun", "Mon",... or "Lun", "Mar"...,
				// the empty days before day 1 of month, and all the days previous to each day.
				// That number of components is calculated with "offset" and is different in English and Spanish
				Component o=(Component) jCalendar.getDayChooser().getDayPanel().getComponent(calendar.get(Calendar.DAY_OF_MONTH)+offset);; 
				o.setBackground(Color.CYAN);
			}
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
		}
	}

	private void jButtonCreate_actionPerformed(ActionEvent e)
	{
		Event event=((Event)jComboBoxEvents.getSelectedItem());

		try {
			jLabelMsg.setForeground(Color.red);
			jLabelError.setText("");
			jLabelMsg.setText("");

			//Displays an exception if the query field is empty
			String inputQuery= jTextFieldQuery.getText();

			if (inputQuery.length()>0) {

				//It could be to trigger an exception if the introduced string is not a number
				float inputPrice= Float.parseFloat(jTextFieldPrice.getText());

				if (inputPrice<=0) jLabelError.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrorNumber"));
				else {

					getBusinessLogic().createQuestion(event, inputQuery, inputPrice); 
					jLabelMsg.setForeground(Color.green);
					jLabelMsg.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryCreated"));
				}
			} else
				jLabelMsg.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrorQuery"));

		} catch (EventFinished e1) {
			jLabelMsg.setText( ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished")+": "+event.getDescription());
		} catch (QuestionAlreadyExist e1) {
			jLabelMsg.setText( ResourceBundle.getBundle("Etiquetas").getString("ErrorQueryAlreadyExist"));
		} catch (java.lang.NumberFormatException e1) {
			jLabelError.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrorNumber"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	private void jButtonClose_actionPerformed(ActionEvent e)
	{
		this.setVisible(false);
	}

}