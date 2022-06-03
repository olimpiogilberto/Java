package br.com.mcs.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class CustomTextField extends JTextField implements FocusListener, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color[] cores = {Color.lightGray,Color.BLACK,Color.WHITE,Color.GRAY};
	
	public CustomTextField() {
		this.addKeyListener(this);
		this.addFocusListener(this);
		
		}
	
	public CustomTextField(int tam) {
		super(tam);
		this.addKeyListener(this);
		this.addFocusListener(this);
		
		}
	
	public CustomTextField(int tam, Color[] cores) {
		super(tam);
		this.addKeyListener(this);
		this.addFocusListener(this);
		this.cores = cores;
		
		}

	@Override
	public void keyReleased(KeyEvent e) {
		this.setText(this.getText().toUpperCase());
	}

	public void focusGained(FocusEvent e) {
		this.setBackground(cores[0]);
		this.setForeground(cores[1]);
		}

	@Override
	public void focusLost(FocusEvent e) {	
		this.setBackground(cores[2]);
		this.setForeground(cores[3]);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		//
		
	}

}
