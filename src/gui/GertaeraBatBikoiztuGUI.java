package gui;

import com.toedter.calendar.JCalendar;

import businessLogic.BLFacade;
import domain.Event;
import exceptions.EventFinished;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.text.DateFormat;
import java.util.*;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GertaeraBatBikoiztuGUI extends JFrame {

	private static BLFacade appFacadeInterface;
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

	private static final long serialVersionUID = 1L;

	private final JLabel jLabelEventDate = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("EventDate"));
	private final JLabel jLabelEvents = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Events"));
	private final JLabel lblNewEventDate = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("NewEventDate"));
	private JButton jButtonClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close"));
	private JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("GertaeraBikoiztu"));

	// Code for JCalendar
	private JCalendar jCalendar1 = new JCalendar();
	private JCalendar jcalendar = new JCalendar();
	private Calendar calendarMio = null;
	private JScrollPane scrollPaneEvents = new JScrollPane();

	private JTable tableEvents= new JTable();


	private DefaultTableModel tableModelEvents;

	private String[] columnNamesEvents = new String[] {
			ResourceBundle.getBundle("Etiquetas").getString("EventN"), 
			ResourceBundle.getBundle("Etiquetas").getString("Event"), 

	};
	private final JLabel lblNewLabel = new JLabel(); //$NON-NLS-1$ //$NON-NLS-2$

	public GertaeraBatBikoiztuGUI()
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
		this.setSize(new Dimension(760, 725));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("GertaeraBikoiztu"));
		this.setLocationRelativeTo(null);
		jLabelEventDate.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEventDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabelEventDate.setBounds(new Rectangle(22, 19, 350, 30));
		jLabelEvents.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabelEvents.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEvents.setBounds(22, 325, 712, 30);
		lblNewEventDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewEventDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewEventDate.setBounds(384, 19, 350, 30);


		this.getContentPane().add(jLabelEventDate);
		this.getContentPane().add(jLabelEvents);
		this.getContentPane().add(lblNewEventDate);

		jButtonClose.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jButtonClose.setBounds(new Rectangle(554, 631, 180, 40));

		jButtonClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}
		});

		this.getContentPane().add(jButtonClose, null);


		jCalendar1.setBounds(new Rectangle(22, 62, 350, 250));


		// Code for JCalendar
		this.jCalendar1.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent propertychangeevent)
			{
				if (propertychangeevent.getPropertyName().equals("locale"))
				{
					jCalendar1.setLocale((Locale) propertychangeevent.getNewValue());
				}
				else if (propertychangeevent.getPropertyName().equals("calendar"))
				{
					calendarMio = (Calendar) propertychangeevent.getNewValue();
					DateFormat dateformat1 = DateFormat.getDateInstance(1, jCalendar1.getLocale());
					jCalendar1.setCalendar(calendarMio);
					Date firstDay=trim(new Date(jCalendar1.getCalendar().getTime().getTime()));
					btnNewButton.setEnabled(false);
					try {
						// calendar invisible
						jcalendar.setVisible(false);
						btnNewButton.setVisible(true);
						tableModelEvents.setDataVector(null, columnNamesEvents);
						tableModelEvents.setColumnCount(3); // another column added to allocate ev objects

						//	getEvents
						Vector<Event> events = getBusinessLogic().getEvents(firstDay);

						if (events.isEmpty() ) jLabelEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("NoEvents")+ ": "+dateformat1.format(calendarMio.getTime()));
						else jLabelEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("Events")+ ": "+dateformat1.format(calendarMio.getTime()));
						for (Event ev:events){
							Vector<Object> row = new Vector<Object>();

							System.out.println("Events "+ev);

							row.add(ev.getEventNumber());
							row.add(ev.getDescription());
							row.add(ev); // ev object added in order to obtain it with tableModelEvents.getValueAt(i,2)
							tableModelEvents.addRow(row);		
						}
						tableEvents.getColumnModel().getColumn(0).setPreferredWidth(25);
						tableEvents.getColumnModel().getColumn(1).setPreferredWidth(268);
						tableEvents.getColumnModel().removeColumn(tableEvents.getColumnModel().getColumn(2)); // not shown in JTable
					} catch (Exception e1) {
						jLabelEvents.setText(e1.getMessage());
					}

				}
				CreateQuestionGUI.paintDaysWithEvents(jCalendar1);
			} 
		});

		this.getContentPane().add(jCalendar1, null);

		scrollPaneEvents.setBounds(new Rectangle(22, 368, 712, 250));
		tableEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// calendar visible
				jcalendar.setVisible(true);
			}
		});

		scrollPaneEvents.setViewportView(tableEvents);
		tableModelEvents = new DefaultTableModel(null, columnNamesEvents) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tableEvents.setModel(tableModelEvents);
		tableEvents.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableEvents.getColumnModel().getColumn(1).setPreferredWidth(268);

		tableEvents.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
		tableEvents.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableEvents.setRowHeight(25);

		DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer)tableEvents.getDefaultRenderer(Object.class);
		renderer1.setHorizontalAlignment( JLabel.CENTER );


		this.getContentPane().add(scrollPaneEvents, null);

		lblNewLabel.setBounds(527, 428, 46, 14);

		getContentPane().add(lblNewLabel);

		jcalendar.setBounds(new Rectangle(40, 50, 225, 150));
		jcalendar.setBounds(384, 62, 350, 250);
		getContentPane().add(jcalendar);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Date firstDay=trim(new Date(jcalendar.getCalendar().getTime().getTime()));

				int i = tableEvents.getSelectedRow();
				Event ev = (Event) tableModelEvents.getValueAt(i,2); // obtain ev object

				try {

					Vector<Event> events = getBusinessLogic().getEvents(firstDay);
					boolean aurkitua = false;

					for (int j = 0; j < events.size(); j++) {
						if (events.get(j).getDescription().compareTo(ev.getDescription()) == 0) {
							aurkitua = true;
							break;
						}
					}

					if (aurkitua)
						JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
					else
						getBusinessLogic().gertaeraBatBikoiztu(ev, firstDay);
				} catch (EventFinished e1) {
					JOptionPane.showMessageDialog(null,e1,"Error",JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e2) {
					e2.printStackTrace();
				}
				CreateQuestionGUI.paintDaysWithEvents(jcalendar);
				CreateQuestionGUI.paintDaysWithEvents(jCalendar1);
			}
		});
		btnNewButton.setBounds(288, 631, 180, 40);
		btnNewButton.setEnabled(false);
		getContentPane().add(btnNewButton);

		// calendar invisible
		jcalendar.setVisible(false);


		// Code for JCalendar
		this.jcalendar.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent propertychangeevent)
			{

				if (propertychangeevent.getPropertyName().equals("locale"))
				{
					jcalendar.setLocale((Locale) propertychangeevent.getNewValue());

				}
				else if (propertychangeevent.getPropertyName().equals("calendar"))
				{
					calendarMio = (Calendar) propertychangeevent.getNewValue();
					jcalendar.setCalendar(calendarMio);
					btnNewButton.setEnabled(true);

				}



				CreateQuestionGUI.paintDaysWithEvents(jcalendar);


			}

		});

	}

	private void jButton2_actionPerformed(ActionEvent e) {
		this.setVisible(false);
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
}

