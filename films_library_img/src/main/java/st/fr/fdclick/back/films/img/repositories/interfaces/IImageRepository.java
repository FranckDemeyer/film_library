package st.fr.fdclick.back.films.img.repositories.interfaces;

import java.io.InputStream;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

public interface IImageRepository {
	void delete(String fileName);
	String save(InputStream stream, String fileName, String contentType, DBObject metaData);
	GridFSDBFile getByFileName(String fileName);
}
