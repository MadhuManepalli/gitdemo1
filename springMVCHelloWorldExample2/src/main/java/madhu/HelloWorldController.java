package madhu;
/** 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String helloWorldMessage = "Hello from madhu!";
		return new ModelAndView("hello", "message", helloWorldMessage);
	}
	
	
}**/


import java.util.Map;

//using annotations

 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HelloWorldController {
 
    @RequestMapping("/hello")
    public ModelAndView hello() {
 
        String helloWorldMessage = "Hello  from madhu!";
        return new ModelAndView("hello", "message", helloWorldMessage);
    }
    
    @RequestMapping(value="/calcsi", method= RequestMethod.GET)
    public ModelAndView calcsi() {
 
        String simsg = "Hello Please Enter the Details!";
        return new ModelAndView("calcsi", "m", simsg);
    }
    
    @RequestMapping(value="/returnsi", method= RequestMethod.POST)
    public ModelAndView returnsi(@RequestParam Map<String,String> s) {
    	Integer p = Integer.valueOf(s.get("p"));
    	Integer r = Integer.valueOf(s.get("r"));
    	Integer t = Integer.valueOf(s.get("t"));
        String h = "The Details Are P : "+p+"R : "+r+"T : "+t+"The Simple Interest is : "+p*t*r;
        return new ModelAndView("returnsi", "m", h);
    }
    
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public ModelAndView login() {
        String simsg = "Hello Please Enter the Details!";
        return new ModelAndView("login", "msg", simsg);
    }
    
    @RequestMapping(value="/m", method= RequestMethod.POST)
    public ModelAndView msg(@ModelAttribute("s") user s) {
    	user si = new user();
    	si.setUname("madhumanepalli");
    	si.setPswd("madhu@1796");
    	si.setEmail("madhu.manepalli666@gmail.com");
    	ModelAndView returnsi = new ModelAndView("m");
    	String h= "Error";
    	if((s.getUname().equals(si.getUname()))
    			&&(s.getPswd().equals(si.getPswd()))&&
    			(s.getEmail().equals(si.getEmail()))) {
    		 h= "Hello!";
    		 returnsi.addObject("si" ,s.getUname());
    		 
    	}
    	returnsi.addObject("msg",h);
        return returnsi;
    }
}
  