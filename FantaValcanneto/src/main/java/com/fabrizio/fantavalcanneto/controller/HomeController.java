package com.fabrizio.fantavalcanneto.controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;






import model.Calciatore;
import model.User;

import org.postgresql.util.MD5Digest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabrizio.fantavalcanneto.persistence.GestoreCalciatori;
import com.fabrizio.fantavalcanneto.persistence.GestoreSquadre;
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
     
    @RequestMapping(value = "admin/CreaSquadra", method = RequestMethod.GET)
    public String retrieveData(Model model, HttpServletRequest request) throws Exception {
    	GestoreSquadre gestoreSquadre = new GestoreSquadre();
    	
    	request.setAttribute("utentiSenzaSquadra", gestoreSquadre.trovaUserSenzaSquadra());
    	return "admin/FormInserimentoSquadra";
    	
    }
    
    
    @RequestMapping(value = "admin/FormInserimentoScontro", method = RequestMethod.GET)
    public String sendToCreaScontro(HttpServletRequest request) throws Exception {
    	return "admin/FormInserimentoScontro";
    }
    
    @RequestMapping(value="admin/inserisciSquadra", method= RequestMethod.GET)
    	public String inserisciSquadra(HttpServletRequest request) throws Exception{
    		String nomeSquadra = request.getParameter("nomeSquadra");
    		String nomeGiocatore = request.getParameter("giocatore");
    		
    		GestoreSquadre gestoreSquadre = new GestoreSquadre();
    		
    		gestoreSquadre.inserisciSquadra(nomeGiocatore, nomeSquadra);
    		return "ciao";
    	}
    	                                                                          
    
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session, 
    		@RequestParam(value="errorMessage", required=false) String errorMessage,
    		HttpServletRequest request) throws Exception {

    	LoginManager lgmMgr = new LoginManager();
    	return lgmMgr.loginUser(user.getUserName(), user.getPassword(), request);
    	
    	
    }
    
    @RequestMapping(value = "/registraCalciatore", method = RequestMethod.POST)
    public String registraCalciatore(Calciatore calciatore, Model model, HttpSession session, 
    		@RequestParam(value="errorMessage", required=false) String errorMessage,
    		HttpServletRequest request) throws Exception {
    	
    	GestoreCalciatori gestoreCalciatori = new GestoreCalciatori();
    	return gestoreCalciatori.creaCalciatore(calciatore.getRuolo(), calciatore.getNome(), calciatore.getSquadraReale(), request);
    	
    }
    
    @RequestMapping(value = "FormInserimentoCalciatore", method=RequestMethod.GET)
    public String doNothing(){
    	return "FormInserimentoCalciatore";
    }
    
    @RequestMapping(value = "inserisciFormazione", method = RequestMethod.GET)
    public String preparaFormazione(HttpSession session, HttpServletRequest request) throws Exception {
    	String ruolo = "D";
    	GestoreSquadre gestoreSquadre = new GestoreSquadre();
    	Map<Integer,String> mappaCalciatori = 
    			gestoreSquadre.retrieveListOfPlayers(request, ruolo, ((User)session.getAttribute("utentes")).getId_utente());
    	
    	request.setAttribute("lista"+ruolo, mappaCalciatori);
    	return "InserimentoFormazione";
    }
   
    @RequestMapping(value = "/registraUtente", method = RequestMethod.POST)
    public String registraUtente(User user, Model model) throws Exception {
    	
    	String nextPage="";
    	boolean registrazioneEffettuata = true;
    	RegistraUtente registratore = new RegistraUtente();
    	
    	registrazioneEffettuata = registratore.registraUtente(user);
    	
    	nextPage=(registrazioneEffettuata? "RegistrazioneEffettuata" : "RegistrazioneFallita");
    	
    	return nextPage;
    	
    }
    
    
    @RequestMapping(value = "FormRegistrazione", method = RequestMethod.GET)
    public String getFormRegistrazione(HttpServletRequest request) throws Exception{
    	return "FormRegistrazione";
    }
    
}
