package gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import businessLogic.BLFacade;
import domain.Event;
import java.awt.Font;
import javax.swing.SwingConstants;



public class DeleteEventsGUI extends JFrame {

	private static BLFacade appFacadeInterface;
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

	private static final long serialVersionUID = 1L;

	private static Vector<Event> events;


	private final JLabel jLabelEventDate = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("EventDate"));
	private final JLabel jLabelEvents = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Events")); 
	private JButton jButtonClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close"));

	// Code for JCalendar
	private JCalendar jCalendar1 = new JCalendar();
	private static Date firstDay;
	private static DateFormat dateformat1;
	private Calendar calendarMio = null;
	private JScrollPane scrollPaneEvents = new JScrollPane();

	private JTable tableEvents= new JTable();


	private DefaultTableModel tableModelEvents;

	private String[] columnNamesEvents = new String[] {
			ResourceBundle.getBundle("Etiquetas").getString("EventN"), 
			ResourceBundle.getBundle("Etiquetas").getString("Event"), 

	};

	private final JButton btnDeleteEvent = new JButton(ResourceBundle.getBundle("Etiquetas").getString("deleteEvent")); //$NON-NLS-1$ //$NON-NLS-2$

	public DeleteEventsGUI()
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
		this.setSize(new Dimension(915, 425));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("deleteEvent"));
		this.setLocationRelativeTo(null);
		jLabelEventDate.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEventDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabelEventDate.setBounds(new Rectangle(22, 13, 350, 30));
		jLabelEvents.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEvents.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabelEvents.setBounds(460, 13, 425, 30);

		this.getContentPane().add(jLabelEventDate, null);
		this.getContentPane().add(jLabelEvents);
		jButtonClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jButtonClose.setBounds(new Rectangle(705, 337, 180, 40));

		jButtonClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}
		});

		this.getContentPane().add(jButtonClose, null);

		jCalendar1.setBounds(new Rectangle(22, 56, 350, 250));

		// Code for JCalendar
		this.jCalendar1.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent propertychangeevent)
			{
				btnDeleteEvent.setEnabled(false);

				if (propertychangeevent.getPropertyName().equals("locale"))
				{
					jCalendar1.setLocale((Locale) propertychangeevent.getNewValue());
				}
				else if (propertychangeevent.getPropertyName().equals("calendar"))
				{
					calendarMio = (Calendar) propertychangeevent.getNewValue();
					dateformat1 = DateFormat.getDateInstance(1, jCalendar1.getLocale());
					jCalendar1.setCalendar(calendarMio);
					firstDay=trim(new Date(jCalendar1.getCalendar().getTime().getTime()));

					try {
						tableModelEvents.setDataVector(null, columnNamesEvents);
						tableModelEvents.setColumnCount(3); // another column added to allocate ev objects

						events = getBusinessLogic().getEvents(firstDay);

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


					}

				}
				CreateQuestionGUI.paintDaysWithEvents(jCalendar1);
			} 
		});

		this.getContentPane().add(jCalendar1, null);

		scrollPaneEvents.setBounds(new Rectangle(460, 56, 425, 250));

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
		btnDeleteEvent.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnDeleteEvent.setEnabled(false);
		btnDeleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, ResourceBundle.getBundle("Etiquetas").getString("DeleteEvent?"),ResourceBundle.getBundle("Etiquetas").getString("Warning") , JOptionPane.YES_NO_OPTION);

				if(resp == 0) {
					int row = tableEvents.getSelectedRow();

					try {
						getBusinessLogic().deleteEvent(events.elementAt(row));
						repaintevents();
						btnDeleteEvent.setEnabled(false);
						JOptionPane.showMessageDialog(null, ResourceBundle.getBundle("Etiquetas").getString("deleteCompleteEvent"));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		tableEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent q) {

				btnDeleteEvent.setEnabled(true);

			}
		});
		btnDeleteEvent.setBounds(460, 337, 180, 40);
		getContentPane().add(btnDeleteEvent);
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

	private void repaintevents() {
		tableModelEvents.setDataVector(null, columnNamesEvents);

		events = getBusinessLogic().getEvents(firstDay);

		if (events.isEmpty()) 
			jLabelEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("NoEvents")+ ": "+dateformat1.format(calendarMio.getTime()));
		else 
			jLabelEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("Events")+ ": "+dateformat1.format(calendarMio.getTime()));

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
	}

}
