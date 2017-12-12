import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

//import com.sun.javafx.geom.Area;
//import com.sun.javafx.geom.PathIterator;
//import com.sun.javafx.geom.Rectangle;


public class Player extends JFrame implements KeyListener,Runnable{
	private static final long serialVersionUID = 1L;
	public JLabel l1,l2,l3,l4,C,coin,cross;
	public JLabel[] c;
	public JLabel[] m;
	public JLabel[] o;
	public JLabel[] b;
	
	
	public int[] collected;
	public int[] killed;
	public static final int BUDDHI = 5;
	public static final int COINS = 50;
	public static final int MOUNTAINS = 8;
	public static final int OBSTACLES = 1;
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public int facing = 0;
	static public int count = 0;
	static public int lives = 3;
	public int n_up = 0, n_l = 0, n_r = 0,n_s = 0;
	public int distance = 0;
	public int up = 1;
	
	public int x = 100,y = 325-40;
	public ImageIcon background = new ImageIcon("mariobg.png");
	public ImageIcon points = new ImageIcon("points.png");
	public ImageIcon playerFacingLeft = new ImageIcon("mario1.png");
	public ImageIcon playerFacingRight = new ImageIcon("mario2.png");

	public ImageIcon MarioStandingLeft = new ImageIcon("MarioStandingLeft.png");
	public ImageIcon MarioStandingRight = new ImageIcon("MarioStandingRight.png");
	public ImageIcon MarioWalkingLeft1 = new ImageIcon("MarioWalkingLeft1.png");
	public ImageIcon MarioWalkingRight1 = new ImageIcon("MarioWalkingRight1.png");
	public ImageIcon MarioWalkingLeft2 = new ImageIcon("MarioWalkingLeft2.png");
	public ImageIcon MarioWalkingRight2 = new ImageIcon("MarioWalkingRight2.png");
	public ImageIcon MarioJumpingLeft = new ImageIcon("MarioJumpingLeft.png");
	public ImageIcon MarioJumpingRight = new ImageIcon("MarioJumpingRight.png");
	public ImageIcon MarioJumpingFastLeft = new ImageIcon("MarioJumpingFastLeft.png");
	public ImageIcon MarioJumpingFastRight = new ImageIcon("MarioJumpingFastRight.png");
	public ImageIcon MarioDead = new ImageIcon("MarioDead.png");
    
	public ImageIcon Coin = new ImageIcon("Coin.png");
	public ImageIcon Mountain = new ImageIcon("mountain.png");
	public ImageIcon Mountain1 = new ImageIcon("mountain1.png");
	public ImageIcon grass = new ImageIcon("grass1.png");
	public ImageIcon grass1 = new ImageIcon("grass2.png");
	public ImageIcon Obstacle = new ImageIcon("obstacle.png");
	public ImageIcon Castle = new ImageIcon("castle.png");
	public ImageIcon pipe= new ImageIcon("pipe.png");
	public ImageIcon pipe1 = new ImageIcon("pipe1.png");
	public ImageIcon Buddhi = new ImageIcon("buddhi.png");
	public ImageIcon Cross = new ImageIcon("cross.png");

	public Thread t1,t2,t3,t4,t5,t6,t7;
	
	public Player(){
		l1 = new JLabel(background); 
		l2 = new JLabel(MarioStandingRight);
		l4 = new JLabel(points);

		facing = RIGHT;
		setSize(600,385);
		setLocationRelativeTo(null);
		l1.setLayout(null);
		l2.setBounds(x, y, 40, 40);
		distance = x;
		l1.add(l2);

		cross = new JLabel(Cross);
		cross.setBounds(450, 50, 20, 20);
		l1.add(cross);
		coin = new JLabel(Coin);
		coin.setBounds(400, 40, 40, 40);
		l1.add(coin);

		
		l3 = new JLabel(String.valueOf(count));
		l3.setBounds(490, 45, 300, 30);
		l3.setFont(new Font("Arial",'B',30));
		l3.setForeground(Color.BLACK);
		l1.add(l3);

		l4.setBounds(400, 30, 170, 60);
		l1.add(l4);

		add(l1);
		
		createWorld();
		
		t6 = new Thread(this);		
		t6.start();

		addKeyListener(this);
		setVisible(true);
		}
	
	public void sleepForTime(int t){
		try {
			Thread.sleep(t);
		} 
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public void createWorld(){
		
	//1.coins
	
		c = new JLabel[COINS];
		collected = new int[COINS];
		for(int i = 0; i < 5; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+200+i*40, y, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		for(int i = 5; i < 10; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+300+i*40, y-42, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		for(int i = 10;i < 14; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+400+i*40, y-(i-10)*10, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		for(int i = 14;i < 16; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+400+i*40, y-42, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		for(int i = 16;i < 20; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+400+i*40, y-40+(i-15)*10, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		//100+400+760=	
		//.........x =	120 ....1380
		//100+600+800
		int j = 10;
		for(int i = 20;i < 23; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+600+i*40, y-(j-10)*10, 30,40);
			j++;
			l1.add(c[i]);
			collected[i] = 0;
		}
		for(int i = 23;i < 24 ; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+600+i*40, y-42, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		j = 16;
		for(int i = 24;i < 27; i++){
		
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+600+i*40, y-110+(i-15)*10, 30,40);
			j++;
			l1.add(c[i]);
			collected[i] = 0;
		}		
		for(int i = 27; i < 28; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+800+i*40, y-42, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		
		//........1980...2050...2120
		
		for(int i = 28; i < 29; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+900+i*40, y-42, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		
		//........2120...2190...2260
		
		for(int i = 29; i < 30; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+1000+i*40, y-42, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		for(int i = 30; i < 35; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+1200+i*40, y, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		
		j = 10;
		for(int i = 35;i < 39; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+1400+i*40, y-(j-10)*10, 30,40);
			j++;
			l1.add(c[i]);
			collected[i] = 0;
		}
		for(int i = 39; i < 41; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+1500+i*40, y-42, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		
		j = 16;
		for(int i = 41;i < 45; i++){		
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+1600+i*40, y-40+(j-15)*10, 30,40);
			j++;
			l1.add(c[i]);
			collected[i] = 0;
		}
		
		//........3460..3530..3600
		
		for(int i = 45; i < 46; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+1700+i*40, y-10, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}	
		for(int i = 46; i < 47; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+1800+i*40, y-42, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}		
		for(int i = 47; i < 48; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+1900+i*40, y-10, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}
		for(int i = 48; i < 49; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+2000+i*40, y-42, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}		
		for(int i = 49; i < 50; i++){
			c[i] = new JLabel(Coin);
			c[i].setBounds(x+2100+i*40, y-10, 30,40);
			l1.add(c[i]);
			collected[i] = 0;
		}

	//2.obstacles
/*		o = new JLabel[OBSTACLES];
		killed  = new int[OBSTACLES];
		o[0] = new JLabel(Obstacle);
		o[0].setBounds(x+100, 325-40, 40, 40);
//		l1.add(o[0]);
		killed[0] = 0;
*/		
		
		b = new JLabel[BUDDHI];
		b[0] = new JLabel(Buddhi);
		b[0].setBounds(200, 325-40, 40, 40);
		l1.add(b[0]);
		b[1] = new JLabel(Buddhi);
		b[1].setBounds(1380, 325-40, 40, 40);
		l1.add(b[1]);
		b[2] = new JLabel(Buddhi);
		b[2].setBounds(2050, 325-40, 40, 40);
		l1.add(b[2]);
		b[3] = new JLabel(Buddhi);
		b[3].setBounds(2190, 325-40, 40, 40);
		l1.add(b[3]);
		b[4] = new JLabel(Buddhi);
		b[4].setBounds(3530, 325-40, 40, 40);
		l1.add(b[4]);
		
		
	//3.mountains
		
		m = new JLabel[MOUNTAINS];
		for(int i=0;i<MOUNTAINS;i++){
			if(i%4 == 0){
				m[i] = new JLabel(Mountain);
			}
			else if(i%4 == 1){
				m[i] = new JLabel(grass1);
			}
			else if(i%4 == 2){
				m[i] = new JLabel(Mountain1);
			}
			else{
				m[i] = new JLabel(grass);
			}
			l1.add(m[i]);
		}
		for(int i=0;i<4;i++){
			if(i%4 == 0){
				m[i].setBounds(x+200+i*300, 325-80, 190, 80);
			}
			else
				m[i].setBounds(x+200+i*600, 325-40, 190, 40);
			l1.add(m[i]);
		}
		for(int i=4;i<8;i++){
			if(i%4 == 0){
				m[i].setBounds(x+2300+(i-4)*300, 325-80, 190, 80);
			}
			else
				m[i].setBounds(x+2300+(i-4)*600, 325-40, 190, 40);
			l1.add(m[i]);
		}
	//Castle	
		C = new JLabel(Castle);
		C.setBounds(x+4300, 325-160, 197, 160);
		l1.add(C);		
		
	}
	
	public void moveWorld(int mo){
		java.awt.Rectangle r;

		for(int i=0;i<COINS;i++){
			r = c[i].getBounds();
			r.x = r.x + mo;
			c[i].setBounds(r);
		}
		for(int i=0;i<MOUNTAINS;i++){
			r = m[i].getBounds();
			r.x = r.x + mo;
			m[i].setBounds(r);
		}
		
		r = C.getBounds();
		r.x = r.x + mo;
		C.setBounds(r);
		
		for(int i=0;i<BUDDHI;i++){
			r = b[i].getBounds();
			r.x = r.x + mo;
			b[i].setBounds(r);
		}		

	}
	

	boolean isInside(int a, int b, int x, int y, int w, int h){
		if((x <= a)&&(a <= x+w)&&(y-h <= b)&&(b <= y))
			return true;
		else
			return false;	
	}

	public boolean intersects(JLabel l1,JLabel l2){
		java.awt.Rectangle r1;
		java.awt.Rectangle r2;
		r1 = l1.getBounds();
		r2 = l2.getBounds();
			
		if(isInside(r1.x, r1.y, r2.x, r2.y, r2.width, r2.height))
			return true;
		else if(isInside(r1.x+r1.width, r1.y, r2.x, r2.y, r2.width, r2.height))
			return true;
		else if(isInside(r1.x, r1.y-r1.height, r2.x, r2.y, r2.width, r2.height))
			return true;
		else if(isInside(r1.x+r1.width, r1.y-r1.height, r2.x, r2.y, r2.width, r2.height))
			return true;
		else
			return false;
	
	}

	public void collectCoinIfAny(){
		for(int i=0;i<COINS ;i++){
        	if(collected[i] == 0){
        		if(intersects(l2,c[i])){
                	l1.remove(c[i]);
                	collected[i] = 1;
                	count++;
                	//System.out.println(count);
                	l3.setText(String.valueOf(count));
                }
            }
        }
	}
	
	public void die() {
		t5 = new Thread(this);
		t5.start();
		try {
			t5.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void dieIfObstacle(){
/*		for(int i=0;i<OBSTACLES ;i++){
			if(killed[i] == 0){
				if(intersects(l2,o[i])){
					die();
				}				
			}
		}
*/		for(int i=0;i<BUDDHI ;i++){
			if(intersects(l2,b[i])){
				die();
			}				
		} 
		
		
	}
/*	public boolean isOnObstacle(JLabel l1,JLabel l2){
		java.awt.Rectangle r1;
		java.awt.Rectangle r2;
		r1 = l1.getBounds();
		r2 = l2.getBounds();
		
		System.out.println("00000");
		
		if((r1.y - r1.height) >= r2.y){
			System.out.println("oo000");
			if((r2.x <= r1.x)&&(r1.x <= r2.x+r2.width)){
				System.out.println("11111");
				return true;
			}
			if((r2.x <= r1.x+r1.width)&&(r1.x+r1.width <= r2.x+r2.width)){
				System.out.println("2222");
				return true;
			}
		}
		return false;
	}
	
	public void killIfLandsOnObstacle(){
		
		for(int i=0;i<OBSTACLES ;i++){
			if(killed[i] == 0){
				if(isOnObstacle(l2,o[i])){
					//killObstacle
					System.out.println("killed");
					o[i].setVisible(false);
					killed[i] = 1;
				}				
			}
		}
	}
*/	
	
	public void win(){
		setVisible(false);
		new Window4();
	}
	
	public void run(){
		if(Thread.currentThread() == t1){
        	l2.setIcon(MarioStandingLeft);
        	facing = LEFT;
        	for(int i = 0;i<10;i++){
        		if(i%2 == 0)
    				l2.setIcon(MarioWalkingLeft1);
    			else
    				l2.setIcon(MarioWalkingLeft2);

        		if(x == 20){
        			//don't move
        		}
        		else if(x == 100){
        			if(distance == 100){
            			//can move left
            			x = x - 4;
            			distance = distance - 4;
            			l2.setLocation(x,y);
            		}
        			else{
        				moveWorld(4);	//move world to right	
        				distance = distance - 4;
        			}
        		}
        		else{
        			x = x-4;
            		distance = distance - 4;
                	l2.setLocation(x,y);
        		}
        		dieIfObstacle();
            	collectCoinIfAny();
        		sleepForTime(20);
        	}
        	l2.setIcon(MarioStandingLeft);
		}
		if(Thread.currentThread() == t2){
        	l2.setIcon(MarioStandingRight);
        	facing = RIGHT;
        	for(int i = 0;i<10;i++){
    			if(i%2 == 0)
    				l2.setIcon(MarioWalkingRight1);
    			else
    				l2.setIcon(MarioWalkingRight2);

        		
        		if(x == 300){
        			moveWorld(-4);		//move world to left
        			distance = distance + 4;
        		}
        		else {
         			x = x+4;
        			distance = distance + 4;
                	l2.setLocation(x,y);	
        		}
            	dieIfObstacle();
        		collectCoinIfAny();
            	sleepForTime(20);
        	}
        	l2.setIcon(MarioStandingRight);
		}
		if(Thread.currentThread() == t3){
			if(facing == LEFT){
				l2.setIcon(MarioJumpingLeft);
				for(int j = 0; j < 20 ;j ++){
					y = y-4;
					l2.setLocation(x, y);
					dieIfObstacle();
					collectCoinIfAny();
					sleepForTime(10);
				}
				for(int j = 0; j < 20 ;j ++){
					y = y+4;
					l2.setLocation(x, y);
					//killIfLandsOnObstacle();
					dieIfObstacle();
					collectCoinIfAny();
					sleepForTime(10);
				}
				l2.setIcon(MarioStandingLeft);
			}
				
			else{
				l2.setIcon(MarioJumpingRight);
				for(int j = 0; j < 20 ;j ++){
					y = y-4;
					l2.setLocation(x, y);
					dieIfObstacle();
					collectCoinIfAny();
					sleepForTime(10);
				}
				for(int j = 0; j < 20 ;j ++){
					y = y+4;
					l2.setLocation(x, y);
					//killIfLandsOnObstacle();
					dieIfObstacle();
					collectCoinIfAny();
					sleepForTime(10);
				}
				l2.setIcon(MarioStandingRight);
			}
		}	
		if(Thread.currentThread() == t4){
			if(facing == LEFT){
				l2.setIcon(MarioJumpingLeft);
				for(int j = 0; j < 10 ;j ++){
					y = y-10;
		       		if(x == 20){
	        			//don't move
	        		}
	        		else if(x == 100){
	        			if(distance == 100){
	            			//can move left
	            			x = x - 8;
	            			distance = distance - 8;
	            		}
	        			else{
	        				moveWorld(8);	//move world to right	
	        				distance = distance - 8;
	        			}
	        		}
	        		else{
	        			x = x-8;
	            		distance = distance - 8;
	        		}	 
					l2.setLocation(x, y);
					dieIfObstacle();
					collectCoinIfAny();
					sleepForTime(20);
				}
				for(int j = 0; j < 10 ;j ++){
					y = y+10;
		       		if(x == 20){
	        			//don't move
	        		}
	        		else if(x == 100){
	        			if(distance == 100){
	            			//can move left
	            			x = x - 8;
	            			distance = distance - 8;
	            		}
	        			else{
	        				moveWorld(4);	//move world to right	
	        				distance = distance - 8;
	        			}
	        		}
	        		else{
	        			x = x-8;
	            		distance = distance - 8;
	        		}
					l2.setLocation(x, y);
					//killIfLandsOnObstacle();
					dieIfObstacle();
					collectCoinIfAny();
					sleepForTime(20);
				}
				l2.setIcon(MarioStandingLeft);
			}
			else{
				l2.setIcon(MarioJumpingRight);
				for(int j = 0; j < 10 ;j ++){
					y = y-10;
		       		if(x == 300){
	        			moveWorld(-8);		//move world to left
	        			distance = distance + 8;
	        		}
	        		else {
	         			x = x + 8;
	        			distance = distance + 8;	
	        		}	 
					l2.setLocation(x, y);
					dieIfObstacle();
					collectCoinIfAny();
					sleepForTime(20);
				}
				for(int j = 0; j < 10 ;j ++){
					y = y+10;
		       		if(x == 300){
	        			moveWorld(-8);		//move world to left
	        			distance = distance + 8;
	        		}
	        		else {
	         			x = x + 8;
	        			distance = distance + 8;	
	        		}
					l2.setLocation(x, y);
					//killIfLandsOnObstacle();
					dieIfObstacle();
					collectCoinIfAny();
					sleepForTime(20);
				}
				l2.setIcon(MarioStandingRight);
			}
			
		}	
		
	//die	
		if(Thread.currentThread() == t5){
			l2.setIcon(MarioDead);
			for(int j = 0; j < 10 ;j ++){
				y = y-8;
				l2.setLocation(x, y);
				sleepForTime(20);
			}
			for(int j = 0; j < 30 ;j ++){
				y = y+8;
				l2.setLocation(x, y);
				sleepForTime(20);
			}
			lives--;
			if(lives > 0){
				setVisible(false);
				new Window2();
			}
			else{
				setVisible(false);
				new Window3();
			}							
		}
		
	//buddhi
		if(Thread.currentThread() == t6){
			java.awt.Rectangle r;

			while(true){
				for(int i=0;i<BUDDHI;i++){
					r = b[i].getBounds();
					if(r.y == 325-40)
						up = 1;
					if(r.y == 125)
						up = 0;
					
					if(up == 1){
						r.y = r.y-2;
					}
					else{
						r.y = r.y+2;
					}				
					b[i].setBounds(r);
				}
				sleepForTime(20);
			
			}
		}

		if(distance >= 4400+80){
			win();
		}
	}
		
	
/*	public static void main(String[] a){
		new Player();	
		
	}
*/
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		//LEFT..............
        if(key == KeyEvent.VK_LEFT) {
        	if(n_l==0){
        		t1 = new Thread(this);
        		t1.start();
        		n_l++;
        	}
        	else{
        		if(!t1.isAlive()){
            		t1 = new Thread(this);
            		t1.start();
            	}	
        	}
        }
        //RIGHT.............
        if(key == KeyEvent.VK_RIGHT) {
        	if(n_r==0){
        		t2 = new Thread(this);
        		t2.start();
        		n_r++;
        	}
        	else{
        		if(!t2.isAlive()){
            		t2 = new Thread(this);
            		t2.start();
            	}	
        	}
        }
        //UP............only up and down jump
        if(key == KeyEvent.VK_UP){
        	if(n_up==0){
        		t3 = new Thread(this);
        		t3.start();
        		n_up++;
        	}
        	else{
        		if(!t3.isAlive()){
            		t3 = new Thread(this);
            		t3.start();
            	}	
        	}	
        }
        //SPACE............trajectory jump
        if(key == KeyEvent.VK_SPACE){
        	if(n_s==0){
        		t4 = new Thread(this);
        		t4.start();
        		n_s++;
        	}
        	else{
        		if(!t4.isAlive()){
            		t4 = new Thread(this);
            		t4.start();
            	}	
        	}	
        }
        
        
	}
        	        	
    public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {		
	}

}
