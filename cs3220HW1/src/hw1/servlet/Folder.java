package hw1.servlet;

public class Folder {
	
	private Integer id;
	
	private String name;
	
	private Integer parentId;
	
	//create getters and setters...these are the things that go into the table
	
	public Folder( Integer id, String name, Integer parentId )
    {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
	
	public Integer getId(){
		return id;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName( String name ){
		this.name = name;
	}
	
	public Integer getParentId(){
		return parentId;
	}
	
	public void setParentId(Integer parentId ){
		this.parentId = parentId;
	}
}
