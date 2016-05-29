package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

public class GameOver extends JFrame implements MouseListener {
  JLabel background;
  JButton Again;
  JButton NO;
  JLabel winner;
  MyFrame restart;
  
	public GameOver() throws HeadlessException {
		setTitle("GAME OVER!");
		setBounds(0,0,1300,1300);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		Again= new JButton("Play again");
		Again.setFont(new Font(Font.SERIF, 14, 20));
		Again.setBounds(550,550,200,100);
		Again.setBackground(Color.BLACK);
		Again.setForeground(Color.RED);
		Again.addMouseListener(this);
		getContentPane().add(Again);
		
		NO= new JButton("No, Thank you :)");
		NO.setFont(new Font(Font.SERIF, 14, 20));
		NO.setBounds(800,700,200,100);
		NO.setBackground(Color.BLACK);
		NO.setForeground(Color.RED);
		NO.addMouseListener(this);
		getContentPane().add(NO);
		
		winner= new JLabel("The Winner is : "+ MyFrame.getBoard().getWinner().getName() + "WOHOOOOO!!!!!");
		winner.setBounds(10,70,200,100);
		winner.setBackground(Color.BLACK);
		winner.setForeground(Color.RED);
		winner.addMouseListener(this);
		getContentPane().add(winner);

		
		
		
		
		background = new JLabel();
		background.setBounds(0,0,1300,950);
		background.setLayout(null);
		background.setIcon(new ImageIcon("5870.jpg"));
		//background.setOpaque(true);
		getContentPane().add(background);

		this.validate();
	}

	public GameOver(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public GameOver(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public GameOver(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==Again){
			addMouseListener(this);
			try {
				restart = new MyFrame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnexpectedFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			restart.setVisible(true);
			restart.validate();
	
		}
		if(e.getSource()==NO){
			System.exit(0);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
