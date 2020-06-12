public abstract class Person implements Comparable {
    String name;
    Integer age;
    
    public Person(String name){
        this(name, 0);
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        if(!name.equals(p.name)) return name.compareTo(p.name);
        return (age.compareTo(p.age));
    }
}
