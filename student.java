package userinput;

public class student {
	private int roll,age;
	private String name,college,course,mobile;
	
	public student() {
		
	}
	public void setData(int roll,String name,int age,String college,String course,String mobile)
	{
		this.roll=roll;
		this.name=name;
		this.age=age;
		this.college=college;
		this.course=course;
		this.mobile=mobile;
	}
	
	public String toString() {
		
		String temp;
		temp="\n\tName    : "+name
			+"\n\tAge     : "+age
			+"\n\tRoll no : "+roll
			+"\n\tCollege : "+college
			+"\n\tCourse  : "+course
			+"\n\tMobile  : "+mobile;
		
		return temp;
		
	}
		public String getCollege() {return college;}
		public int getroll() {return roll;}
		public String getname() {return name;}
		public String getCourse() {return course;}
		public String getMobile() {return mobile;}
		public int getage() {return age;}
		
		public String checkData() {
			String str="NULL";
			str=anythingNull();
			if(str!="NULL")
					return str;
			if(!mobile.matches("[0-9]{10}"))
				str="Invalid Mobile Number";
			else if(!name.matches("\s*[A-Z|\s*]*\s*"))
				str="Invalid Name formate";
			else if(!college.matches("\s*[A-Z|\s*]*\s*"))
				str="Invalid College Name formate";
			else if(!course.matches("\s*[A-Z|\s*]*\s*"))
				str="Invalid course Name formate";
			if(age<0||age>99)
				return "Invalid Age ";
			
			
			return str;
		}
		public String anythingNull() {
			String str="NULL";
			if(name==null||college==null||course==null||mobile==null)
				str="Empty Data Not Allowed";
			
			return str;
		}
		
	
}
