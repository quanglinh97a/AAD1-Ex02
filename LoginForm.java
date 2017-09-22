package com.quanglinhit;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class LoginForm extends JFrame {
	JTextField txtId, txtName, txtGender, txtRollNumber, txtClassName;
	JSpinner txtBirthday;
	JFormattedTextField txtEmail, txtPhone;
	JButton btnSend, btnReset;
	ButtonGroup genderGroup;
	JRadioButton radMale, radFeMale;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy  hh:mm:ss aaa");

	public LoginForm() {
		addControls();
		addEvents();
	}

	public void addControls() {
		JFrame frame = new JFrame("Form " + sdf.format(new Date()));
		frame.setSize(800, 600);
		frame.setLayout(null);

		JPanel pnLogin = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.cyan, 1);
		TitledBorder titleBorder = BorderFactory.createTitledBorder("Form Thông Tin");
		pnLogin.setBorder(titleBorder);
		pnLogin.setBounds(50, 50, 680, 460);
		pnLogin.setLayout(null);
		frame.add(pnLogin);

		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(100, 50, 100, 30);
		pnLogin.add(lblId);
		txtId = new JTextField();
		txtId.setBounds(200, 50, 400, 30);
		pnLogin.add(txtId);

		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(100, 90, 100, 30);
		pnLogin.add(lblName);
		txtName = new JTextField();
		txtName.setBounds(200, 90, 400, 30);
		pnLogin.add(txtName);

		JLabel lblGender = new JLabel("Gender: ");
		lblGender.setBounds(100, 130, 100, 30);
		pnLogin.add(lblGender);
		radMale = new JRadioButton("Male ");
		radMale.setBounds(200, 130, 100, 30);
		pnLogin.add(radMale);

		radFeMale = new JRadioButton("FeMale ");
		radFeMale.setBounds(300, 130, 100, 30);
		pnLogin.add(radFeMale);
		genderGroup = new ButtonGroup();
		genderGroup.add(radMale);
		genderGroup.add(radFeMale);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(100, 170, 100, 30);
		pnLogin.add(lblEmail);
		txtEmail = new JFormattedTextField();
		txtEmail.setBounds(200, 170, 400, 30);
		pnLogin.add(txtEmail);

		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setBounds(100, 210, 100, 30);
		pnLogin.add(lblPhone);
		MaskFormatter mkPhone = null;
		try {
			mkPhone = new MaskFormatter("#### ### ###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		mkPhone.setPlaceholderCharacter('_');
		txtPhone = new JFormattedTextField(mkPhone);
		txtPhone.setBounds(200, 210, 400, 30);
		pnLogin.add(txtPhone);

		JLabel lblBirthday = new JLabel("Birthday: ");
		lblBirthday.setBounds(100, 250, 100, 30);
		pnLogin.add(lblBirthday);
		SpinnerDateModel sdm = new SpinnerDateModel();
		txtBirthday = new JSpinner(sdm);
		txtBirthday.setEditor(new JSpinner.DateEditor(txtBirthday, "dd/MM/yyyy"));
		txtBirthday.setBounds(200, 250, 400, 30);
		pnLogin.add(txtBirthday);

		JLabel lblRollNumber = new JLabel("Roll number: ");
		lblRollNumber.setBounds(100, 290, 100, 30);
		pnLogin.add(lblRollNumber);

		txtRollNumber = new JTextField();
		txtRollNumber.setBounds(200, 290, 400, 30);
		pnLogin.add(txtRollNumber);

		btnReset = new JButton("Reset");
		btnReset.setBounds(390, 330, 100, 30);
		pnLogin.add(btnReset);

		btnSend = new JButton("Send");
		btnSend.setBounds(500, 330, 100, 30);
		pnLogin.add(btnSend);

		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addEvents() {
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getInformation();
			}
		});
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				resetInformation();
			}
		});
	}
	protected void resetInformation() {
		txtId.setText("");
		txtName.setText("");
		txtBirthday.setValue("");
		txtEmail.setText("");
		txtPhone.setText("");
		txtRollNumber.setText("");
		txtClassName.setText("");
	}
	protected void getInformation() {
		String gender = "";
		if (radMale.isSelected()) {
			gender = radMale.getText();
		} else {
			gender = radFeMale.getText();
		}
		String msg = "Id: " + txtId.getText() + "\nName: " + txtName.getText() + "\nGender: " + gender + "\nEmail: "
				+ txtEmail.getText() + "\nBirthday: " + txtBirthday.getName() + "\nPhone: " + txtPhone.getText()
				+ "\nRoll number: " + txtRollNumber.getText();
		JOptionPane.showConfirmDialog(null, msg);
	}

	public static void main(String[] args) {
		LoginForm ui = new LoginForm();
	}

}
