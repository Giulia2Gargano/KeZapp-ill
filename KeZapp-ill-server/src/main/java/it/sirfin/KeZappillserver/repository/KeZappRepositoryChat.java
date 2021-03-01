/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.KeZappillserver.repository;

import it.sirfin.KeZappillserver.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Palo
 */
public interface KeZappRepositoryChat extends JpaRepository<Chat, Long> {

}
