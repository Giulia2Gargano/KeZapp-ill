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
import it.sirfin.KeZappillserver.model.Messaggio;
import it.sirfin.KeZappillserver.service.KeZappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KeZappController {

    @Autowired
    KeZappService keZappService;

    @RequestMapping("/registrazione")
    @ResponseBody
    public RegistrazioneDto registrazione(@RequestBody RichiediRegistrazioneDto reqDto) {
        System.out.println("Servizio Chiamato");
        return keZappService.registrazione(reqDto);
    }

    @RequestMapping("/invia-tutti")
    @ResponseBody
    public RegistrazioneDto inviaATutti(@RequestBody InviaMessaggioDto reqDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RequestMapping("/invia-uno")
    @ResponseBody
    public RegistrazioneDto inviaAUno(@RequestBody InviaMessaggioDto reqDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RequestMapping("/aggiorna")
    @ResponseBody
    public RegistrazioneDto aggiorna(@RequestBody RichiediMessaggioDto reqDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
