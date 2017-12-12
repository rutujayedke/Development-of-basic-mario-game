import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Window2 extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;
	public ImageIcon background = new ImageIcon("bg.png");
	public ImageIcon mario = new ImageIcon("mario.png");
	public ImageIcon cross = new ImageIcon("cross.png");
	public ImageIcon coin = new ImageIcon("Coin.png");
	
	JLabel bg,cr1,cr2,c,m,l1,l2;
	public Thread t;

	Window2(){
		bg = new JLabel(background);
		m = new JLabel(mario);
		cr1 = new JLabel(cross);
		cr2 = new JLabel(cross);
		c = new JLabel(coin);

		setTitle("MARIO");
		setSize(600,385);
		setLocationRelativeTo(null);
	
		bg.setLayout(null);

		m.setBounds(230, 180, 40, 40);
		bg.add(m);
		cr1.setBounds(290, 190, 20, 20);
		bg.add(cr1);
		cr2.setBounds(450, 50, 20, 20);
		bg.add(cr2);
		c.setBounds(400, 40, 40, 40);
		bg.add(c);
		
		String s;
		l1 = new JLabel();
		s = String.valueOf(Player.count);
		l1.setText(s);
		l1.setBounds(490, 45, 300, 30);
		l1.setFont(new Font("Arial",'B',20));
		l1.setForeground(Color.WHITE);
		bg.add(l1);
		
		l2 = new JLabel();
		s = String.valueOf(Player.lives);
		l2.setText(s);
		l2.setBounds(330, 150, 300, 100);
		l2.setFont(new Font("Arial",'B',30));
		l2.setForeground(Color.WHITE);
		bg.add(l2);
		
		add(bg);		
		setVisible(true);
		wait1();
		
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
		new Player();

	}
	
/*	public static void main(String[] args) {
		new Window2();
	}
*/	
}
