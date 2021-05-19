package org.cedam.application.randonnees.front.controler;

import org.cedam.application.randonnees.front.bean.DayBean;
import org.cedam.application.randonnees.front.proxies.DayServiceProxy;
import org.cedam.application.randonnees.front.utils.ViewsName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/days")
public class DayController implements ViewsName {

	@Autowired
	private DayServiceProxy dayServiceProxy;

	private static final String ATT_DAY = "day"; 
	
	@GetMapping("/{id}")
	public String trekById(Model model, @PathVariable("id") final int id) {
		DayBean day = dayServiceProxy.getById(id);
		model.addAttribute(ATT_DAY, day);
		return VIEW_DAY_DETAIL;
	}

}