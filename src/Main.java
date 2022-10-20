import repository.Model.Ticket;
import service.TicketServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
Kiev
Amsterdam,Kiev,Zurich,Prague,Berlin,Barcelona
Paris-Skopje,Zurich-Amsterdam,Prague-Zurich,Barcelona-Berlin,Kiev-Prague,Skopje-Paris,Amsterdam-Barcelona,Berlin-Keiv,Berlin-Amsterdam
        * */
        TicketServiceImpl ticketService = new TicketServiceImpl();
        Scanner sc = new Scanner(System.in);
        String startPoint = sc.nextLine();
        String visited = sc.nextLine();
        List<String> visitedCities = new ArrayList<>(List.of(visited.split(",")));
        ticketService.addVisitedCities(visitedCities);
        List<String> tickets = new ArrayList<>(List.of(sc.nextLine().split(",")));
        tickets.forEach(ticket->{
            String[] t = ticket.split("-");
            Ticket ticket1 = new Ticket(t[0],t[1]);
            ticketService.addTicket(ticket1);
        });
        System.out.println(ticketService.getRoute(startPoint));
    }
}