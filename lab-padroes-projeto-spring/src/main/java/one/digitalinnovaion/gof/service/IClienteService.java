package one.digitalinnovaion.gof.service;

import one.digitalinnovaion.gof.model.ClienteModel;

import java.util.List;

public interface IClienteService {

    List<ClienteModel> getAll();

    ClienteModel getById(Long id);

    void insert(ClienteModel cliente);

    void update(Long id, ClienteModel cliente);

    void delete(Long id);
}
