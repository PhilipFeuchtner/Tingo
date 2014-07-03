package de.uniko.iwm.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

public class Init {

	@Value("/manifest.json")
	private Resource manifestFile;
	
	public Init() {
		File f = new File("/manifest.json");
		System.out.println("-------------->" + f.getName()+ " " + 		f.canRead());
		
		InputStream is = getClass().getResourceAsStream("/manifest.json");
		
			System.out.println("--------->" + (is != null));
	
	}

	public void getParse() {

		ObjectMapper mapper = new ObjectMapper();

		try {
			InputStream is = getClass().getResourceAsStream("/manifest.json");
			Repo repo = mapper.readValue(is, Repo.class);
			System.out.println(repo);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
