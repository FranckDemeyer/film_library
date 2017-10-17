package st.fr.fdclick.back.films.img.repositories.implementations;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import st.fr.fdclick.back.films.img.repositories.interfaces.IImageRepository;

@Repository
public class ImageRepository implements IImageRepository {
	
	@Autowired
	private GridFsTemplate gridFSTemplate;

	@Override
	public void delete(String fileName) {
		gridFSTemplate.delete(new Query(GridFsCriteria.whereFilename().is(fileName)));
	}

	@Override
	public String save(InputStream stream, String fileName, String contentType, DBObject metaData) {
		return gridFSTemplate.store(stream, fileName, contentType, metaData).toString();
	}

	@Override
	public GridFSDBFile getByFileName(String fileName) {
		return gridFSTemplate.findOne(new Query(GridFsCriteria.whereFilename().is(fileName)));
	}

}
