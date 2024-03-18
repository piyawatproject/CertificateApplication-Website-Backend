package com.gable.cts.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.gable.cts.model.Certificate;
import com.gable.cts.repository.CertificateRepository;

@Service
public class CertificateService {
	
	@Autowired
	private CertificateRepository repo;
	
	//GET ALL CERTIFICATION THAT HAVE IN LIST (DISTINT)
	public List<Certificate> findAll() {
		return repo.findAll();
	}

		
	//GET ONLY ONE
	public  Certificate findOne(Long id) {
		return repo.findById(id).get();
	}
		
	//ADD NEW CERTIFICATE
	//public Certificate addNewCertificate(Certificate certificate) {
	//	Certificate new_certificate = null;
	//	if (!repo.existsById(certificate.getId())) {
	//		new_certificate = certificate;
	//	}
	//	return repo.save(new_certificate);
	//}
	
	public Certificate addCertificate(Certificate certificate) {
		Certificate ret = null;
		try {
			if (certificate.getId() == null) {
				ret = repo.save(certificate);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ret;
	}
		
	//UPDATE&EDIT EMPLOYEE
	public Certificate updateCertificate(Certificate certificate) {
		Certificate ret = null;
		
		try {
			if(repo.existsById(certificate.getId())) {
				ret = repo.save(certificate);
			}
		}catch( Exception ex) {
			ex.printStackTrace();

		}
		return ret;
	}
	
	 public byte[] jsonStringToByteArray(String jsonString) {
	        jsonString = jsonString.substring(1, jsonString.length() - 1);

	        String[] parts = jsonString.split(",");
	        List<Byte> byteList = new ArrayList<>();
	        for (String part : parts) {
	        	int intValue = Integer.parseInt(part.trim());
	        	byteList.add((byte) intValue);
	        }

	        byte[] byteArray = new byte[byteList.size()];
	        for (int i = 0; i < byteList.size(); i++) {
	            byteArray[i] = byteList.get(i);
	        }

	        return byteArray;
	    }
	 
		
}
