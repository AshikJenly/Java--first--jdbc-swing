package userinput;
import java.sql.*;
public class data {
	static private data DATA;
	frameclass frame;
	private int rollno;
	private student stud;
	private Connection con;
	Statement stm;
	PreparedStatement ptm;
	ResultSet result;
	
	
	//Established connection throw Driver_manager
private data(frameclass frame){
//		super()
;
		
		
		try {
		Class.forName("org.sqlite.JDBC");
		con=DriverManager.getConnection("jdbc:sqlite:C:/sqlite/studinfo.db");	
		stm=null;
		ptm=null;
		stud=new student();
		rollno=getLastRoll();
		this.frame=frame;
		}
		catch(Exception e) {
			System.out.println("\n\t\tError occured in data() of data.java class");
			System.out.println(e.toString());
		}
		DATA =this;
	}
	//SINGLETON CONSTRUCTOR
public static data constructdata(frameclass frame) {
		if(DATA==null) {
				data temp=new data(frame);
				
				return temp;
		}
		else
				return DATA;
	}
public int getLastRoll() {
		int r=0;
		
		try {
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("SELECT * FROM students");
			while(rs.next())
			{
				r=rs.getInt("roll");
			}
			
			//System.out.println("roll from getlast"+r);
			
		}catch(Exception e) {
			System.out.println("\nError in to roll() "+e.toString());
		}
		return r+1;
	}
public void insert(student newStd) {
	    	try {
	    	ptm=con.prepareStatement("INSERT into students values(?,?,?,?,?,?)");
	    	
	    	ptm.setInt(1, rollno);rollno++;
	    	ptm.setString(2, newStd.getname());
	    	ptm.setInt(3, newStd.getage());
	    	ptm.setString(4, newStd.getCollege());
	    	ptm.setString(5, newStd.getCourse());
	    	ptm.setString(6, newStd.getMobile());
	    	
	    	ptm.executeUpdate();
	    	
	    	}
	    	catch(Exception e) {
	    		System.out.println("\nError Occured in insert "+e.toString());
	    		}
	    }
public void terminate_all() {
			try{
				if(stm!=null)
					stm.close();
				if(ptm!=null)
					ptm.close();
				if(con!=null)
					con.close();
			}catch(Exception e) {
				System.out.println("\nError in termination ");
				System.out.println(e.toString());
			}
			System.out.println("\nSuccessFully Terminated");
	}
	
	
public  void displayAll() {
		
		try {
			stm=con.createStatement();
			result=stm.executeQuery("SELECT * FROM students");
			
			while(result.next()) {
					stud=getOneStudent();
					frame.text_area_updation(stud);
					frame.text_area.append("\n\t  <<<    -----     >>>\n");
					
					}
		}
		catch(Exception e) 
		{
			System.out.println("\n\t\tError occured in displayAll()");
			System.out.println(e.toString());
		}
	}
	 
	
private student getOneStudent() {
	    	if(result!=null) {
	    	student stud =new student();
	    	try{stud.setData(
					result.getInt("roll"),
					result.getString("name"),
					result.getInt("age"),
				    result.getString("college"),
				    result.getString("course"),
				    result.getString("mobile")
				    );
	    	}catch(Exception e) {
	    		System.out.println("\nError occured in getOneStudent\n"+e.toString());
	    		
	    	}
	    	return stud;
	    	}
	    	else
	    		return null;
	    		    	    	
 		}
	    
	 
public student getStudentByRoll(int roll_no) {
		student std=null;
		try {
		ptm=con.prepareStatement("SELECT * FROM students WHERE roll=?");
		ptm.setInt(1,roll_no);
		result=ptm.executeQuery();
		std=getOneStudent();
		
		}
		catch(Exception e) {
			System.out.println("\nError in getStudentByRoll in data class"
					+e.toString());
		}
		
		return std;
	
}
	    
}	    
