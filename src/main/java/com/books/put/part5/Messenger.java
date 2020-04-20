package com.books.put.part5;

public class Messenger {

  private MailServer mailServer;
  private TemplateEngine templateEngine;

  public Messenger(MailServer mailServer, TemplateEngine templateEngine) {
    this.mailServer = mailServer;
    this.templateEngine = templateEngine;
  }

  void sendMessage(Client client, Template template) {
    String messageContent = templateEngine.prepareMessage(template, client);
    mailServer.send(client.getEmail(), messageContent);
  }
}
