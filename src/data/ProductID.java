package data;

import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;

final public class ProductID {

    private final String productID;

    public ProductID(String code) throws NullObjectException, EmptyCodeException, BadlyFormedCodeException {
        NullObjectException(code);
        EmptyCodeException(code);
        this.productID = code;
        BadlyFormedCode(this.productID);
    }

    public String getPersonalID() {
        return productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductID product = (ProductID) o;
        return productID.equals(product.productID);
    }

    @Override
    public int hashCode() {
        return productID.hashCode();
    }

    @Override
    public String toString() {
        return "ProductID{" + "product code='" + productID + '\'' + '}';
    }

    public void BadlyFormedCode(String code) throws BadlyFormedCodeException {
        for (int i = 0; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i)) && !Character.isLetter(code.charAt(i))) {
                throw new BadlyFormedCodeException("código de identificación mal formado");
            }
        }
    }

    public void NullObjectException(String code) throws NullObjectException {
        if (code == null) {
            throw new NullObjectException("objeto sin instanciar");
        }
    }

    public void EmptyCodeException(String code) throws EmptyCodeException {
        if (code == "") {
            throw new EmptyCodeException("código de identificación vacio");
        }
    }

}
