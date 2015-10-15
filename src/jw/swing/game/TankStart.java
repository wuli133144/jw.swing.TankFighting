/**
 *
 *文件名：TankStart.java 
 *copyright (c) 2015-2020 by jackwu
 *all rights reserved
 *内容摘要：入口
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
	
	//全局的值
	private final int frame_width=600;//设置窗口的宽
	private final int frame_height=800;//设置窗口的高
	private final float versionID=1l;//
	private final boolean Isvisible=true;
	//菜单选项
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
	List<CBullet> bullet=new ArrayList<CBullet>();//子弹
    List<CTank> tanks=new ArrayList<CTank>();//坦克
    //List<CBullet> bullet=new ArrayList<E>();
    List<CTree> trees=new ArrayList<CTree>();//树
    List<normalWall> normalwall=new ArrayList<normalWall>();//普通的墙
    List<CmetalWall> metalwall=new ArrayList<CmetalWall>();//金属墙
    List<normalWall> homewall=new ArrayList<normalWall>();//普通的墙
  //  List< CHome> home=new ArrayList<CHome>();
    List< CRiver> rivers=new ArrayList<CRiver>();
    
    
  //  List<E>
	//也可以这么写 
	//private ArrayList<MenuItem>submenu=null;
    
	public void updata(Graphics g)
	{
		jimage=this.createImage(frame_width,frame_height);
		Graphics gp=jimage.getGraphics();
		Color c=gp.getColor();
	
		gp.fillRect(0, 0, frame_width, frame_height);
		gp.setColor(c);//设置颜色
		
		//绘制图片
		//***************************
		
		//***************************
		//添加图片
		//
		g.drawImage(jimage,0,0,null);
		
		
	}
	//游戏的入口
	public void InitAllControl()
	{
       jmb=new MenuBar();
		
		jmainmenu0=new Menu("游戏帮助");
		jmainmenu1=new Menu("开始游戏");
		jmainmenu2=new Menu("游戏等级");
		jmainmenu3=new Menu("开始/暂停");
		//设置字体
		jmainmenu0.setFont(new Font("manoca",Font.BOLD,15));
		jmainmenu1.setFont(new Font("manoca",Font.BOLD,15));
		jmainmenu2.setFont(new Font("manoca",Font.BOLD,15));
		jmainmenu3.setFont(new Font("manoca",Font.BOLD,15));
		//设置子菜单
		
		jitem0=new MenuItem("开始游戏");
		jitem1=new MenuItem("暂停游戏");
		jitem2=new MenuItem("退出");
		jitem3=new MenuItem("游戏说明");
		jitem4=new MenuItem("级别1");
		jitem5=new MenuItem("级别2");
		jitem6=new MenuItem("级别3");
		jitem7=new MenuItem("级别4");
		jitem8=new MenuItem("继续？");
	    //	jitem9=new MenuItem();
		//设置子菜单字体
		jitem0.setFont(new Font("manoca",Font.BOLD,15));
		jitem1.setFont(new Font("manoca",Font.BOLD,15));
		jitem2.setFont(new Font("manoca",Font.BOLD,15));
		jitem3.setFont(new Font("manoca",Font.BOLD,15));
		jitem4.setFont(new Font("manoca",Font.BOLD,15));
		jitem4.setFont(new Font("manoca",Font.BOLD,15));
		jitem6.setFont(new Font("manoca",Font.BOLD,15));
		jitem7.setFont(new Font("manoca",Font.BOLD,15));
		jitem8.setFont(new Font("manoca",Font.BOLD,15));
		//开始菜单
		jmainmenu1.add(jitem0);
		jmainmenu1.add(jitem2);
		//等级菜单
		jmainmenu2.add(jitem4);
		jmainmenu2.add(jitem5);
		jmainmenu2.add(jitem6);
		jmainmenu2.add(jitem7);
		//开始暂停
		jmainmenu3.add(jitem1);
		jmainmenu3.add(jitem8);
		//游戏说明
		//jmainmenu4.add(jitem3);
		jmainmenu0.add(jitem3);
		//jmainmenu4.add(jitem0);
		jmb.add(jmainmenu0);
		jmb.add(jmainmenu1);
		jmb.add(jmainmenu2);
		jmb.add(jmainmenu3);
		
		
		jitem0.setActionCommand("开始游戏");
		jmainmenu0.addActionListener(this);
		
		jitem1.setActionCommand("stop");
		jitem1.addActionListener(this);
		
		jitem2.setActionCommand("游戏退出");
		jitem2.addActionListener(this);
		jitem3.setActionCommand("游戏说明");
		jitem3.addActionListener(this);
		
		jitem4.setActionCommand("级别1");
		jitem4.addActionListener(this);
		
		jitem5.setActionCommand("级别2");
		jitem5.addActionListener(this);
		
		jitem6.setActionCommand("级别3");
		jitem6.addActionListener(this);
		
		jitem7.setActionCommand("级别4");
		jitem7.addActionListener(this);
		
		jitem8.setActionCommand("继续？");
		jitem8.addActionListener(this);
		/*
		 * 	jitem0=new MenuItem("开始游戏");
		jitem1=new MenuItem("暂停游戏");
		jitem2=new MenuItem("退出");
		jitem3=new MenuItem("游戏说明");
		jitem4=new MenuItem("级别1");
		jitem5=new MenuItem("级别2");
		jitem6=new MenuItem("级别3");
		jitem7=new MenuItem("级别4");
		jitem8=new MenuItem("继续？");
		 * */

		this.setMenuBar(jmb);
		this.setVisible(Isvisible);
	
	}
	
	/***
	 * 构造函数
	 */
	public TankStart()
	{
		InitAllControl();//初始化所有的控件
		//设置背景图片
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		//设置大小
		this.setSize(frame_width,frame_height);
		this.setLocation(300, 80);
		this.addWindowListener(new WindowAdapter() {
			
			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosed(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {//关闭窗口
				// TODO Auto-generated method stub
				//super.windowClosed(e);
				System.exit(0);
				
			}
			
		});
		this.setTitle("作者 ：吴玉杰---完成时间：2015-10 ");
		this.setResizable(false);
		//this.isvisible(Isvisible);
		this.setVisible(Isvisible);//设置可见性
		
		
	   //添加键盘监听器
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
	
	//绘图进程
	private class drawthread implements Runnable
	{
		public  void run()
		{
			while(Isvisible)
			{
				repaint();//重绘图片
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
