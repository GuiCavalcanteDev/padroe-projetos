package one.digitalinnovaion.gof.service;

import one.digitalinnovaion.gof.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface IViaCepService {

    @GetMapping("/{cep}/json")
    Endereco consultaCep(@PathVariable("cep") String cep);
}
