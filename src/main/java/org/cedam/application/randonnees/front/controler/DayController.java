package org.cedam.application.randonnees.front.controler;

import org.cedam.application.randonnees.front.bean.DayBean;
import org.cedam.application.randonnees.front.proxies.DayServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DayController {

    @Autowired
    private DayServiceProxy dayServiceProxy;
    
    @GetMapping("/day/{id}")
    public String trekById(Model model, @PathVariable("id") final int id){

    	
    	DayBean day =  dayServiceProxy.getById(id);
    	//day.getDays().forEach(x -> x.setUrl("/day/"+x.getId()));
    	
    	model.addAttribute("day", day);
        return "detailDay";
    }
    
    
}