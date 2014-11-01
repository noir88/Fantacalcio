package com.fabrizio.fantavalcanneto;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.postgresql.util.MD5Digest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fabrizio.fantavalcanneto.persistence.RegistraUtente;
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
         
        return "FormRegistrazione";
    }
     
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Locale locale, Model model) {
        return "login";
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
    
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String login(@Validated User user, Model model) {
        model.addAttribute("userName", user.getUserName());
        return "user";
    }
}
