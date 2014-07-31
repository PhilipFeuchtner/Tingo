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
			repo = mapper.readValue(file.getFile(), Repo.class);
			
			String index = "";
			int i0 = 0;
			for (Section s: repo.getSectionlist()) {
				index = "" +i0;
				s.setIndex(index);
				
				int i1 = 0;
				for (GroupItem g: s.getGroupitemlist()) {
					index = i0 + "-" + i1;
					g.setIndex(index);
					
					int i2 = 0;
					for (Mediaobject m: g.getMedia()) {
						index = i0 + "-" + i1 + "-" + i2;
						m.setIndex(index);
						
						i2++;
					}
					
					i2 = 0;
					for(QuestionItem q: g.getQuestionitemlist()) {
						index = i0 + "-" + i1 + "-" + i2;
						q.setIndex(index);
						
//						int i3 =0;
//						for(TaskItem t: q.getTaskitemlist()){
//							index = i0 + "-" + i1 + "-" + i2 + "-" + i3;
//							t.setIndex(index);
//							
//							i3++;
//						}
						
						i2++;
					}
					
					i1++;
				}
				
				i0++;
			}
			
			return repo;
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
