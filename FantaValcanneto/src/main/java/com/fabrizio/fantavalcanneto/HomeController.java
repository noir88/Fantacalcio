package com.fabrizio.fantavalcanneto;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.postgresql.util.MD5Digest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabrizio.fantavalcanneto.persistence.RegistraUtente;
import com.fabrizio.fantavalcanneto.security.LoginManager;
import com.fabrizio.fantavalcanneto.security.Md5PasswordEncrypter;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
     
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
     
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
         
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
         
        String formattedDate = dateFormat.format(date);
         
        model.addAttribute("serverTime", formattedDate );
         
        return "login";
    }
     
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session, 
    		@RequestParam(value="errorMessage", required=false) String errorMessage,
    		HttpServletRequest request) throws Exception {
    	
    	LoginManager lgmMgr = new LoginManager();
    	return lgmMgr.loginUser(user.getUserName(), user.getPassword(), request);
    }
   
    @RequestMapping(value = "/registraUtente", method = RequestMethod.POST)
    public String registraUtente(User user, Model model) throws Exception {
    	
    	String nextPage="";
    	boolean registrazioneEffettuata = true;
    	RegistraUtente registratore = new RegistraUtente();
    	
    	registrazioneEffettuata = registratore.registraUtente(user);
    	
    	nextPage=(registrazioneEffettuata? "RegistrazioneEffetuata" : "RegistrazioneFallita");
    	
    	return nextPage;
    	
    }
    
}
