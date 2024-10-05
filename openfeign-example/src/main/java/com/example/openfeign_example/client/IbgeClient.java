package com.example.openfeign_example.client;

import com.example.openfeign_example.model.Estado;
import com.example.openfeign_example.model.Municipio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ibge-client", url = "http://servicodados.ibge.gov.br/api/v1")
public interface IbgeClient {

	@GetMapping("localidades/estados")
	List<Estado> obterEstados();

	@GetMapping("localidades/estados/24/municipios")
	List<Municipio> obterMunicipiosRN();
}
