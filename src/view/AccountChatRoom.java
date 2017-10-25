package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import com.mybank.controller.CommandPoint;
import com.mybank.controller.ControlCommand;
import com.mybank.controller.ForAccount;
import com.mybank.domain.Account;
import com.mybank.domain.OverdraftException;

public class AccountChatRoom {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
    private ControlCommand contrl = new ControlCommand();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountChatRoom window = new AccountChatRoom();
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
	public AccountChatRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Account Chat Room");
		frame.setBounds(100, 100, 794, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(246, 262, 522, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterText = textField.getText()+btnNewButton.getText();
			     textField.setText(EnterText);
			}
		});
		btnNewButton.setBounds(10, 271, 72, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(".");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 if(textField.getText().indexOf(".")==-1)
			   {
				   textField.setText(textField.getText()+btnNewButton_1.getText());
			   }
				
			}
		});
		btnNewButton_1.setBounds(80, 271, 72, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Enter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(textField.getText());
				textField.setText(null);
			}
		});
		btnNewButton_2.setBounds(147, 271, 72, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton button = new JButton("7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterText = textField.getText()+button.getText();
			     textField.setText(EnterText);
			}
		});
		button.setBounds(10, 249, 72, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterText = textField.getText()+button_1.getText();
			     textField.setText(EnterText);
			}
		});
		button_1.setBounds(80, 249, 72, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("9");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterText = textField.getText()+button_2.getText();
			     textField.setText(EnterText);
			}
		});
		button_2.setBounds(147, 249, 72, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterText = textField.getText()+button_3.getText();
			     textField.setText(EnterText);
			}
		});
		button_3.setBounds(10, 225, 72, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterText = textField.getText()+button_4.getText();
			     textField.setText(EnterText);
			}
		});
		button_4.setBounds(80, 225, 72, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterText = textField.getText()+button_5.getText();
			     textField.setText(EnterText);
			}
		});
		button_5.setBounds(147, 225, 72, 23);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("1");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     String EnterText = textField.getText()+button_6.getText();
			     textField.setText(EnterText);
			}
		});
		button_6.setBounds(10, 203, 72, 23);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("2");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterText = textField.getText()+button_7.getText();
			     textField.setText(EnterText);
			}
		});
		button_7.setBounds(80, 203, 72, 23);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("3");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterText = textField.getText()+button_8.getText();
			     textField.setText(EnterText);
			}
		});
		button_8.setBounds(147, 203, 72, 23);
		frame.getContentPane().add(button_8);
		
		JButton btnNewButton_3 = new JButton("Display account balance");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Writer writer;
					try {
						writer = new FileWriter("command.xml");
						contrl.setNameCommand("getBalance");
						Marshaller.marshal(contrl, writer);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					CommandPoint.readXMLCommand();
					CommandPoint.writeXMLResult();
					Reader reader = new FileReader("command.xml");
					contrl = (ControlCommand) Unmarshaller.unmarshal(ControlCommand.class, reader);
					textField_1.setText(Double.toString(contrl.getValue()));
				} catch (FileNotFoundException e1) {
					e1.getMessage();
				}catch (MarshalException | ValidationException e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
			}
		});
		btnNewButton_3.setBounds(10, 96, 209, 32);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton button_9 = new JButton("Make a deposit");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Writer writer;
					try {
						writer = new FileWriter("command.xml");
						contrl.setNameCommand("deposit");
						String EnterDeposit = textField_1.getText();
						contrl.setValue(Double.parseDouble(EnterDeposit));
						Marshaller.marshal(contrl, writer);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					CommandPoint.readXMLCommand();
					CommandPoint.writeXMLResult();
					Reader reader = new FileReader("command.xml");
					contrl = (ControlCommand) Unmarshaller.unmarshal(ControlCommand.class, reader);
					textField_1.setText(Double.toString(contrl.getValue()));
				} catch (FileNotFoundException e1) {
					e1.getMessage();
				}catch (MarshalException | ValidationException e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
			}
		});
		button_9.setBounds(10, 128, 209, 32);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("Make a withdraw");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Writer writer;
					try {
						writer = new FileWriter("command.xml");
						contrl.setNameCommand("withdrow");
						String EnterDeposit = textField_1.getText();
						contrl.setValue(Double.parseDouble(EnterDeposit));
						Marshaller.marshal(contrl, writer);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					CommandPoint.readXMLCommand();
					CommandPoint.writeXMLResult();
					Reader reader = new FileReader("command.xml");
					contrl = (ControlCommand) Unmarshaller.unmarshal(ControlCommand.class, reader);
					textField_1.setText(Double.toString(contrl.getValue()));
				} catch (FileNotFoundException e1) {
					e1.getMessage();
				}catch (MarshalException | ValidationException e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
				
			}
		});
		button_10.setBounds(10, 160, 209, 32);
		frame.getContentPane().add(button_10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(246, 96, 522, 165);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
	}
}
