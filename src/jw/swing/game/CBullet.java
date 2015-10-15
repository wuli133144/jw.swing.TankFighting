/**
 *
 *�ļ�����CBullet.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *����ժҪ���ӵ���Ĵ���
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

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author jackwu
 *
 */
public class CBullet {
	
	
    //���캯��0
	public CBullet(int x,int y,Direction direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	   //���캯��1
		public CBullet(int x,int y,Direction direction,boolean bbulletfighter,State _state){
			this.x=x;
			this.y=y;
			this.direction=direction;
			this.bbulletfignter=bbulletfighter;
			this.state=_state;//���ó�ʼ״̬
		}
	public CBullet(int x,int y,Direction direction,boolean bbulletfighter,TankStart _tank){
		this.x=x;
		this.y=y;
		this.direction=direction;
		this.bbulletfignter=bbulletfighter;
		this.start=_tank;//���ó�ʼ״̬
	}
  private 	int x,y;//λ������
  private boolean bbulletfignter=true;//�ӵ������﷢������� ���˻������
  public static  int width;
  public static int height;//�ӵ��Ĵ�С
  private Direction direction;
  private State state;
  
  private static int speedx,speedy;//�ӵ����ٶ�
  
  private TankStart start;
  
  //�������
  static Toolkit toolkit=Toolkit.getDefaultToolkit();
  //����ͼƬ
  private static Image [] imgs=null;
  //������
  private static Map <String,Image> map=new HashMap<String, Image>();//��ͼƬ������
  
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
   
  
  //�ƶ�
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


//��ͼ
public void draw(Graphics g){
	if(state == State.DEAD){
		start.bullet.remove(this);//�Ƴ���ǰ��
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

//���ӵ�ײ����̹��ʱ
public boolean Hittank(List<CTank> ls_tank){
	
	for(int i=0;i< ls_tank.size();i++)
	{
		if(hittank(ls_tank.get(i))){
			return true;
		}
	}
	return false;
}
//�ӵ���̹����


public  boolean   hittank( CTank tank){
	//�ӵ����ڲ����ӵ���̹���н���
	if(     (this.state == State.LIVING)
			&&(this.getRectangle().intersects(tank.getRect()))
			&&(tank.isaLive() == State.LIVING) 
			&&(this.bbulletfignter != tank.bfightertank)//�ӵ��ǵ��˵��ӵ�
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


//�ﵽǽ��
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
	   &&(this.getRectangle().intersects(wall.getRectangle()))//��ײ���
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
