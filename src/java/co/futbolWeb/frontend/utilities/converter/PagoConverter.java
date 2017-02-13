
package co.futbolWeb.frontend.utilities.converter;

import co.futbolWeb.backend.persistence.entities.Pago;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Pago.class)
public class PagoConverter extends AbstractConverter {

    public PagoConverter() {

        this.nameManagedBean = "pagoManagedBean";
                
    }

}