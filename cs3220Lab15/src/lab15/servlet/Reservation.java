package lab15.servlet;

public class Reservation {
	
	private Integer id;
	
	private String day;
	
	private String time;
	
	private String name;
	

	public Reservation(Integer id, String day, String time, String name ){
		this.id = id;
		this.day = day;
		this.time = time;
		this.name = name;
		
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getDay(){
		return day;
	}
	
	public void setDay( String day ){
		this.day = day;
	}
	
	public String getTime(){
		return time;
	}
	
	public void setTime( String time ){
		this.time = time;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
