/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notepadappl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import static java.awt.SystemColor.text;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static javafx.scene.input.KeyCode.N;
import javax.swing.filechooser.FileNameExtensionFilter;
import static javax.swing.text.html.HTML.Attribute.N;

public class NotepadAppl extends JFrame implements ActionListener {

JMenuBar menubar=new JMenuBar();
JMenu file=new JMenu("File");
JMenu edit=new JMenu("Edit");
JMenu help=new JMenu("Help");


JMenuItem newFile= new JMenuItem("New");
JMenuItem openfile= new JMenuItem("Open");
JMenuItem saveFile = new JMenuItem("Save");
JMenuItem print= new JMenuItem("Print");
JMenuItem exit=new JMenuItem ("Exit");
JMenuItem cut= new JMenuItem("Cut");
JMenuItem copy= new JMenuItem ("Copy");
JMenuItem paste= new JMenuItem("Paste");
JMenuItem selectall = new JMenuItem("Select All");
JMenuItem about= new JMenuItem("About");

JTextArea textArea=new JTextArea();

NotepadAppl(){

 setTitle("Notepad Application");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBackground(Color.red);
        ImageIcon icon=new ImageIcon(getClass().getResource("EwsqwVtVgAESqD6.png"));
         setIconImage(icon.getImage());

setJMenuBar(menubar);
menubar.add(file);
menubar.add(edit);
menubar.add (help);

menubar.add(file);
menubar.add(edit);
menubar.add(help);
file.add(newFile);
file.add(openfile);
file.add (saveFile);
file.add(print);
file.add(exit);


edit.add(cut);
edit.add(copy);
edit.add(paste);
edit.add(selectall);
help.add(about);

JScrollPane scrollpane=new JScrollPane(textArea);
add(scrollpane);
scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
scrollpane.setBorder(BorderFactory.createEmptyBorder());

textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
textArea.setLineWrap(true);
textArea.setWrapStyleWord(true);

newFile.addActionListener(this);
openfile.addActionListener(this);
saveFile.addActionListener(this);
print.addActionListener(this);
exit.addActionListener(this);
cut.addActionListener(this);
copy.addActionListener(this);
paste.addActionListener(this);
selectall.addActionListener(this);
about.addActionListener(this);

newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));  
openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));  
saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK)); 
print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
}   
    
 public void actionPerformed(ActionEvent e){
    if(e.getActionCommand().equalsIgnoreCase("New")){
  textArea.setText(null);
}else if(e.getActionCommand().equalsIgnoreCase("Open")){

 JFileChooser fileChooser=new JFileChooser();
FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Files.txt)", "txt");

fileChooser.setAcceptAllFileFilterUsed(false);
fileChooser.addChoosableFileFilter(textFilter);
int action=fileChooser.showOpenDialog(null);
if(action!=JFileChooser.APPROVE_OPTION){
   return;
}
else{
   String FileName=fileChooser.getSelectedFile().getAbsolutePath().toString();
   if(!FileName.contains(".txt"))
       FileName=FileName+"txt";  
       
   try{
       BufferedReader reader=new BufferedReader(new FileReader(fileChooser.getSelectedFile()));

       textArea.read(reader,null);
}catch (IOException ex){
       ex.printStackTrace();
}
}

}else if(e.getActionCommand().equalsIgnoreCase("Save")){

JFileChooser fileChooser=new JFileChooser();
FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Filest.tt)", "t");

fileChooser.setAcceptAllFileFilterUsed(false);
fileChooser.addChoosableFileFilter(textFilter);
int action=fileChooser.showSaveDialog(null);
if(action!=JFileChooser.APPROVE_OPTION){
   return;
}
else{
   String FileName=fileChooser.getSelectedFile().getAbsolutePath().toString();
   if(!FileName.contains(".txt"))
       FileName=FileName+"txt";  
       
   try{
       BufferedWriter writer=new BufferedWriter(new FileWriter(FileName));

       textArea.write(writer);
}catch (IOException ex){
       ex.printStackTrace();
}
}

}else if(e.getActionCommand().equalsIgnoreCase("Print")){

try{
  textArea.print();
}    catch  (PrinterException ex){
  Logger.getLogger(NotepadAppl.class.getName()).log(Level.SEVERE,null,ex);
}

}else if(e.getActionCommand().equalsIgnoreCase("Exit")){
System.exit(0);
}else if(e.getActionCommand().equalsIgnoreCase("Cut")){
  textArea.cut();
}else if(e.getActionCommand().equalsIgnoreCase("Copy")){
 textArea.copy();
}else if(e.getActionCommand().equalsIgnoreCase("Paste")){
textArea.paste();
}else if(e.getActionCommand().equalsIgnoreCase("Select All")){
textArea.selectAll();
}else if(e.getActionCommand().equalsIgnoreCase("About")){
new About().setVisible(true);
}

}
public static void main(String[] args) throws Exception {

UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new NotepadAppl().setVisible(true);
    }
}