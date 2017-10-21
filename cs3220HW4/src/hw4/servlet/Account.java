package hw4.servlet;

public class Account {
	
	private String username;
	
	private String password;
	
	private Integer accId; 
	
	public Account( String username, String password, Integer accId )
    {
        this.username = username;
        this.password = password;
        this.accId = accId;
    }
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername( String username ){
		this.username = username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword( String password ){
		this.password = password;
	}
	
	public Integer getAccId(){
		return accId;
	}
	
	public void setAccId(Integer accId){
		this.accId = accId;
	}

}
