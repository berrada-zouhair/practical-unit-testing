package com.books.put.part5;

import static com.books.put.part5.Category.BOAT;
import static com.books.put.part5.Category.HORSE;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceResultsServiceTest {

  private Message message;
  private RaceResultsService raceResultsService;
  private Client client1;
  private Client client2;

  @BeforeEach
  void setUp() {
    message = mock(Message.class);
    raceResultsService = new RaceResultsService();
    client1 = mock(Client.class, "Client 1");
    client2 = mock(Client.class, "Client 2");
  }

  @Test
  void not_subscribed_clients_should_not_receive_message() {
    raceResultsService.send(message, HORSE);
    verify(client1, never()).receiveMessage(message);
    verify(client2, never()).receiveMessage(message);
  }

  @Test
  void subscribed_client_should_receive_message() {
    Client client = mock(Client.class);
    raceResultsService.addSubscriber(client, HORSE);
    raceResultsService.send(message, HORSE);
    verify(client).receiveMessage(message);
  }

  @Test
  void subscribed_clients_should_all_receive_message() {
    raceResultsService.addSubscriber(client1, HORSE);
    raceResultsService.addSubscriber(client2, HORSE);
    raceResultsService.send(message, HORSE);
    verify(client1).receiveMessage(message);
    verify(client2).receiveMessage(message);
  }

  @Test
  void multiple_subscribers_should_receive_message_only_once() {
    Client client = mock(Client.class);
    raceResultsService.addSubscriber(client, HORSE);
    raceResultsService.addSubscriber(client, HORSE);
    raceResultsService.send(message, HORSE);
    verify(client, times(1)).receiveMessage(message);
  }

  @Test
  void unsubscribed_client_should_not_receive_message() {
    raceResultsService.addSubscriber(client1, HORSE);
    raceResultsService.addSubscriber(client2, HORSE);
    raceResultsService.removeSubscriber(client2, HORSE);
    raceResultsService.send(message, HORSE);
    verify(client1).receiveMessage(message);
    verify(client2, never()).receiveMessage(message);
  }

  @Test
  void clients_should_receive_messages_only_for_categories_subscribed_for() {
    raceResultsService.addSubscriber(client1, HORSE);
    raceResultsService.addSubscriber(client2, BOAT);
    raceResultsService.send(message, HORSE);
    verify(client1).receiveMessage(message);
    verify(client2, never()).receiveMessage(message);
  }

  @Test
  void client_should_receive_all_messages_only_for_categories_subscribed_for() {
    raceResultsService.addSubscriber(client1, HORSE);
    raceResultsService.send(message, HORSE);
    raceResultsService.send(message, HORSE);
    raceResultsService.send(message, HORSE);
    verify(client1, times(3)).receiveMessage(message);
  }

  @Test
  void unsubscribe_client_not_subscribed_should_have_no_impact() {
    raceResultsService.removeSubscriber(client1, HORSE);
    raceResultsService.send(message, HORSE);
    raceResultsService.send(message, HORSE);
    raceResultsService.send(message, HORSE);
    verify(client1, never()).receiveMessage(message);
  }
}
