import java.util.ArrayList;
import java.util.List;

public class Party extends Event {
    List<Event> events;
    public Party(String name, String date, String description) {
        super(name, date, description);
        events = new ArrayList<>();
    }

    public void addEvent(Event e) {
        events.add(e);
    }

    @Override
    public int getAudienceCount() {
        int res = super.getAudienceCount();
        for(final Event e: events) res += e.getAudienceCount();
        return res;
    }
}
