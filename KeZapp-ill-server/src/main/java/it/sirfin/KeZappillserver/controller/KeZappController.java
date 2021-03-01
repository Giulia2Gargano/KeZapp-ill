/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.KeZappillserver.controller;

import it.sirfin.KeZappillserver.dto.InviaMessaggioDto;
import it.sirfin.KeZappillserver.dto.RegistrazioneDto;
import it.sirfin.KeZappillserver.dto.RichiediMessaggioDto;
import it.sirfin.KeZappillserver.dto.RichiediRegistrazioneDto;
import it.sirfin.KeZappillserver.service.KeZappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KeZappController {

    @Autowired
    KeZappService keZappService;

    @RequestMapping("/registrazione")
    public RegistrazioneDto registrazione(RichiediRegistrazioneDto reqDto) {
        return registrazione(reqDto);
    }

    @RequestMapping("/invia-tutti")
    public RegistrazioneDto inviaATutti(InviaMessaggioDto reqDto) {
        return inviaATutti(reqDto);
    }

    @RequestMapping("/invia-uno")
    public RegistrazioneDto inviaAUno(InviaMessaggioDto reqDto) {
        return inviaAUno(reqDto);
    }

    @RequestMapping("/aggiorna")
    public RegistrazioneDto aggiorna(RichiediMessaggioDto reqDto) {
        return aggiorna(reqDto);
    }
}
