package de.uniko.iwm.home;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import de.uniko.iwm.support.web.Feedback;
import de.uniko.iwm.tingo.question.Question;
import de.uniko.iwm.tingo.question.QuestionController;
import de.uniko.iwm.tingo.simple.SimpleQ;
import de.uniko.iwm.tingo.simple.SimpleQG;
import de.uniko.iwm.tingo.simple.SimpleState;
import de.uniko.iwm.tingo.simple.SimpleState.SOLVED;
import de.uniko.iwm.tingo.task.Task;
import de.uniko.iwm.tingo.task.TaskListWrapper;

@Controller
public class HomeController {
	private static final Logger LOG = LoggerFactory
			.getLogger(QuestionController.class);

	private List<SimpleQG> questions;

	@PostConstruct
	void init() {
		questions = new ArrayList<SimpleQG>();

		Set<String> a0 = new HashSet<String>();
		Set<String> a1 = new HashSet<String>();
		Set<String> a2 = new HashSet<String>();

		a0.add("A");
		a0.add("B");
		a0.add("C");

		a1.add("B");

		SimpleQ q01 = new SimpleQ("Birds Mania", "birds.jsp", a0);
		SimpleQ q02 = new SimpleQ("Crazy Cars", "cars.jsp", a1);
		SimpleQ q03 = new SimpleQ("Vocal Validator", "emptyQuestion.jsp", a2);
		SimpleQ q04 = new SimpleQ("GoT Quotes", "got-quotes.jsp", a2);
		
		ArrayList<SimpleQ> sq0 = new ArrayList<SimpleQ>();
		sq0.add(q01);
		sq0.add(q02);
		sq0.add(q03);
		sq0.add(q04);

		SimpleQ q11 = new SimpleQ("Question 11", "File 1",
				new HashSet<String>());
		SimpleQ q12 = new SimpleQ("Question 12", "File 2",
				new HashSet<String>());
		SimpleQ q13 = new SimpleQ("Question 13", "File 3",
				new HashSet<String>());

		ArrayList<SimpleQ> sq1 = new ArrayList<SimpleQ>();
		sq1.add(q11);
		sq1.add(q12);
		sq1.add(q13);

		SimpleQ q21 = new SimpleQ("Question 21", "File 1",
				new HashSet<String>());
		SimpleQ q22 = new SimpleQ("Question 22", "File 2",
				new HashSet<String>());
		SimpleQ q23 = new SimpleQ("Question 23", "File 3",
				new HashSet<String>());

		ArrayList<SimpleQ> sq2 = new ArrayList<SimpleQ>();
		sq2.add(q21);
		sq2.add(q22);
		sq2.add(q23);

		SimpleQ q31 = new SimpleQ("Question 31", "File 1",
				new HashSet<String>());
		SimpleQ q32 = new SimpleQ("Question 32", "File 2",
				new HashSet<String>());
		SimpleQ q33 = new SimpleQ("Question 33", "File 3",
				new HashSet<String>());

		ArrayList<SimpleQ> sq3 = new ArrayList<SimpleQ>();
		sq3.add(q31);
		sq3.add(q32);
		sq3.add(q33);

		SimpleQG sqg0 = new SimpleQG("Medic", "medic", sq0);
		SimpleQG sqg1 = new SimpleQG("Music", "music", sq1);
		SimpleQG sqg2 = new SimpleQG("Games", "games", sq2);
		SimpleQG sqg3 = new SimpleQG("Tools", "tools", sq3);

		sqg2.getState().setCorrect(SOLVED.PARTLY);
		sqg3.getState().setCorrect(SOLVED.CORRECT);

		questions = new ArrayList<SimpleQG>();
		questions.add(sqg0);
		questions.add(sqg1);
		questions.add(sqg2);
		questions.add(sqg3);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(Principal principal) {
		LOG.info("/");

		ModelAndView mav = new ModelAndView();
		mav.setViewName(principal != null ? "questionDispatcher" : "homeNotSignedIn");
		mav.addObject("questiongroups", questions);
		
		return mav;
	}

	@RequestMapping(value = "mansion/questiongroup/{index}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView mansonQuestion(@PathVariable int index, Model model) {
		LOG.info("mansion/questiongroup/" + index);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("questionRenderer");

		model.addAttribute("qg", questions.get(index));
		model.addAttribute("groupindex", index);
		model.addAttribute("feedback", new Feedback(SOLVED.PARTLY));
		model.addAttribute("file", "/resources/questions/emptyQuestion.jsp");

		return mav;
	}

	@RequestMapping(value = "mansion/questionpage/{group}/{question}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView handleQuestionPage(@PathVariable int group,
			@PathVariable int question, Model model) {
		LOG.info("mansion/questiongroup/" + group + "/" + question);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("questionRenderer");
		
		TaskListWrapper tl = new TaskListWrapper();
		tl.add(new Task(""));
		tl.add(new Task(""));
		tl.add(new Task(""));
		tl.add(new Task(""));
		tl.add(new Task(""));
		tl.add(new Task(""));
		tl.add(new Task(""));

		model.addAttribute("qg", questions.get(group));
		model.addAttribute("groupindex", group);
		model.addAttribute("questionindex", question);
		model.addAttribute("result", tl);
		
		
		// model.addAttribute("file", "/resources/questions/" +
		// questions.get(index).getQuestions().get(0).getFile());
		model.addAttribute("file",
				"/resources/questions/"
						+ questions.get(group).getQuestions().get(question)
								.getFile());

		return mav;
	}

	// ----------------------------------------------------------------------------

	@RequestMapping(value = "mansion/ajax", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<SimpleQG> mansonCallback() {
		LOG.info("manson/ajax");
		return questions;
	}

	@RequestMapping(value = "question/ajax/{group}/{question}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Feedback validateQuestion(@PathVariable int group,
			@PathVariable int question,
			@RequestParam("results") String[] results, Model model) {
		LOG.info("question/ajax/" + group + "/" + question);

		Set<String> chal = new HashSet<String>();
		for (int i = 0; i < results.length; i++) {
			chal.add(results[i]);
		}
		;

		SimpleQ q = questions.get(group).getQuestions().get(question);
		q.validate(chal);

		LOG.info("Callenge: " + q.getState().getCorrect());

		return new Feedback(q.getState().getCorrect());
	}
}
