package de.uniko.iwm.home;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import de.uniko.iwm.tingo.question.Question;
import de.uniko.iwm.tingo.question.QuestionController;
import de.uniko.iwm.tingo.simple.SimpleQ;
import de.uniko.iwm.tingo.simple.SimpleQG;

@Controller
public class HomeController {
	private static final Logger LOG = LoggerFactory.getLogger(QuestionController.class);
	
	private List<SimpleQG> questions;
	
	@PostConstruct
	void init() {
		questions = new ArrayList<SimpleQG>();
		
		SimpleQ q01 = new SimpleQ("Birds Mania", "birds.jsp", "A");
		SimpleQ q02 = new SimpleQ("Crazy Cars", "cars.jsp", "B");
		
		ArrayList <SimpleQ> sq0 = new ArrayList<SimpleQ>();
		sq0.add(q01);
		sq0.add(q02);
		
		SimpleQ q11 = new SimpleQ("Question 11", "File 1", "A");
		SimpleQ q12 = new SimpleQ("Question 12", "File 2", "B");
		SimpleQ q13 = new SimpleQ("Question 13", "File 3", "C");
		
		ArrayList <SimpleQ> sq1 = new ArrayList<SimpleQ>();
		sq1.add(q11);
		sq1.add(q12);
		sq1.add(q13);
		
		SimpleQ q21 = new SimpleQ("Question 21", "File 1", "A");
		SimpleQ q22 = new SimpleQ("Question 22", "File 2", "B");
		SimpleQ q23 = new SimpleQ("Question 23", "File 3", "C");
		
		ArrayList <SimpleQ> sq2 = new ArrayList<SimpleQ>();
		sq2.add(q21);
		sq2.add(q22);
		sq2.add(q23);
		
		SimpleQ q31 = new SimpleQ("Question 31", "File 1", "A");
		SimpleQ q32 = new SimpleQ("Question 32", "File 2", "B");
		SimpleQ q33 = new SimpleQ("Question 33", "File 3", "C");
		
		ArrayList <SimpleQ> sq3 = new ArrayList<SimpleQ>();
		sq3.add(q31);
		sq3.add(q32);
		sq3.add(q33);
		
		SimpleQG sqg0 = new SimpleQG("Gruppentext 0", "medic", sq0);
		SimpleQG sqg1 = new SimpleQG("Gruppentext 1", "music", sq1);
		SimpleQG sqg2 = new SimpleQG("Gruppentext 2", "games", sq2);
		SimpleQG sqg3 = new SimpleQG("Gruppentext 3", "tools", sq3);
		
		sqg2.getState().setCorrect(true);
		sqg3.getState().setCorrect(true);
		
		questions = new ArrayList<SimpleQG>();
		questions.add(sqg0);
		questions.add(sqg1);
		questions.add(sqg2);
		questions.add(sqg3);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		// return principal != null ? "homeSignedIn" : "homeNotSignedIn";
		return principal != null ? "questionDispatcher" : "homeNotSignedIn";
	}
	
	@RequestMapping(value = "mansion/ajax", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<SimpleQG> mansonCallback() {
		LOG.info("manson/ajax");
		return questions;
	}
	
	@RequestMapping(value = "mansion/questiongroup/{index}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView mansonQuestion(@PathVariable int index, Model model) {
		LOG.info("mansion/questiongroup/" + index);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("questionRenderer");
		
		model.addAttribute("qg", questions.get(index));
		model.addAttribute("groupindex", index);
		//model.addAttribute("file", "/resources/questions/" + questions.get(index).getQuestions().get(0).getFile());
		model.addAttribute("file", "/resources/questions/emptyQuestion.jsp");
		
		return mav;
	}

	@RequestMapping(value = "mansion/questionpage/{group}/{question}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView handleQuestionPage(@PathVariable int group, @PathVariable int question, Model model) {
		LOG.info("mansion/questiongroup/" + group + "/" + question);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("questionRenderer");
		
		model.addAttribute("qg", questions.get(group));
		model.addAttribute("groupindex", group);
		//model.addAttribute("file", "/resources/questions/" + questions.get(index).getQuestions().get(0).getFile());
		model.addAttribute("file", "/resources/questions/" + questions.get(group).getQuestions().get(question).getFile());
		
		return mav;
	}


}
