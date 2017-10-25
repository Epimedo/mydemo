package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;

import com.mybank.controller.CommandPoint;
import com.mybank.controller.ControlCommand;
import com.mybank.controller.ForCustomer;

public class BankChatRoom {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField;
	private ControlCommand contrl = new ControlCommand();
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankChatRoom window = new BankChatRoom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankChatRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Bank Chat Room");
		frame.setBounds(100, 100, 744, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"john", "bob", "Ray"}));
		comboBox.setBounds(653, 256, 65, 39);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(653, 210, 65, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Send");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(comboBox.getSelectedItem() + " " + textField_1.getText());
				textField_1.setText(null);
			}
		});
		button.setBounds(653, 165, 65, 45);
		frame.getContentPane().add(button);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 275, 643, 31);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 728, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmQuit);
		
		JMenu mnAbout = new JMenu("About");
		
		menuBar.add(mnAbout);
		
		JMenuItem mntmAboutProgramn = new JMenuItem("About Programn");
		mntmAboutProgramn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutAuthor.main(null);
			}
		});
		mnAbout.add(mntmAboutProgramn);
		
		textField = new JTextField();
		textField.setBounds(0, 21, 643, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(653, 133, 65, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("Get Ac");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     contrl.setValue(Double.parseDouble(textField_2.getText()));
			     contrl.setNameCommand("getac");
			     try {
					Writer writer = new FileWriter("cutcommand.xml");
					Marshaller.marshal(contrl, writer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MarshalException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ValidationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			     ForCustomer.readXMLCommand();
			     ForCustomer.writeXMLAnswer();
			     AccountChatRoom.main(null);
				}
		});
		button_1.setBounds(653, 77, 65, 45);
		frame.getContentPane().add(button_1);
	}
}
