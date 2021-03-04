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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl implements KeZappService {

    @Autowired
    KeZappRepositoryChat keZappRepositoryChat;
    @Autowired
    KeZappRepositoryMessaggio keZappRepositoryMessaggio;

    @Override
    public RegistrazioneDto registrazione(RichiediRegistrazioneDto reqregDto) {
        if (keZappRepositoryChat.findByNickname(reqregDto.getNickname()).isEmpty()) {
            //creare nuovA CHat con i dati ricevuti 
            Chat ch = new Chat(reqregDto.getNickname());
            //salvare sul db recuperando laversione con l'id che il db ha aggiunto
            keZappRepositoryChat.save(ch);
            //convertire l'id in stringa metterlo nella sessione della chat e aggiornarla sul db
            ch.setSessione(Long.toString(ch.getId()));
            keZappRepositoryChat.save(ch);
            //ritornare un registrazione dto
            return new RegistrazioneDto(ritornaContatti(ch), ritornaMessaggi(ch), ch.getSessione());
        }
        return new RegistrazioneDto();
    }

    @Override
    public RegistrazioneDto inviaATutti(InviaMessaggioDto iat) {
        //cercare tra le chat quella che ha la sessione del dto e recuperarne il nickname
        Chat c = keZappRepositoryChat.findBySessione(iat.getSessione());
        //se non esiste ritornare un dto vuoto
        if (c.getNickname().isEmpty()) {
            return new RegistrazioneDto();
        }
        //se esiste usare il nickname della chat per compilarlo e salvarlo
        Messaggio m = new Messaggio(iat.getMessaggio(), null, c.getNickname());
        keZappRepositoryMessaggio.save(m);
        keZappRepositoryMessaggio.findAll();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public RegistrazioneDto inviaAUno(InviaMessaggioDto ia1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegistrazioneDto aggiorna(RichiediMessaggioDto reqM) {
        return new RegistrazioneDto(keZappRepositoryChat.findAll(), keZappRepositoryMessaggio.findAll(), reqM.getSessione());
    }

    @Override
    public List<Chat> ritornaContatti(Chat c) {
        return keZappRepositoryChat.findByNickname(c.getSessione());
    }

    @Override
    public List<Messaggio> ritornaMessaggi(Chat c) {
        return keZappRepositoryMessaggio.findByAliasMittente(c.getSessione());
    }

}
