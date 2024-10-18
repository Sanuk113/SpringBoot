import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // Constructors
    public ItemCategory() {
        // Default constructor
    }

    public ItemCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    // Getters and Setters with method chaining
    public Long getId() {
        return id;
    }

    public ItemCategory setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ItemCategory setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public ItemCategory setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ItemCategory setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    // Automatically set createdAt and updatedAt fields before saving
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // equals and hashCode methods for object comparison based on 'id' and 'categoryName'
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCategory that = (ItemCategory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName);
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "ItemCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
