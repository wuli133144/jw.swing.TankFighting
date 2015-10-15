/**
 *
 *�ļ�����TankStart.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *����ժҪ�����
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



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InvalidNameException;
import javax.swing.JFrame;

/**
 * @author jackwu
 *
 */
public class TankStart extends JFrame implements ActionListener{
	
	//ȫ�ֵ�ֵ
	private final int frame_width=600;//���ô��ڵĿ�
	private final int frame_height=800;//���ô��ڵĸ�
	private final float versionID=1l;//
	private final boolean Isvisible=true;
	//�˵�ѡ��
	private MenuBar   jmb=null;
	
	private Menu      jmainmenu0=null,jmainmenu1=null,jmainmenu2=null,jmainmenu3=null;
	private MenuItem  jitem0=null;
	private MenuItem  jitem1=null;
	private MenuItem  jitem2=null;
	private MenuItem  jitem3=null;
	private MenuItem  jitem4=null;
	private MenuItem  jitem5=null;
	private MenuItem  jitem6=null;
	private MenuItem  jitem7=null;
	private MenuItem  jitem8=null;
	
	private Image     jimage=null;
	
	
	CHome home=new CHome(40, 40, this);
	
//	boold booldvalue=new boold(this.getX(), this.getY(), _tstart);	
	
	
	List<BombTank> bombTanks = new ArrayList<BombTank>();
	List<CBullet> bullet=new ArrayList<CBullet>();//�ӵ�
    List<CTank> tanks=new ArrayList<CTank>();//̹��
    //List<CBullet> bullet=new ArrayList<E>();
    List<CTree> trees=new ArrayList<CTree>();//��
    List<normalWall> normalwall=new ArrayList<normalWall>();//��ͨ��ǽ
    List<CmetalWall> metalwall=new ArrayList<CmetalWall>();//����ǽ
    List<normalWall> homewall=new ArrayList<normalWall>();//��ͨ��ǽ
  //  List< CHome> home=new ArrayList<CHome>();
    List< CRiver> rivers=new ArrayList<CRiver>();
    
    
  //  List<E>
	//Ҳ������ôд 
	//private ArrayList<MenuItem>submenu=null;
    
	public void updata(Graphics g)
	{
		jimage=this.createImage(frame_width,frame_height);
		Graphics gp=jimage.getGraphics();
		Color c=gp.getColor();
	
		gp.fillRect(0, 0, frame_width, frame_height);
		gp.setColor(c);//������ɫ
		
		//����ͼƬ
		//***************************
		
		//***************************
		//���ͼƬ
		//
		g.drawImage(jimage,0,0,null);
		
		
	}
	//��Ϸ�����
	public void InitAllControl()
	{
       jmb=new MenuBar();
		
		jmainmenu0=new Menu("��Ϸ����");
		jmainmenu1=new Menu("��ʼ��Ϸ");
		jmainmenu2=new Menu("��Ϸ�ȼ�");
		jmainmenu3=new Menu("��ʼ/��ͣ");
		//��������
		jmainmenu0.setFont(new Font("manoca",Font.BOLD,15));
		jmainmenu1.setFont(new Font("manoca",Font.BOLD,15));
		jmainmenu2.setFont(new Font("manoca",Font.BOLD,15));
		jmainmenu3.setFont(new Font("manoca",Font.BOLD,15));
		//�����Ӳ˵�
		
		jitem0=new MenuItem("��ʼ��Ϸ");
		jitem1=new MenuItem("��ͣ��Ϸ");
		jitem2=new MenuItem("�˳�");
		jitem3=new MenuItem("��Ϸ˵��");
		jitem4=new MenuItem("����1");
		jitem5=new MenuItem("����2");
		jitem6=new MenuItem("����3");
		jitem7=new MenuItem("����4");
		jitem8=new MenuItem("������");
	    //	jitem9=new MenuItem();
		//�����Ӳ˵�����
		jitem0.setFont(new Font("manoca",Font.BOLD,15));
		jitem1.setFont(new Font("manoca",Font.BOLD,15));
		jitem2.setFont(new Font("manoca",Font.BOLD,15));
		jitem3.setFont(new Font("manoca",Font.BOLD,15));
		jitem4.setFont(new Font("manoca",Font.BOLD,15));
		jitem4.setFont(new Font("manoca",Font.BOLD,15));
		jitem6.setFont(new Font("manoca",Font.BOLD,15));
		jitem7.setFont(new Font("manoca",Font.BOLD,15));
		jitem8.setFont(new Font("manoca",Font.BOLD,15));
		//��ʼ�˵�
		jmainmenu1.add(jitem0);
		jmainmenu1.add(jitem2);
		//�ȼ��˵�
		jmainmenu2.add(jitem4);
		jmainmenu2.add(jitem5);
		jmainmenu2.add(jitem6);
		jmainmenu2.add(jitem7);
		//��ʼ��ͣ
		jmainmenu3.add(jitem1);
		jmainmenu3.add(jitem8);
		//��Ϸ˵��
		//jmainmenu4.add(jitem3);
		jmainmenu0.add(jitem3);
		//jmainmenu4.add(jitem0);
		jmb.add(jmainmenu0);
		jmb.add(jmainmenu1);
		jmb.add(jmainmenu2);
		jmb.add(jmainmenu3);
		
		
		jitem0.setActionCommand("��ʼ��Ϸ");
		jmainmenu0.addActionListener(this);
		
		jitem1.setActionCommand("stop");
		jitem1.addActionListener(this);
		
		jitem2.setActionCommand("��Ϸ�˳�");
		jitem2.addActionListener(this);
		jitem3.setActionCommand("��Ϸ˵��");
		jitem3.addActionListener(this);
		
		jitem4.setActionCommand("����1");
		jitem4.addActionListener(this);
		
		jitem5.setActionCommand("����2");
		jitem5.addActionListener(this);
		
		jitem6.setActionCommand("����3");
		jitem6.addActionListener(this);
		
		jitem7.setActionCommand("����4");
		jitem7.addActionListener(this);
		
		jitem8.setActionCommand("������");
		jitem8.addActionListener(this);
		/*
		 * 	jitem0=new MenuItem("��ʼ��Ϸ");
		jitem1=new MenuItem("��ͣ��Ϸ");
		jitem2=new MenuItem("�˳�");
		jitem3=new MenuItem("��Ϸ˵��");
		jitem4=new MenuItem("����1");
		jitem5=new MenuItem("����2");
		jitem6=new MenuItem("����3");
		jitem7=new MenuItem("����4");
		jitem8=new MenuItem("������");
		 * */

		this.setMenuBar(jmb);
		this.setVisible(Isvisible);
	
	}
	
	/***
	 * ���캯��
	 */
	public TankStart()
	{
		InitAllControl();//��ʼ�����еĿؼ�
		//���ñ���ͼƬ
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		//���ô�С
		this.setSize(frame_width,frame_height);
		this.setLocation(300, 80);
		this.addWindowListener(new WindowAdapter() {
			
			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosed(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {//�رմ���
				// TODO Auto-generated method stub
				//super.windowClosed(e);
				System.exit(0);
				
			}
			
		});
		this.setTitle("���� �������---���ʱ�䣺2015-10 ");
		this.setResizable(false);
		//this.isvisible(Isvisible);
		this.setVisible(Isvisible);//���ÿɼ���
		
		
	   //��Ӽ��̼�����
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	
		
			
	
		
		
		
	}
	
	//��ͼ����
	private class drawthread implements Runnable
	{
		public  void run()
		{
			while(Isvisible)
			{
				repaint();//�ػ�ͼƬ
			        //Thread.sleep(50);
				 try {
						Thread.sleep(50);
					  } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					  }
			 }
			
			}
      }
	
	
	
	public static void main(String arg[])
	{
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	     public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
