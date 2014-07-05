package de.uniko.iwm.home;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import de.uniko.iwm.Repo.GroupItem;
import de.uniko.iwm.Repo.Init;
import de.uniko.iwm.Repo.Repo;
import de.uniko.iwm.Repo.Section;
import de.uniko.iwm.Repo.SimpleState;
import de.uniko.iwm.Repo.SimpleState.SOLVED;
import de.uniko.iwm.support.web.Feedback;
import de.uniko.iwm.tingo.navigation.GroupEntry;
import de.uniko.iwm.tingo.task.Correct;
import de.uniko.iwm.tingo.task.CorrectValueWrapper;
import de.uniko.iwm.tingo.task.Task;
import de.uniko.iwm.tingo.task.TaskListWrapper;

@Controller
public class HomeController {
	private static final Logger LOG = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private CorrectValueWrapper cvw;

	@Value("classpath:manifest.json")
	private Resource manifestFile;
	
	Repo repo;
	
	@PostConstruct
	void init() {
		Init i = new Init(manifestFile);
		repo = i.getParse();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(Principal principal) {
		LOG.info("/");

		if (principal == null) return new ModelAndView("homeNotSignedIn");
		
		ModelAndView mav = new ModelAndView("questionDispatcher");
		
		List <GroupEntry> ge = new ArrayList <GroupEntry> ();
		for ( Section i: repo.getSectionlist()) {
			ge.add(new GroupEntry(i.getTitle(), i.getSvgid()));
		}
	
		mav.addObject("groups", ge);

		return mav;
	}

	@RequestMapping(value = "mansion/questiongroup/{index}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView mansonQuestion(@PathVariable int index, Model model) {
		LOG.info("mansion/questiongroup/" + index);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("questionRenderer");

//		model.addAttribute("qg", questions.get(index));
		model.addAttribute("groupindex", index);
		model.addAttribute("feedback", new Feedback(SOLVED.PARTLY));
		model.addAttribute("file", "/resources/questions/emptyQuestion.jsp");

		return mav;
	}

	@RequestMapping(value = "mansion/questionpage/{group}/{question}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView handleQuestionIntroPage(@PathVariable int group,
			@PathVariable int question, Model model) {
		LOG.info("mansion/questionintro/" + group + "/" + question);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("questionRenderer");

//		model.addAttribute("qg", questions.get(group));
		model.addAttribute("groupindex", group);
		model.addAttribute("questionindex", question);
		model.addAttribute("results", new TaskListWrapper());
		model.addAttribute("correctResp", cvw);

//		model.addAttribute("file",
//				"/resources/questions/"
//						+ questions.get(group).getQuestions().get(question).getFile());
		// model.addAttribute("file", "/resources/questions/emptyQuestion.jsp");

		return mav;

	}

	@RequestMapping(value = "mansion/questionpage/{group}/{question}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public String handleQuestionPage(@PathVariable int group,
			@PathVariable int question,
			@ModelAttribute("results") TaskListWrapper tl, Model model) {
		LOG.info("mansion/questionpage/" + group + "/" + question);

		// int i = 0;
		// LOG.info("Correct List");
		// if (correctList != null) {
		//
		// for (Correct e : correctList.getCorrectList()) {
		// LOG.info(e.toString());
		// }
		// } else {
		// LOG.info("no correct responses");
		// }

		int i = 0;
		LOG.info("Tasks List");
		if (tl != null) {

			for (Task e : tl.getTaskList()) {
				LOG.info(e.toString() + ": " + cvw.getCorrectValues().get(i++));
			}
		} else {
			LOG.info("no tasks");
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("questionRenderer");

		// TaskListWrapper tl = new TaskListWrapper();

//		model.addAttribute("qg", questions.get(group));
		model.addAttribute("groupindex", group);
		model.addAttribute("questionindex", question);
		model.addAttribute("results", tl);
		model.addAttribute("correctResp", cvw);

		// model.addAttribute("file", "/resources/questions/" +
		// questions.get(index).getQuestions().get(0).getFile());
//		model.addAttribute("file",
//				"/resources/questions/"
//						+ questions.get(group).getQuestions().get(question)
//								.getFile());

		return "questionRenderer";
	}

	// ----------------------------------------------------------------------------
/*
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
	*/
}
