/**
 *
 *�ļ�����CHome.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *����ժҪ��
 *
 *�汾�ţ�1.0
 *���ߣ�jackwu
 *���ʱ�䣺2015-10-13
 *
 *�汾�ţ�1.0
 *ԭ���ߣ�jackwu
 *�޸��ߣ�jackwu
 *���ʱ�䣺2015-10-13
 *
 **/

package jw.swing.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * @author jackwu
 *
 */
public class CHome {
	
	
	private int x,y;
	private int width,height;
	//private State live;
	private  TankStart tstart;
	
	private State state=State.LIVING;
	//���캯��
	public CHome(int x,int y,TankStart tstart){
		this.x=x;
		this.y=y;
		this.tstart=tstart;
	}
	
	//���캯��2
	private TankStart ts;
	//��ȡ�������
	private static Toolkit toolkit=Toolkit.getDefaultToolkit();
	//������Դ
	private  static Image [] imgs=null;
	
	static {
		
		imgs=new Image[]{
				
				toolkit.getImage(BombTank.class.getResource("Images/home.jpg")),
		};
		
		
	}
	
	
	//
	public void gameover(Graphics g){
		
		this.ts.tanks.clear();
		this.ts.bullet.clear();
		this.ts.bombTanks.clear();
		this.ts.homewall.clear();
		this.ts.rivers.clear();
		this.ts.normalwall.clear();
		//this.ts.
		this.ts.home.setAlive(State.DEAD);
		
		Color c=g.getColor();
		g.setColor(Color.RED);
		Font f=g.getFont();
		//g.setFont(font)
		g.setFont(new Font("manoca",Font.PLAIN,20));
		g.drawString("��Ϸ������", 200, 200);
		g.setFont(f);
		g.setColor(c);
		
   }
	//
	public void draw(Graphics g){
		
		if(this.isalive() == State.LIVING){
			g.drawImage(imgs[0],x,y,null);
			for(int i=0;i<this.ts.homewall.size();i++){
			  normalWall wall=ts.homewall.get(i);//��ȡǽ
			  wall.draw(g);//��ǽ
			}
		}
		else {
			this.gameover(g);//��Ϸ����
		}
		
	}
	
	public State isalive(){
		return state;
	}
	public Rectangle getRectangle(){
		return new Rectangle(x,y,width,height);
	}
	
	public void setAlive(State state){
		this.state=state;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int  getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}

}
