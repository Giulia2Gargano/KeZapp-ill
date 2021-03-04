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
            return new RegistrazioneDto(ritornaContatti(), ritornaMessaggi(ch.getNickname()), ch.getSessione());
        }
        return new RegistrazioneDto();
    }

    @Override
    public RegistrazioneDto inviaATutti(InviaMessaggioDto iat) {
        System.out.println(iat);
        //cercare tra le chat quella che ha la sessione del dto e recuperarne il nickname
        Chat c = keZappRepositoryChat.findBySessione(iat.getSessione());
        //se non esiste ritornare un dto vuoto
        if (c.getNickname() == null || c.getNickname().isEmpty()) {
            return new RegistrazioneDto();
        }
        //se esiste usare il nickname della chat per compilarlo e salvarlo
        Messaggio m = new Messaggio(iat.getMessaggio(), null, c.getNickname());
        keZappRepositoryMessaggio.save(m);
        //keZappRepositoryMessaggio.findAll();
        return new RegistrazioneDto(ritornaContatti(), ritornaMessaggi(c.getNickname()), iat.getSessione());
    }

    @Override
    public RegistrazioneDto inviaAUno(InviaMessaggioDto ia1) {
        System.out.println("--------------------------------------------");
        System.out.println(ia1);
        System.out.println("--------------------------------------------");
        Chat c = keZappRepositoryChat.findBySessione(ia1.getSessione());
        if (c.getNickname() == null || c.getNickname().isEmpty()) {
            return new RegistrazioneDto();
        }
        System.out.println("--------------------------------------------");
        System.out.println(c);
        System.out.println("--------------------------------------------");
        Messaggio m = new Messaggio(ia1.getMessaggio(), ia1.getDestinatario(), c.getNickname());
        System.out.println(m);
        System.out.println("--------------------------------------------");
        keZappRepositoryMessaggio.save(m);
        return new RegistrazioneDto(ritornaContatti(), ritornaMessaggiPrivati(c.getNickname()), ia1.getSessione());
    }

    @Override
    public RegistrazioneDto aggiorna(RichiediMessaggioDto reqM) {
        List<Messaggio> m = keZappRepositoryMessaggio.findAll();
        List<Chat> c = keZappRepositoryChat.findAll();
        return new RegistrazioneDto(c, m, reqM.getSessione());
    }

    @Override
    public List<Chat> ritornaContatti() {
        return keZappRepositoryChat.findAll();
    }

    @Override
    public List<Messaggio> ritornaMessaggi(String nn) {
        List<Messaggio> privati = keZappRepositoryMessaggio.findByAliasDestinatario(nn);
        List<Messaggio> pubblici = keZappRepositoryMessaggio.findByAliasDestinatarioIsNull();
        System.out.println(privati);
        System.out.println(pubblici);
        privati.addAll(pubblici);
        return privati;
    }

    @Override
    public List<Messaggio> ritornaMessaggiPrivati(String p) {
        List<Messaggio> privati = keZappRepositoryMessaggio.findByAliasDestinatario(p);
        return privati;
    }
}
