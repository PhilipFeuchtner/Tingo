package de.uniko.iwm.home;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
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
import de.uniko.iwm.Repo.Navigation;
import de.uniko.iwm.Repo.QuestionItem;
import de.uniko.iwm.Repo.Repo;
import de.uniko.iwm.Repo.SimpleState;
import de.uniko.iwm.Repo.TaskItem;
import de.uniko.iwm.Repo.SimpleState.SOLVED;
import de.uniko.iwm.support.web.Feedback;
import de.uniko.iwm.support.web.Message;
import de.uniko.iwm.tingo.task.CorrectValueWrapper;
import de.uniko.iwm.tingo.task.Task;
import de.uniko.iwm.tingo.task.ResultListWrapper;

@Controller
// @Scope("session")
@SessionAttributes({ "repo", "correctValues" })
public class HomeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1178938782319091910L;

	private static final Logger LOG = LoggerFactory
			.getLogger(HomeController.class);

	public enum STATE {
		IMAGE, QUIZ, REVIEW
	};

	@Value("classpath:manifest.json")
	private Resource manifestFile;

	@ModelAttribute("repo")
	public Repo repo() {
		LOG.info("new reop.");
		Init i = new Init(manifestFile);
		return i.getParse();
	}

	@ModelAttribute("correctValues")
	public CorrectValueWrapper correctValues() {
		LOG.info("new correctValues.");
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
			@ModelAttribute() Repo repo,
			Model model) {
		LOG.info("get mansion/questiondefault/" + index);

		// Repo repo = (Repo) model.asMap().get("repo");
		repo.getNavigation().setSection(index);

		return "questionDefault";
	}

	@RequestMapping(value = "mansion/questionpage/{index}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String questionPageGET(@PathVariable int index,
			@ModelAttribute() Repo repo,
			// @ModelAttribute() CorrectValueWrapper correctValues,
			@RequestParam(required = false) STATE state, Model model) {
		LOG.info("get mansion/questionpage");

		List<List<TaskItem>> cv = new ArrayList<List<TaskItem>>();
		ResultListWrapper rlw = new ResultListWrapper();

		// Repo repo = (Repo) model.asMap().get("repo");
		repo.getNavigation().setGroup(index);

		for (QuestionItem qi : repo.getQuestions()) {
			List<TaskItem> ql = new ArrayList<TaskItem>();
			cv.add(ql);
			rlw.addQuestion();

			for (TaskItem ti : qi.getTaskitemlist()) {
				ql.add(ti);
				rlw.add(ti.getUserinput());
			}
		}

		model.addAttribute("results", rlw);
		model.addAttribute("correctValues", new CorrectValueWrapper(cv));

		String nav = "questionDefault";
		if (state != null) {
			switch (state) {
			case QUIZ:
				nav = "questionRenderer";
				break;
			case IMAGE:
			case REVIEW:
				break;
			default:
			}
		}
		System.out.println(" <-- ");

		return nav;
	}

	@RequestMapping(value = "mansion/questionpage/{index}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public String questionPagePOST(@PathVariable int index,
			@ModelAttribute() Repo repo,
			// @ModelAttribute() CorrectValueWrapper correctValues,
			@ModelAttribute() ResultListWrapper results, Model model) {
		LOG.info("POST  mansion/questionpage/" + index);

		// Repo repo = (Repo) model.asMap().get("repo");
		CorrectValueWrapper correctValues = (CorrectValueWrapper) model.asMap().get(
				"correctValues");

		repo.increment();
		
		List<List<TaskItem>> rl = correctValues.getValues();
		int i = 0;
		for (List<String> u : results.getResultList()) {

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

		List<QuestionItem> rqi = repo.getQuestions();
		i = 0;

		int sum_score = 0;
		boolean sum_comp = true;
		
		for (List<TaskItem> u : correctValues.getValues()) {
			int score = 0;
			boolean isCompleteSolved = true;
			
			for (TaskItem v : u) {
				if (v.validate()) {
					score += v.getScore(); 
				} else {
					isCompleteSolved = false;
				}
				
				// System.out.println(i + ": " + v);
			}

			SimpleState state = rqi.get(i).getState();
			state.setScore(score);
			
			if (isCompleteSolved) {
				state.setSolved(SOLVED.CORRECT);
			} else {
				state.setSolved(score == 0 ? SOLVED.INCORRECT : SOLVED.PARTLY);
			}

			sum_score += score;
			sum_comp &= isCompleteSolved;
			
			// System.out.println("State: " + state);
			rqi.get(i).setTaskitemlist(u);
			i++;
		}
		
		SimpleState g_state = repo.getGroupItem().getState();
		g_state.setScore(sum_score);
		
		if (sum_comp) {
			g_state.setSolved(SOLVED.CORRECT);
		} else {
			g_state.setSolved(sum_score == 0 ? SOLVED.INCORRECT : SOLVED.PARTLY);
		}

		return "questionDefault";
	}

	@RequestMapping(value = "mansion/review", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String reviewPage(
			@ModelAttribute() Repo repo,
			Model model) {
		LOG.info("GET mansion/review");

		return "questionResults";
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

