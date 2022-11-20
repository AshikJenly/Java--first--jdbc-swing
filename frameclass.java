package userinput;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
//import java.awt.LayoutManager;
import java.awt.event.*;


@SuppressWarnings("serial")
public class frameclass extends JFrame implements ActionListener{
		private static frameclass frame;
			data DATA;
			JMenuBar mainmenubar;
			JMenu menu1,menu2,menu_close,textarea_menu;
			JMenuItem item1,item2,item3,save,close,clear;
			
			JTextArea text_area,text_area2;
			JPanel panel1;
			JPanel mainPanel;
			
			JPanel panel2;
			JLabel insert_info;
			JLabel name,age,college,course,mobile;
			JTextField name_field,age_field,college_field,cou_field,mo_field;
			JButton insert,clear_t2;
			JScrollPane sp,sp2;
			JPanel panel_for_display;
			JLabel for_display_one;
			
			JTextField roll_no;
			JButton roll_Enter;
			
private frameclass(data d) {
				
				super("\t\t[   JENLY   ]");
				DATA =d;
				frame=this;
				//menu Bar
				addWindowListener(new WindowAdapter(){
		            public void windowClosing(WindowEvent e){
		                System.out.println("Closing Window");
		                DATA.terminate_all();
		            }
		        });
					
				{
					
					mainmenubar=new JMenuBar();
					menu_close=new JMenu("FILE");mainmenubar.add(menu_close);
					menu1=new JMenu("INSERT");mainmenubar.add(menu1);
					menu2=new JMenu("SEARCH");mainmenubar.add(menu2);
					textarea_menu=new JMenu("TEXT AREA");mainmenubar.add(textarea_menu);
					
					item1=new JMenuItem("DISPLAY ALL");menu2.add(item1);
					item1.addActionListener(this);
					item2=new JMenuItem("DISPLAY ONE");menu2.add(item2);
					item3=new JMenuItem("ENTER INFO");menu1.add(item3);
					save=new JMenuItem("SAVE ");menu_close.add(save);
					close=new JMenuItem("CLOSE ");menu_close.add(close);
					close.addActionListener(this);
					clear=new JMenuItem("CLEAR");
					clear.addActionListener(this);
					textarea_menu.add(clear);
						
					add(mainmenubar,BorderLayout.NORTH);
						
					}
					
					
					
				//Display all Layout	
				{	
					text_area = new JTextArea(20,30);text_area.setBorder(getBorder("INFO",Color.DARK_GRAY,3));
					text_area2=new JTextArea(10,25);
				    
				    text_area.setEditable(false);
				    text_area2.setEditable(false);
				    
				    for_display_one=new JLabel("      Search        ");
				    for_display_one.setBorder(getBorder("",Color.black,1));
				    panel_for_display=new JPanel();
				    panel_for_display.setBorder(getBorder("STUDENT",Color.YELLOW,3));
				    panel_for_display.setLayout(new GridLayout(2,1));
					
				    JPanel Temp =new JPanel();Temp.setBorder(getBorder("ROLL",Color.BLACK,2));
				    Temp.setLayout(new GridLayout(3,3));
				    roll_no=new JTextField(10);
				    roll_Enter=new JButton("ENTER");
				    
				    Temp.add(roll_no);Temp.add(roll_Enter);
				    roll_Enter.addActionListener(this);
				    //TO change
				    clear_t2=new JButton("CLEAR TEXT");
				    clear_t2.addActionListener(this);
				    
				    Temp.add(for_display_one,BorderLayout.SOUTH);
				    Temp.add(clear_t2);
				    
					{
						panel1=new JPanel();
						Border br=getBorder("STUDENT INFORMATION",Color.BLUE,5);
						panel1.setBorder(br);
						
						sp=new JScrollPane(text_area);
						sp2=new JScrollPane(text_area2);
						panel_for_display.add(Temp);
						panel_for_display.add(sp2);
						
						panel1.add(panel_for_display,BorderLayout.EAST);
						panel1.add(sp,BorderLayout.WEST);
						add(panel1,BorderLayout.SOUTH);
					}
				}
				//panel2
				{
					 panel2=new JPanel();
					 Border br=getBorder("ENTER VALUES",Color.MAGENTA,5);
					 panel2.setBorder(br);
					 
					 name =new JLabel("	ENTER__NAME	: ");
					 age = new JLabel("	ENTER__AGE		: ");
				  college =new JLabel("	ENTER__COLLEGE : ");
				    course=new JLabel("	ENTER__COURSE  : ");
				    mobile=new JLabel("	ENTER__MOBILE  : ");
				  
				   
				   name_field=new JTextField(20);age_field=new JTextField(20);
				   college_field=new JTextField(20);cou_field=new JTextField(20);
				   mo_field=new JTextField(20);
				   insert =new JButton("INSERT");
				   insert.setBackground(Color.GREEN);
				   insert.addActionListener(this);
				   
				   panel2.setLayout(new GridLayout(6,2,1,7));
				
					panel2.add(name);panel2.add(name_field);
					panel2.add(age);panel2.add(age_field);
					panel2.add(college);panel2.add(college_field);
					panel2.add(course);panel2.add(cou_field);
					panel2.add(mobile);panel2.add(mo_field);
					//updation field
					insert_info=new JLabel("         insert              ");
					panel2.add(insert_info);panel2.add(insert);
					add(panel2,BorderLayout.CENTER);
					
				}
					
			}
private Border getBorder(String title,Color color,int width) {
	Border br=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(color,width),
    		title,TitledBorder.CENTER,TitledBorder.CENTER);
	
	return br;
}
public static frameclass getframeclass(data d) {
				if(frame!=null)
					return frame;
				else
					return new frameclass(d);
					
			}
			
void text_area_updation(student stud) {
				//if truncate true
				text_area.append(stud.toString());
				
				
			}
void searchedStudent(student stud) {
	//if truncate true
//	text_area2.append(stud.toString());
	text_area2.setText(stud.toString());
	
}
void insertintodata() {
		
		try {
		int age=Integer.valueOf(age_field.getText());
	 	String name=name_field.getText().toUpperCase(),
		college=college_field.getText().toUpperCase(),
		course=cou_field.getText().toUpperCase(),
		mobile=mo_field.getText();

	 	student temporary=new student();
	 	temporary.setData(1, name, age, college, course, mobile);
	 	
	 	
	 	String str =temporary.checkData(); 
	 	 
	 	if(str=="NULL") {
//	 		System.out.println(temporary);
	 		DATA.insert(temporary);
	 		insert_info.setText("SUCCESSFULLY INSERTED");
	 	}
	 	else
	 		insert_info.setText(str);
		}catch(Exception e) {
			insert_info.setText("Error Occured");
		}
}
private void clearInsertField() {
	name_field.setText(null);age_field.setText(null);
	college_field.setText(null);cou_field.setText(null);
	mo_field.setText(null);
}
@Override
public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		 String action_cmd=e.getActionCommand();
		 
		 switch(action_cmd) {
		 		
		 		case "DISPLAY ALL":
		 				text_area.setText("");
		 				DATA.displayAll();
		 				break;
		 		case "CLOSE ":
		 				DATA.terminate_all();
		 				this.dispose();
		 				break;
		 		case "CLEAR":
		 				text_area.setText("");
		 				break;
		 		case "ENTER":
		 			
		 				if(roll_no.getText()==null)
		 						break;
		 				else {
		 						try
		 						{
		 							int roll=Integer.valueOf(roll_no.getText());
		 							roll_no.setText(null);
		 							if(roll>=DATA.getLastRoll())
		 								for_display_one.setText("Invalid Roll");
		 							else
		 							{
		 								student std=DATA.getStudentByRoll(roll);
		 								for_display_one.setText("ROLL NO : "+roll);
		 								searchedStudent(std);
		 								
		 							}
		 					}catch(Exception E) 
		 						{
		 						for_display_one.setText("Please Enter Roll");
		 					
		 						}
		 			}
		 			break;
		 		case "INSERT":	
		 				insertintodata();
		 				clearInsertField();
		 				break;
		 		case "CLEAR TEXT":
		 				text_area2.setText(null);
		 				for_display_one.setText("SEARCH BY ROLL");
		 				break;
		 		
		 	}
		}

			
		
}
