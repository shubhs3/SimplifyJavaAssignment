package repository;

import repository.Model.Ticket;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TourismRepository {
    private final HashMap<String, Set<String>> store;
    private final Set<String> visitedCitiesStore;

    public TourismRepository() {
        store = new HashMap<>();
        visitedCitiesStore = new HashSet<>();
    }

    public Set<String> getVisitedCities() {
        return visitedCitiesStore;
    }

    public void addTicket(Ticket ticket) {
        String source = ticket.getSource().toLowerCase();
        String destination = ticket.getDestination().toLowerCase();
        if (store.containsKey(source)) {
            Set<String> connections = store.get(source);
            connections.add(destination);
            store.put(source,connections);
        } else {
            store.put(source, new HashSet<String>() {{
                add(destination);
            }});
        }
    }

    public void addVisitedCities(List<String> visitedCities) {
        visitedCities = visitedCities.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        visitedCitiesStore.addAll(visitedCities);
    }

    public HashMap<String, Set<String>> getAvailableTickets() {
        return store;
    }
}
