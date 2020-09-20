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
import domain.Question;
import java.awt.Font;
import javax.swing.SwingConstants;


public class DeleteQuestionsGUI extends JFrame {

	private static BLFacade appFacadeInterface;
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

	private static final long serialVersionUID = 1L;

	private static Vector<Question> questions;

	private final JLabel jLabelEventDate = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("EventDate"));
	private final JLabel jLabelQueries = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Queries")); 
	private final JLabel jLabelEvents = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Events")); 
	private JButton jButtonClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close"));

	// Code for JCalendar
	private JCalendar jCalendar1 = new JCalendar();
	private Calendar calendarMio = null;
	private JScrollPane scrollPaneEvents = new JScrollPane();
	private JScrollPane scrollPaneQueries = new JScrollPane();

	private JTable tableEvents= new JTable();
	private JTable tableQueries = new JTable();


	private DefaultTableModel tableModelEvents;
	private DefaultTableModel tableModelQueries;

	private String[] columnNamesEvents = new String[] {
			ResourceBundle.getBundle("Etiquetas").getString("EventN"), 
			ResourceBundle.getBundle("Etiquetas").getString("Event"), 

	};
	private String[] columnNamesQueries = new String[] {
			ResourceBundle.getBundle("Etiquetas").getString("QueryN"), 
			ResourceBundle.getBundle("Etiquetas").getString("Query")

	};

	private final JButton btnDeleteQuestion = new JButton(ResourceBundle.getBundle("Etiquetas").getString("deleteQuestion")); //$NON-NLS-1$ //$NON-NLS-2$

	public DeleteQuestionsGUI()
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
		this.setSize(new Dimension(915, 715));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("deleteQuestion"));
		this.setLocationRelativeTo(null);
		jLabelEventDate.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEventDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabelEventDate.setBounds(new Rectangle(22, 13, 350, 30));
		jLabelQueries.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelQueries.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabelQueries.setBounds(12, 319, 885, 30);
		jLabelEvents.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEvents.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabelEvents.setBounds(460, 13, 425, 30);

		this.getContentPane().add(jLabelEventDate, null);
		this.getContentPane().add(jLabelQueries);
		this.getContentPane().add(jLabelEvents);
		jButtonClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jButtonClose.setBounds(new Rectangle(487, 625, 180, 40));

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
				btnDeleteQuestion.setEnabled(false);

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
					btnDeleteQuestion.setEnabled(false);

					try {
						tableModelEvents.setDataVector(null, columnNamesEvents);
						tableModelEvents.setColumnCount(3); // another column added to allocate ev objects

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

						jLabelQueries.setText(e1.getMessage());
					}

				}
				CreateQuestionGUI.paintDaysWithEvents(jCalendar1);
				
				tableModelQueries.setDataVector(null, columnNamesQueries);
			} 
		});

		this.getContentPane().add(jCalendar1, null);

		scrollPaneEvents.setBounds(new Rectangle(460, 56, 425, 250));
		scrollPaneQueries.setBounds(new Rectangle(242, 362, 425, 250));
		tableEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableEvents.getSelectedRow();
				Event ev = (Event)tableModelEvents.getValueAt(i,2); // obtain ev object

				questions = getBusinessLogic().getQuestions(ev);


				tableModelQueries.setDataVector(null, columnNamesQueries);
				tableModelQueries.setColumnCount(3); // another column added to allocate qu objects

				if (questions.isEmpty())
					jLabelQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("NoQueries")+": "+ev.getDescription());
				else 
					jLabelQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectedEvent")+" "+ev.getDescription());

				for (Question q:questions){
					Vector<Object> row = new Vector<Object>();

					row.add(q.getQuestionNumber());
					row.add(q.getQuestion());
					row.add(q);
					tableModelQueries.addRow(row);
				}
				tableQueries.getColumnModel().getColumn(0).setPreferredWidth(25);
				tableQueries.getColumnModel().getColumn(1).setPreferredWidth(268);
				tableQueries.getColumnModel().removeColumn(tableQueries.getColumnModel().getColumn(2));
				btnDeleteQuestion.setEnabled(false);// not shown in JTable
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


		scrollPaneQueries.setViewportView(tableQueries);
		tableModelQueries = new DefaultTableModel(null, columnNamesQueries) {

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

		tableQueries.setModel(tableModelQueries);
		tableQueries.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableQueries.getColumnModel().getColumn(1).setPreferredWidth(268);
		
		tableQueries.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
		tableQueries.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableQueries.setRowHeight(25);

		DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer)tableQueries.getDefaultRenderer(Object.class);
		renderer2.setHorizontalAlignment( JLabel.CENTER );
		

		this.getContentPane().add(scrollPaneEvents, null);
		this.getContentPane().add(scrollPaneQueries, null);
		btnDeleteQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnDeleteQuestion.setEnabled(false);
		btnDeleteQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, ResourceBundle.getBundle("Etiquetas").getString("DeleteQuestion?"),ResourceBundle.getBundle("Etiquetas").getString("Warning") , JOptionPane.YES_NO_OPTION);

				if(resp == 0) {
					int row = tableQueries.getSelectedRow();

					try {
						getBusinessLogic().deleteQuestion(questions.elementAt(row));
						repaintquestions();
						btnDeleteQuestion.setEnabled(false);
						JOptionPane.showMessageDialog(null, ResourceBundle.getBundle("Etiquetas").getString("deleteCompleteQuestion"));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		tableQueries.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent q) {

				btnDeleteQuestion.setEnabled(true);

			}
		});
		btnDeleteQuestion.setBounds(242, 625, 180, 40);
		getContentPane().add(btnDeleteQuestion);
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

	private void repaintquestions() {
		int i = tableEvents.getSelectedRow();
		Event ev = (Event)tableModelEvents.getValueAt(i,2); // obtain ev object

		questions = getBusinessLogic().getQuestions(ev);

		tableModelQueries.setDataVector(null, columnNamesQueries);
		tableModelQueries.setColumnCount(3); // another column added to allocate qu objects

		if (questions.isEmpty())
			jLabelQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("NoQueries")+": "+ev.getDescription());
		else 
			jLabelQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectedEvent")+" "+ev.getDescription());

		for (Question q:questions){
			Vector<Object> row = new Vector<Object>();

			row.add(q.getQuestionNumber());
			row.add(q.getQuestion());
			row.add(q);
			tableModelQueries.addRow(row);
		}
		tableQueries.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableQueries.getColumnModel().getColumn(1).setPreferredWidth(268);
		tableQueries.getColumnModel().removeColumn(tableQueries.getColumnModel().getColumn(2)); // not shown in JTable
	}

}
