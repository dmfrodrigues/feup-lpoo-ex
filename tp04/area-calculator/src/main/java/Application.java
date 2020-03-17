import java.awt.geom.Area;

public class Application {
    public static void main(String[] args){
        AreaAggregator a = new AreaAggregator();
        System.out.println(a.output());
        System.out.println(a.outputXML());
    }
}
