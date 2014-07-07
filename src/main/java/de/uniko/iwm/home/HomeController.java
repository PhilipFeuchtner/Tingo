package de.uniko.iwm.home;

import java.io.Serializable;
import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import de.uniko.iwm.Repo.Init;
import de.uniko.iwm.Repo.Repo;
import de.uniko.iwm.Repo.SimpleState.SOLVED;
import de.uniko.iwm.support.web.Feedback;
import de.uniko.iwm.support.web.Message;
import de.uniko.iwm.tingo.task.CorrectValueWrapper;
import de.uniko.iwm.tingo.task.Task;
import de.uniko.iwm.tingo.task.TaskListWrapper;

@Controller
@Scope("session")
@SessionAttributes({ "Repo", "CorrectValues" })
public class HomeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1178938782319091910L;

	private static final Logger LOG = LoggerFactory
			.getLogger(HomeController.class);

	@Value("classpath:manifest.json")
	private Resource manifestFile;

	@ModelAttribute("Repo")
	public Repo repo() {
		Init i = new Init(manifestFile);
		return i.getParse();
	}

	@ModelAttribute("CorrectValues")
	public CorrectValueWrapper cvw() {
		return new CorrectValueWrapper();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
		LOG.info("/");

		if (principal == null)
			return "homeNotSignedIn";

		return "questionDispatcher";
	}
	
	@RequestMapping(value = "mansion/questiondefault/{index}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String questionDefault(@PathVariable int index,
			@ModelAttribute("CorrectValues") CorrectValueWrapper cvw,
			Model model) {
		LOG.info("get mansion/questiondefault/" + index);
		
		Repo repo = (Repo)model.asMap().get("Repo");
		repo.setIndex(index);

		model.addAttribute("file", "/resources/questions/emptyQuestion.jsp");

		return "questionRenderer";		
	}	

	@RequestMapping(value = "mansion/questionpage/{index}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String questionPageGET(
			@PathVariable int index,
			@ModelAttribute("CorrectValues") CorrectValueWrapper cvw,
			Model model) {
		LOG.info("get mansion/questionpage");

		if (!model.containsAttribute("Repo")) {
			model.addAttribute("message", new Message("Session expired.",
					Message.Type.ERROR));

			return "redirect:/";
		}
		
		Repo repo = (Repo)model.asMap().get("Repo");
		int si = repo.getIndex();
		repo.getSectionlist().get(si).setIndex(index);
		
		// System.out.println("si: " + si);
		

		// model.addAttribute("file", "/resources/questions/emptyQuestion.jsp");

		model.addAttribute("results", new TaskListWrapper());
		model.addAttribute("correctResp", cvw);

		return "questionRenderer";
	}

	@RequestMapping(value = "mansion/questionpage/{index}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView questionPagePOST(
			@PathVariable int index,
			@ModelAttribute("CorrectValues") CorrectValueWrapper cvw,
			Model model) {
		LOG.info("GET  mansion/questionintro");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("questionRenderer");

		// model.addAttribute("qg", questions.get(group));
//		model.addAttribute("groupindex", group);
//		model.addAttribute("questionindex", question);
		model.addAttribute("results", new TaskListWrapper());
		model.addAttribute("correctResp", cvw);

		// model.addAttribute("file",
		// "/resources/questions/"
		// + questions.get(group).getQuestions().get(question).getFile());
		// model.addAttribute("file", "/resources/questions/emptyQuestion.jsp");

		return mav;

	}

	@RequestMapping(value = "mansion/questiongroup/{index}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public String handleQuestionPage(@PathVariable int index,
//			@PathVariable int question,
			@ModelAttribute("results") TaskListWrapper tl,
			@ModelAttribute("CorrectValues") CorrectValueWrapper cvw,
			Model model) {
		LOG.info("POST mansion/questiongroup/" + index );

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
				LOG.info(e.toString() + ": " + cvw.getValues().get(i++));
			}
		} else {
			LOG.info("no tasks");
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("questionRenderer");

		// TaskListWrapper tl = new TaskListWrapper();

		// model.addAttribute("qg", questions.get(group));
//		model.addAttribute("groupindex", group);
//		model.addAttribute("questionindex", question);
		model.addAttribute("results", tl);
		model.addAttribute("correctResp", cvw);

		// model.addAttribute("file", "/resources/questions/" +
		// questions.get(index).getQuestions().get(0).getFile());
		// model.addAttribute("file",
		// "/resources/questions/"
		// + questions.get(group).getQuestions().get(question)
		// .getFile());

		return "questionRenderer";
	}

	// ----------------------------------------------------------------------------
	/*
	 * @RequestMapping(value = "mansion/ajax", method = RequestMethod.GET)
	 * 
	 * @ResponseStatus(value = HttpStatus.OK)
	 * 
	 * @ResponseBody public List<SimpleQG> mansonCallback() {
	 * LOG.info("manson/ajax"); return questions; }
	 * 
	 * @RequestMapping(value = "question/ajax/{group}/{question}")
	 * 
	 * @ResponseStatus(value = HttpStatus.OK)
	 * 
	 * @ResponseBody public Feedback validateQuestion(@PathVariable int group,
	 * 
	 * @PathVariable int question,
	 * 
	 * @RequestParam("results") String[] results, Model model) {
	 * LOG.info("question/ajax/" + group + "/" + question);
	 * 
	 * Set<String> chal = new HashSet<String>(); for (int i = 0; i <
	 * results.length; i++) { chal.add(results[i]); } ;
	 * 
	 * SimpleQ q = questions.get(group).getQuestions().get(question);
	 * q.validate(chal);
	 * 
	 * LOG.info("Callenge: " + q.getState().getCorrect());
	 * 
	 * return new Feedback(q.getState().getCorrect()); }
	 */
}
