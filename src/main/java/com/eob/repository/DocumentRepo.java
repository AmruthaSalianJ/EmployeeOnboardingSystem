package com.eob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eob.entity.Document;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Long> {

    // Find all documents for a given user ID
    List<Document> findByUserId(Long userId);

    // Find a document by its name
    List<Document> findByDocumentName(String documentName);
}