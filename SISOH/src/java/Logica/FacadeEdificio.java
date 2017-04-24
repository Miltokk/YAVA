/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidad.Edificio;
import Servicios.ServiceLocator;
import java.util.List;

/**
 *
 * @author Miltokk
 */
public class FacadeEdificio {
    
  public List<Edificio> consultaEdificio(){
    
        List<Edificio> resultado = null;
        ServiceLocator.getInstanceEdificioDAO().setObjeto(Edificio.class);
        resultado = ServiceLocator.getInstanceEdificioDAO().mostrarEdificios();
        return resultado;
        
    }
  
   public void agregarEdificio(Edificio edificio){
         ServiceLocator.getInstanceEdificioDAO().setObjeto(Edificio.class);
         ServiceLocator.getInstanceEdificioDAO().insertarEdificio(edificio);
    }
   
   public void modificarEdificio(Edificio edificio){
   
           ServiceLocator.getInstanceEdificioDAO().setObjeto(Edificio.class);
         ServiceLocator.getInstanceEdificioDAO().modificarEdificio(edificio);
   }
    
   
   public void eliminarEdificio(Edificio edificio){
       
         ServiceLocator.getInstanceEdificioDAO().setObjeto(Edificio.class);
         ServiceLocator.getInstanceEdificioDAO().eliminarEdificio(edificio);
   }
   
   
  
}
