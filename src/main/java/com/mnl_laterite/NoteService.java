package com.mnl_laterite;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class NoteService {

  private MongoClient mongoClient;
  private MongoDatabase noteDatabase;
  private MongoCollection<Document> noteCollection;

  NoteService (MongoClient mongoClient) {

    this.mongoClient = mongoClient;
    noteDatabase = mongoClient.getDatabase("NoteDatabase");
    noteCollection = noteDatabase.getCollection("NoteCollection");
  }


  private Document toDocument (Note note) {
    return new Document("_id", note.getNoteId())
                .append("owner", note.getOwner())
                .append("content", note.getContent())
                .append("title", note.getTitle());
  }

  void insertNote (Note note) {
    noteCollection.insertOne(toDocument(note));
  }

  void deleteNoteById (ObjectId id) {
    noteCollection.deleteOne(new Document("_id", id));
  }

  void updateNoteContent(ObjectId id, String content) {
    noteCollection.updateOne(new Document("_id", id), new Document("content", content));
  }

  void updateNoteTitle(ObjectId id, String title) {
    noteCollection.updateOne(new Document("_id", id), new Document("title", title));
  }

  List<String> getAllNotes() {
    FindIterable<Document> results = noteCollection.find();
    List<String> returnList = new ArrayList<>();

    for (Document doc : results) {
      returnList.add(doc.toJson());
    }

    return returnList;
  }

}
