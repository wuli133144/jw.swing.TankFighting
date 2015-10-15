/**
 *
 *文件名：CRiver.java 
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

/**
 * @author jackwu
 *
 */
public class CRiver {
	
public final int width=40;
public final int Long=100;

private int x,y;
private TankStart start;

public CRiver(int x,int y,TankStart start){
  this.x=x;
  this.y=y;
  this.start=start;
}

//加载图片资源
private static Image []imgs=null;
private static Toolkit tk=Toolkit.getDefaultToolkit();

static {
	
     //加载
	 imgs=new Image[]{
			tk.getImage(BombTank.class.getResource("Images/river.jpg")),
	 };
}

public void draw(Graphics g){
	g.drawImage(imgs[0],x,y,null);
}

public int getRiverLength(){
	return Long;
}
public int getRivewidth(){
	return width;
}
public int getX(){
	return x;
}
public int getY(){
	return y;
}
public void setY(int y){
	this.y=y;
}
public void setX(int x){
	this.x=x;
}



public Rectangle getRectangle(){
	
	return new Rectangle(x,y,width,Long);
}


}
