package one.digitalinnovaion.gof.service.impl;

import one.digitalinnovaion.gof.model.ClienteModel;
import one.digitalinnovaion.gof.model.Endereco;
import one.digitalinnovaion.gof.repository.IClienteRepository;
import one.digitalinnovaion.gof.repository.IEnderecoRepository;
import one.digitalinnovaion.gof.service.IClienteService;
import one.digitalinnovaion.gof.service.IViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository repository;
    @Autowired
    IEnderecoRepository enderecoRepository;

    @Autowired
    private IViaCepService viaCepService;

    @Override
    public List<ClienteModel> getAll() {
        return repository.findAll();
    }

    @Override
    public ClienteModel getById(Long id) {
        Optional<ClienteModel> cliente = repository.findById(id);
        return cliente.get();
    }

    @Override
    public void insert(ClienteModel cliente) {
       salvarClienteComCep(cliente);
    }

    @Override
    public void update(Long id, ClienteModel cliente) {
        Optional<ClienteModel> clienteBd = repository.findById(id);
        if (clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void salvarClienteComCep(ClienteModel cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultaCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        repository.save(cliente);

    }
}
