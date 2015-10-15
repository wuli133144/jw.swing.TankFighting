/**
 *
 *文件名：BombTank.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *内容摘要：
 *
 *版本号：1.0
 *作者：jackwu
 *完成时间：2015-10-12
 *
 *版本号：1.0
 *原作者：jackwu
 *修改者：jackwu
 *完成时间：2015-10-12
 *
 **/

package jw.swing.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.ImageCapabilities;
import java.awt.Toolkit;

/**
 * @author jackwu
 *
 */
public class BombTank {
	
	private int step=0;
	
	//爆炸的位置坐标
	private int x;
	private int y;
	private static Toolkit toolkit=Toolkit.getDefaultToolkit();
	
	//设置坦克的生命值
	private  State state=State.LIVING;//坦克师有生命的坦克
	
	public TankStart tks=null;
	//图片
	private static Image []imgs=null;
	//静态代码区
	static 
	{
		imgs=new Image[]
				{  
				toolkit.getImage(BombTank.class.getClassLoader().getResource("Images/1.gif")),
				toolkit.getImage(BombTank.class.getClassLoader().getResource("Images/2.gif")),
				toolkit.getImage(BombTank.class.getClassLoader().getResource("Images/3.gif")),
				toolkit.getImage(BombTank.class.getClassLoader().getResource("Images/4.gif")),
				toolkit.getImage(BombTank.class.getClassLoader().getResource("Images/5.gif")),
				toolkit.getImage(BombTank.class.getClassLoader().getResource("Images/6.gif")),
				toolkit.getImage(BombTank.class.getClassLoader().getResource("Images/7.gif")),
				toolkit.getImage(BombTank.class.getClassLoader().getResource("Images/8.gif")),
				toolkit.getImage(BombTank.class.getClassLoader().getResource("Images/9.gif")),
				toolkit.getImage(BombTank.class.getClassLoader().getResource("Images/10.gif")),
				   
				};
		
	   }
	   
	
	//构造函数
	public BombTank(int x,int y,TankStart _tks)
	{
		 //初始化 
		this.x=x;
		this.y=y;
		this.tks=_tks;
	}
	 public void  drawbomb(Graphics g)
	 {
		 if(state == State.DEAD)//死坦克
			 {
				 //tks.bombTanks.remove(this);
				 tks.bombTanks.remove(this);
				 return; 
			 }
		 if(step == imgs.length)//炸弹炸光了重新开始
		   {
				 state= State.DEAD;
				 step=0;
				 return ;
			 }
		
		 
		 g.drawImage(imgs[step], 0,0,null);
		 step++;
	 }
	
	

}
