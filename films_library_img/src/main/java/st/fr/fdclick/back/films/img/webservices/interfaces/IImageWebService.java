package st.fr.fdclick.back.films.img.webservices.interfaces;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import st.fr.fdclick.back.films.img.dtos.ImageDTO;

public interface IImageWebService {
	void delete(String fileName);
	void save(ImageDTO image);
	void save(MultipartFile file);
	ResponseEntity<byte[]> getBase64ByFileName(String fileName);
	ResponseEntity<InputStreamResource> getStreamByFileName(String fileName);
}
