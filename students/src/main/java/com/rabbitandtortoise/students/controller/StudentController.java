package com.rabbitandtortoise.students.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rabbitandtortoise.students.pojo.StudentPOJO;
import com.rabbitandtortoise.students.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	// Home controller
	@GetMapping("/home")
	public String home(ModelMap map) {
		List<StudentPOJO> students = service.searchAll();

		map.addAttribute("students", students);
		return "Home";
	}

	// Add form controller
	@GetMapping("/add")
	private String addStudent() {

		return "Add";
	}

	/*
	 * @PostMapping("/home") public StudentPOJO home(@RequestParam int id, ModelMap
	 * map) { StudentPOJO student = service.search(id); if (student != null) { //
	 * success map.addAttribute("student", student); }
	 * 
	 * map.addAttribute("student", student); return student; }
	 */
	// Add response controller
	@PostMapping("/add")
	public String addStudent(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			ModelMap map) {
		StudentPOJO student = service.addStudent(id, name, email);

		if (student != null) {
			map.addAttribute("student", student);
			map.addAttribute("msg", "Student added successfully..!!");
		} else {
			map.addAttribute("msg", "Student not added..!!");
		}
		return "Add";

	}

	// Search form controller
	@GetMapping("/search")
	public String search(ModelMap map) {
		return "Search";

	}

	// Search response controller
	@PostMapping("/search")
	public String search(@RequestParam int id, ModelMap map) {
		StudentPOJO student = service.search(id);
		if (student != null) {
			// success
			map.addAttribute("student", student);
			return "Search";
		}
		// failure
		map.addAttribute("msg", "Student data does not exist..!!");
		return "Search";
	}

	//Remove Data Controller 
	@GetMapping("/remove")
	public String delete(@RequestParam int id, ModelMap map) {
		int student = service.delete(id);
		if (student != 0) {
			// success
			List<StudentPOJO> students = service.searchAll();
			map.addAttribute("students", students);
			map.addAttribute("msg", "Student removed successfully..!!");
			return "Remove";
		}
		// failure
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		map.addAttribute("msg", "Student data does not exist..!!");
		return "Remove";
	}

	// Update form controller
	@GetMapping("/update")
	public String updateForm(HttpServletRequest request, @RequestParam String id, ModelMap map) {
		int stud_id = Integer.parseInt(request.getParameter("id"));
		StudentPOJO student = service.search(stud_id);
		if (student != null) {
			// success
			map.addAttribute("student", student);
		}
		// failure
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		map.addAttribute("msg", "Student data does not exist..!!");
		return "Update";
	}

	// Update Data controller
	@PostMapping("/updateData")
	public String updateData(@RequestParam String id, @RequestParam String name, @RequestParam String email,
			ModelMap map) {
		int stud_id = Integer.parseInt(id);
		int student = service.updateData(stud_id, name, email);
		if (student != 0) {
			// success
			map.addAttribute("msg", "Student data updated successfully..!!");
			List<StudentPOJO> students = service.searchAll();
			map.addAttribute("students", students);
			return "Update";
		}
		// failure
		map.addAttribute("msg", "Student not updated..!!");
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		return "Update";
	}

}
