/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Entidad.Edificio;
import Negocios.EdificiosDelegate;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Miltokk
 */
public class EdificiosBeanHelper  implements Serializable{
    
       
    private EdificiosDelegate edificioDelegate;
    private List<Edificio> listaFiltrada;
    private List<Edificio> listaSeleccionEdificios;
    
    private Edificio edificio;
    
    private Edificio selecEdificio;
    
    public EdificiosBeanHelper(){
        try{
            this.edificioDelegate = new EdificiosDelegate();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        edificio = new Edificio();
        selecEdificio = new Edificio();
        
    }
    
    
    public void setEdificioDelegate(EdificiosDelegate edificioDelegate){
        this.edificioDelegate = edificioDelegate;
    }
  
    public EdificiosDelegate getEdificioDelegate(){
        return edificioDelegate;
    }
    
    public void setListaFiltrada(List<Edificio> listaFiltrada){
        this.listaFiltrada = listaFiltrada;
    }
    
    public List<Edificio> getListaFiltrada(){
        return listaFiltrada;
    }
    
    public void setListaSeleccionEdificio(List<Edificio> listaSeleccionEdificios ){
        this.listaSeleccionEdificios = listaSeleccionEdificios;
    }
    
    public List<Edificio> getListaSeleccionEdificios(){
        return listaSeleccionEdificios;
    }
    
    public void setEdificio(Edificio edificio){
        this.edificio = edificio;
    }
    
    public Edificio getEdificio(){
        return edificio;
    }
    
    public void setSelecEdificio( Edificio selecEdificio ){
        this.selecEdificio = edificio;
    }
    
    public List<Edificio> filtrado(){
        return edificioDelegate.getEdificios();
    }
    
    
    
    public void seleccionarRegistro(){
        for(Edificio edf : edificioDelegate.getEdificios())
            if( edf.getEdificioId().equals(selecEdificio.getEdificioId()) )
                edificio = edf;
    }
    
    public void eliminarDeLista( int id ){
        for( Edificio edf : listaSeleccionEdificios )
            if( edf.getEdificioId().equals(id) ){
                int index = listaSeleccionEdificios.indexOf(edf);
                listaSeleccionEdificios.remove(index);
                break;
            }
                
    }
    
   
}
