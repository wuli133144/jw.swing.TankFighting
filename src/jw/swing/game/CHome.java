/**
 *
 *文件名：CHome.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *内容摘要：
 *
 *版本号：1.0
 *作者：jackwu
 *完成时间：2015-10-13
 *
 *版本号：1.0
 *原作者：jackwu
 *修改者：jackwu
 *完成时间：2015-10-13
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
	//构造函数
	public CHome(int x,int y,TankStart tstart){
		this.x=x;
		this.y=y;
		this.tstart=tstart;
	}
	
	//构造函数2
	private TankStart ts;
	//获取控制面板
	private static Toolkit toolkit=Toolkit.getDefaultToolkit();
	//加载资源
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
		g.drawString("游戏结束！", 200, 200);
		g.setFont(f);
		g.setColor(c);
		
   }
	//
	public void draw(Graphics g){
		
		if(this.isalive() == State.LIVING){
			g.drawImage(imgs[0],x,y,null);
			for(int i=0;i<this.ts.homewall.size();i++){
			  normalWall wall=ts.homewall.get(i);//获取墙
			  wall.draw(g);//画墙
			}
		}
		else {
			this.gameover(g);//游戏结束
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
