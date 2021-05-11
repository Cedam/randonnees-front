package org.cedam.application.randonnees.front.controler;

import java.util.List;

import org.cedam.application.randonnees.front.bean.TrekBean;
import org.cedam.application.randonnees.front.proxies.TrekServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class AccueilController {

    @Autowired
    private TrekServiceProxy trekServiceProxy;
    
    @GetMapping(value = {"/", "/accueil"})
    public String accueil(Model model){

    	List<TrekBean> treks =  trekServiceProxy.getAll();
    	
    	treks.forEach(x -> {
    		x.setUrl("/trek/"+x.getId());
    	});
    	
    	model.addAttribute("treks", treks);    
         
        return "accueil";
    }
    
}