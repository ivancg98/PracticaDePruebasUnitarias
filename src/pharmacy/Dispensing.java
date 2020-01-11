package pharmacy;

import data.HealthCardID;
import data.ProductID;
import pharmacy.exceptions.DispensingNotAvailableException;

import java.util.Date;
import java.util.List;

public class Dispensing {

    private byte nOrder;
    private Date initDate, finalDate;
    private boolean isCompleted;
    List<MedicineDispensingLine> l;

    HealthCardID healthCardID;

    public Dispensing(Date initDate, Date finalDate){
        this.initDate = initDate;
        this.finalDate = finalDate;

    }

    public boolean dispensingEnabled() throws DispensingNotAvailableException {
      Date date = new Date();
      Date actualDate = new Date(date.getYear(), date.getMonth(), date.getDay());

      int s1 = initDate.compareTo(actualDate);
      int s2 = finalDate.compareTo(finalDate);

      if(s1 == 0 || s2 == 0 || (s1>0 && s2<0)){
          return true;
      }

      throw new DispensingNotAvailableException("Retirada fuera del periodo de dispensación");

    }

    public void setProductAsDispensed(ProductID prodID) {
        for (int i = 0; i < l.size(); i++) {
            if (prodID.equals(l.get(i).getProdID())) {
                l.get(i).setAdquired(true);
            }
        }
    }

    public void setCompleted() {
        this.isCompleted = true;
    }

    public boolean isCompleted(){
        for (int i = 0; i < l.size(); i++){
            if(!l.get(i).isAdquired()){
                return false;
            }
        }
        return true;
    }

    public void setInitDate(Date initDate){
        this.initDate = initDate;
    }

    public void setFinalDate(Date finalDate){
        this.finalDate = finalDate;
    }

}
