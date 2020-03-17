package com.wipro.holmes.uhg.enb.esp.services;

import java.io.IOException;
import javax.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.wipro.holmes.uhg.enb.esp.models.File;

@Service
public class FileServiceImpl implements FileService<File> {

	private GridFsTemplate gridFsTemplate;
	private GridFsOperations operations;
	private static final String ID = "_id";
	private static final String TEMPLATE = "template.xlsx";
	private String TEMPLATE_ID;

	public FileServiceImpl(GridFsTemplate gridFsTemplate, GridFsOperations operations) {
		this.gridFsTemplate = gridFsTemplate;
		this.operations = operations;
	}

	@PostConstruct
	public void init() throws IOException {
		DBObject metaData = new BasicDBObject();
		metaData.put(ID, TEMPLATE);
		GridFSFile template = gridFsTemplate.find(new Query(Criteria.where("metadata." + ID).is(TEMPLATE))).first();
		if (template == null)
			TEMPLATE_ID = gridFsTemplate
					.store(new ClassPathResource("static/" + TEMPLATE).getInputStream(), TEMPLATE, metaData).toString();
		else
			TEMPLATE_ID = template.getObjectId().toString();
	}

	@Override
	public File readFile() throws Exception {
		return readFile(TEMPLATE_ID);
	}

	@Override
	public File readFile(String fileId) throws IllegalStateException, IOException {
		GridFSFile gridFile = gridFsTemplate.findOne(new Query(Criteria.where(ID).is(fileId)));
		File file = new File(operations.getResource(gridFile).getInputStream());
		return file;
	}

	@Override
	public String saveFile(MultipartFile file) throws IOException {
		ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getName(), file.getContentType());
		return id.toString();
	}

}
