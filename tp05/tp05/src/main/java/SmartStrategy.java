import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {

    List<StringDrink> dl = new ArrayList<>();
    List<StringRecipe> rl = new ArrayList<>();

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        dl.add(drink);
        rl.add(recipe);
        if(bar.isHappyHour()) happyHourStarted(bar);
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for(int i = 0; i < dl.size(); ++i){
            bar.order(dl.get(i), rl.get(i));
        }
        dl.clear();
        rl.clear();
    }

    @Override
    public void happyHourEnded(StringBar bar) {}
}
