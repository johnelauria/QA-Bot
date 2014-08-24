package org.cambridge.qabot;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.cambridge.qabot.config.Config;

import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Main extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnStart;
	private JButton btnAddCountry;
	private JComboBox<String> comboBox;
	private JComboBox<String> selectNewCountry;
	private JLabel lblTestAgenda;
	private JLabel lblServer;
	private JList<String> countryList;
	private JLabel lblCountriesToTest;
	private DefaultComboBoxModel<String> countriesToTest;
	private DefaultListModel<String> countryListModel;
	private static DefaultListModel<String> logListModel = new DefaultListModel<String>();
	private JList<String> logs;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 410);
		setTitle("QA Bot");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setName("QA Bot");
		setContentPane(contentPane);
		
		lblTestAgenda = new JLabel("Test agenda");
		
		lblServer = new JLabel("Server");
		
		JLabel lblServerToTest = new JLabel("Change Country");
		
		comboBox = new JComboBox<String>(this.servers());
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		
		lblCountriesToTest = new JLabel("Countries to test");
		
		countryList = new JList<String>(countryListData());
		
		selectNewCountry = new JComboBox<String>(this.listCountriesToTest());
		
		btnAddCountry = new JButton("Add ->");
		btnAddCountry.addActionListener(this);
		
		logs = new JList<String>(logListModel);
		
		JLabel lblSomeUsefulLogs = new JLabel("Some useful logs");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSomeUsefulLogs))
						.addComponent(logs, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblCountriesToTest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnAddCountry)
										.addComponent(selectNewCountry, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(countryList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblServerToTest)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblTestAgenda)))
									.addGap(55)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblServer)
											.addGap(155))
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(18)
							.addComponent(btnStart)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTestAgenda)
						.addComponent(lblServer))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblServerToTest))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnStart)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(98)
							.addComponent(lblCountriesToTest)
							.addGap(18)
							.addComponent(selectNewCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddCountry))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(countryList, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSomeUsefulLogs)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(logs, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * List the servers to conduct the test on
	 * @return DefaultComboBoxModel server_environment
	 */
	private DefaultComboBoxModel<String> servers() {
		final DefaultComboBoxModel<String> list= new DefaultComboBoxModel<String>();
		final Config server = new Config();
		for (String site : server.testServers().keySet()) {
			list.addElement(site);
		}
		return list;
	}
	
	/**
	 * Lists all countries that can be added for testing
	 * @return DefaultComboBoxModel countriesToTest
	 */
	private DefaultComboBoxModel<String> listCountriesToTest() {
		countriesToTest = new DefaultComboBoxModel<String>();
		countriesToTest.addElement("United States");
		countriesToTest.addElement("United Kingdom");
		countriesToTest.addElement("Hungary");
		countriesToTest.addElement("China");
		countriesToTest.addElement("Lithuania");
		countriesToTest.addElement("Latvia");
		countriesToTest.addElement("Philippines");
		countriesToTest.addElement("Singapore");
		return countriesToTest;
	}
	
	/**
	 * Lists all countries that will be tested once automation testing starts
	 * @return DefaultListModel countryListData
	 */
	private DefaultListModel<String> countryListData() {
		countryListModel = new DefaultListModel<String>();
		countryListModel.addElement("United States");
		countryListModel.addElement("United Kingdom");
		return countryListModel;
	}
	
	public static void addLog(String log) {
		logListModel.addElement(log);
	}

	@Override
	public void actionPerformed(ActionEvent btn) {
		// When user clicked on Country Change Start button
		if (btn.getSource().equals(btnStart)) {
			try {
				ChangeCountry changeCountry = new ChangeCountry(comboBox.getSelectedItem().toString(), countryListModel);
				changeCountry.execute();
				changeCountry.run();
				showMessageDialog(null, "Automated testing has completed without errors", "Completed", INFORMATION_MESSAGE);
			} catch (Exception e) {
				showMessageDialog(null, e.getMessage(), "Error occured!", ERROR_MESSAGE);
			}
		}
		if (btn.getSource().equals(btnAddCountry)) {
			countryListModel.addElement(selectNewCountry.getSelectedItem().toString());
		}
	}
}
