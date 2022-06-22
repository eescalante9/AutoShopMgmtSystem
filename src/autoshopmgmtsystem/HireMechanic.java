package autoshopmgmtsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class HireMechanic extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldSpecialization;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HireMechanic frame = new HireMechanic();
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
	public HireMechanic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("HIRE MECHANIC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		
		JLabel lblMechanicID = new JLabel("Mechanic ID:");
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		
		JLabel lblMechanicName = new JLabel("Name:");
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		
		JLabel lblSpecialization = new JLabel("Specialization:");
		
		textFieldSpecialization = new JTextField();
		textFieldSpecialization.setColumns(10);
		
		JButton btnHire = new JButton("HIRE");
		btnHire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHireActionPerformed(e);
			}
		});
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackActionPerformed(e);
			}
		});
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogoutActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(134)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMechanicID)
								.addComponent(lblMechanicName)
								.addComponent(lblSpecialization))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldSpecialization)
								.addComponent(textFieldName)
								.addComponent(textFieldID, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(btnHire)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack)
							.addPreferredGap(ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
							.addComponent(btnLogout)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMechanicID))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMechanicName)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpecialization)
						.addComponent(textFieldSpecialization, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnHire)
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnLogout))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void btnHireActionPerformed(ActionEvent e){
		try{Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mechanic_shop","root","Peruano93!!");
        	String sql = "insert into mechanics values (?,?,?)";
        	PreparedStatement ptstmt = conn.prepareStatement(sql);
        	ptstmt.setString(1, textFieldID.getText());
        	ptstmt.setString(2, textFieldName.getText());
        	ptstmt.setString(3, textFieldSpecialization.getText());
        	ptstmt.executeUpdate();
        	JOptionPane.showMessageDialog(null, "Mechanic added succesfully.");
        	conn.close();
        	textFieldID.setText("");
        	textFieldName.setText("");
        	textFieldSpecialization.setText("");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
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
