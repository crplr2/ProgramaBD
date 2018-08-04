package ProgramBD.Roberto.Reportes.ProductosMasDescuento;

public class ProductosMasDescuento {
    private String ProductID;
    private String Name;
    private String StandardCost;
    private String ListPrice;
    private String SpecialOfferID;
    private String Description;
    private String DiscountPct;
    private String Type;
    private String MinQty;
    private String MaxQty;

    //SETTERS
    public void setProductID(String productID) {
        ProductID = productID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setStandardCost(String standardCost) {
        StandardCost = standardCost;
    }

    public void setListPrice(String listPrice) {
        ListPrice = listPrice;
    }

    public void setSpecialOfferID(String specialOfferID) {
        SpecialOfferID = specialOfferID;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDiscountPct(String discountPct) {
        Double discount = Double.valueOf(discountPct)*100;
        DiscountPct = String.valueOf(discount);
    }

    public void setType(String type) {
        Type = type;
    }

    public void setMinQty(String minQty) {
        MinQty = minQty;
    }

    public void setMaxQty(String maxQty) {
        MaxQty = maxQty;
    }


    //GETTERS
    public String getProductID() {
        return ProductID;
    }

    public String getName() {
        return Name;
    }

    public String getStandardCost() {
        return StandardCost;
    }

    public String getListPrice() {
        return ListPrice;
    }

    public String getSpecialOfferID() {
        return SpecialOfferID;
    }

    public String getDescription() {
        return Description;
    }

    public String getDiscountPct() {
        return DiscountPct;
    }

    public String getType() {
        return Type;
    }

    public String getMinQty() {
        return MinQty;
    }

    public String getMaxQty() {
        return MaxQty;
    }
}
