package com.example.openfeign_example.client;

import com.example.openfeign_example.model.Estado;
import com.example.openfeign_example.model.Municipio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ibge-client", url = "http://servicodados.ibge.gov.br/api/v1")
public interface IbgeClient {

	@GetMapping("localidades/estados")
	List<Estado> getEstados();

	@GetMapping("localidades/estados/24/municipios")
	List<Municipio> getMunicipiosRN();

	@GetMapping("localidades/estados/{id}")
	Estado getEstadoById(@PathVariable("id") Long id);
}
