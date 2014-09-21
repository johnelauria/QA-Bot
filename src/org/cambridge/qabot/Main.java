package org.cambridge.qabot;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static org.cambridge.qabot.config.Data.countryList;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.cambridge.qabot.config.Config;
import org.cambridge.qabot.config.Data;
import org.cambridge.qabot.test.ChangeCountry;
import org.cambridge.qabot.test.Purchase;

public class Main extends JFrame implements ActionListener, KeyListener {
	
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
	private static final String testTypeList[] = {"Purchase", "Change Country"};
	private JComboBox<String> testType;

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
		
		comboBox = new JComboBox<String>(this.servers());
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		
		lblCountriesToTest = new JLabel("Countries to test");

		countryList = new JList<String>(countryListData());
		JScrollPane scrollpane = new JScrollPane(countryList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		countryList.addListSelectionListener(countryListSelectionListener);
		
		selectNewCountry = new JComboBox<String>(countryList());
		selectNewCountry.addKeyListener(this);
		btnAddCountry = new JButton("+");
		btnAddCountry.addActionListener(this);
		
		btnRemoveCountry = new JButton("-");
		btnRemoveCountry.setEnabled(false);
		btnRemoveCountry.addActionListener(this);
		
		testType = new JComboBox<String>(testTypeList);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCountriesToTest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRemoveCountry)
									.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
									.addComponent(btnAddCountry))
								.addComponent(selectNewCountry, 0, 133, Short.MAX_VALUE)
								.addComponent(testType, 0, 133, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addComponent(lblTestAgenda)
							.addGap(77)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblServer)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnStart))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(scrollpane, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
								.addGap(8))))
					.addGap(22))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTestAgenda)
						.addComponent(lblServer))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(98)
							.addComponent(lblCountriesToTest)
							.addGap(18)
							.addComponent(selectNewCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRemoveCountry)
								.addComponent(btnAddCountry)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnStart)
								.addComponent(testType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addComponent(scrollpane, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
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
	
	/**
	 * Removes a specific country from the country list to be tested
	 * @param int countryListIndex
	 */
	private void removeCountryFromList(int countryListIndex) {
		countryListModel.removeElementAt(countryListIndex);
	}
	
	/**
	 * If the tester clicks on one of the countries in the countryList JList
	 */
	private ListSelectionListener countryListSelectionListener = new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			btnRemoveCountry.setEnabled(true);
			
		}
	};

	@Override
	public void actionPerformed(ActionEvent e) {
		// When user clicked on Country Change Start button
		if (e.getSource().equals(btnStart)) {
			try {
				int errors = 0;
				switch (testType.getSelectedItem().toString()) {
				case "Purchase":
					Purchase purchase = new Purchase(comboBox.getSelectedItem().toString(), countryListModel);
					errors = purchase.start();
					break;
				case "Change Country":
					ChangeCountry changeCountry = new ChangeCountry(comboBox.getSelectedItem().toString(), countryListModel);
					errors = changeCountry.start();
					break;
				}
				if (errors > 0)
					showMessageDialog(null, errors + " Errors found during testing!", "Error found!", ERROR_MESSAGE);
				else
					showMessageDialog(null, "Automated testing has completed without errors", "Completed", INFORMATION_MESSAGE);
			} catch (Exception ex) {
				showMessageDialog(null, ex.getMessage(), "Error occured!", ERROR_MESSAGE);
			}
		}
		// When clicking the "+" country button to the countries to test list
		if (e.getSource().equals(btnAddCountry)) {
			countryListModel.addElement(selectNewCountry.getSelectedItem().toString());
		}
		// When clicking the "-" button, delete the selected list in the JList
		if (e.getSource().equals(btnRemoveCountry)) {
			removeCountryFromList(countryList.getSelectedIndex());
			btnRemoveCountry.setEnabled(false);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			if (selectNewCountry.isFocusOwner())
				countryListModel.addElement(selectNewCountry.getSelectedItem().toString());
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
