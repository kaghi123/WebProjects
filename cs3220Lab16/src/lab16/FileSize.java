package lab16;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FileSize extends SimpleTagSupport{

	private int value;
	
	public FileSize()
    {
        value = 0;
    }
	
	public void setValue( int value )
    {
        this.value = value;
    }
	
	public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        if(value < Math.pow(2, 10)){
        	out.print( "B" );
        }
        else if(Math.pow(2, 10) <= value && value < Math.pow(2, 20)){
        	out.print( "KB" );
        }
        
        else if(value > Math.pow(2, 10)){
        	out.print( "MB" );
        }
        
    }
}
