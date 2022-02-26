package com.ajayaw.cloud.awsstorage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * @author ajayaw
 *
 */

@Configuration
public class AwsConfig {
	
	@Value("${cloud.aws.accesskey}")
	private String accessKey;
	
	@Value("${cloud.aws.secretKey}")
	private String secretKey;
	
	@Value("${cloud.aws.profile}")
	private String awsProfile;
	
	@Value("${cloud.aws.region}")
	private String region;
	
	@Bean
	public AmazonS3 s3(){
		
		AWSCredentials aWSCredentials  = new BasicAWSCredentials(accessKey,secretKey);
		
		return AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(aWSCredentials))
				.withRegion(region)
				.build();
	}

	
	
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}



	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}



	/**
	 * @return the awsProfile
	 */
	public String getAwsProfile() {
		return awsProfile;
	}


	/**
	 * @param awsProfile the awsProfile to set
	 */
	public void setAwsProfile(String awsProfile) {
		this.awsProfile = awsProfile;
	}


	/**
	 * @return the accessKey
	 */
	public String getAccessKey() {
		return accessKey;
	}

	/**
	 * @param accessKey the accessKey to set
	 */
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	/**
	 * @return the secretKey
	 */
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * @param secretKey the secretKey to set
	 */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	

}
