package repository.Model;

import java.util.HashMap;

public class Ticket {
    private final String source;
    private final String destination;

    public Ticket(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public HashMap<String,String> getTicket(){
        return new HashMap<>(){{
           put(source,destination);
        }};
    }
}
