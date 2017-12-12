
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window1 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton button;
	JLabel bg,l1,l2;
	public ImageIcon mario_start_bg = new ImageIcon("mario_new.png");
	public ImageIcon mario_start = new ImageIcon("super_mario.png");
	public ImageIcon run = new ImageIcon("run.png");

	public Window1(){
		Player.count = 0;
		
		bg = new JLabel(mario_start_bg);
		l1 = new JLabel(mario_start);
		l2 = new JLabel(run);
		
		setTitle("MARIO");
		setSize(600,385);
		setLocationRelativeTo(null);
		bg.setLayout(null);

		l1.setBounds(53, 70, 144, 100);
		bg.add(l1);
		add(bg);
		
		button = new JButton(run);
		button.setBounds(50, 250, 150, 37);
		button.addActionListener(this);
		
		bg.add(button);
;
		setVisible(true);
	}
	
	
	public static void main(String args[]){
		new Window1();
	}

	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Window2();
		
	}
}
