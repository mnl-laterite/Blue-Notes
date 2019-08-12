package com.mnl_laterite;

import lombok.Data;

@Data
public class Note {

  private final long noteId;

  private String content;

  private String title;

  private String tags;

  Note (long noteId, String content, String title, String tags) {

    this.noteId = noteId;
    this.content = content;
    this.title = title;
    this.tags = tags;
  }

}
