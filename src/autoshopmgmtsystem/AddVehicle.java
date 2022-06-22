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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class AddVehicle extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldVehicleID;
	private JTextField textFieldVin;
	private JTextField textFieldOwner;
	private JTextField textFieldMake;
	private JTextField textFieldModel;
	private JTextArea textAreaProblem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVehicle frame = new AddVehicle();
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
	public AddVehicle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ADD VEHICLE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		
		JLabel lblID = new JLabel("Vehicle ID:");
		
		textFieldVehicleID = new JTextField();
		textFieldVehicleID.setColumns(10);
		
		JLabel lblVin = new JLabel("VIN:");
		
		textFieldVin = new JTextField();
		textFieldVin.setColumns(10);
		
		JLabel lblOwner = new JLabel("Owner:");
		
		textFieldOwner = new JTextField();
		textFieldOwner.setColumns(10);
		
		JLabel lblMake = new JLabel("Make:");
		
		textFieldMake = new JTextField();
		textFieldMake.setColumns(10);
		
		JLabel lblModel = new JLabel("Model:");
		
		textFieldModel = new JTextField();
		textFieldModel.setColumns(10);
		
		JLabel lblProblem = new JLabel("Problem:");
		
		JButton btnAddVehicle = new JButton("ADD VEHICLE");
		btnAddVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddVehicleActionPerformed(e);
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
		textAreaProblem = new JTextArea();
		//JTextArea textAreaProblem = new JTextArea();
		textAreaProblem.setLineWrap(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(99)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblID)
								.addComponent(lblVin)
								.addComponent(lblOwner)
								.addComponent(lblMake)
								.addComponent(lblModel)
								.addComponent(lblProblem))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textAreaProblem)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textFieldModel)
									.addComponent(textFieldMake)
									.addComponent(textFieldOwner)
									.addComponent(textFieldVin)
									.addComponent(textFieldVehicleID, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
								.addComponent(btnAddVehicle))
							.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
					.addComponent(btnLogout)
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblID)
						.addComponent(textFieldVehicleID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVin)
						.addComponent(textFieldVin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOwner)
						.addComponent(textFieldOwner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMake)
						.addComponent(textFieldMake, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModel)
						.addComponent(textFieldModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProblem)
						.addComponent(textAreaProblem, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(btnAddVehicle)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnLogout))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void btnAddVehicleActionPerformed(ActionEvent e) {
		try{Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mechanic_shop","root","Peruano93!!");
			String sql = "insert into vehicles values (?,?,?,?,?,?)";
			PreparedStatement ptstmt = conn.prepareStatement(sql);
			ptstmt.setString(1, textFieldVehicleID.getText());
			ptstmt.setString(2, textFieldVin.getText());
			ptstmt.setString(3, textFieldOwner.getText());
			ptstmt.setString(4, textFieldMake.getText());
			ptstmt.setString(5, textFieldModel.getText());
			ptstmt.setString(6, textAreaProblem.getText());
			ptstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Vehicle added succesfully.");
			conn.close();
    
			textFieldVehicleID.setText("");
			textFieldVin.setText("");
			textFieldOwner.setText("");
			textFieldMake.setText("");
			textFieldModel.setText("");
			textAreaProblem.setText("");
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, ex);
		}
	
	}
	
	private void btnBackActionPerformed(ActionEvent e) {
		VehiclesPage obj = new VehiclesPage();
		obj.setVisible(true);
		dispose();
	}
	
	private void btnLogoutActionPerformed(ActionEvent e) {
		ShopLogin obj = new ShopLogin();
		obj.setVisible(true);
		dispose();
	}
	
	
}
