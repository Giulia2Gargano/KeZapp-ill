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
import it.sirfin.KeZappillserver.repository.KeZappRepositoryChat;
import it.sirfin.KeZappillserver.repository.KeZappRepositoryMessaggio;
import it.sirfin.KeZappillserver.service.KeZappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl implements KeZappService {

    @Autowired
    KeZappRepositoryChat keZappRepositoryChat;
    @Autowired
    KeZappRepositoryMessaggio KeZappRepositoryMessaggio;

    @Override
    public RegistrazioneDto registrazione(RichiediRegistrazioneDto reqregDto) {
        
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
