/**
 * 
 */
package com.ajayaw.cloud.awsstorage.model;

import java.io.Serializable;
import java.net.URL;

/**
 * @author ajayaw
 *
 */
public class UploadResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4219075446276448610L;
	
	private String eTag;
	private URL url;
	/**
	 * @return the eTag
	 */
	public String geteTag() {
		return eTag;
	}
	/**
	 * @param eTag the eTag to set
	 */
	public void seteTag(String eTag) {
		this.eTag = eTag;
	}
	/**
	 * @return the url
	 */
	public URL getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(URL url) {
		this.url = url;
	}
}
