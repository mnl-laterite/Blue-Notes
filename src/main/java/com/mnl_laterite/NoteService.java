package com.mnl_laterite;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class NoteService {

  private MongoClient mongoClient;
  private MongoDatabase noteDatabase;
  private MongoCollection noteCollection;

  NoteService () {

    mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    noteDatabase = mongoClient.getDatabase("NoteDatabase");
    noteCollection = noteDatabase.getCollection("NoteCollection");
  }

}
