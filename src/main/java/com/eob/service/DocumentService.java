package com.eob.service;

import java.util.List;
import java.util.Optional;

import com.eob.entity.Document;
import com.eob.entity.User;

public interface DocumentService {
	Document createDocument(String documentName,String documentPath );
	List<Document> getAllDocuments();
	Optional<Document> getDocumentByID(long Id);
//	List<Document> getDocumentsByUserId(long userID);
	boolean deleteDocument(long documentId);

}
