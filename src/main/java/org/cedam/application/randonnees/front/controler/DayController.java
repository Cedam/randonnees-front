package org.cedam.application.randonnees.front.controler;

import java.util.Optional;

import org.cedam.application.randonnees.front.bean.DayBean;
import org.cedam.application.randonnees.front.bean.TrekBean;
import org.cedam.application.randonnees.front.proxies.DayServiceProxy;
import org.cedam.application.randonnees.front.proxies.TrekServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/treks/{trekId}/days")
public class DayController extends SuperControler {

	@Autowired
	private DayServiceProxy dayServiceProxy;

	@Autowired
	private TrekServiceProxy trekServiceProxy;

	private static final String ATT_DAY_FORM = "dayForm";
	private static final String ATT_TITLE = "title";
	private static final String ATT_ACTION_LIBELLE = "actionLibelle";
	private static final String ATT_DAY = "day";
	private static final String ATT_ERROR_MESSAGE = "errorMessage";

	@GetMapping("/{id}")
	public String dayById(Model model, @PathVariable("id") final int id) {
		DayBean day = dayServiceProxy.getById(id);
		model.addAttribute(ATT_DAY, day);
		return VIEW_DAY_DETAIL;
	}

	@GetMapping(value = { "/new" })
	public String newDay(Model model, @PathVariable("trekId") Optional<Integer> trekId) {

		DayBean day = new DayBean();
		day.setTrek(trekServiceProxy.getById(trekId.get()));
		model.addAttribute(ATT_DAY_FORM, day);
		model.addAttribute(ATT_TITLE, "Créer une nouvelle journée");
		model.addAttribute(ATT_ACTION_LIBELLE, "Créer");
		return VIEW_DAY_SAVE;
	}

	@GetMapping(value = { "/save/{id}" })
	public String saveDay(Model model, @PathVariable("id") Optional<Integer> id) {

		model.addAttribute(ATT_DAY_FORM, dayServiceProxy.getById(id.get()));
		model.addAttribute(ATT_TITLE, "Modifier la journée");
		model.addAttribute(ATT_ACTION_LIBELLE, "Modifier");

		return VIEW_DAY_SAVE;
	}

	@PostMapping(value = { "/save" })
	public String saveDay(Model model, @PathVariable("trekId") Optional<Integer> trekId, @ModelAttribute("day") DayBean day) {

		try {
			TrekBean trek = trekServiceProxy.getById(trekId.get());
			day.setTrek(trek);
			model.addAttribute(ATT_DAY_FORM, day);
			DayBean dayCreate = dayServiceProxy.save(day);			
			model.addAttribute(ATT_DAY, dayCreate);
		} catch (Exception ex) {
			model.addAttribute(ATT_DAY_FORM, day);
			model.addAttribute(ATT_ERROR_MESSAGE, "saveDay error : " + ex.getMessage());
			return VIEW_DAY_SAVE;
		}

		return VIEW_DAY_DETAIL;
	}

}