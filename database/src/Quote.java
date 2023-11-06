public class Quote {
    private int id; // If you have an ID for each quote
    private int num_of_trees;
    private double budget;

    // Constructors, getters, setters
    public Quote(int num_of_trees, double budget) {
        this.num_of_trees = num_of_trees;
        this.budget = budget;
    }

    // Getters and setters for ID (if applicable), num_of_trees, and budget
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_of_trees() {
        return num_of_trees;
    }

    public void setNum_of_trees(int num_of_trees) {
        this.num_of_trees = num_of_trees;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}