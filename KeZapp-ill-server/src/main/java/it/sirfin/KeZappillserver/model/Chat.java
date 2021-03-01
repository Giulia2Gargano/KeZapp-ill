/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.KeZappillserver.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chat implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nickname;

    @Column
    private String Sessione;

    public Chat() {
    }

    public Chat(String nickname, String Sessione) {
        this.nickname = nickname;
        this.Sessione = Sessione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSessione() {
        return Sessione;
    }

    public void setSessione(String Sessione) {
        this.Sessione = Sessione;
    }

    @Override
    public String toString() {
        return "Chat{" + "id=" + id + ", nickname=" + nickname + ", Sessione=" + Sessione + '}';
    }

}
