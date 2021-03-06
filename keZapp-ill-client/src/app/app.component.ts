import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Chat } from './chat';
import { InviaMessaggioDto } from './invia-messaggio-dto';
import { Messaggio } from './messaggio';
import { RegistrazioneDto } from './registrazione-dto';
import { RichiediMessaggiDto } from './richiedi-messaggi-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  contatto = new Chat();
  contatti: Chat[] = [];

  messaggio = new Messaggio();
  messaggi: Messaggio[] = [];
  messaggioDaInviare = "";
  showRegistra = true;
  showForm = false;
  sessione = "";

  constructor(private http: HttpClient) { }

  registrazione() {
    this.showForm = true;
    this.showRegistra = false;
    let req = new RichiediRegistrazioneDto();
    req.nickname = this.contatto.nickname;
    let oss = this.http.post<RegistrazioneDto>("http://localhost:8080/registrazione", req);
    oss.subscribe(r => {
      this.contatti = r.contatti;
      this.sessione = r.sessione;
    });
    this.contatto = new Chat();
  }

  inviaATutti() {
    let req = new InviaMessaggioDto();
    req.sessione = this.sessione;
    req.messaggio = this.messaggioDaInviare;
    let oss = this.http.post<RegistrazioneDto>("http://localhost:8080/invia-tutti", req);
    oss.subscribe(r => {
      this.messaggi = r.messaggi;
      this.contatti = r.contatti;
    });
  }

  inviaAUno(c: Chat) {
    let req = new InviaMessaggioDto();
    req.sessione = this.sessione;
    req.messaggio = this.messaggioDaInviare;
    console.log(c.nickname);
    req.destinatario = c.nickname;
    let oss = this.http.post<RegistrazioneDto>("http://localhost:8080/invia-uno", req);
    console.log("sto per fare la subscribe");
    oss.subscribe(r => {
      this.messaggi = r.messaggi;
      this.contatti = r.contatti;
    });
    console.log("ho fatto la subscribe");
  }

  aggiorna() {
    let req = new RichiediMessaggiDto();
    req.sessione = this.sessione;
    let oss = this.http.post<RegistrazioneDto>("http://localhost:8080/aggiorna", req);
    oss.subscribe(r => {
      this.contatti = r.contatti;
      this.messaggi = r.messaggi;
    });
  }


}
