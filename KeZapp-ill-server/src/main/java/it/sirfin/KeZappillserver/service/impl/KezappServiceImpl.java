/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.KeZappillserver.service.impl;

import it.sirfin.KeZappillserver.dto.InviaMessaggioDto;
import it.sirfin.KeZappillserver.dto.RegistrazioneDto;
import it.sirfin.KeZappillserver.dto.RichiediMessaggioDto;
import it.sirfin.KeZappillserver.dto.RichiediRegistrazioneDto;
import it.sirfin.KeZappillserver.service.KeZappService;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl implements KeZappService {

    @Override
    public RichiediRegistrazioneDto registrazione(RichiediRegistrazioneDto reqregDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InviaMessaggioDto invaATutti(InviaMessaggioDto iat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InviaMessaggioDto invaAUno(InviaMessaggioDto ia1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegistrazioneDto aggiorna(RichiediMessaggioDto reqM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
