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
import it.sirfin.KeZappillserver.model.Chat;
import it.sirfin.KeZappillserver.model.Messaggio;
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
        Chat ch = new Chat(reqregDto.getNickname());
        keZappRepositoryChat.save(ch);
        ch.setSessione(Long.toString(ch.getId()));
        keZappRepositoryChat.save(ch);
        return new RegistrazioneDto();
        //creare nuovA CHat con i dati ricevuti 
        //salvare sul db recuperando laversione con l'id che il db ha aggiunto
        //convertire l'id in stringa metterlo nella sessione della chat e aggiornarla sul db
        //ritornare un registrazione dto
    }

    @Override
    public InviaMessaggioDto invaATutti(InviaMessaggioDto iat) {
        KeZappRepositoryMessaggio.findBySessione(iat.getSessione());
        Messaggio m = new Messaggio(iat.getMessaggio(), iat.getDestinatario(), iat.getSessione());
        KeZappRepositoryMessaggio.save(m);
        KeZappRepositoryMessaggio.findAll();
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
