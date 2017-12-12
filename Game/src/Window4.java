import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Window4 extends JFrame implements Runnable, ActionListener{
	private static final long serialVersionUID = 1L;
	public ImageIcon background = new ImageIcon("bg.png");
	public ImageIcon win = new ImageIcon("marbg1.jpg");		
	
	JLabel bg,w,l1,l2,l3,l4;
	Thread t;

	JButton b1,b2;
	
	public Window4() {
		bg = new JLabel(background);
		w = new JLabel(win);

		setTitle("GameOver");
		setSize(600,385);
		setLocationRelativeTo(null);
		bg.setLayout(null);

		w.setBounds(150, 30, 300, 220);
		
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

		l3 = new JLabel("You");
		l3.setBounds(170, 100, 150, 35);
		l3.setFont(new Font("Arial",'B',35));
		l3.setForeground(Color.WHITE);
		bg.add(l3);

		l4 = new JLabel("Won!");
		l4.setBounds(170, 140, 150, 35);
		l4.setFont(new Font("Arial",'B',35));
		l4.setForeground(Color.WHITE);
		bg.add(l4);

		b1 = new JButton("New Game");
		b1.setBounds(100, 310, 150, 30);
		b1.addActionListener(this);
		bg.add(b1);

		b2 = new JButton("Exit");
		b2.setBounds(350, 310, 150, 30);
		b2.addActionListener(this);
		bg.add(b2);
		
		bg.add(w);
		add(bg);
		
		setVisible(true);
		
	}
	
	public void wait1(){
		t = new Thread(this);
		t.start();	
	}	
	public void run() {
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		setVisible(false);
		new Window1();
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
		new Window4();
	}
*/
}
