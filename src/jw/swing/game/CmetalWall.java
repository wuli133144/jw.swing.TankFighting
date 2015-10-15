/**
 *
 *文件名：CmetalWall.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *内容摘要：金属的墙
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

import org.w3c.dom.css.Rect;

/**
 * @author jackwu
 *
 */
public class CmetalWall {
	
	//成员
	private int x=30,y=30;
	private int width,height;
	private TankStart tstart;
	
	
	public CmetalWall(int x,int y,TankStart _tankstart){
		this.x=x;
		this.y=y;
		this.tstart=_tankstart;
		
	}
	
	private static Image []imgs=null;
	private static Toolkit tk=Toolkit.getDefaultToolkit();
	static {
	
		imgs=new  Image[]{
				tk.getImage(BombTank.class.getResource("Images/metalWall.jpg")),
		};
		
		}
	
	
	//绘图函数
	public void draw(Graphics g){
		g.drawImage(imgs[0],x, y,null);
	}
   //属性函数
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
