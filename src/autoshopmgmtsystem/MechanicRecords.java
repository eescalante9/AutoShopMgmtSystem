package autoshopmgmtsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MechanicRecords extends JFrame {

	private JPanel contentPane;
	private JTable tableRecords;
	private JLabel lblNewLabel;
	private JButton btnBack;
	private JButton btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MechanicRecords frame = new MechanicRecords();
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
	public MechanicRecords() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnViewRecords = new JButton("VIEW RECORDS");
		btnViewRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnViewRecordsActionPerformed(e);
			}
		});
		
		lblNewLabel = new JLabel("Mechanic Records");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackActionPerformed(e);
			}
		});
		
		btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogoutActionPerformed(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack)
							.addPreferredGap(ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
							.addComponent(btnLogout)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnViewRecords)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
					.addGap(48))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnViewRecords)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnLogout))
					.addContainerGap())
		);
		
		tableRecords = new JTable();
		scrollPane.setViewportView(tableRecords);
		tableRecords.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Name", "Specialization"
			}
		));
		contentPane.setLayout(gl_contentPane);
	}

	private void btnViewRecordsActionPerformed(ActionEvent e) {
		 try{ Class.forName("com.mysql.jdbc.Driver");
		 	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mechanic_shop","root","Peruano93!!");
         	String sql="select * from mechanics";
         	PreparedStatement pstmt=conn.prepareStatement(sql);
         	ResultSet rs= pstmt.executeQuery();
         	DefaultTableModel tm=(DefaultTableModel)tableRecords.getModel();
         	tm.setRowCount(0);
         	while(rs.next()){
         		Object o[]={rs.getInt("MECHANIC_ID"),rs.getString("MECHANIC_NAME"),rs.getString("MECHANIC_SPECIALIZATION")};
         		tm.addRow(o);
         	}
         	conn.close();
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex);
         }
	}
	
	private void btnBackActionPerformed(ActionEvent e) {
		MechanicsPage obj = new MechanicsPage();
		obj.setVisible(true);
		dispose();
	}
	
	private void btnLogoutActionPerformed(ActionEvent e) {
		ShopLogin obj = new ShopLogin();
		obj.setVisible(true);
		dispose();
	}
	
	
}
