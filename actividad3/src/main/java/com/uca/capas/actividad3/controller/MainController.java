package com.uca.capas.actividad3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.actividad3.domain.Student;

@Controller
public class MainController {
	
	private List<Student> students = new ArrayList<Student>();
	
	@GetMapping("/inicio")
	public String inicio(Student student) {
		return "index";
	}
	
	@PostMapping("/formData")
	public ModelAndView procesar(Student student) {
		students.add(student);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("student", new Student());
		return mav;
	}
	
	@GetMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listado");
		mav.addObject("studentList", this.students);
		
		return mav;
	}
		
}


