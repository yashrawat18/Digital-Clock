import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class DigitalClock extends JFrame{
    private JLabel heading;
    private JLabel clockLabel;

    private Font font = new Font("",Font.BOLD,35);
    
    DigitalClock(){
        super.setTitle("Digital Clock");
        super.setSize(500,500);
        super.setLocation(300,50);
        this.createGUI();
        super.setVisible(true);
    }

    public void createGUI(){
        heading = new JLabel("My Clock");
        clockLabel = new JLabel("Clock");
        heading.setFont(font);
        clockLabel.setFont(font);
        startClock();
        this.setLayout(new GridLayout(2,1)); 
        this.add(heading);
        this.add(clockLabel);   
    }

    public void startClock(){
        // Timer timer = new Timer(1000,new ActionListener() {

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         //String DateTime = new Date().toString();
        //         //String dateTime = new Date().toLocaleString();
        //         Date d = new Date();
        //         SimpleDateFormat sfd = new SimpleDateFormat("hh:mm:ss a");
        //         String dateTime = sfd.format(d);
        //         clockLabel.setText(dateTime);

        //     }
            
        // });
       // timer.start();

        Thread t = new Thread(){
            public void run(){
                try{
                
                    while(true){
                    
                        Date d = new Date();
                        SimpleDateFormat sfd = new SimpleDateFormat("hh:mm:ss a");
                        String dateTime = sfd.format(d);
                        clockLabel.setText(dateTime);
                        //Thread.sleep(1000);
                        Thread.currentThread().sleep(1000);
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
    public static void main(String[] args) {
        new DigitalClock();
    }
}