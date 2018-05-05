package com.afuera.gesstock1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controlador {
	@RequestMapping("/prueba")
	public String getIndexPage() {
		System.out.println("\t\tHASDASHDOASDASDOASDH");
		return "index";
		
	}

	
}
