package com.eob.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eob.entity.Document;
import com.eob.repository.DocumentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl {

    @Autowired
    private DocumentRepo documentRepository;

    // Create a new document
    public Document createDocument(int userId, String documentName, String documentPath) {
        Document document = new Document(userId, documentName, documentPath);
        return documentRepository.save(document);
    }

    // Get all documents
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    // Get a document by its ID
    public Optional<Document> getDocumentById(Long documentId) {
        return documentRepository.findById(documentId);
    }

    // Get documents by user ID
    public List<Document> getDocumentsByUserId(Long userId) {
        return documentRepository.findByUserId(userId);
    }



    // Delete a document by ID
    public boolean deleteDocument(Long documentId) {
        if (documentRepository.existsById(documentId)) {
            documentRepository.deleteById(documentId);
            return true;
        }
        return false;
    }
}
