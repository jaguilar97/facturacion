package com.Facturacion.controller;

import com.Facturacion.domain.Fdetalle;
import com.Facturacion.service.FdetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FdetalleController {

@Autowired
private FdetalleService fdetalleService;

@GetMapping("/fdetalle/listado")
public String inicio(Model model) {

var fdetalles = fdetalleService.getFdetalles();
model.addAttribute("fdetalles", fdetalles);

return "/fdetalle/listado";
}

@GetMapping("/fdetalle/nuevo")
public String nuevoFdetalle(Fdetalle fdetalle) {
return "/fdetalle/modificar";
}

@PostMapping("/fdetalle/guardar")
public String guardarFdetalle(Fdetalle fdetalle) {
fdetalleService.save(fdetalle);
return "redirect:/fdetalle/listado";
}

@GetMapping("/fdetalle/modificar/{idFdetalle}")
public String modificarFdetalle(Fdetalle fdetalle, Model model) {
fdetalle = fdetalleService.getFdetalle(fdetalle);
model.addAttribute("fdetalle", fdetalle);
return "/fdetalle/modificar";
}

@GetMapping("/fdetalle/eliminar/{idFdetalle}")
public String eliminarFdetalle(Fdetalle fdetalle) {
fdetalleService.delete(fdetalle);
return "redirect:/fdetalle/listado";
}

}
