package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.util.concurrent.TimeUnit;

import online_store_group_project.Customer;
import online_store_group_project.User;

public class GUI_SignInPage extends JPanel {
	
	private GUI_skeleton driver;
	private JPanel signInPanel;
	private JPanel registerPanel;
	private CoolLabel signInMessage;
	private CoolLabel registerMessage;
	
	private CoolTextField signInUsernameField;
	private CoolPasswordField signInPasswordField;
	
	private CoolTextField registerUsernameField;
	private CoolPasswordField registerPasswordField;
	private CoolTextField registerFirstNameField;
	private CoolTextField registerLastNameField;
	private CoolTextField registerEmailField;
	
	public GUI_SignInPage(GUI_skeleton driver) {
		super();
		this.driver = driver;
		this.setBorder(new EmptyBorder(50, 50, 50, 50));
		this.setSize(new Dimension(driver.getWidth(), driver.getHeight() - 30));
		this.setPreferredSize(new Dimension(driver.getWidth(), driver.getHeight() - 30));
		
		Dimension panelDim = new Dimension(400, 270);
		
		signInPanel = new JPanel();
		signInPanel.setName("Sign In");
		signInPanel.setSize(panelDim);
		signInPanel.setPreferredSize(panelDim);
		signInUsernameField = new CoolTextField("username");
		signInUsernameField.setPreferredSize(new Dimension(400, 30));
		signInPasswordField = new CoolPasswordField("password");
		signInPasswordField.setPreferredSize(new Dimension(400, 30));
		CoolButton loginButton = new CoolButton("Log In");
		loginButton.setPreferredSize(new Dimension(400, 30));
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				handleLogIn();
			}
		});
		
		signInPanel.add(signInUsernameField);
		signInPanel.add(signInPasswordField);
		signInPanel.add(loginButton);

		registerPanel = new JPanel();
		registerPanel.setName("Register");
		registerPanel.setSize(panelDim);
		registerPanel.setPreferredSize(panelDim);
		
		registerFirstNameField = new CoolTextField("First Name");
		registerFirstNameField.setPreferredSize(new Dimension(400, 30));
		
		registerLastNameField = new CoolTextField("Last Name");
		registerLastNameField.setPreferredSize(new Dimension(400, 30));
		
		registerEmailField = new CoolTextField("Email");
		registerEmailField.setPreferredSize(new Dimension(400, 30));
		
		registerUsernameField = new CoolTextField("username");
		registerUsernameField.setPreferredSize(new Dimension(400, 30));
		
		registerPasswordField = new CoolPasswordField("password");
		registerPasswordField.setPreferredSize(new Dimension(400, 30));
		
		CoolButton registerButton = new CoolButton("Register");
		registerButton.setPreferredSize(new Dimension(400, 30));
		registerButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				handleRegister();
			}
		});
		
		registerPanel.add(registerFirstNameField);
		registerPanel.add(registerLastNameField);
		registerPanel.add(registerEmailField);
		registerPanel.add(registerUsernameField);
		registerPanel.add(registerPasswordField);
		registerPanel.add(registerButton);
		
		ArrayList<JPanel> tabs = new ArrayList<JPanel>();
		tabs.add(signInPanel);
		tabs.add(registerPanel);
		
		TabSelect signInBox = new TabSelect(tabs);
		
		add(signInBox);
	}
	
	public void handleLogIn() {
		String username = signInUsernameField.getText();
		String password = new String(signInPasswordField.getPassword());
		User user = driver.store.getUserByUsername(username);
		if(user != null) {
			if(password.equals(user.getPassword())) {
				driver.activeUser = user;
				driver.goToAccountPage();
			}
			else {
				logInErrorMessage();
			}
		}
		else {
			logInErrorMessage();
		}
		
	}
	
	public void logInErrorMessage() {
		if(signInMessage != null) {
			signInPanel.remove(signInMessage);
		}
		CoolLabel errorMessage = new CoolLabel("No user with those credentials exists", Color.WHITE, Color.RED, 400, 30);
		signInMessage = errorMessage;
		signInPanel.add(signInMessage);
		signInPanel.repaint();
		signInPanel.revalidate();
	}
	
	public void logInSuccessMessage() {
		if(signInMessage != null) {
			signInPanel.remove(signInMessage);
		}
		CoolLabel successMessage = new CoolLabel("Sucessfully logged in!", Color.WHITE, Color.GREEN, 400, 30);
		signInMessage = successMessage;
		signInPanel.add(signInMessage);
		signInPanel.repaint();
		signInPanel.revalidate();
	}
	
	public void handleRegister() {
		if(registerMessage != null) {
			registerPanel.remove(registerMessage);
			registerPanel.repaint();
			registerPanel.revalidate();
		}
		String username = registerUsernameField.getText();
		String password = new String(registerPasswordField.getPassword());
		String firstName = registerFirstNameField.getText();
		String lastName = registerLastNameField.getText();
		String email = registerEmailField.getText();
		
		if(!username.equals("username") && !password.equals("password") && !firstName.equals("First Name") && !lastName.equals("Last Name") && !email.equals("Email")) {
			if(username.length() > 5) {
				if(password.length() > 7) {
					if(driver.store.getUserByUsername(username) == null) {
						if(!driver.store.userExists(registerEmailField.getText())) {
							Customer newUser = new Customer(driver.store, username, email, firstName, lastName, password);
							driver.store.customers.add(newUser);
							driver.store.users.add(newUser);
							driver.activeUser = newUser;
							registerSuccessMessage();
						}
						else {
							registerErrorMessage(2);
						}
					}
					else {
						registerErrorMessage(1);
					}
				}
				else {
					registerErrorMessage(4);
				}

			}
			else {
				registerErrorMessage(3);
			}
		}
		else {
			registerErrorMessage(0);
		}
	}
	
	public void registerErrorMessage(int errorCode) {
		CoolLabel errorMessage;
		switch(errorCode) {
		case 0:
			errorMessage = new CoolLabel("Please complete all fields", Color.WHITE, Color.RED, 400, 30);
			break;
		case 1:
			errorMessage = new CoolLabel("A user with that username already exists", Color.WHITE, Color.RED, 400, 30);
			break;
		case 2:
			errorMessage = new CoolLabel("A user with that email already exists", Color.WHITE, Color.RED, 400, 30);
			break;
		case 3:
			errorMessage = new CoolLabel("Please choose a username with at least 6 characters", Color.WHITE, Color.RED, 400, 30);
			break;
		case 4:
			errorMessage = new CoolLabel("Please choose a password with at least 8 characters", Color.WHITE, Color.RED, 400, 30);
			break;
		default:
			errorMessage = new CoolLabel("Something went wrong with registration", Color.WHITE, Color.RED, 400, 30);
			break;
		}
		
		registerMessage = errorMessage;
		registerPanel.add(registerMessage);
		registerPanel.repaint();
		registerPanel.revalidate();
	}
	
	public void registerSuccessMessage() {
		CoolLabel successMessage = new CoolLabel("Successfully registered!", Color.WHITE, Color.GREEN, 400, 30);
		
		registerMessage = successMessage;
		registerPanel.add(registerMessage);
		registerPanel.repaint();
		registerPanel.revalidate();
	}
	
}
