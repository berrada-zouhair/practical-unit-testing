package com.books.put.part5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MessengerTest {

  @Test
  void mocks_should_be_of_same_types_parameter() {
    MailServer mailServer = Mockito.mock(MailServer.class);
    TemplateEngine templateEngine = Mockito.mock(TemplateEngine.class);
    assertThat(mailServer).isInstanceOf(MailServer.class);
    assertThat(templateEngine).isInstanceOf(TemplateEngine.class);
  }

  @Test
  void should_send_message() {
    Template template = Mockito.mock(Template.class);
    Client client = Mockito.mock(Client.class);
    TemplateEngine templateEngine = Mockito.mock(TemplateEngine.class);
    MailServer mailServer = Mockito.mock(MailServer.class);

    String clientEmail = "zouhair@info.com";
    String messageContent = "message content";

    Mockito.when(client.getEmail()).thenReturn(clientEmail);
    Mockito.when(templateEngine.prepareMessage(template, client)).thenReturn(messageContent);

    Messenger messenger = new Messenger(mailServer, templateEngine);
    messenger.sendMessage(client, template);
    Mockito.verify(mailServer).send(clientEmail, messageContent);
  }
}
