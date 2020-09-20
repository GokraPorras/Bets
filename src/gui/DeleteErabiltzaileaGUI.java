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
import domain.Erabiltzailea;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class DeleteErabiltzaileaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BLFacade appFacadeInterface;
	private JButton btnDelete ;

	public static BLFacade getBusinessLogic() {
		return appFacadeInterface;
	}

	public static void setBussinessLogic(BLFacade afi) {
		appFacadeInterface = afi;
	}
	

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tableUsers;

	private static Vector<Erabiltzailea> erabiltzaileak;
	private JButton btnClose;
	private DefaultTableModel tableModelUsers;
	private String[] columnUserNames = new String[] {
			ResourceBundle.getBundle("Etiquetas").getString("ErabiltzaileIzena"),
			ResourceBundle.getBundle("Etiquetas").getString("Izena"),
			ResourceBundle.getBundle("Etiquetas").getString("1.Abizena"),
			ResourceBundle.getBundle("Etiquetas").getString("2.Abizena"),

	};
	public DeleteErabiltzaileaGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("DeleteUser"));
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 758, 257);
		contentPane.add(scrollPane);

		tableUsers = new JTable();
		tableUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				btnDelete.setEnabled(true);

			}
		});
		
		

		
		scrollPane.setViewportView(tableUsers);
		tableModelUsers = new DefaultTableModel(null, columnUserNames) {

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
		tableUsers.setModel(tableModelUsers);
		tableUsers.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableUsers.getColumnModel().getColumn(1).setPreferredWidth(25);
		tableUsers.getColumnModel().getColumn(2).setPreferredWidth(25);
		tableUsers.getColumnModel().getColumn(3).setPreferredWidth(25);
		tableUsers.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
		tableUsers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableUsers.setRowHeight(25);

		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tableUsers.getDefaultRenderer(Object.class);
		renderer.setHorizontalAlignment( JLabel.CENTER );

		erabiltzaileak = getBusinessLogic().getErabiltzaileak();
		for (Erabiltzailea u : erabiltzaileak) {
			int numCols = tableModelUsers.getColumnCount();
			Object[] row = new Object[numCols];
			row[0] = u.getErabizena();
			row[1] = u.getIzena();
			row[2] = u.getAbizena1();
			row[3] = u.getAbizena2();
			tableModelUsers.addRow(row);
		}

		btnDelete = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DeleteUser"));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelUsers = (DefaultTableModel) tableUsers.getModel();
				String erabizena = String.valueOf(modelUsers.getValueAt(tableUsers.getSelectedRow(), 0));

				getBusinessLogic().deleteErabiltzailea(erabizena);
				erabiltzaileak = getBusinessLogic().getErabiltzaileak();

				modelUsers.setDataVector(null,columnUserNames);
				repaintusers();

				btnDelete.setEnabled(false);
			}
		});
		btnDelete.setBounds(83, 294, 214, 39);
		contentPane.add(btnDelete);
		btnDelete.setEnabled(false);

		btnClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close"));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton2_actionPerformed(e);
			}
		});

		btnClose.setBounds(489, 294, 214, 39);
		contentPane.add(btnClose);
	}

	private void jButton2_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

	private void repaintusers() {
		for (Erabiltzailea u : erabiltzaileak) {
			int numCols = tableUsers.getModel().getColumnCount();
			Object[] row = new Object[numCols];
			row[0] = u.getErabizena();
			row[1] = u.getIzena();
			row[2] = u.getAbizena1();
			row[3] = u.getAbizena2();
			((DefaultTableModel) tableUsers.getModel()).addRow(row);
		}
	}

}
