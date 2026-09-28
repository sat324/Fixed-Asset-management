public class AssetCategory {

    private int categoryId;
    private String categoryName;

    public AssetCategory() {
    }

    public AssetCategory(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "Category ID: " + categoryId +
               ", Category Name: " + categoryName;
    }
}