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
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;


public class VehiclesPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehiclesPage frame = new VehiclesPage();
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
	public VehiclesPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Vehicles Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnAddVehicle = new JButton("ADD VEHICLE");
		btnAddVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddVehicleActionPerformed(e);
			}
		});
		
		JButton btnRemoveVehicle = new JButton("REMOVE VEHICLE");
		btnRemoveVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRemoveVehicleActionPerformed(e);
			}
		});
		
		JButton btnViewVehicles = new JButton("VIEW VEHICLES");
		btnViewVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnViewVehiclesActionPerformed(e);
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnViewVehicles, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addComponent(btnAddVehicle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRemoveVehicle, GroupLayout.PREFERRED_SIZE, 125, Short.MAX_VALUE))
							.addGap(146))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack)
							.addPreferredGap(ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
							.addComponent(btnLogout)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(btnViewVehicles, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAddVehicle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRemoveVehicle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnLogout))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void btnViewVehiclesActionPerformed(ActionEvent e) {
		VehicleRecords obj = new VehicleRecords();
		obj.setVisible(true);
		dispose();
	}
	
	private void btnAddVehicleActionPerformed(ActionEvent e) {
		AddVehicle obj = new AddVehicle();
		obj.setVisible(true);
		dispose();
	}
	
	private void btnRemoveVehicleActionPerformed(ActionEvent e) {
		RemoveVehicle obj = new RemoveVehicle();
		obj.setVisible(true);
		dispose();
	}
	
	private void btnBackActionPerformed(ActionEvent e) {
		MainPage obj = new MainPage();
		obj.setVisible(true);
		dispose();
	}
	
	private void btnLogoutActionPerformed(ActionEvent e) {
		ShopLogin obj = new ShopLogin();
		obj.setVisible(true);
		dispose();
	}
	
}
