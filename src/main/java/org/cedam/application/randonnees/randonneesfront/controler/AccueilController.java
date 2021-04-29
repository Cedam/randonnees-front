package org.cedam.application.randonnees.randonneesfront.controler;

import java.util.List;

import org.cedam.application.randonnees.randonneesfront.bean.TrekBean;
import org.cedam.application.randonnees.randonneesfront.proxies.TrekServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccueilController {

    @Autowired
    private TrekServiceProxy trekServiceProxy;
    
    @RequestMapping("/")
    public String accueil(Model model){
    	
    	List<TrekBean> treks =  trekServiceProxy.listeDesTreks();
    	model.addAttribute("treks", treks);
        return "Accueil1";
    }
    
}