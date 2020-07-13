package huarongdao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Person extends JButton implements FocusListener{
	
	int no;
	Color b = new Color(184,207,229);
	
	public Person(int no,String name) {
		super(name);
		setBackground(Color .white);
		setFont(new Font("����",Font.PLAIN ,18));
		setFocusPainted(false);
		this.no = no;
		addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		setBackground(b);
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		setBackground(Color .white);
	}

}
