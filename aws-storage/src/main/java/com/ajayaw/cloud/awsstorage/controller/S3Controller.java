/**
 * 
 */
package com.ajayaw.cloud.awsstorage.controller;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ajayaw.cloud.awsstorage.model.UploadResponse;
import com.ajayaw.cloud.awsstorage.model.request.BucketCreateRequest;
import com.ajayaw.cloud.awsstorage.service.S3Service;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

/**
 * @author ajayaw
 *
 */
@RestController
@RequestMapping(path="/s3")
public class S3Controller {
	
	@Autowired
	private S3Service s3Service;
	
	@GetMapping
	public S3ObjectInputStream getContent() {
		GetObjectRequest getObjectRequest = new GetObjectRequest("chatapp-dev-tf-state","test");
		return s3Service.retrieve(getObjectRequest).getObjectContent();
	}
		
	@GetMapping(path="/{bucketName}/{fileName}")
	public S3ObjectInputStream getContent(@PathVariable String bucketName,@PathVariable String fileName) {
		GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName,fileName);
		return s3Service.retrieve(getObjectRequest).getObjectContent();
	}
	
	@PostMapping(path="/{bucketName}/upload")
	public UploadResponse saveContent(@PathVariable("bucketName") String bucketname,
			@RequestParam("file") MultipartFile file) throws IOException {
		if(file.isEmpty()) {
			throw new IllegalStateException("Empty File upload not allowed size [ :" + file.getSize() + "]");
		}
		
		InputStream is = file.getInputStream();
        String keyName = file.getOriginalFilename();
        return s3Service.save(bucketname, keyName, new ObjectMetadata(), is);
	}
	
	@PostMapping(path="/create")
	public Bucket createBucket(@RequestBody BucketCreateRequest createBucketRequest) throws IOException {
		return s3Service.create(createBucketRequest);		
	}
}
