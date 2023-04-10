/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notepadappl;
import java.awt.Font;
import javax.swing.*;


public class About extends JFrame {
About (){
   setBounds(100,100, 500, 400);
   setTitle("About Motepad Application");
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
ImageIcon icon=new ImageIcon(getClass().getResource("EwsqwVtVgAESqD6.png"));
         setIconImage(icon.getImage());


   setLayout(null);

JLabel iconLabel=new JLabel(new ImageIcon(getClass().getResource("EwsqwVtVgAESqD6.png")));

iconLabel.setBounds(100,50,80,80);
add(iconLabel);
JLabel textLabel=new JLabel("<html>Welcome to Notepad<br>Notepad is a simple text editor\n" +
"for Microsoft windows and a basic text-editing program\n" +
"which enables computer users to create documents<br>All\n" +
"rights reserved@2022</html>");
textLabel.setBounds(100,50,350,300);
textLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
add(textLabel);
}
public static void main(String args[]){
   new About().setVisible(true);
}
}