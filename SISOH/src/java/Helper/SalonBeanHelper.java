/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Entidad.Salon;
import Negocios.SalonesDelegate;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Angel
 */
public class SalonBeanHelper implements Serializable {

    private SalonesDelegate salonDelegate;
    private List<Salon> listaFiltrada;
    private List<Salon> listaSeleccionSalones;

    private Salon sala;

    private Salon selecSala;

    public SalonBeanHelper() {
        try {
            this.salonDelegate = new SalonesDelegate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sala = new Salon();
        selecSala = new Salon();
    }

    public void setSalonDelegate(SalonesDelegate salonDelegate) {
        this.salonDelegate = salonDelegate;
    }

    public void setListaFiltrada(List<Salon> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public void setListaSeleccionSala(List<Salon> listaSeleccionUnidadAcademica) {
        this.listaSeleccionSalones = listaSeleccionUnidadAcademica;
    }

    public void setSala(Salon sala) {
        this.sala = sala;
    }

    public void setSelecSala(Salon selecSala) {
        this.selecSala = selecSala;
    }

    public SalonesDelegate getSalonDelegate() {
        return salonDelegate;
    }

    public List<Salon> getListaFiltrada() {
        return listaFiltrada;
    }

    public List<Salon> getListaSeleccionSalon() {
        return listaSeleccionSalones;
    }

    public Salon getSala() {
        return sala;
    }

    public Salon getSelecSala() {
        return selecSala;
    }

    public List<Salon> filtrado() {
        return salonDelegate.getSalones();
    }

    public void seleccionarRegistro() {
        for (Salon sal : salonDelegate.getSalones()) {
            if (sal.getSalonId().equals(selecSala.getSalonId())) {
                sala = sal;
            }
        }
    }

    public void eliminarDeLista(int id) {
        for (Salon sal : listaSeleccionSalones) {
            if (sal.getSalonId().equals(id)) {
                int index=listaSeleccionSalones.indexOf(sal);
                listaSeleccionSalones.remove(index);
                break;
            }
        }
    }

}
