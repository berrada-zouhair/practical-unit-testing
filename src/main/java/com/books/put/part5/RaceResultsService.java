package com.books.put.part5;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;

public class RaceResultsService {

  private Map<Category, Collection<Client>> clientsByCategory = new EnumMap<>(Category.class);

  public void addSubscriber(Client client, Category category) {
    if (clientsByCategory.containsKey(category)) {
      clientsByCategory.get(category).add(client);
    } else {
      clientsByCategory.put(category, new HashSet<>(asList(client)));
    }
  }

  public void send(Message message, Category category) {
    Collection<Client> clients = clientsByCategory.get(category);
    if (clients != null && !clients.isEmpty()) {
      clients.forEach(client -> client.receiveMessage(message));
    }
  }

  public void removeSubscriber(Client client, Category category) {
    if (clientsByCategory.containsKey(category)) {
      clientsByCategory.get(category).remove(client);
    }
  }
}
