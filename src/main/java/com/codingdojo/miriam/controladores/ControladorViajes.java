package com.codingdojo.miriam.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.miriam.modelos.Gasto;
import com.codingdojo.miriam.servicios.ServicioViajes;

@Controller
@RequestMapping("/expenses")
public class ControladorViajes {
	
	//Linking this Class with Services
	private final ServicioViajes servicio;
	
	public ControladorViajes(ServicioViajes servicio) {
		this.servicio = servicio;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	//READ ALL - GET
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(Model model) {
		//Asks for all
		List<Gasto> lista_gastos = servicio.get_gastos();
		//Saves it in model
		model.addAttribute("lista_gastos", lista_gastos);
		//index.jsp will have them
		return "index.jsp";
	}
	
	//---------------------------------------------------------------------------------------------------
	
	//CREATE - GET
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String new_expense(@ModelAttribute("gasto") Gasto gasto) {
		return "new.jsp";
	}
	//CREATE - POST
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("gasto") Gasto gasto,
						 BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			servicio.save_gasto(gasto);
			return "redirect:/expenses";
		}
	}
	
	//---------------------------------------------------------------------------------------------------
	
	//DELETE - DELETE
	@RequestMapping(value="/delete/{id_url}", method=RequestMethod.DELETE)
	public String eliminate(@PathVariable("id_url") Long id) {
		servicio.delete_gasto(id);
		return "redirect:/expenses";
	}
	
	//---------------------------------------------------------------------------------------------------
	
	//UPDATE - GET
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, @ModelAttribute("gasto") Gasto gasto) {
        Gasto gasto_edit = servicio.find_gasto(id);
        System.out.println(gasto.getExpense_name());
        model.addAttribute("gasto", gasto_edit);
        return "edit.jsp";
    }
	
	//UPDATE - PUT
	@PutMapping("/edit/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("gasto") Gasto gasto, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			servicio.save_gasto(gasto);
			return "redirect:/expenses";
		}
	}

	//----------------------------------------------------------------------------------------------------
	
	//READ ONE - GET
	@GetMapping("{id}")
	//@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show_one(@PathVariable("id") Long id, Model model) {
		//Asks for one
		Gasto gasto_encontrado = servicio.find_gasto(id);
		System.out.println(gasto_encontrado.getExpense_name());
		//Saves it in model
		model.addAttribute("gasto", gasto_encontrado);
		//show.jsp will have it
		return "show.jsp";
	}
	
	
}
