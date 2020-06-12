public abstract class Act {
    String name;
    String country;
    
    public Act(String name, String country){
        this.name = name;
        this.country = country;
    }
    
    public String getName() { return name; }

    public String getCountry() { return country; }

    @Override
    public boolean equals(Object obj) {
        Act act = (Act)obj;
        return (name.equals(act.name) &&
                country.equals(act.country));
    }

    @Override
    public int hashCode() {
        return (name.hashCode() *
                country.hashCode());
    }
}
