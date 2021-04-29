package org.cedam.application.randonnees.front.controler;

import java.util.List;

import org.cedam.application.randonnees.front.bean.TrekBean;
import org.cedam.application.randonnees.front.proxies.TrekServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    @Autowired
    private TrekServiceProxy trekServiceProxy;
    
    @GetMapping("/")
    public String accueil(Model model){
    	
    	List<TrekBean> treks =  trekServiceProxy.listeDesTreks();
    	model.addAttribute("treks", treks);
        return "Accueil";
    }
    
}