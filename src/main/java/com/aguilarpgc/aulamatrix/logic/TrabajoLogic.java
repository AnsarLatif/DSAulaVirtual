 package com.aguilarpgc.aulamatrix.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aguilarpgc.aulamatrix.model.Trabajo;
import com.aguilarpgc.aulamatrix.repository.TrabajoRepository;

@Service
public class TrabajoLogic {

	@Autowired
	TrabajoRepository trabajoRepository;
	

    public void addTrabajo(Trabajo trabajo){
    	
        trabajoRepository.addOrUpdateTrabajo(trabajo);
    }


	public String saveFile(MultipartFile myFile) {
		InputStream inputStream = null;  
		  OutputStream outputStream = null;  

		  String fileName = myFile.getOriginalFilename();  
		  
		  try {  
		   inputStream = myFile.getInputStream();  
		  
		   String ruta = "D:/Data/files/" + fileName;
		   File newFile = new File(ruta);  
		   if (!newFile.exists()) {  
		     newFile.createNewFile();  
		   }else{
			   return "";
		   }
		   outputStream = new FileOutputStream(newFile);  
		   int read = 0;  
		   byte[] bytes = new byte[1024];  
		  
		   while ((read = inputStream.read(bytes)) != -1) {  
		    outputStream.write(bytes, 0, read);  
		   }  
		   
		   return ruta;
		  } catch (IOException e) {  
		   // TODO Auto-generated catch block  
		   e.printStackTrace();  
		  }  
		
		  return "";
	}

	
}
