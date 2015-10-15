/**
 *
 *文件名：CTank.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *内容摘要：坦克类
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



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.w3c.dom.css.Rect;


/**
 * @author jackwu
 *
 */
public class CTank {
	private int Speedx=6,Speedy=6;//坦克的速度初始速度
	private  final int  count=0;
	private  static int tank_width=35,tank_height=35;
	private  Direction direction =Direction.STOP;//设置坦克的初始状态是静止的
	private  Direction direction_to=Direction.UP;//设置坦克的初始化方向
	
	
	TankStart tankstart;
	
	public boolean BU=false,BD=false,BR=false,BL=false;
	
	public int lifevalue=200;
	private State  islive=State.LIVING;//设置坦克的初始是活着的
	public boolean bfightertank=true;//坦克的类型 敌人还是玩家
	private int now_x,now_y;//新坐标
	private int old_x,old_y;//旧的坐标
	
	
	
	
	/**
	 *函数名：
	 *参数：
	 *返回值：void
	 *功能说明：
	 *完成时间：2015-10-12下午10:37:25
	 *作者：jackwu
	 */
	private  CTank(boolean bstate,int _x,int _y) {
		// TODO Auto-generated method stub
		now_x=_x;
		now_y=_y;
		old_x=_x;
		old_y=_y;
		bfightertank=bstate;//初始化坦克的状态
	}
	public CTank(int x,int y,boolean bstate,Direction direction,TankStart __startclient){
		this.now_x=x;
		this.now_y=y;
		this.bfightertank=bstate;
		this.tankstart=__startclient;
		this.direction=direction;
		
	}
	
	
	private static Random num=new Random();
	int step=num.nextInt(10)+5;//生成下一步的大小

	
	/*
	 * 加载资源图片
	 * 
	 * */
	private  static Image []ims=null;
	
	//控制面板
	private  static Toolkit toolkit=Toolkit.getDefaultToolkit();
	//静态区代码
	
	static 
	{
		ims=new Image[]{
				//Toolkit.
			    toolkit.getImage(BombTank.class.getResource("Images/tankU.gif")),
			    toolkit.getImage(BombTank.class.getResource("Images/tankD.gif")),
			    toolkit.getImage(BombTank.class.getResource("Images/tankL.gif")),
			    toolkit.getImage(BombTank.class.getResource("Images/tankR.gif")),
				
		     };
	}
		
	
	//绘图函数
	public void draw(Graphics g){
	
	 if(this.isaLive() == State.DEAD){
		  if(!bfightertank){
			  this.tankstart.tanks.remove(this);
			  
			 return;
		  }
		 
	}
	if(bfightertank){
		//画血包
		
	}
	switch(direction_to){
	
		case UP:
		{  
			g.drawImage(ims[0],now_x,now_y,null);
			break;
		}
		case DOWN:{
			g.drawImage(ims[1],now_x,now_y,null);
			break;
		}
		case LEFT:{
			g.drawImage(ims[2],now_x,now_y,null);
			break;
		}
		case RIGHT:{
			g.drawImage(ims[3],now_x,now_y,null);
			break;
		}
		 //添加移动的函数
	
	}
	}
public void move(){
	
	this.old_x=now_x;
	this.old_y=now_y;
	switch(direction){
	
	case UP:{
		now_y=now_y-Speedy;
		break;
	}
	case DOWN:{
		now_y=now_y+Speedy;
		break;
	}
	case LEFT:{
		now_x=now_x-Speedx;
		break;

	}
	case RIGHT:{
		now_x=now_x+Speedx;
		break;
	}
	case STOP:{
	    break;
	  }
}
	if(this.direction != Direction.STOP ){
		direction=direction_to;
	}
	if(now_x <0)
		now_x=0;
	if(now_y <=40)
		now_y=40;
	if(now_x >= this.tankstart.WIDTH-this.tank_width){
		now_x=this.tankstart.WIDTH;
	}
	if(now_y >= this.tankstart.HEIGHT-this.tank_height){
		now_y=this.tankstart.HEIGHT;
	}
	if(!bfightertank){
		
		Direction []directionarr=Direction.values();
		//产生随机路径
		if(step == 0){
			step=this.num.nextInt(10)+5;
			
			direction=directionarr[this.num.nextInt(directionarr.length)];//产生随机的方向
			
			
		}
		step--;
		//敌人开火
		if(num.nextInt(50) >=48){
			this.fire();
		}
	 }

}	
	


public void changetoold(){
	old_x=now_x;
	old_y=now_y;
	
}

//开火
public CBullet fire() {  //开火方法
	if ( this.isaLive() == State.DEAD){
		return null;
	}
	int x = this.now_x + CTank.tank_width / 2 - CBullet.width / 2;  //开火位置
	int y = this.now_y + CTank.tank_height / 2 - CBullet.height / 2;
	CBullet m = new CBullet(x, y + 2,direction, bfightertank, this.tankstart);  //没有给定方向时，向原来的方向发火
	tankstart.bullet.add(m);                                              
	return m;
}

//撞到一般墙
public boolean cracktowall(normalWall wall){
	if(this.getRect().intersects(wall.getrectangle())){
		changetoold();
		return true;
	}
	return false;
	
}
//装到金属墙
public boolean cracktowall(CmetalWall wall){
	if(this.getRect().intersects(wall.getRectangle())){
		changetoold();
		return true;
	}
	return false;
	
}

public boolean cracktoriver(CRiver river){
	if(this.getRect().intersects(river.getRectangle())){
		changetoold();
		return true;
	}
	return false;
}
public boolean cracktohome(CRiver river){
	if(this.getRect().intersects(river.getRectangle())){
		changetoold();
		return true;
	}
	return false;
}
//撞到墙壁时
public boolean cracktotank(java.util.List<CTank> tanks){
	
	for(int i=0;i< tanks.size();i++){
		CTank tank =tanks.get(i);
		
		if(this !=tank){
			if(this.getRect().intersects(tank.getRect())
					&& this.islive == State.LIVING
					&& tank.islive == State.LIVING){
				this.changetoold();
				tank.changetoold();
				return true;
			}
			
		 }
			
		}
	return false;
	
	}
	

//画血包
public void drawblood(Graphics g){
  
	
	Color c=g.getColor();
	g.setColor(Color.red);
	g.drawRect(375, 585, this.tank_width, 10);
	int w = this.tank_width * lifevalue / 200;
	g.fillRect(375, 585, w, 10);
	g.setColor(c);
	
	}
	
	public boolean eatblood(boold b){
		if(this.lifevalue <= 100)
		{
			lifevalue+=100;
			//b.state = State.DEAD;
			//b.state=State.DEAD;
			b.setState(State.DEAD);
			
			return true;
		}
		else 
		{
			lifevalue=200;
			return false;
		}
	
	}
	public void keyPressed(KeyEvent e) {  //接受键盘事件
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_R:  //当按下R时，重新开始游戏
		{
			break;
		}
		case  KeyEvent.VK_LEFT:{
			BL=true;
			break;
		}
		case KeyEvent.VK_RIGHT:{
			BR=true;
			break;
		}
		case KeyEvent.VK_UP:{
			BU=true;
			break;
		}
		case KeyEvent.VK_DOWN:{
			BD=true;
			break;
		}
		}
		
}
	
	public void keyReleased(KeyEvent e) {  //键盘释放监听
		int key = e.getKeyCode();
		switch (key) {
		
		case KeyEvent.VK_F:
			fire();
			break;
			
		case KeyEvent.VK_RIGHT:
			BR = false;
			break;
		
		case KeyEvent.VK_LEFT:
			BL = false;
			break;
		
		case KeyEvent.VK_UP:
			BU = false;
			break;
		
		case KeyEvent.VK_DOWN:
			BD = false;
			break;
			

		}
		ToDirection();  //释放键盘后确定移动方向
	}

	public void ToDirection(){
		if(!BU&&!BD&&BL&&!BR){
			direction=Direction.LEFT;
		}
		if(!BU&&!BD&&!BL&&BR){
			direction=Direction.RIGHT;
		}
		if(!BU&&BD&&!BL&&!BR){
			direction=Direction.DOWN;
		}
		if(BU&&!BD&&!BL&&!BR){
			direction=Direction.UP;
		}
		
	}




	public Rectangle getRect(){
		return new Rectangle(now_x,now_y,tank_width,tank_height);
	}
	
	public State isaLive(){
		return islive;
	}
	//设置生命值
	 public void setLife(State state){
		this.islive=state;
	}
	 
	 public int getX(){
		 return now_x;
	 }
	 public int getY(){
		 return now_y;
	 }
	 
	 public int getLifeValue(){
		 return lifevalue;
	 }
	 public void setliftvalue(int value){
		 this.lifevalue=value;
	 }
	 //消息响应
	 
	 
}
