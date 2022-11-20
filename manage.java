package userinput;

import javax.swing.JFrame;

public class manage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		frameclass f1=frameclass.getframeclass(null);
		data d1=data.constructdata(f1);
		f1.DATA=d1;
		
		
		f1.setSize(730,720);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	
		//d1.terminate_all();
		
		
//		
	}

}
