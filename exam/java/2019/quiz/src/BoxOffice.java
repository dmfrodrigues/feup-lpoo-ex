import java.util.*;

public class BoxOffice {
    private static Map<Concert, Set<Integer>> soldTickets = new HashMap<>();
    public static List<Ticket> buy(Concert concert, int number) {
        if(soldTickets.get(concert) == null){
            soldTickets.put(concert, new HashSet<>());
        }
        List<Ticket> res = new ArrayList<>();
        for(int i = 0; i < number; ++i){
            int ticketNumber = getLeastAvailableTicketNumber(concert);
            soldTickets.get(concert).add(ticketNumber);
            try {
                res.add(new Ticket(ticketNumber, concert));
            } catch (InvalidTicket invalidTicket) {
                invalidTicket.printStackTrace();
            }
        }
        return res;
    }
    private static int getLeastAvailableTicketNumber(Concert concert){
        int i = 1;
        while(soldTickets.get(concert).contains(i)) ++i;
        return i;
    }
}
