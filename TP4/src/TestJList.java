import java.awt.GridLayout;
import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TestJList {
	protected JLabel label;
	protected JList list;
	protected JList list2;
	
	TestJList(){
		JFrame f = new JFrame("JList simple");
		String[] items = {"Paris","Madrid","Marseille","Londre","Lisbonne","Allemagne"};
		String[] sousFileList = {};
		File path = new File("/usr/include/");
		String[] fileList = path.list();
		
		list = new JList(fileList);
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list2 = new JList(sousFileList);
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				label.setText("Selection de : "+ list.getSelectedValue());
				File f = new File("/usr/include/"+list.getSelectedValue());
	
				if(f.isDirectory()){							
					list2.setListData(f.list());
				}else{
					list2.setListData(sousFileList);
					
				}
				
			}
		});
		
		list.setCellRenderer(new MyCellRenderer());
		list2.setCellRenderer(new MyCellRenderer());
		
		list2.setVisibleRowCount(3);
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list2.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				label.setText("Selection de : "+ list2.getSelectedValue());
				
			}
		});
		
		JScrollPane scroll = new JScrollPane(list);
		JScrollPane scroll2 = new JScrollPane(list2);
		
		Border b = BorderFactory.createTitledBorder("Liste");
		scroll.setBorder(b);
		
		Border b2 = BorderFactory.createTitledBorder("Liste2");
		scroll2.setBorder(b2);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
		panel.add(scroll);
		panel.add(scroll2);
		label = new JLabel("Aucune selection ! ");
		panel.add(label);
		
		
		f.getContentPane().add(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				new TestJList();
				
			}
		});
	}

}
