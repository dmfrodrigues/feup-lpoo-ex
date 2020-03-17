import java.util.List;

public class City implements SumProvider {
    private List<House> listHouses;

    public City(List<House> listHouses){
        this.listHouses = listHouses;
    }

    @Override
    public double sum(){
        double s = 0.0;
        for(House h: listHouses)
            s += h.getArea();
        return s;
    }

}
