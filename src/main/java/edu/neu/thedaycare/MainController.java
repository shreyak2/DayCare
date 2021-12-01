package edu.neu.thedaycare;

import java.util.Collection;

import javax.annotation.Resource;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import edu.neu.thedaycare.entities.Classroom;
import edu.neu.thedaycare.entities.Enquiry;
import edu.neu.thedaycare.entities.Student;
import edu.neu.thedaycare.entities.Teacher;
import edu.neu.thedaycare.repository.ClassroomRepository;
import edu.neu.thedaycare.repository.StudentRepository;
import edu.neu.thedaycare.repository.TeacherRepository;

@Controller
public class MainController {
	
	@Autowired
	@Resource
	StudentRepository sturep;
	
	@Autowired
	@Resource
	TeacherRepository trep;
	
	@Autowired
	@Resource
	ClassroomRepository crep;
	
    @RequestMapping("")
    public String home() {
        return "home";
    }
	
	@RequestMapping(value="/enquiry", method=RequestMethod.GET)
	public String enquiry(Model model) {

        Enquiry user = new Enquiry();
        model.addAttribute("enquiry", user);
		
		return "enquiry";
		
	}

    @RequestMapping("/dashboard")
    public String admin(Model model) {
    	List<Student> ss = sturep.findAll();
    	model.addAttribute("students", ss);
        return "dashboard";
    }


	@RequestMapping(value="/students", method=RequestMethod.GET)
	public String student(Model model) {
		
    	List<Student> ss = sturep.findAll();
    	model.addAttribute("students", ss);
		
		return "student";
		
	}
	
	@RequestMapping(value="/teachers", method=RequestMethod.GET)
	public String teacher(Model model) {

    	List<Teacher> tt = trep.findAll();
    	model.addAttribute("teachers", tt);
		
		return "teacher";
		
	}
	
	@RequestMapping(value="/classroom", method=RequestMethod.GET)
	public String classroom(Model model) {

    	List<Classroom> tt = crep.findAll();
    	model.addAttribute("classrooms", tt);

		return "classroom";
		
	}
	
	@RequestMapping(value="/report", method=RequestMethod.GET)
	public String report(Model model) {
		return "report";
		
	}

	@RequestMapping(value="/AboutUs", method=RequestMethod.GET)
	public String AboutUs(Model model) {
		return "AboutUs";
		
	}
	
	@PostMapping("/register_succ")
	public String submitForm(@ModelAttribute("enquiry") Enquiry enquiry) {
	    return "register_success";
	}


}
