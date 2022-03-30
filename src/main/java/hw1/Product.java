package hw1;

public class Product {
    private int id;
    private String title;
    private int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Product(" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ')';
    }
}
