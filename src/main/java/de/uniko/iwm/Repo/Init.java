package de.uniko.iwm.Repo;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.io.Resource;

public class Init {

	private Resource file;
	
	public Init(Resource file) {
			this.file = file;
	}

	public Repo getParse() {

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.readValue(file.getFile(), Repo.class);
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
