package Final;

public class Course {

	
	private String name;
	
	private String courseType;
	
	private Boolean isMapped;
	
	
	
	public Course( String name, String courseType, Boolean isMapped )
    {
        this.name = name;
        this.courseType = courseType;
        this.isMapped = isMapped;
        
    }
	
	public String getName(){
		return name;
	}
	
	public void setName( String name ){
		this.name = name;
	}
	
	public String getCourseType(){
		return courseType;
	}
	
	public void setCourseType( String courseType ){
		this.courseType = courseType;
	}
	
	public Boolean GetIsMapped(){
		return isMapped;
	}
	
	public void setIsMapped( Boolean isMapped ){
		this.isMapped = isMapped;
	}
	
	
}


