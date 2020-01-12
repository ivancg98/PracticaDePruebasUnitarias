package pharmacy;

import data.ProductID;
import pharmacy.exceptions.DispensingNotAvailableException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Dispensing {

    private Date initDate, finalDate;
    private boolean isCompleted;
    public List<MedicineDispensingLine> l;

    public Dispensing(String initDate, String finalDate, List<MedicineDispensingLine> l) throws ParseException {
        this.initDate = createDate(initDate);
        this.finalDate = createDate(finalDate);
        this.l = l;
    }

    public boolean dispensingEnabled() throws DispensingNotAvailableException, ParseException {

      Date date = createDateActual();

      int s1 = initDate.compareTo(date);
      int s2 = finalDate.compareTo(date);
      DispensingNotAvailableException(s1, s2);
      return true;

    }

    public void setProductAsDispensed(ProductID prodID) {
        for (int i = 0; i < l.size(); i++) {
            if (prodID.equals(l.get(i).getProdID()) && !l.get(i).isAdquired()) {
                    l.get(i).setAdquired(true);
                    break;
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

    public void setInitDate(Date date) throws ParseException {
        this.initDate = date;
    }

    public Date getInitDate(){
        return initDate;
    }

    public void setFinalDate(Date date) throws ParseException {
        this.finalDate = date;
    }

    public Date getFinalDate(){
        return finalDate;
    }

    public Date createDate (String Date ) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d  = sdf.parse(Date);
        return d;
    }

    public Date createDateActual() throws ParseException {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String actualdate = dateFormat.format(date);
        return createDate(actualdate);
    }

    public void DispensingNotAvailableException(int s1, int s2) throws DispensingNotAvailableException {
        if(!(s1 == 0 || s2 == 0 || (s1<0 && s2>0))){
            throw new DispensingNotAvailableException("Retirada fuera del periodo de dispensación");
        }
    }


}
