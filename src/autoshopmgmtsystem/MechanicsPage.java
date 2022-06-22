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


public class MechanicsPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MechanicsPage frame = new MechanicsPage();
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
	public MechanicsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Mechanics Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnRecords = new JButton("RECORDS");
		btnRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRecordsActionPerformed(e);
			}
		});
		
		JButton btnHireMechanic = new JButton("HIRE MECHANIC");
		btnHireMechanic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHireMechanicActionPerformed(e);
			}
		});
		
		JButton btnFireMechanic = new JButton("FIRE MECHANIC");
		btnFireMechanic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFireMechanicActionPerformed(e);
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnBack)
									.addPreferredGap(ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
									.addComponent(btnLogout))
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(148)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnHireMechanic, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRecords, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFireMechanic, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRecords, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHireMechanic, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFireMechanic, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogout)
						.addComponent(btnBack))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void btnRecordsActionPerformed(ActionEvent e) {
		MechanicRecords obj = new MechanicRecords();
		obj.setVisible(true);
		dispose();
	}
	
	private void btnHireMechanicActionPerformed(ActionEvent e) {
		HireMechanic obj = new HireMechanic();
		obj.setVisible(true);
		dispose();
	}
	
	private void btnFireMechanicActionPerformed(ActionEvent e) {
		FireMechanic obj = new FireMechanic();
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
