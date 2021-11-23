package com.avanade.conta.corrente.repository;

import com.avanade.conta.corrente.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

    public List<ClienteModel> findByNome(String nome);
}
