/**
 *
 *�ļ�����BombTank.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *����ժҪ��
 *
 *�汾�ţ�1.0
 *���ߣ�jackwu
 *���ʱ�䣺2015-10-12
 *
 *�汾�ţ�1.0
 *ԭ���ߣ�jackwu
 *�޸��ߣ�jackwu
 *���ʱ�䣺2015-10-12
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
	
	//��ը��λ������
	private int x;
	private int y;
	private static Toolkit toolkit=Toolkit.getDefaultToolkit();
	
	//����̹�˵�����ֵ
	private  State state=State.LIVING;//̹��ʦ��������̹��
	
	public TankStart tks=null;
	//ͼƬ
	private static Image []imgs=null;
	//��̬������
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
	   
	
	//���캯��
	public BombTank(int x,int y,TankStart _tks)
	{
		 //��ʼ�� 
		this.x=x;
		this.y=y;
		this.tks=_tks;
	}
	 public void  drawbomb(Graphics g)
	 {
		 if(state == State.DEAD)//��̹��
			 {
				 //tks.bombTanks.remove(this);
				 tks.bombTanks.remove(this);
				 return; 
			 }
		 if(step == imgs.length)//ը��ը�������¿�ʼ
		   {
				 state= State.DEAD;
				 step=0;
				 return ;
			 }
		
		 
		 g.drawImage(imgs[step], 0,0,null);
		 step++;
	 }
	
	

}
