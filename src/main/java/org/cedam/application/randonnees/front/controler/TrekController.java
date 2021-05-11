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

@Controller
public class TrekController {

	@Autowired
	private TrekServiceProxy trekServiceProxy;

	@GetMapping("/trek/{id}")
	public String trekById(Model model, @PathVariable("id") final int id) {

		TrekBean trek = trekServiceProxy.getById(id);
		trek.getDays().forEach(x -> x.setUrl("/day/" + x.getId()));

		model.addAttribute("trek", trek);
		return "detailTrek";
	}

	@GetMapping(value = { "/trek/save", "/trek/save/{id}" })
	public String updateTrek(Model model, @PathVariable("id") Optional<Integer> id) {

		if (id.isPresent()) {
			model.addAttribute("trekForm", trekServiceProxy.getById(id.get()));
			model.addAttribute("title", "Modifier le trek");
			model.addAttribute("actionLibelle", "Modifier");
		} else {
			model.addAttribute("trekForm", new TrekBean());
			model.addAttribute("title", "Créer un nouveau trek");
			model.addAttribute("actionLibelle", "Créer");
		}

		return "saveTrek";
	}


	@PostMapping("/trek/save")
	public String saveTrek(Model model, @ModelAttribute("trek") TrekBean trek) {

		try {
			TrekBean trekCreate = trekServiceProxy.save(trek);
			model.addAttribute("trek", trekCreate);
		} catch (Exception ex) {
			model.addAttribute("trekForm", trek);
			model.addAttribute("errorMessage", "Contact not found");
			return "createTrek";
		}

		return "detailTrek";
	}

}