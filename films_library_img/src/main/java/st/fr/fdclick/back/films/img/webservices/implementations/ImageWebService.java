package st.fr.fdclick.back.films.img.webservices.implementations;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import st.fr.fdclick.back.films.img.dtos.ImageDTO;
import st.fr.fdclick.back.films.img.services.interfaces.IImageService;
import st.fr.fdclick.back.films.img.webservices.interfaces.IImageWebService;

@RestController
@RequestMapping("img")
@CrossOrigin(origins="*")
public class ImageWebService implements IImageWebService {
	
	@Autowired
	private IImageService imageService;

	@RequestMapping(value="/del/{filename:.+}", method=RequestMethod.DELETE)
	@Override
	public void delete(@PathVariable("filename") String fileName) {
		imageService.delete(fileName);
	}

	@RequestMapping(value="/save/b64", method=RequestMethod.POST)
	@Override
	public void save(@RequestBody ImageDTO image) {
		DBObject metaData = new BasicDBObject();
		imageService.save(image, metaData);
	}

	@RequestMapping(value="/save/mp", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	@Override
	public void save(@RequestParam("file") MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		DBObject metaData = new BasicDBObject();
		try {
			imageService.save(file.getInputStream(), fileName, file.getContentType(), metaData);
		} catch (IOException e) {}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/b64/{name}", method=RequestMethod.GET)
	@ResponseBody
	@Override
	public ResponseEntity<byte[]> getBase64ByFileName(@PathVariable("name") String fileName) {
		GridFSDBFile file = imageService.getByFileName(fileName);
		if(file == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		try {
			ResponseEntity.ok().body(Base64.encodeBase64(StreamUtils.copyToByteArray(file.getInputStream())));
		} catch (IOException e) {}
		return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
	}

	@RequestMapping(value="/mp/{name}", method=RequestMethod.GET)
	@ResponseBody
	@Override
	public ResponseEntity<InputStreamResource> getStreamByFileName(@PathVariable("name") String fileName) {
		GridFSDBFile file = imageService.getByFileName(fileName);
		if(file == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().contentLength(file.getLength()).contentType(MediaType.parseMediaType(file.getContentType())).body(new InputStreamResource(file.getInputStream()));
	}

}
