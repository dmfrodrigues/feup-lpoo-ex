public class StringBar extends Bar {
    private boolean happyHour = false;
    StringBar(){}

    public void order(StringDrink d, StringRecipe r){
        r.mix(d);
    }

    @Override
    public boolean isHappyHour() {
        return happyHour;
    }

    public void startHappyHour() {
        this.happyHour = true;
        super.notifyObservers();
    }
    public void endHappyHour() {
        this.happyHour = false;
        super.notifyObservers();
    }
}
