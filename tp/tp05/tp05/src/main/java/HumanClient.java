public class HumanClient implements Client {

    private OrderingStrategy s;

    public HumanClient(OrderingStrategy s) {
        this.s = s;
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        s.wants(drink, recipe, bar);
    }

    @Override
    public void happyHourStarted(Bar bar) {
        s.happyHourStarted((StringBar)bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        s.happyHourEnded((StringBar)bar);
    }
}
