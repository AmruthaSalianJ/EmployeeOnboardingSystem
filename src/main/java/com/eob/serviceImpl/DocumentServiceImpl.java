package com.eob.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eob.entity.Document;
import com.eob.entity.User;
import com.eob.repository.DocumentRepo;
import com.eob.service.DocumentService;

import java.util.List;
import java.util.Optional;

@Service
public  class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepo documentRepository;
    @Override
    // Create a new document
    public Document createDocument(String documentName, String documentPath) {
        Document document = new Document(documentName, documentPath);
        return documentRepository.save(document);
    }
    @Override
    // Get all documents
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
    @Override
    // Get a document by its ID
    public Optional<Document> getDocumentByID(long documentId) {
        return documentRepository.findById(documentId);
    }
    

	/*
	 * // Get documents by user ID public List<Document> getDocumentsByUserId(long
	 * userId) { return documentRepository.findByUserId(userId); }
	 */


	@Override
    // Delete a document by ID
    public boolean deleteDocument(long documentId) {
        if (documentRepository.existsById(documentId)) {
            documentRepository.deleteById(documentId);
            return true;
        }
        return false;
    }




	

}
