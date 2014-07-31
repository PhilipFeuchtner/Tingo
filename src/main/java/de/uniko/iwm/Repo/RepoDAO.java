package de.uniko.iwm.Repo;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class RepoDAO {

	@Value("classpath:manifest.json")
	private Resource file;

	private Repo repo;

	public RepoDAO() {
	}

	public Repo getRepo() {
		if (repo != null)
			return repo;

		ObjectMapper mapper = new ObjectMapper();

		try {
			return repo = mapper.readValue(file.getFile(), Repo.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
