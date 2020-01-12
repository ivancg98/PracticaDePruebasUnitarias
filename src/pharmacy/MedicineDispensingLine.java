package pharmacy;


import data.ProductID;


public class MedicineDispensingLine {

    ProductID prodID;
    Boolean adquired;

    public MedicineDispensingLine(ProductID prodID) {
        this.prodID = prodID;
        this.adquired = false;
    }

    public void setAdquired(Boolean adquired) {
        this.adquired = adquired;
    }

    public boolean isAdquired() {
        return adquired;
    }

    public ProductID getProdID() {
        return prodID;
    }
}
