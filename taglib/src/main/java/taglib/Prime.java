package taglib;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class Prime extends TagSupport{
   int number;
	public int getNumber() {
	return number;
}
   public void setNumber(int number) {
	this.number = number;
   }
	@Override
	public int doStartTag()throws JspException {
		 int flag = 0;

	        if (number <= 1) {
	            flag = 1; 
	        } else {
	            for (int i = 2; i <= Math.sqrt(number); i++) {
	                if (number % i == 0) {
	                    flag = 1;
	                    break;
	                }
	            }
	        }

	        try {
	            if (flag == 0) {
	                pageContext.getOut().println(number + " is a Prime Number");
	            } else {
	                pageContext.getOut().println(number + " is Not a Prime Number");
	            }
	        } catch (IOException e) {
	            throw new JspException("Error writing to JSP: " + e.getMessage());
	        }

		return SKIP_BODY;
	}
	
}
