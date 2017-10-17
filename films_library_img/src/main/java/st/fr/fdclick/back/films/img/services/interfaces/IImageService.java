package st.fr.fdclick.back.films.img.services.interfaces;

import java.io.InputStream;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import st.fr.fdclick.back.films.img.dtos.ImageDTO;

public interface IImageService {
	void delete(String fileName);
	String save(ImageDTO image, DBObject metaData);
	String save(InputStream stream, String fileName, String contentType, DBObject metaData);
	GridFSDBFile getByFileName(String fileName);
}
