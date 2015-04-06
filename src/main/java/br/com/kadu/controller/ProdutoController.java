package br.com.kadu.controller;

import br.com.kadu.model.Produto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "produto";
	}

    @AddDependencies
    @RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = "application/json")
    public Produto salvar(@Load Produto produto) throws IOException {
        return produto;
    }
}