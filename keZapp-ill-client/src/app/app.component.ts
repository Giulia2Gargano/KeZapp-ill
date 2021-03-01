import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Chat } from './chat';
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

  constructor(private http: HttpClient) { }

  registrazione() {
    
    let req = new RichiediRegistrazioneDto();
    req.nickname = this.contatto.nickname;
    let oss = this.http.post<RegistrazioneDto>("http://localhost:8080/registrazione", req);
    oss.subscribe(r => this.contatti = r.contatti);
    this.contatto = new Chat();

  }
}
