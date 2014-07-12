package de.uniko.iwm.home;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import de.uniko.iwm.Repo.Init;
import de.uniko.iwm.Repo.Repo;
import de.uniko.iwm.Repo.TaskItem;
import de.uniko.iwm.Repo.SimpleState.SOLVED;
import de.uniko.iwm.support.web.Feedback;
import de.uniko.iwm.support.web.Message;
import de.uniko.iwm.tingo.task.CorrectValueWrapper;
import de.uniko.iwm.tingo.task.Task;
import de.uniko.iwm.tingo.task.ResultListWrapper;

@Controller
// @Scope("session")
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

		Repo repo = (Repo) model.asMap().get("Repo");
		repo.setIndex(index);

		// model.addAttribute("file", "/resources/questions/emptyQuestion.jsp");
		model.addAttribute("start", false);

		return "questionRenderer";
	}

	@RequestMapping(value = "mansion/questionpage/{index}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String questionPageGET(@PathVariable int index,
			@RequestParam(required = false) String quiz, Model model) {
		LOG.info("get mansion/questionpage");

		if (!model.containsAttribute("Repo")) {
			model.addAttribute("message", new Message("Session expired.",
					Message.Type.ERROR));

			return "redirect:/";
		}

		Repo repo = (Repo) model.asMap().get("Repo");
		int si = repo.getIndex();
		repo.getSectionlist().get(si).setIndex(index);

		model.addAttribute("start", (quiz == null ? false : true));
		model.addAttribute("results", new ResultListWrapper());
		model.addAttribute("CorrectValues", new CorrectValueWrapper());

		return "questionRenderer";
	}

	@RequestMapping(value = "mansion/questionpage/{index}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public String questionPagePOST(@PathVariable int index,
			@ModelAttribute("CorrectValues") CorrectValueWrapper cvw,
			@ModelAttribute() ResultListWrapper results, Model model) {
		LOG.info("POST  mansion/questionpage/" + index);
		
		List<List<TaskItem>> rl = cvw.getValues();
		int i = 0;
		for (List<String> u : results.getResultList()) { // ;cvw.getValues()) {

			if (u != null) {
				int j = 0;
				for (String v : u) {
					List<TaskItem> ti = rl.get(i);

					switch (ti.get(j).getType()) {
					case TEXT:
						ti.get(j).setUserinput(v);
						break;
					case RADIO:
						ti.get(0).setUserinput(v);
						break;
					case CHECK:
						int w = Integer.parseInt(v);
						ti.get(w).setUserinput(v);
						break;
					default:
						LOG.error("Unknown question type: "
								+ ti.get(j).getType());
					}

					j++;
				}
			}
			i++;
		}

		i = 0;
		for (List<TaskItem> u : cvw.getValues()) {
			for (TaskItem v : u) {
				System.out.println(i + ": " + v);
			}
			i++;
		}

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
