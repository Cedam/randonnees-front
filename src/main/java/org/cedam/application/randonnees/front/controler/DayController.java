package org.cedam.application.randonnees.front.controler;

import java.util.Optional;

import org.cedam.application.randonnees.front.bean.DayBean;
import org.cedam.application.randonnees.front.proxies.DayServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/days")
public class DayController extends SuperControler {

	@Autowired
	private DayServiceProxy dayServiceProxy;

	private static final String ATT_DAY_FORM = "dayForm"; 
	private static final String ATT_TITLE = "title"; 
	private static final String ATT_ACTION_LIBELLE= "actionLibelle"; 
	private static final String ATT_DAY = "day"; 
	private static final String ATT_ERROR_MESSAGE = "errorMessage"; 
	
	@GetMapping("/{id}")
	public String trekById(Model model, @PathVariable("id") final int id) {
		DayBean day = dayServiceProxy.getById(id);
		model.addAttribute(ATT_DAY, day);
		return VIEW_DAY_DETAIL;
	}

	@GetMapping(value = { "/save", "/save/{id}" })
	public String saveDay(Model model, @PathVariable("id") Optional<Integer> id) {

		if (id.isPresent()) {
			model.addAttribute(ATT_DAY_FORM, dayServiceProxy.getById(id.get()));
			model.addAttribute(ATT_TITLE, "Modifier la journée");
			model.addAttribute(ATT_ACTION_LIBELLE, "Modifier");
		} else {
			model.addAttribute(ATT_DAY_FORM, new DayBean());
			model.addAttribute(ATT_TITLE, "Créer une noubelle journée");
			model.addAttribute(ATT_ACTION_LIBELLE, "Créer");
		}

		return VIEW_DAY_SAVE;
	}


	@PostMapping("/save")
	public String saveDay(Model model, @ModelAttribute("day") DayBean day) {

		try {
			DayBean dayCreate = dayServiceProxy.save(day);
			model.addAttribute(ATT_DAY, dayCreate);
		} catch (Exception ex) {
			model.addAttribute(ATT_DAY_FORM, day);
			model.addAttribute(ATT_ERROR_MESSAGE, "saveDay error : "+ex.getMessage());
			return VIEW_DAY_SAVE;
		}

		return VIEW_DAY_DETAIL;
	}
	
}