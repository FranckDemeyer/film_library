package st.fr.fdclick.back.films.img.services.implementations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import st.fr.fdclick.back.films.img.dtos.ImageDTO;
import st.fr.fdclick.back.films.img.repositories.interfaces.IImageRepository;
import st.fr.fdclick.back.films.img.services.interfaces.IImageService;

@Service("imageService")
public class ImageService implements IImageService {
	
	@Autowired
	private IImageRepository imageRepository;

	@Override
	public void delete(String fileName) {
		imageRepository.delete(fileName);
	}

	@Override
	public String save(ImageDTO image, DBObject metaData) {
		return imageRepository.save(new ByteArrayInputStream(Base64.decodeBase64(image.getImage())), image.getName(), image.getType(), metaData);
	}

	@Override
	public String save(InputStream stream, String fileName, String contentType, DBObject metaData) {
		return imageRepository.save(stream, fileName, contentType, metaData);
	}

	@Override
	public GridFSDBFile getByFileName(String fileName) {
		return imageRepository.getByFileName(fileName);
	}

}
