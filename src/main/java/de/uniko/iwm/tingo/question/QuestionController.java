package de.uniko.iwm.tingo.question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Secured("ROLE_USER")
public class QuestionController {

	private static final Logger LOG = LoggerFactory.getLogger(QuestionController.class);
		
	@RequestMapping(value = "question/current", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Question getIt(UserDetails userDetails) {
		LOG.info(userDetails.toString());
		return new Question();
	}
	
}
