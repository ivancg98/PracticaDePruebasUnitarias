package servicies;

import pharmacy.Sale;

import java.net.ConnectException;

public interface SalesHistoryInt  {
    public void registerSale(Sale sale) throws ConnectException;
    }

