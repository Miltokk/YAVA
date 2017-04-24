/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Edificio;
import java.util.List;

/**
 *
 * @author Miltokk
 */
public interface InterfaceDAO<T> {
      public List<Edificio> mostrarEdificios();
    public void modificarEdificio(Edificio edificio);
    public void insertarEdificio(Edificio edificio);
    public void eliminarEdificio(Edificio edificio);
}
