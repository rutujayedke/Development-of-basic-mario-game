import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Window3 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	public ImageIcon background = new ImageIcon("bg.png");
	public ImageIcon GameOver = new ImageIcon("gameover.png");		
	
	JLabel bg,go,l1,l2;

	JButton b1,b2;
	
	public Window3() {
		bg = new JLabel(background);
		go = new JLabel(GameOver);

		setTitle("GameOver");
		setSize(600,385);
		setLocationRelativeTo(null);
		bg.setLayout(null);

		go.setBounds(200, 40, 200, 200);
		bg.add(go);
		
		String s ;
		l1 = new JLabel();
		s = "Total Score : ";
		l1.setText(s);
		l1.setBounds(220, 260, 200, 30);
		l1.setFont(new Font("Arial",'B',20));
		l1.setForeground(Color.WHITE);
		bg.add(l1);
		
		l2 = new JLabel();
		s = String.valueOf(Player.count);
		l2.setText(s);
		l2.setBounds(350, 260, 200, 30);
		l2.setFont(new Font("Arial",'B',30));
		l2.setForeground(Color.WHITE);
		bg.add(l2);

		b1 = new JButton("New Game");
		b1.setBounds(100, 310, 150, 30);
		b1.addActionListener(this);
		bg.add(b1);

		b2 = new JButton("Exit");
		b2.setBounds(350, 310, 150, 30);
		b2.addActionListener(this);
		bg.add(b2);
		
		add(bg);
		
		setVisible(true);
		
	}
	

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1){		//new game
			Player.count = 0;
			Player.lives = 3;
			setVisible(false);
			new Window2();
		}
		else{							//exit
			System.exit(0);
		}
	}
/*	public static void main(String[] args) {
		new Window3();
	}
*/
}
