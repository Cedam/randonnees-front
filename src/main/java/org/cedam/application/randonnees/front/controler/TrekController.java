package org.cedam.application.randonnees.front.controler;

import java.util.Optional;

import org.cedam.application.randonnees.front.bean.TrekBean;
import org.cedam.application.randonnees.front.proxies.TrekServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("/treks")
public class TrekController extends SuperControler {

	@Autowired
	private TrekServiceProxy trekServiceProxy;

	private static final String ATT_TREK_FORM = "trekForm";
	private static final String ATT_TITLE = "title";
	private static final String ATT_ACTION_LIBELLE = "actionLibelle";
	private static final String ATT_TREK = "trek";
	private static final String ATT_ERROR_MESSAGE = "errorMessage";

	@GetMapping("/{id}")
	public String trekById(Model model, @PathVariable("id") final int id) {

		TrekBean trek = trekServiceProxy.getById(id);
		trek.getDays().forEach(x -> x.setUrl("../treks/" + id + "/days/" + x.getId()));

		model.addAttribute(ATT_TREK, trek);
		return VIEW_TREK_DETAIL;
	}

	@GetMapping(value = { "/new" })
	public String newTrek(Model model) {		
		model.addAttribute(ATT_TREK_FORM, new TrekBean());
		model.addAttribute(ATT_TITLE, "Créer un nouveau trek");
		model.addAttribute(ATT_ACTION_LIBELLE, "Créer");
		return VIEW_TREK_SAVE;
	}

	@GetMapping(value = { "/save/{id}" })
	public String saveTrek(Model model, @PathVariable("id") Optional<Integer> id) {
		model.addAttribute(ATT_TREK_FORM, trekServiceProxy.getById(id.get()));
		model.addAttribute(ATT_TITLE, "Modifier le trek");
		model.addAttribute(ATT_ACTION_LIBELLE, "Modifier");
		return VIEW_TREK_SAVE;
	}

	@PostMapping("/save")
	public String saveTrek(Model model, @ModelAttribute("trek") TrekBean trek) {

		try {
			TrekBean trekCreate = trekServiceProxy.save(trek);
			model.addAttribute(ATT_TREK, trekCreate);
		} catch (Exception ex) {
			model.addAttribute(ATT_TREK_FORM, trek);
			model.addAttribute(ATT_TITLE, "Modifier le trek");
			model.addAttribute(ATT_ACTION_LIBELLE, "Modifier");
			model.addAttribute(ATT_ERROR_MESSAGE, "saveTrek error : " + ex.getMessage());
			return VIEW_TREK_SAVE;
		}

		return VIEW_TREK_DETAIL;
	}

	@RolesAllowed("USER")
	@RequestMapping("/u*")
	public String getUser()
	{
		return "Welcome User";
	}

	@RolesAllowed({"USER","ADMIN"})
	@RequestMapping("/admin")
	public String getAdmin()
	{
		return "Welcome Admin";
	}



}