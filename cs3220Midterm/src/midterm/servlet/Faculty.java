package midterm.servlet;

public class Faculty {

	private String department;
	
	private String name;
	
	private boolean isChairperson;
	
	public Faculty(String department, String name, boolean isChairperson){
		this.department = department;
		this.name = name;
		this.isChairperson = isChairperson;
	}
		
	public String getDepartment(){
		return department;
	}
	
	public void setDepartment(String department){
		this.department = department;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public boolean getIsChairperson(){
		return isChairperson;
	}
	
	public void setIsChairperson(boolean isChairperson){
		this.isChairperson = isChairperson;
	}
	
	
	
}
