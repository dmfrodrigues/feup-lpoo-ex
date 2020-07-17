public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuffer sb = new StringBuffer(drink.getText());
        sb.reverse();
        drink.setText(sb.toString());
    }
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
