package de.uniko.iwm.Repo;

import java.io.IOException;

import javax.inject.Inject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class RepoDAO {

	@Value("classpath:manifest.json")
	private Resource file;

	@Value("/resources/questions/Capitalisation/manifest.json")
	private Resource testfile;

	@Inject
	private ResourceLoader resourceLoader;

	@Value("/resources/questions/")
	private String QUESTIONBASE;

	@Value("/manifest.json")
	private String MANIFEST;

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
			for (Section s : repo.getSectionlist()) {
				index = "" + i0;
				s.setIndex(index);

				int i1 = 0;
				for (Entry e : s.getEntries()) {
					try {
						GroupItem item = mapper.readValue(
								resourceLoader.getResource(
										QUESTIONBASE + e.getBase() + MANIFEST)
										.getFile(), GroupItem.class);
						
						item.setBase(e.getBase());
						
						// System.out.println(" ----> " + item.getTitle());
						s.getGroupitemlist().add(item);
						
					} catch (JsonGenerationException ex) {
						ex.printStackTrace();
					} catch (JsonMappingException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}

				i1 = 0;
				for (GroupItem g : s.getGroupitemlist()) {
					index = i0 + "-" + i1;
					g.setIndex(index);

					int i2 = 0;
					for (Mediaobject m : g.getMedia()) {
						index = i0 + "-" + i1 + "-" + i2;
						m.setIndex(index);

						i2++;
					}

					i2 = 0;
					for (QuestionItem q : g.getQuestionitemlist()) {
						index = i0 + "-" + i1 + "-" + i2;
						q.setIndex(index);

						// int i3 =0;
						// for(TaskItem t: q.getTaskitemlist()){
						// index = i0 + "-" + i1 + "-" + i2 + "-" + i3;
						// t.setIndex(index);
						//
						// i3++;
						// }

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
