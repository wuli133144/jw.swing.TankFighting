/**
 *
 *�ļ�����CTree.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *����ժҪ���������Ľ���
 *
 *�汾�ţ�1.0
 *���ߣ�jackwu
 *���ʱ�䣺2015-10-14
 *
 *�汾�ţ�1.0
 *ԭ���ߣ�jackwu
 *�޸��ߣ�jackwu
 *���ʱ�䣺2015-10-14
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
public class CTree {
 
	
	private  int x=30,y=30;
    private  int width,height;
    
    private TankStart tstart;
    
    
    public CTree(int x,int y,TankStart _tstart){
    	this.x=x;
    	this.y=y;
    	this.tstart=_tstart;
    	
    }
    
    
    private static Image []imgs=null;
    private static Toolkit tk=Toolkit.getDefaultToolkit();
    static {
    	
    	imgs=new Image[]{
    		tk.getImage(BombTank.class.getResource("Images/tree.gif")),	
    			
    	};
    	
    	
    }
    
    
    //���Բ�������
	
	public void draw(Graphics g) {
		g.drawImage(imgs[0],x, y, null);            //�ڶ�ӦX��Y������
	}
	public  int gettreeWidth() {
		return this.width;
	}
	public int gettreeheight(){
		return this.height;
	}
    
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}
    
    
    
    
    
    
	
}
