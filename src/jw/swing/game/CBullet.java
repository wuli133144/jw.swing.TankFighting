/**
 *
 *文件名：CBullet.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *内容摘要：子弹类的代码
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

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author jackwu
 *
 */
public class CBullet {
	
	
    //构造函数0
	public CBullet(int x,int y,Direction direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	   //构造函数1
		public CBullet(int x,int y,Direction direction,boolean bbulletfighter,State _state){
			this.x=x;
			this.y=y;
			this.direction=direction;
			this.bbulletfignter=bbulletfighter;
			this.state=_state;//设置初始状态
		}
	public CBullet(int x,int y,Direction direction,boolean bbulletfighter,TankStart _tank){
		this.x=x;
		this.y=y;
		this.direction=direction;
		this.bbulletfignter=bbulletfighter;
		this.start=_tank;//设置初始状态
	}
  private 	int x,y;//位置坐标
  private boolean bbulletfignter=true;//子弹从哪里发射的类型 敌人还是玩家
  public static  int width;
  public static int height;//子弹的大小
  private Direction direction;
  private State state;
  
  private static int speedx,speedy;//子弹的速度
  
  private TankStart start;
  
  //控制面板
  static Toolkit toolkit=Toolkit.getDefaultToolkit();
  //加载图片
  private static Image [] imgs=null;
  //索引表
  private static Map <String,Image> map=new HashMap<String, Image>();//存图片和索引
  
  static {
	  
	  imgs=new Image[]{
			  toolkit.getImage(BombTank.class.getResource("Images/bulletD.gif")),
			  toolkit.getImage(BombTank.class.getResource("Images/bulletL.gif")),
			  toolkit.getImage(BombTank.class.getResource("Images/bulletR.gif")),
			  toolkit.getImage(BombTank.class.getResource("Images/bulletU.gif")),
			  toolkit.getImage(BombTank.class.getResource("Images/bulletRD.gif")),
			  toolkit.getImage(BombTank.class.getResource("Images/bulletRU.gif")),
			  toolkit.getImage(BombTank.class.getResource("Images/bulletLD.gif")),
			  toolkit.getImage(BombTank.class.getResource("Images/bulletLU.gif")),
			 
			 };
	  map.put("U",imgs[3]);
	  map.put("D",imgs[0]);
	  map.put("L",imgs[1]);
	  map.put("R",imgs[2]);
	   }
   
  
  //移动
  public void move()
  {
	  if(this.direction == Direction.UP){
		  y=y-speedy;
	  }
	  else if(this.direction == Direction.DOWN){
		  y=y+speedy;
	  }
	  else if(this.direction == Direction.LEFT){
		  x=x-speedy;
	  }
	  if(this.direction == Direction.RIGHT){
		  y=y+speedy;
	  }
	  if(this.direction == Direction.STOP){
		   return ;
	  }
	  if(x<0 || y<0 ||x>start.WIDTH || y> start.HEIGHT){
		  state=State.DEAD;
	  }
  
	
}


//绘图
public void draw(Graphics g){
	if(state == State.DEAD){
		start.bullet.remove(this);//移除当前项
		return ; }
	else {
		
		switch(direction){
				case LEFT:
				{
					g.drawImage(map.get('L'), x, y,null);
					break;
				}
				case DOWN:{
					g.drawImage(map.get('D'), x, y,null);
					break;
				}
				case UP:{
					//g.draw3DRect(speedx, speedy, width, height, raised)
					g.drawImage(imgs[3], x, y,null);
					break;
				}
				case RIGHT:{
					g.drawImage(imgs[2],x,y,null);
					break;
				}
		
		}
		
		}
	move();
}



public State isalive(){
	return this.state;
}

public Rectangle getRectangle(){
	return new Rectangle(x,y,width,height);
}

//当子弹撞击到坦克时
public boolean Hittank(List<CTank> ls_tank){
	
	for(int i=0;i< ls_tank.size();i++)
	{
		if(hittank(ls_tank.get(i))){
			return true;
		}
	}
	return false;
}
//子弹打到坦克上


public  boolean   hittank( CTank tank){
	//子弹存在并且子弹与坦克有交集
	if(     (this.state == State.LIVING)
			&&(this.getRectangle().intersects(tank.getRect()))
			&&(tank.isaLive() == State.LIVING) 
			&&(this.bbulletfignter != tank.bfightertank)//子弹是敌人的子弹
		)
	{
		 
		 BombTank bomb=new BombTank(tank.getX(), tank.getY(),this.start);
		 start.bombTanks.add(bomb);
		 
			 if(tank.bfightertank){
				  if(tank.lifevalue >= 50){
					  tank.lifevalue-=50;
					}
				  else{
					  tank.lifevalue=0;
					  tank.setLife(State.DEAD);
					}
				}
			 
	    this.state=State.DEAD;
	    
		return true;
	 }
	
        return false;
	

	//return bbulletfignter;
}


//达到墙上
public boolean hitWall(normalWall wall){
	//if(tank)
	if( this.isalive() == State.LIVING){
		this.state=State.DEAD;
		this.start.normalwall.remove(wall);
		this.start.homewall.remove(wall);
		return true;
	}
	else {
		return false;
	}
	
}
public boolean hitWall(CmetalWall wall){
	
	if((this.isalive() == State.LIVING)  
	   &&(this.getRectangle().intersects(wall.getRectangle()))//碰撞检测
	  ){
		this.state=State.DEAD;
		return true;
		
	}
	return false;
}


public boolean hithomeWall(CTank tank){
	if(     (this.state == State.LIVING)
			&&(start.home.getRectangle().intersects(this.getRectangle()))
			&&(tank.isaLive() == State.LIVING)){
		
	   this.state=State.DEAD;
	   start.home.setAlive(State.DEAD);
	   return true;
	   
	}
	else {
		return false;
	}

}




}
