package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

public class MyFrame extends JFrame implements MouseListener   {
	JLabel label1; 
	JLabel label2;
	JLabel background;
	static JTextField text1;
	static JTextField text2;
	JButton button1;
	 Player p1;
	 static Player p2;
	 static Board board;  // to connect GUI to the code
	
	
	
	public MyFrame() throws IOException, UnexpectedFormatException {
		//setSize(500,500);
	    setTitle("Welcome to YuGiOh!");
		setBounds(0,0,1300,1300);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		board= new Board();
		// label1 and its text
		label1 = new JLabel("First Player's name:");
		//label1.setOpaque(true);
		
		label1.setBounds(10,10,150,20);
		
		text1 = new JTextField();
		text1.setBounds(10,40,150,20);
		if(text1.getText()!=""){
		//p1 = new Player(text1.getName());
		
		}
        
		label1.setBackground(Color.BLACK);
		label1.setOpaque(true);
		label1.setBackground(Color.BLACK);
		label1.setForeground(Color.RED); 
		getContentPane().add(label1);
		getContentPane().add(text1);
		
		// label2 and its text
		label2 = new JLabel("Second Player's name:");
		label2.setBounds(10,70,150,20);
		text2 = new JTextField();
		text2.setBounds(10,100,150,20);
	
			
			
		label2.setBackground(Color.BLACK);
		label2.setOpaque(true);
		label2.setBackground(Color.BLACK);
		label2.setForeground(Color.RED); 
		
		
		
		getContentPane().add(label2);
		getContentPane().add(text2);

		
		
		// the start game button 
		button1 = new JButton();
		button1.setText("Start Game");
		button1.setFont(new Font(Font.SERIF, 14, 20));
		button1.setBounds(550,550,150,20);
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.RED);
		button1.addMouseListener(this);
		getContentPane().add(button1);
		
		background = new JLabel();
		background.setBounds(0,0,1300,950);
		background.setLayout(null);
		background.setIcon(new ImageIcon("5870.jpg"));
		//background.setOpaque(true);
		getContentPane().add(background);
	}

	public static  Board getBoard() {
		return board;
	}

	public static void main(String[] args) throws IOException, UnexpectedFormatException {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==button1);
		{ 
			//initialize el game
			try {
				try {
					p1 = new Player(text2.getText());
				} catch (UnexpectedFormatException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					p2 = new Player(text2.getText());
				} catch (UnexpectedFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				board.startGame(p1, p2);
				p1= board.getActivePlayer();
				p2=board.getOpponentPlayer();
			
				
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			
			SecondFrame gameFrame= new SecondFrame();
			
			gameFrame.setVisible(true);
			dispose();
			
		}
		
		
	}

	public  Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public static Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
		
	}

}
