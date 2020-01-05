package pharmacy;


import data.ProductID;


public class MedicineDispensingLine {

    ProductID prodID;
    Boolean adquired;

    public MedicineDispensingLine(ProductID prodID, Boolean adquired){
        this.prodID = prodID;
        this.adquired = adquired;
    }

    public void setAdquired(Boolean adquired) {
        this.adquired = adquired;
    }

    public boolean getAdquired(){
        return adquired;
    }

    public ProductID getProdID(){
        return prodID;
    }
}
