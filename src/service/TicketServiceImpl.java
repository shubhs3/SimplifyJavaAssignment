package service;

import repository.Model.Ticket;
import repository.TourismRepository;
import repository.Utils.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class TicketServiceImpl implements TicketService {
    private final TourismRepository tourismRepository;

    public TicketServiceImpl() {
        tourismRepository = new TourismRepository();
    }

    @Override
    public void addTicket(Ticket ticket) {
        tourismRepository.addTicket(ticket);
    }

    @Override
    public String getRoute(String startPoint) {
        startPoint = startPoint.toLowerCase();
        final HashMap<String, Set<String>> availableTickets = tourismRepository.getAvailableTickets();
        final Set<String> visitedCities = tourismRepository.getVisitedCities();
        StringBuilder route = new StringBuilder(Utils.toCamelCase(startPoint));
        String currentStation = new String(startPoint);
        boolean stop = false;
        while (!stop) {
            if (!availableTickets.containsKey(currentStation)) {
                stop = true;
            }
            Set<String> possibleDestinations = availableTickets.get(currentStation);
            Set<String> intersection = new HashSet<String>(visitedCities);
            intersection.retainAll(possibleDestinations);
            for (String i : intersection) {
                if (visitedCities.contains(i)) {
                    currentStation = i;
                    visitedCities.remove(i);
                }
            }
            route.append("->").append(Utils.toCamelCase(currentStation));
            if (currentStation.compareTo(startPoint)==0) {
                stop = true;
            }
        }
        return route.toString();
    }

    @Override
    public void addVisitedCities(List<String> visitedCities) {
        tourismRepository.addVisitedCities(visitedCities);
    }
}
