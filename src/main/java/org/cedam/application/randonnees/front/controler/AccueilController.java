package org.cedam.application.randonnees.front.controler;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.front.bean.TrekBean;
import org.cedam.application.randonnees.front.proxies.TrekServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController extends SuperControler {

	private static final Logger logger = LogManager.getLogger(DayController.class);
	
	@Autowired
	private TrekServiceProxy trekServiceProxy;

	private static final String ATT_TREKS = "treks"; 
	
	@GetMapping(value = { "/", "/accueil" })
	public String accueil(Model model) {
		logger.info("AccueilController.accueil");
		List<TrekBean> treks = trekServiceProxy.getAll();
		treks.forEach(x -> x.setUrl("/treks/" + x.getId()));
		model.addAttribute(ATT_TREKS, treks);

		return VIEW_ACCUEIL;
	}

}