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
import it.sirfin.KeZappillserver.model.Chat;
import it.sirfin.KeZappillserver.model.Messaggio;
import java.util.List;

/**
 *
 * @author Palo
 */
public interface KeZappService {

    RegistrazioneDto registrazione(RichiediRegistrazioneDto reqregDto);

    RegistrazioneDto inviaATutti(InviaMessaggioDto iat);

    RegistrazioneDto inviaAUno(InviaMessaggioDto ia1);

    RegistrazioneDto aggiorna(RichiediMessaggioDto reqM);

    List<Chat> ritornaContatti(Chat c);

    List<Messaggio> ritornaMessaggi(Chat c);

}
