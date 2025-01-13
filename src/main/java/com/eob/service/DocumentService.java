package com.eob.service;

import java.util.List;
import java.util.Optional;

import com.eob.entity.Document;

public interface DocumentService {
	Document createDocument(int userId,String documentName,String documentPath );
	List<Document> getAllDocuments();
	Optional<Document> getDocumentByID(int Id);
	List<Document> getDocumentsByUserId(int userID);
	boolean deleteDocument(int documentId);

}
