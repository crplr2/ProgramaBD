package ProgramBD.Hector.ListadoProductos;


public class ListadoProductos {
    private String Name;
    private String Color;
    private String StandardCost;
    private String Quantity;
    private String UnitPrice;
    private String UnitPriceDiscount;
    private String Description;
    private String ProductID;

    //GETTERS
    public String getName() {
        return Name;
    }

    public String getColor() {
        return Color;
    }

    public String getStandardCost() {
        return StandardCost;
    }

    public String getQuantity() {
        return Quantity;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public String getUnitPriceDiscount() {
        return UnitPriceDiscount;
    }

    public String getDescription() {
        return Description;
    }

    public String getProductID() {
        return ProductID;
    }


    //SETTERS
    public void setName(String name) {
        Name = name;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setStandardCost(String standardCost) {
        StandardCost = standardCost;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public void setUnitPrice(String unitPrice) {
        UnitPrice = unitPrice;
    }

    public void setUnitPriceDiscount(String unitPriceDiscount) {
        UnitPriceDiscount = unitPriceDiscount;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }
}
