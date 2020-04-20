package com.books.put.part13;

public class MySut {

  private Collaborator collaborator;

  public String useCollaborato() {
    return collaborator.doSomeThing();
  }

  public void setCollaborator(Collaborator collaborator) {
    this.collaborator = collaborator;
  }
}
