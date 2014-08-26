package org.cambridge.qabot;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static org.cambridge.qabot.config.Data.countryList;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import org.cambridge.qabot.config.Config;
import org.cambridge.qabot.config.Data;

public class Main extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnStart;
	private JButton btnAddCountry;
	private JButton btnRemoveCountry;
	private JComboBox<String> comboBox;
	private JComboBox<String> selectNewCountry;
	private JLabel lblTestAgenda;
	private JLabel lblServer;
	private JList<String> countryList;
	private JLabel lblCountriesToTest;
	private DefaultListModel<String> countryListModel;

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
		setBounds(100, 100, 490, 336);
		setTitle("QA Bot");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setName("QA Bot");
		setContentPane(contentPane);
		
		lblTestAgenda = new JLabel("Task");
		
		lblServer = new JLabel("Server");
		
		JLabel lblServerToTest = new JLabel("Change Country");
		
		comboBox = new JComboBox<String>(this.servers());
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		
		lblCountriesToTest = new JLabel("Countries to test");

		countryList = new JList<String>(countryListData());
		JScrollPane scrollpane = new JScrollPane(countryList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		selectNewCountry = new JComboBox<String>(countryList());
		
		btnAddCountry = new JButton("+");
		btnAddCountry.addActionListener(this);
		
		btnRemoveCountry = new JButton("-");
		btnRemoveCountry.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblServerToTest)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(43)
									.addComponent(lblTestAgenda)))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblServer)
									.addGap(155))
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(btnStart))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCountriesToTest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRemoveCountry)
									.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
									.addComponent(btnAddCountry))
								.addComponent(selectNewCountry, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollpane, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
							.addGap(8)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServer)
						.addComponent(lblTestAgenda))
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
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddCountry)
								.addComponent(btnRemoveCountry)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(scrollpane, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
					.addGap(115))
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
	 * These are the set of countries to be tested
	 * @return DefaultListModel countryListModel
	 */
	private DefaultListModel<String> countryListData() {
		countryListModel = new DefaultListModel<String>();
		for (String startCountry : new Data().preSetCountries()) {
			countryListModel.addElement(startCountry);
		}
		return countryListModel;
	}

	@Override
	public void actionPerformed(ActionEvent btn) {
		// When user clicked on Country Change Start button
		if (btn.getSource().equals(btnStart)) {
			try {
				ChangeCountry changeCountry = new ChangeCountry(comboBox.getSelectedItem().toString(), countryListModel);
				int errors = changeCountry.start();
				if (errors > 0)
					showMessageDialog(null, errors + " Errors found during testing!", "Error found!", ERROR_MESSAGE);
				else
					showMessageDialog(null, "Automated testing has completed without errors", "Completed", INFORMATION_MESSAGE);
			} catch (Exception e) {
				showMessageDialog(null, e.getMessage(), "Error occured!", ERROR_MESSAGE);
			}
		}
		// When clicking the add country button to the countries to test list
		if (btn.getSource().equals(btnAddCountry)) {
			countryListModel.addElement(selectNewCountry.getSelectedItem().toString());
		}
		
		if (btn.getSource().equals(btnRemoveCountry)) {
			//TODO: Implement method to remove a country from the list after clicking the "-" button
		}
	}
}
