/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.KeZappillserver.repository;

import it.sirfin.KeZappillserver.model.Messaggio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeZappRepositoryMessaggio extends JpaRepository<Messaggio, Long> {

    List<Messaggio> findByAliasMittente(String s);
}
