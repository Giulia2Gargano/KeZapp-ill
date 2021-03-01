import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Chat } from './chat';
import { InviaMessaggioDto } from './invia-messaggio-dto';
import { RegistrazioneDto } from './registrazione-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  contatto = new Chat();
  contatti: Chat[] = [];
  messaggio = "";
  constructor(private http: HttpClient) { }

  registrazione() {

    let req = new RichiediRegistrazioneDto();
    req.nickname = this.contatto.nickname;
    let oss = this.http.post<RegistrazioneDto>("http://localhost:8080/registrazione", req);
    oss.subscribe(r => this.contatti = r.contatti);
    this.contatto = new Chat();

  }

  inviaATutti() {
    let req = new InviaMessaggioDto();
    let oss = this.http.post<RegistrazioneDto>("http://localhost:8080/invia-tutti", req);
    oss.subscribe();
  }

  inviaAUno() {
    let req = new InviaMessaggioDto();
    //req.destinatario = this.contatto.nickname;
    let oss = this.http.post<RegistrazioneDto>("http://localhost:8080/invia-uno", req);
    oss.subscribe();
  }

  aggiorna() {
    let oss = this.http.get<RegistrazioneDto>("http://localhost:8080/aggiorna");
    oss.subscribe(r => this.contatti = r.contatti);
  }


}
