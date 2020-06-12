public class Speaker extends User {
    public Speaker(String name, int age) {
        super(name, age);
    }

    public Speaker(String name) { super(name); }

    public int getFee() {
        return 0;
    }

    @Override
    public String toString() {
        return "Speaker " + getName() + " has a fee value of " + getFee() + ".";
    }
}
