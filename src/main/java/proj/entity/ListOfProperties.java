package proj.entity;

import javax.persistence.*;

/**
 * Created by SCIP on 26.07.2016.
 */
@Entity
public class ListOfProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(fetch = FetchType.LAZY)
    private Category category;
    @ManyToMany(fetch = FetchType.LAZY)
    private Property property;

    public ListOfProperties() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "ListOfProperties{" +
                "id=" + id +
                ", category=" + category +
                ", property=" + property +
                '}';
    }
}
