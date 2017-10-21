package hw3.servlet;

public class File1 {

	private Integer id;
	
	private String name;
	
	private String type;
	
	private long size;
	
	private String date;
	
	private Integer parentId;
	
	private boolean isFolder;
	
	
	public File1( Integer id, String name, String type, long size, String date, Integer parentId, boolean isFolder )
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.date = date;
        this.parentId = parentId;
        this.isFolder = isFolder;
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
	
	public String getType(){
		return type;
	}
	
	public void setType( String type ){
		this.type = type;
	}
	
	public long getSize(){
		return size;
	}
	
	public void setSize(long size){
		this.size = size;
	}
	
	public String getDate(){
		return date;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public Integer getParentId(){
		return parentId;
	}
	
	public void setParentId(Integer parentId ){
		this.parentId = parentId;
	}
	
	public boolean getIsFolder(){
		return isFolder;
	}
	
	public void serIsFolder(boolean isFolder){
		this.isFolder = isFolder;
	}
	
	
	
	
	
	
	
	
	
	
	
}

