/**
 *
 *文件名：normalWall.java 
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

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * @author jackwu
 *
 */
public class normalWall {

	 //构造函数
	private int x,y;
	private final int wall_width=20,wall_height=20;
	
	private TankStart tankstart;
	private int lifevalue;
	
	//添加控制面板
	private static Toolkit toolkit =Toolkit.getDefaultToolkit();
	//图片
	private static Image []imgs=null;
	//加载资源
	static {
		
		imgs=new Image[]{
				toolkit.getImage(normalWall.class.getResource("Images/commonWall")),
		};
	}
	
	
	
	
	public normalWall(int x,int y,TankStart tankstart){
		this.x=x;
		this.y=y;
		this.tankstart=tankstart;
	}
	
	
	public void draw(Graphics g){
		g.drawImage(imgs[0],0,0,null);
	}
	
public Rectangle getrectangle(){
	return new Rectangle(x,y,wall_width,wall_height);
}


}
