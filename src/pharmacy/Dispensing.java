package pharmacy;

import data.HealthCardID;
import data.ProductID;
import pharmacy.exceptions.DispensingNotAvailableException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Dispensing {

    private byte nOrder;
    private Date initDate, finalDate;
    private boolean isCompleted;
    public List<MedicineDispensingLine> l;

    public Dispensing(String initDate, String finalDate, List<MedicineDispensingLine> l) throws ParseException {
        this.initDate = createDate(initDate);
        this.finalDate = createDate(finalDate);
        this.l = l;
    }

    public Dispensing(){
    }

    public boolean dispensingEnabled() throws DispensingNotAvailableException, ParseException {
      Date date = new Date();
      DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
      String actualdate = dateFormat.format(date);
      date = createDate(actualdate);

      System.out.println(initDate);
      System.out.println(finalDate);
      int s1 = initDate.compareTo(date);
      int s2 = finalDate.compareTo(date);

      if(s1 == 0 || s2 == 0 || (s1<0 && s2>0)){
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

    public void setInitDate(String Date) throws ParseException {
        this.initDate = createDate(Date);
    }

    public Date getInitDate(){
        return initDate;
    }

    public void setFinalDate(String Date) throws ParseException {
        this.finalDate = createDate(Date);
    }

    public Date getFinalDate(){
        return finalDate;
    }

    public Date createDate (String Date ) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d  = sdf.parse(Date);
        return d;
    }

}
