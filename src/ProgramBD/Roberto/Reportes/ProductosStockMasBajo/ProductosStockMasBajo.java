package ProgramBD.Roberto.Reportes.ProductosStockMasBajo;

public class ProductosStockMasBajo {
    private String ProductID;
    private String ProductNumber;
    private String Name;
    private String SafetyStockLevel;
    private String ReorderPoint;
    private String DaysToManufacture;
    private String StandardCost;
    private String ListPrice;

    //GETTERS
    public String getProductID() {
        return ProductID;
    }

    public String getProductNumber() {
        return ProductNumber;
    }

    public String getName() {
        return Name;
    }

    public String getSafetyStockLevel() {
        return SafetyStockLevel;
    }

    public String getReorderPoint() {
        return ReorderPoint;
    }

    public String getDaysToManufacture() {
        return DaysToManufacture;
    }

    public String getStandardCost() {
        return StandardCost;
    }

    public String getListPrice() {
        return ListPrice;
    }


    //SETTERS
    public void setProductID(String productID) {
        ProductID = productID;
    }

    public void setProductNumber(String productNumber) {
        ProductNumber = productNumber;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSafetyStockLevel(String safetyStockLevel) {
        SafetyStockLevel = safetyStockLevel;
    }

    public void setReorderPoint(String reorderPoint) {
        ReorderPoint = reorderPoint;
    }

    public void setDaysToManufacture(String daysToManufacture) {
        DaysToManufacture = daysToManufacture;
    }

    public void setStandardCost(String standardCost) {
        StandardCost = standardCost;
    }

    public void setListPrice(String listPrice) {
        ListPrice = listPrice;
    }
}
