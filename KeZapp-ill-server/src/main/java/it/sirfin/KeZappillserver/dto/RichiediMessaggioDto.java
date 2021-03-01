/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.KeZappillserver.dto;

/**
 *
 * @author Palo
 */
public class RichiediMessaggioDto {

    private String sessione;

    public RichiediMessaggioDto() {
    }

    public RichiediMessaggioDto(String sessione) {
        this.sessione = sessione;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

    @Override
    public String toString() {
        return "RichiediMessaggioDto{" + "sessione=" + sessione + '}';
    }

}
