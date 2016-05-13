import java.awt.Component;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class MyCellRenderer extends JLabel implements ListCellRenderer<Object> {
     final static ImageIcon longIcon = new ImageIcon("img/folder.png");
     final static ImageIcon shortIcon = new ImageIcon("img/file.png");

     // This is the only method defined by ListCellRenderer.
     // We just reconfigure the JLabel each time we’re called.

     public Component getListCellRendererComponent(
       JList<?> list,           // the list
       Object value,            // value to display
       int index,               // cell index
       boolean isSelected,      // is the cell selected
       boolean cellHasFocus)    // does the cell have focus
     {
         String s = value.toString();
         setText(s);
         File temp = new File("/usr/include/"+s);
         System.out.println(temp.getAbsolutePath());
         if(!s.equals("")){
        	 setIcon(new File("/usr/include/"+s).isDirectory() ? longIcon : shortIcon);
         }
         
         if (isSelected) {
             setBackground(list.getSelectionBackground());
             setForeground(list.getSelectionForeground());
         } else {
             setBackground(list.getBackground());
             setForeground(list.getForeground());
         }
         setEnabled(list.isEnabled());
         setFont(list.getFont());
         setOpaque(true);
         return this;
     }
 }
