import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Event {
    private String title;
    private String date;
    private String description;
    private List<Person> persons;
    private Set<String> audience;
    
    public Event(String title, String date, String description){
        this.title = title;
        this.date = date;
        this.description = description;
        persons = new ArrayList<>();
        audience = new HashSet<>();
    }

    public Event(String title) {
        this(title, "");
    }

    public Event(String title, String description) {
        this(title, description, "");
    }

    public Event(Event e) {
        this(e.title, e.date, e.description);
    }

    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getDescription() { return description; }

    public void setTitle(String title) { this.title = title; }
    public void setDate(String date) { this.date = date; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    @Override
    public boolean equals(Object obj) {
        Event e = (Event)obj;
        return (title.equals(e.title) &&
                date.equals(e.date) &&
                description.equals(e.description));
    }

    public void addPerson(Person person) {
        persons.add(person);
        audience.add(person.getName());
    }

    public int getAudienceCount() {
        return audience.size();
    }
}
