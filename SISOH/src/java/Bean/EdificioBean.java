/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entidad.Edificio;
import Helper.EdificiosBeanHelper;
import Negocios.EdificiosDelegate;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Miltokk
 */
@Named(value = "EdificioBean")
@Dependent
public class EdificioBean implements Serializable{
    
    
      private Edificio edificio;   
    private List <Edificio> edificios;
    EdificiosBeanHelper edificiosBeanHelper;
    private Edificio edificioModificado;
    
    
    
    
        public Edificio getEdificoModificado() {
        return edificioModificado;
    }

    public void setEdificioModificado(Edificio edificioModificado) {
        this.edificioModificado = edificioModificado;
    }
    
    public EdificioBean() {
          edificiosBeanHelper = new EdificiosBeanHelper();
        edificio = new Edificio();
       edificioModificado=new Edificio();
    }
        
   
     
      public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }  
    
    public List<Edificio> getEdificios(){
        edificios=edificiosBeanHelper.filtrado();
        return edificios;
    }
     
    
      public List<Edificio> getListaEdificios(){
        return edificios;
    }
    
    
    
    public void addEdificio(){        
      edificiosBeanHelper.getEdificioDelegate().agregarEdificio(edificio);
       edificio=new Edificio();
    }
    
    public List<Edificio> mostrarEdificios(){
       edificios= edificiosBeanHelper.filtrado();
        return edificios;
    }
    
    public void modificar(){
        edificiosBeanHelper.getEdificioDelegate().modificarEdificio(edificioModificado);
        edificio=new Edificio();
    }
    public void eliminar(){
        edificiosBeanHelper.getEdificioDelegate().eliminarEdificio(edificio);
        edificio=new Edificio();
    }
    
    
}
