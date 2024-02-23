package tn.esprit.aerolux.services;

import tn.esprit.aerolux.Models.Vol;

import java.sql.SQLException;
import java.util.List;

public interface IService <T>{
    void ajouter (T t) throws SQLException;
    void update(T t) throws SQLException;
    List<Vol> rechercher(String lieu) throws SQLException ;
    void supprimer(int id)  throws  SQLException;
    List<Vol> recuperer() throws  SQLException;
    Vol findById(int id) throws SQLException;
  /*  void modifier (T t) throws SQLException;

    void supprimer(T t) throws SQLException;
    List<T> recuperer() throws SQLException;
    T findbyId(int id) throws SQLException;*/
}
