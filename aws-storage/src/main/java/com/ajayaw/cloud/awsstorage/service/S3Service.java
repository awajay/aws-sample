/**
 * 
 */
package com.ajayaw.cloud.awsstorage.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajayaw.cloud.awsstorage.model.UploadResponse;
import com.ajayaw.cloud.awsstorage.model.request.BucketCreateRequest;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

/**
 * @author ajayaw
 *
 */
@Service
public class S3Service {
	
	private AmazonS3 s3;
	
	@Autowired
	public void insert(AmazonS3 s3) {
		this.s3 = s3;		
	}
	
	public UploadResponse save(String bucketName,
			String filename,
			ObjectMetadata objectMetadata,
			InputStream inputStream
			) {
		/*ObjectMetadata objMetaData = new ObjectMetadata();
		optionalMetadata.ifPresent(map-> {
			if(!map.isEmpty()) {
				map.forEach((key, value) -> objMetaData.addUserMetadata(key, value));
			}
		});*/
		try {
			UploadResponse uploadResponse = new UploadResponse();
			PutObjectResult putObjectResult = s3.putObject(bucketName, filename, inputStream, objectMetadata);
			uploadResponse.seteTag(putObjectResult.getETag());
			uploadResponse.setUrl(s3.getUrl(bucketName, filename));
			return uploadResponse;
		}catch(AmazonServiceException e) {
			throw new IllegalStateException("Failed to store file",e);
		}
	}
	
	public S3Object retrieve(GetObjectRequest getObjectRequest) {
		return s3.getObject(getObjectRequest);
	}
	
	public Bucket create(BucketCreateRequest bucketCreate) {
		CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketCreate.getBucketName(),bucketCreate.getRegion());
		return s3.createBucket(createBucketRequest);
	}	
}
