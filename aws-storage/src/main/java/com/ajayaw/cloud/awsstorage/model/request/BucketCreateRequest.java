/**
 * 
 */
package com.ajayaw.cloud.awsstorage.model.request;

import java.io.Serializable;

/**
 * @author ajayaw
 *
 */
public class BucketCreateRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2183191505162168920L;
	
	private String bucketName;
	private String region;
	/**
	 * @return the bucketName
	 */
	public String getBucketName() {
		return bucketName;
	}
	/**
	 * @param bucketName the bucketName to set
	 */
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
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
	
	@Override
	public String toString() {
		return "createBucket [bucketName=" + bucketName + ", region=" + region + "]";
	}
}
