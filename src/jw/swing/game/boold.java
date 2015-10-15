/**
 *
 *文件名：boold.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *内容摘要：
 *
 *版本号：1.0
 *作者：jackwu
 *完成时间：2015-10-14
 *
 *版本号：1.0
 *原作者：jackwu
 *修改者：jackwu
 *完成时间：2015-10-14
 *
 **/

package jw.swing.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

import org.w3c.dom.css.Rect;

/**
 * @author jackwu
 *
 */
public class boold {
    
	private  int x,y;
	private int width,height;
	private TankStart tstart;
	
	
	public boold(int x,int y,TankStart _tstart){
		this.x=x;
		this.y=y;
		this.tstart=_tstart;
	}
	
	public  State state=State.LIVING;
	public void setState(State state){
		this.state=state;
	}
	public State getState(){
		return state;
	}
	//生成随机数
	
	private static  Random r=new Random();
	//int num=r.nextInt(10)+5;
	int step=0;
	
	
	//加载图片
	private  static Image []imgs=null;
	
	private static Toolkit tk=Toolkit.getDefaultToolkit();
	
	static {
		 imgs=new Image[]{
				tk.getImage(BombTank.class.getResource("Images/hp.png")),
		 };
	
		
	}
	
	private int[][] position = { { 155, 196 }, { 500, 58 }, { 80, 340 },
			{ 99, 199 }, { 345, 456 }, { 123, 321 }, { 258, 413 } };
	
	
	public void draw(Graphics g){
	if(r.nextInt(100) >= 98){
		this.state = State.LIVING;
		move();
	}
	if(this.state == State.DEAD){
		return;
	}
		g.drawImage(imgs[0],x,y,null);
	}
	
	public void move(){
		step++;
		if(step == position.length){
			step=0;
		}
		this.x=position[step][0];
		this.y=position[step][1];
		
	}
	
    
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public Rectangle getRectangle(){
		return new Rectangle(x,y,width,height);
	}
	
}
