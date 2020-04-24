
package buzzzer;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
class Buzzzer implements ActionListener {
    int c=0;
    String[] str=new String[26];
    int par=0;
    int l=str.length;
    JFrame fra;
    JFrame fra2;
    JLabel lb3,lb4;
    TextField tx,area,time;
      JButton nxt,bck;
      JButton strt,close,buzz,buzzques,hold;
      boolean yo=false,buzzon=true,bhold=false;
      JLabel lb,lb2,lb5;
      int readtime=3000;
      int lby=250;
      int gatetime=2000;
      int showtime=1000;
      int gap=0;
      //by default buzzer with questions
      
    public void input()
    {
    
        fra=new JFrame("BUZZER:fill.in.participants");
        
        JLabel lb=new JLabel("  Name Of Participants:");
        lb.setLocation(0, 0);
        lb.setSize(250, 30);
        lb.setHorizontalAlignment(0);
        fra.add(lb);
        
        
        
        lb3=new JLabel();
        lb3.setBounds(0,170,270,30);
        lb3.setHorizontalAlignment(0);
        fra.add(lb3);
        
        
        
        
        
         tx=new TextField("Participant "+(par+1));
        tx.setBounds(10,40,250,30);
        
        
        fra.add(tx);
        fra.setLayout(null);
        fra.setSize(290,350);
        fra.setVisible(true);
        
        fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        buzz=new JButton("ONLY BUZZER");
        buzz.setBounds(10,120,120,30);
        buzz.addActionListener(this);
        fra.add(buzz);
        
        buzzques=new JButton("+QUESTIONS");
        buzzques.setBounds(140,120,120,30);
        buzzques.addActionListener(this);
        fra.add(buzzques);
        
        
        
        
        nxt=new JButton("ADD>>");
        nxt.setBounds(30,80,100,30);
        nxt.addActionListener(this);
        fra.add(nxt);
        
        bck=new JButton("BACK<<");
        bck.setBounds(140,80,100,30);
        bck.addActionListener(this);
        fra.add(bck);
        
        
        
        strt=new JButton("<<START>>");
        strt.setBounds(85,250,100,30);
        strt.addActionListener(this);
        fra.add(strt);
        
        time=new TextField("interval b/w questions(in sec)");
        time.setBounds(50,210,170,20);
    
            
        fra.getContentPane().setBackground(Color.gray);
        lb.setFont(new Font("Courier New", Font.ITALIC, 16));
                lb.setForeground(Color.white);
                lb3.setForeground(Color.white);
                        
        start();
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==nxt )
        {
            str[par]=tx.getText();
            par++;
            
            if(par<l)
            tx.setText("Participant "+(par+1));
            else
            {
                fra.setVisible(false);
                fra2.setVisible(true);
                yo=true;
                try{gap=Integer.parseInt(time.getText())*1000;}
                
                          catch(Exception e1){gap=0;}
                        
            }
        }
        if(e.getSource()==strt )
        {
                        fra.setVisible(false);
                        fra2.setVisible(true);
                        yo=true;
                        try{gap=Integer.parseInt(time.getText())*1000;}
                          catch(Exception e1){gap=0;}
                        
        }
        if(e.getSource()==close)
        {
            fra2.setVisible(false);
            exit(0);
        }
        if(e.getSource()==buzz)
        {
            lb3.setText("BUZZER : mode ON");
            lby=250;
            buzzon=true;
            time.setVisible(false);
        }
        if(e.getSource()==buzzques)
        {
            lb3.setText("BUZZER + QUESTIONS : mode ON");
            lby=450;
            buzzon=false;
            time.setVisible(true);
            fra.add(time);
            
        }
        if(e.getSource()==hold)
        {
            if(!bhold)
            {
                bhold=true;
                hold.setText("RESUME");
            }
            else
            {
                bhold=false;
                hold.setText("HOLD");
            }
        }
        if(e.getSource()==bck)
        {
            if(par>=1)
            {
                par--;
            tx.setText("Participant "+(par+1));
            str[par]="";
            }
        }
    }

    public void play() 
    {    
        try {
            File file =new File("ques.txt");
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()||buzzon)    
                
                //top:while(true)
            {
                
                fra2=new JFrame("LET'S Play");
                fra2.setSize(2000,1950);
                fra2.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
                fra2.getContentPane().setBackground(Color.BLACK);
                
                
                
                
                
                
                
                
                
                
                
                lb=new JLabel();
                lb.setLocation(200,lby);
                lb.setSize(1000, 70);
                lb.setHorizontalAlignment(0);
                
                lb.setFont(new Font("CASTELLAR", Font.BOLD, 70));
                lb.setForeground(Color.RED);
                
                
                
                fra2.add(lb);
                
                
                
                
                close=new JButton("--EXIT--");
                close.setBounds(1200,650,100,30);
                close.addActionListener(this);
                fra2.add(close);
                
                hold=new JButton("HOLD");
                hold.setBounds(1050,650,100,30);
                hold.addActionListener(this);
                fra2.add(hold);
                
                area=new TextField();
                area.setBounds(0,0,0,0);
                fra2.add(area);
                
                fra2.setLayout(null);
                if(yo)fra2.setVisible(true);
                
                
                
                if(!buzzon)
                {
                lb2=new JLabel();
                lb2.setLocation(130,30);
                lb2.setSize(1350, 50);
                //lb2.setHorizontalAlignment(0);
                lb2.setFont(new Font("CASTELLAR", Font.BOLD, 18));
                lb2.setForeground(Color.WHITE);
                
                lb5=new JLabel();
                lb5.setLocation(10,30);
                lb5.setSize(100, 50);
                c++;
                lb5.setText("QUES "+c+":");
                //lb2.setHorizontalAlignment(0);
                lb5.setFont(new Font("MONOTYPE CORSIVA", Font.BOLD, 26));
                lb5.setForeground(Color.WHITE);
                
                
                
                fra2.add(lb2);
                fra2.add(lb5);
                
                
                String s1="<html>";
                String[] s2=sc.nextLine().split(" ");
                
                top:for(int x=0;x<s2.length;x++)
                {
                    if((s1+" "+s2[x]).length()%60!=0)
                        s1=s1+" "+s2[x];
                    else
                        s1=s1+"<br/>"+s2[x];
                    
                }
                s1=s1+"<html>";
                lb2.setText(s1);
                
                
                
                try {
                        Thread.sleep(readtime);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Buzzzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                
                
                
                
                
                }
                
                    while(bhold)
                        pause();
                
                lb.setText("NOW");
                area.setText("");
              /*  area=new TextField();
                area.setBounds(0,0,0,0);
                fra2.add(area);*/
                
                
                do
                {
                     try {
                        Thread.sleep(gatetime);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Buzzzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }while(!yo);
                 
                top:for(int b=1;b<=2;b++)
             {
                String s=area.getText();
                char c='a';
                try{
                    c=s.charAt(0);
                    lb.setText(str[(int)c-97]);
                    
                    lb.setFont(new Font("CASTELLAR", Font.BOLD, 90));
                    lb.setForeground(Color.yellow);
                    fra2.getContentPane().setBackground(Color.GRAY);
                    //s=c+"";
                }
                catch(Exception e)
                {
                    
                    while(bhold)
                        pause();
                    //fra2.setVisible(false);
                    //play();
                    //continue top;
                }
                
             }  
                
                
               do{
               try {
                    Thread.sleep(showtime);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Buzzzer.class.getName()).log(Level.SEVERE, null, ex);
                }
               }while(bhold);
               
               
                try {
                    Thread.sleep(gap);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Buzzzer.class.getName()).log(Level.SEVERE, null, ex);
                }
                fra2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fra2.setVisible(false);
                
                //play();
            }  
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Buzzzer.class.getName()).log(Level.SEVERE, null, ex);
            
            
            
            
        }
        
       
        exit(0);
    }  
    
    
    public void start()
    {
        play();
    }
    public void pause() 
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Buzzzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
    
    
    public static void main(String[] args) throws InterruptedException {
    
    Buzzzer ob=new Buzzzer();
  //  ob.buzzon=true;
    ob.input();
    
    }
    
}
