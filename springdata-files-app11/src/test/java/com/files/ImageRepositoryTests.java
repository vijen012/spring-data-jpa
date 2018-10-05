package com.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.files.entities.Image;
import com.files.repositories.ImageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageRepositoryTests {

	@Autowired
	private ImageRepository imageRepository;
	
	@Test
	public void testImageSave() {
		
		String fileName = "spring-data.jpg";
		Image image = new Image();
		image.setId(101);
		image.setName("spring-data.jpg");
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
			if (inputStream != null) {
				
				byte[] fileContent = new byte[inputStream.available()];
				inputStream.read(fileContent);
				image.setData(fileContent);
				imageRepository.save(image);
				
			} else {
				throw new FileNotFoundException("File: "+ fileName + " not in classpath");
			}
		}
		catch( Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Test
	public void testReadImage()	{
		Image image = imageRepository.findOne(101L);
		File file = new File(image.getName());		
		try (OutputStream outputStram = new FileOutputStream(file)) {
			outputStram.write(image.getData());			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
