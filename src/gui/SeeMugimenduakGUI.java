package gui;

import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import businessLogic.BLFacade;
import domain.Mugimendua;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class SeeMugimenduakGUI extends JFrame {

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

	private DefaultTableModel tableModelMugimenduak;
	private String[] columnMugNames = new String[] {
			ResourceBundle.getBundle("Etiquetas").getString("Data"),
			ResourceBundle.getBundle("Etiquetas").getString("hasierakoDirua"),
			ResourceBundle.getBundle("Etiquetas").getString("DiruHeina"),
			ResourceBundle.getBundle("Etiquetas").getString("bukaerakoDirua"),
			ResourceBundle.getBundle("Etiquetas").getString("Mota"),
	};
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the frame.
	 */
	public SeeMugimenduakGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("SeeMovements"));
		setBounds(100, 100, 1400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		JScrollPane scrollPane = new JScrollPane();

		JRadioButton rdbtnApustua = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("APUSTUA")); //$NON-NLS-1$ //$NON-NLS-2$
		buttonGroup.add(rdbtnApustua);

		JRadioButton rdbtnSarrera = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("SARRERA")); //$NON-NLS-1$ //$NON-NLS-2$

		buttonGroup.add(rdbtnSarrera);

		JRadioButton rdbtnApustuanitza = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("APUSTU-ANITZA"));

		buttonGroup.add(rdbtnApustuanitza);

		JRadioButton rdbtnIrabazi = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("IRABAZIA")); //$NON-NLS-1$ //$NON-NLS-2$

		buttonGroup.add(rdbtnIrabazi);

		JRadioButton rdbtnGaldu = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("GALDU")); //$NON-NLS-1$ //$NON-NLS-2$

		buttonGroup.add(rdbtnGaldu);

		JRadioButton rdbtnItzulketa = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("ITZULKETA")); //$NON-NLS-1$ //$NON-NLS-2$

		buttonGroup.add(rdbtnItzulketa);

		JRadioButton rdbtnGuztiak = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("GUZTIAK")); //$NON-NLS-1$ //$NON-NLS-2$
		buttonGroup.add(rdbtnGuztiak);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1342, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(rdbtnSarrera)
																.addGap(18))
														.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
																.addComponent(rdbtnGuztiak)
																.addGap(32)))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(rdbtnApustua)
														.addGap(32)))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(rdbtnApustuanitza)
												.addComponent(rdbtnItzulketa, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(rdbtnIrabazi)
														.addGap(47)
														.addComponent(rdbtnGaldu)))
										.addGap(314)))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnGuztiak)
								.addComponent(rdbtnApustuanitza))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnApustua)
								.addComponent(rdbtnIrabazi)
								.addComponent(rdbtnGaldu))
						.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnSarrera)
								.addComponent(rdbtnItzulketa))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		JTable table = new JTable();

		scrollPane.setViewportView(table);
		tableModelMugimenduak = new DefaultTableModel(null, columnMugNames) {

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
		table.setModel(tableModelMugimenduak);
		contentPane.setLayout(gl_contentPane);

		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));

		table.setRowHeight(25);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
		renderer.setHorizontalAlignment( JLabel.CENTER );

		Vector<Mugimendua> mugimenduak = getBusinessLogic().getMugimenduak(gui.UnRegisteredGUI.erab);

		for (Mugimendua m : mugimenduak) {
			System.out.println(m.getDiruHeina());

			int numCols = table.getModel().getColumnCount();
			Object[] fila = new Object[numCols];
			fila[0] = m.getData().toString();
			fila[1] = Float.toString(m.getHasierakoDirua());
			fila[3] = Float.toString(m.getBukaerakoDirua());
			fila[4] = ResourceBundle.getBundle("Etiquetas").getString(m.getMota());

			if(m.getDiruHeina()>0)
				fila[2] = "+" + Float.toString(m.getDiruHeina());
			else if(m.getDiruHeina()<0)
				fila[2] = Float.toString(m.getDiruHeina());
			else
				fila[2] = "\u00B1" + Float.toString(m.getDiruHeina());

			((DefaultTableModel) table.getModel()).addRow(fila);
		}

		rdbtnApustua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vector<Mugimendua> mugimenduak = getBusinessLogic().getMugimenduak(gui.UnRegisteredGUI.erab);
				tableModelMugimenduak.setDataVector(null, columnMugNames);
				for (Mugimendua m : mugimenduak) {

					if(m.getMota().compareTo("APUSTUA")==0) {
						System.out.println(m.getDiruHeina());

						int numCols = table.getModel().getColumnCount();
						Object[] fila = new Object[numCols];
						fila[0] = m.getData().toString();
						fila[1] = Float.toString(m.getHasierakoDirua());
						fila[3] = Float.toString(m.getBukaerakoDirua());
						fila[4] = ResourceBundle.getBundle("Etiquetas").getString(m.getMota());

						if(m.getDiruHeina()>0)
							fila[2] = "+" + Float.toString(m.getDiruHeina());
						else if(m.getDiruHeina()<0)
							fila[2] = Float.toString(m.getDiruHeina());
						else
							fila[2] = "\u00B1" + Float.toString(m.getDiruHeina());

						((DefaultTableModel) table.getModel()).addRow(fila);
					}
				}
			}
		});
		rdbtnSarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Mugimendua> mugimenduak = getBusinessLogic().getMugimenduak(gui.UnRegisteredGUI.erab);
				tableModelMugimenduak.setDataVector(null, columnMugNames);
				for (Mugimendua m : mugimenduak) {

					if(m.getMota().compareTo("SARRERA")==0) {
						System.out.println(m.getDiruHeina());

						int numCols = table.getModel().getColumnCount();
						Object[] fila = new Object[numCols];
						fila[0] = m.getData().toString();
						fila[1] = Float.toString(m.getHasierakoDirua());
						fila[3] = Float.toString(m.getBukaerakoDirua());
						fila[4] = ResourceBundle.getBundle("Etiquetas").getString(m.getMota());

						if(m.getDiruHeina()>0)
							fila[2] = "+" + Float.toString(m.getDiruHeina());
						else if(m.getDiruHeina()<0)
							fila[2] = Float.toString(m.getDiruHeina());
						else
							fila[2] = "\u00B1" + Float.toString(m.getDiruHeina());

						((DefaultTableModel) table.getModel()).addRow(fila);
					}
				}
			}
		});


		rdbtnApustuanitza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Mugimendua> mugimenduak = getBusinessLogic().getMugimenduak(gui.UnRegisteredGUI.erab);
				tableModelMugimenduak.setDataVector(null, columnMugNames);
				for (Mugimendua m : mugimenduak) {
					if(m.getMota().compareTo("APUSTU-ANITZA")==0) {
						System.out.println(m.getDiruHeina());

						int numCols = table.getModel().getColumnCount();
						Object[] fila = new Object[numCols];
						fila[0] = m.getData().toString();
						fila[1] = Float.toString(m.getHasierakoDirua());
						fila[3] = Float.toString(m.getBukaerakoDirua());
						fila[4] = ResourceBundle.getBundle("Etiquetas").getString(m.getMota());

						if(m.getDiruHeina()>0)
							fila[2] = "+" + Float.toString(m.getDiruHeina());
						else if(m.getDiruHeina()<0)
							fila[2] = Float.toString(m.getDiruHeina());
						else
							fila[2] = "\u00B1" + Float.toString(m.getDiruHeina());

						((DefaultTableModel) table.getModel()).addRow(fila);
					}
				}
			}
		});
		rdbtnIrabazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Mugimendua> mugimenduak = getBusinessLogic().getMugimenduak(gui.UnRegisteredGUI.erab);
				tableModelMugimenduak.setDataVector(null, columnMugNames);
				for (Mugimendua m : mugimenduak) {

					if(m.getMota().compareTo("IRABAZIA")==0) {
						System.out.println(m.getDiruHeina());

						int numCols = table.getModel().getColumnCount();
						Object[] fila = new Object[numCols];
						fila[0] = m.getData().toString();
						fila[1] = Float.toString(m.getHasierakoDirua());
						fila[3] = Float.toString(m.getBukaerakoDirua());
						fila[4] = ResourceBundle.getBundle("Etiquetas").getString(m.getMota());

						if(m.getDiruHeina()>0)
							fila[2] = "+" + Float.toString(m.getDiruHeina());
						else if(m.getDiruHeina()<0)
							fila[2] = Float.toString(m.getDiruHeina());
						else
							fila[2] = "\u00B1" + Float.toString(m.getDiruHeina());

						((DefaultTableModel) table.getModel()).addRow(fila);
					}
				}
			}
		});
		rdbtnGaldu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Mugimendua> mugimenduak = getBusinessLogic().getMugimenduak(gui.UnRegisteredGUI.erab);
				tableModelMugimenduak.setDataVector(null, columnMugNames);
				for (Mugimendua m : mugimenduak) {
					if(m.getMota().compareTo("IRABAZIA")==0) {
						System.out.println(m.getDiruHeina());

						int numCols = table.getModel().getColumnCount();
						Object[] fila = new Object[numCols];
						fila[0] = m.getData().toString();
						fila[1] = Float.toString(m.getHasierakoDirua());
						fila[3] = Float.toString(m.getBukaerakoDirua());
						fila[4] = ResourceBundle.getBundle("Etiquetas").getString(m.getMota());

						if(m.getDiruHeina()>0)
							fila[2] = "+" + Float.toString(m.getDiruHeina());
						else if(m.getDiruHeina()<0)
							fila[2] = Float.toString(m.getDiruHeina());
						else
							fila[2] = "\u00B1" + Float.toString(m.getDiruHeina());

						((DefaultTableModel) table.getModel()).addRow(fila);
					}
				}
			}
		});

		rdbtnItzulketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Mugimendua> mugimenduak = getBusinessLogic().getMugimenduak(gui.UnRegisteredGUI.erab);
				tableModelMugimenduak.setDataVector(null, columnMugNames);
				for (Mugimendua m : mugimenduak) {

					if(m.getMota().compareTo("ITZULKETA")==0) {
						System.out.println(m.getDiruHeina());

						int numCols = table.getModel().getColumnCount();
						Object[] fila = new Object[numCols];
						fila[0] = m.getData().toString();
						fila[1] = Float.toString(m.getHasierakoDirua());
						fila[3] = Float.toString(m.getBukaerakoDirua());
						fila[4] = ResourceBundle.getBundle("Etiquetas").getString(m.getMota());

						if(m.getDiruHeina()>0)
							fila[2] = "+" + Float.toString(m.getDiruHeina());
						else if(m.getDiruHeina()<0)
							fila[2] = Float.toString(m.getDiruHeina());
						else
							fila[2] = "\u00B1" + Float.toString(m.getDiruHeina());

						((DefaultTableModel) table.getModel()).addRow(fila);
					}
				}
			}
		});

		rdbtnGuztiak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Mugimendua> mugimenduak = getBusinessLogic().getMugimenduak(gui.UnRegisteredGUI.erab);
				tableModelMugimenduak.setDataVector(null, columnMugNames);
				for (Mugimendua m : mugimenduak) {
					System.out.println(m.getDiruHeina());

					int numCols = table.getModel().getColumnCount();
					Object[] fila = new Object[numCols];
					fila[0] = m.getData().toString();
					fila[1] = Float.toString(m.getHasierakoDirua());
					fila[3] = Float.toString(m.getBukaerakoDirua());
					fila[4] = ResourceBundle.getBundle("Etiquetas").getString(m.getMota());

					if(m.getDiruHeina()>0)
						fila[2] = "+" + Float.toString(m.getDiruHeina());
					else if(m.getDiruHeina()<0)
						fila[2] = Float.toString(m.getDiruHeina());
					else
						fila[2] = "\u00B1" + Float.toString(m.getDiruHeina());

					((DefaultTableModel) table.getModel()).addRow(fila);
				}
			}
		});

	}
}
