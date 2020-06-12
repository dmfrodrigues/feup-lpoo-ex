import java.util.ArrayList;
import java.util.List;

public class Band extends Act {
    List<Artist> artistList;
    
    public Band(String name, String country){
        super(name, country);
        artistList = new ArrayList<>();
    }

    public void addArtist(Artist artist) { artistList.add(artist); }
    public List<Artist> getArtists() { return artistList; }

    public boolean containsArtist(Artist artist) { 
        return artistList.contains(artist); 
    }
}
