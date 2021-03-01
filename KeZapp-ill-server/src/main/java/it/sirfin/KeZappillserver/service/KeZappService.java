/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.KeZappillserver.service;

import it.sirfin.KeZappillserver.dto.InviaMessaggioDto;
import it.sirfin.KeZappillserver.dto.RegistrazioneDto;
import it.sirfin.KeZappillserver.dto.RichiediMessaggioDto;
import it.sirfin.KeZappillserver.dto.RichiediRegistrazioneDto;

/**
 *
 * @author Palo
 */
public interface KeZappService {

    RichiediRegistrazioneDto registrazione(RichiediRegistrazioneDto reqregDto);

    InviaMessaggioDto invaATutti(InviaMessaggioDto iat);

    InviaMessaggioDto invaAUno(InviaMessaggioDto ia1);

    RegistrazioneDto aggiorna(RichiediMessaggioDto reqM);
}
