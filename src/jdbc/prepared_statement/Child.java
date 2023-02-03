package jdbc.prepared_statement;

public class Child {

    private int id;
    private String name;

    private boolean nice;

    public Child(int id, String name, boolean nice) {
        this.id = id;
        this.name = name;
        this.nice = nice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNice() {
        return nice;
    }

    public void setNice(boolean nice) {
        this.nice = nice;
    }

    public void printOut(){
        System.out.println(this.name + " is " + (nice ? "nice" : "Nauthty"));
    }
}
