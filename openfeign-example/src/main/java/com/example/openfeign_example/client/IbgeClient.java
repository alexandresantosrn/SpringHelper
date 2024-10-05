package com.example.openfeign_example.client;

import com.example.openfeign_example.model.Estado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "ibge-client", url = "http://servicodados.ibge.gov.br/api/v1")
public interface IbgeClient {

	@RequestMapping(method = RequestMethod.GET, value = "localidades/estados")
	List<Estado> obterEstados();
}
