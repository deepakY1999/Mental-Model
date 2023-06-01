package com.Emp.Emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpController {

	@Autowired
	EmpDao dao;
	
	@RequestMapping(value = "/viewmap/{}pageid")
	public String edit(@PathVariable int pageid,Model m) {
		int total=5;
		if(pageid==1) {}
		else {
			pageid=(pageid-1)*total+1;
		}
		System.out.println(pageid);
		List<Emp>list=dao.getEmployeesByPage(pageid,total);
		m.addAttribute("msg", list);
		return "viewemp";
		
	}
	
	@RequestMapping("/empform")
	public String showform(Model m) {
		m.addAttribute("command", new Emp());
		return "empform";
		
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute ("emp")Emp emp) {
		dao.save(emp);
		return "redirect:/viewmap";
		
	}
	
	@RequestMapping("/viewmap")
	public String viewmap(Model m) {
		List<Emp>list=dao.getEmployeesByPage(1, 2);
		m.addAttribute("list", list);
		return viewmap(null);
		
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public String editsave(@ModelAttribute ("emp")Emp emp) {
		dao.update(emp);
		return "redirect:/viewmap";
		
	}
	
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
	public String Delete(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/viewmap";
		
	}
	
	
}
