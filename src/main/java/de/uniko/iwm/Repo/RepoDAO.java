package de.uniko.iwm.Repo;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class RepoDAO {

	// @Value("classpath:manifest.json")
	private Resource manifestFile;
	
	private Repo repo;
	
	public RepoDAO() {
		manifestFile = new ClassPathResource("manifest.json");
		
		ObjectMapper mapper = new ObjectMapper();

		try {
			repo = mapper.readValue(manifestFile.getFile(), Repo.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repo = null;		
	}

	public Repo getRepo() {
		return repo;
	}
}
