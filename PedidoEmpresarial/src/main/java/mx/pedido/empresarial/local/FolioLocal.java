/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.local;

import java.util.List;
import javax.ejb.Local;
import mx.pedido.empresarial.modelo.Folio;

/**
 *
 * @author ihsa
 */
@Local
public interface FolioLocal {

    void create(Folio folio);

    void edit(Folio folio);

    void remove(Folio folio);

    Folio find(Object id);

    List<Folio> findAll();

    List<Folio> findRange(int[] range);

    int count();

    int getFolio(Object nombreComprobante);

    String getFolio(String nombreComprobante);

    String traerAnioFolio(String nombreComprobante);
    
}
