package ProgramBD.Roberto.ProductoHistorico.Producto;

import javafx.css.Size;

public class Producto {
    private String ProductID ;
    private String Name ;
    private String ProductNumber ;
    private String MakeFlag ;
    private String FinishedGoodsFlag ;
    private String Color ;
    private String SafetyStockLevel ;
    private String ReorderPoint ;
    private String StandardCost ;
    private String ListPrice ;
    private String Size ;
    private String SizeUnitMeasureCode ;
    private String WeightUnitMeasureCode ;
    private String Weight ;
    private String DaysToManufacture ;
    private String ProductLine ;
    private String OClass ;
    private String Style ;
    private String ProductSubcategoryID ;
    private String ProductModelID ;
    private String SellStartDate ;
    private String SellEndDate ;
    private String DiscontinuedDate ;
    private String rowguid ;
    private String ModifiedDate ;


    /************GETTERS**************/
    public String getProductID() {
        return ProductID;
    }

    public String getOClass() {
        return OClass;
    }

    public String getName() {
        return Name;
    }

    public String getProductNumber() {
        return ProductNumber;
    }

    public String getMakeFlag() {
        return MakeFlag;
    }

    public String getFinishedGoodsFlag() {
        return FinishedGoodsFlag;
    }

    public String getColor() {
        return Color;
    }

    public String getSafetyStockLevel() {
        return SafetyStockLevel;
    }

    public String getReorderPoint() {
        return ReorderPoint;
    }

    public String getStandardCost() {
        return StandardCost;
    }

    public String getListPrice() {
        return ListPrice;
    }

    public String getSize() {
        return Size;
    }

    public String getSizeUnitMeasureCode() {
        return SizeUnitMeasureCode;
    }

    public String getWeightUnitMeasureCode() {
        return WeightUnitMeasureCode;
    }

    public String getWeight() {
        return Weight;
    }

    public String getDaysToManufacture() {
        return DaysToManufacture;
    }

    public String getProductLine() {
        return ProductLine;
    }


    public String getStyle() {
        return Style;
    }

    public String getProductSubcategoryID() {
        return ProductSubcategoryID;
    }

    public String getProductModelID() {
        return ProductModelID;
    }

    public String getSellStartDate() {
        return SellStartDate;
    }

    public String getSellEndDate() {
        return SellEndDate;
    }

    public String getDiscontinuedDate() {
        return DiscontinuedDate;
    }

    public String getRowguid() {
        return rowguid;
    }

    public String getModifiedDate() {
        return ModifiedDate;
    }






    /************SETTERS**************/
    public void setProductID(String productID) {
        ProductID = productID;
    }

    public void setOClass(String OClass){
        this.OClass = OClass;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setProductNumber(String productNumber) {
        ProductNumber = productNumber;
    }

    public void setMakeFlag(String makeFlag) {
        MakeFlag = makeFlag;
    }

    public void setFinishedGoodsFlag(String finishedGoodsFlag) {
        FinishedGoodsFlag = finishedGoodsFlag;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setSafetyStockLevel(String safetyStockLevel) {
        SafetyStockLevel = safetyStockLevel;
    }

    public void setReorderPoint(String reorderPoint) {
        ReorderPoint = reorderPoint;
    }

    public void setStandardCost(String standardCost) {
        StandardCost = standardCost;
    }

    public void setListPrice(String listPrice) {
        ListPrice = listPrice;
    }

    public void setSize(String size) {
        Size = size;
    }

    public void setSizeUnitMeasureCode(String sizeUnitMeasureCode) {
        SizeUnitMeasureCode = sizeUnitMeasureCode;
    }

    public void setWeightUnitMeasureCode(String weightUnitMeasureCode) {
        WeightUnitMeasureCode = weightUnitMeasureCode;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public void setDaysToManufacture(String daysToManufacture) {
        DaysToManufacture = daysToManufacture;
    }

    public void setProductLine(String productLine) {
        ProductLine = productLine;
    }

    public void setStyle(String style) {
        Style = style;
    }

    public void setProductSubcategoryID(String productSubcategoryID) {
        ProductSubcategoryID = productSubcategoryID;
    }

    public void setProductModelID(String productModelID) {
        ProductModelID = productModelID;
    }

    public void setSellStartDate(String sellStartDate) {
        SellStartDate = sellStartDate;
    }

    public void setSellEndDate(String sellEndDate) {
        SellEndDate = sellEndDate;
    }

    public void setDiscontinuedDate(String discontinuedDate) {
        DiscontinuedDate = discontinuedDate;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public void setModifiedDate(String modifiedDate) {
        ModifiedDate = modifiedDate;
    }
}
