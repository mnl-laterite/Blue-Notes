package com.mnl_laterite;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Note {

  private ObjectId noteId;

  private String owner;

  private String content;

  private String title;

  Note (String content, String title) {

    this.noteId = new ObjectId();
    this.content = content;
    this.title = title;
  }

  Note (ObjectId noteId, String content, String title) {

    this.noteId = noteId;
    this.content = content;
    this.title = title;
  }

}
