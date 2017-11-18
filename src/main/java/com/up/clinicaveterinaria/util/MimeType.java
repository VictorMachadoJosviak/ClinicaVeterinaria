package com.up.clinicaveterinaria.util;

public enum MimeType {
	
	PDF("application", "pdf"),
	XML("application", "xml"),
	XLSX("application", "xlsx"),
	CSV("text", "csv");

	private String accessType;
	private String mimeType;
	private String contentType;

	private MimeType(String accessType, String mimeType) {
		this.accessType = accessType;
		this.mimeType = mimeType;
		this.contentType = this.accessType + "/" + this.mimeType;
	}

	public String getAccessType() {
		return accessType;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getContentType() {
		return this.contentType;
	}
}
