/**
 *
 *�ļ�����normalWall.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *����ժҪ��
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

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * @author jackwu
 *
 */
public class normalWall {

	 //���캯��
	private int x,y;
	private final int wall_width=20,wall_height=20;
	
	private TankStart tankstart;
	private int lifevalue;
	
	//��ӿ������
	private static Toolkit toolkit =Toolkit.getDefaultToolkit();
	//ͼƬ
	private static Image []imgs=null;
	//������Դ
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
