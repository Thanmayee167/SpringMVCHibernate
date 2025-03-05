package com.thanmayee.springhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.thanmayee.springhibernate.dao.AlienDao;
import com.thanmayee.springhibernate.model.Alien;

@Controller
public class HomeController {
	@Autowired
	private AlienDao dao;

	@GetMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/getAliens")
	public String getAliens(Model m)
	{
		m.addAttribute("result", dao.getAliens());
		return "showAliens";
	}

	@GetMapping("/getAlien")
	public String getAlien(@RequestParam int aid, Model m)
	{
		m.addAttribute("result", dao.getAlien(aid));
		return "showAliens";
	}

	@GetMapping("/add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap modelMap) {
		int sum = i + j;

		modelMap.addAttribute("sum", sum);

		return "result";
	}

	@GetMapping("addAlien")
	public String addAlien(@ModelAttribute("result") Alien a)
	{
		dao.addAlien(a);
		return "showAliens";
	}

	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Aliens");
	}
}
