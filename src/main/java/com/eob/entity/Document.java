package com.eob.entity;
import java.sql.Timestamp;

public class Document {
    private int documentId;
    private int userId;
    private String documentName;
    private String documentPath;
    private Timestamp uploadedAt;

    // Constructor
    public Document(int documentId, int userId, String documentName, String documentPath, Timestamp uploadedAt) {
        this.documentId = documentId;
        this.userId = userId;
        this.documentName = documentName;
        this.documentPath = documentPath;
        this.uploadedAt = uploadedAt;
    }

    public Document(int userId, String documentName, String documentPath) {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public Timestamp getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Timestamp uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
