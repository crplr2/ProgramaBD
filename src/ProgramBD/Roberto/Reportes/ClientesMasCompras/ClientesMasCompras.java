package ProgramBD.Roberto.Reportes.ClientesMasCompras;

public class ClientesMasCompras {
    private String VendorID;
    private String AccountNumber;
    private String Name;
    private String CantidadCompras;
    private String TotalCompras;
    private String CreditRating;
    private String PreferredVendorStatus;



    //GETTER
    public String getVendorID() {
        return VendorID;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public String getName() {
        return Name;
    }

    public String getCantidadCompras() {
        return CantidadCompras;
    }

    public String getTotalCompras() {
        return TotalCompras;
    }

    public String getCreditRating() {
        return CreditRating;
    }

    public String getPreferredVendorStatus() {
        return PreferredVendorStatus;
    }



    //SETTER
    public void setVendorID(String vendorID) {
        VendorID = vendorID;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCantidadCompras(String cantidadCompras) {
        CantidadCompras = cantidadCompras;
    }

    public void setTotalCompras(String totalCompras) {
        TotalCompras = totalCompras;
    }

    public void setCreditRating(String creditRating) {
        CreditRating = creditRating;
    }

    public void setPreferredVendorStatus(String preferredVendorStatus) {
        PreferredVendorStatus = preferredVendorStatus;
    }
}
