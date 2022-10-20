package service;

import repository.Model.Ticket;

import java.util.List;

public interface TicketService{
  void addTicket(Ticket ticket);
  String getRoute(String startPoint);
  void addVisitedCities(List<String> visitedCities);
}