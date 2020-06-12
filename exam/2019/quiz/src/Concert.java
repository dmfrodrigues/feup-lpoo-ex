import java.util.ArrayList;
import java.util.List;

public class Concert {
    String city;
    String country;
    String date;
    
    List<Act> acts;
    
    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
        
        acts = new ArrayList<>();
    }

    public void addAct(Act act) { acts.add(act); }
    public List<Act> getActs(){ return acts; }

    public String getCity(){ return city; }
    public String getCountry(){ return country; }
    public String getDate(){ return date; }
    
    @Override
    public boolean equals(Object obj) {
        Concert c = (Concert)obj;
        return (city.equals(c.city) &&
                country.equals(c.country) &&
                date.equals(c.date) &&
                acts.equals(c.acts));
    }

    @Override
    public int hashCode() {
        return (city.hashCode() *
                country.hashCode() *
                date.hashCode() * 
                acts.hashCode());
    }

    public boolean isValid(Ticket ticket) {
        return (this.equals(ticket.getConcert()));
    }

    public boolean participates(Artist artist) {
        for(final Act act: acts){
            if(act instanceof Band && ((Band)act).containsArtist(artist)) return true;
            if(act instanceof Artist && ((Artist)act).equals(artist)) return true;
        }
        return false;
    }
}
