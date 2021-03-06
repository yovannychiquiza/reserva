package com.reserva.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.reserva.model.Empleado;
import com.reserva.model.EmpleadoPermiso;
import com.reserva.service.EmpleadoService;

@Controller
@RequestMapping(value="/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addEmpleadoPage() {
		ModelAndView modelAndView = new ModelAndView("empleado/add-empleado-form");
		modelAndView.addObject("empleado", new Empleado());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingEmpleado(@ModelAttribute Empleado empleado) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/empleado/list");
		empleadoService.addEmpleado(empleado);
		
		String message = "El Empleado fue satisfactoriamente creado.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfEmpleados() {
		ModelAndView modelAndView = new ModelAndView("empleado/list-of-empleados");
		
		List<Empleado> empleados = empleadoService.getEmpleados();
		modelAndView.addObject("empleados", empleados);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editEmpleadoPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("empleado/edit-empleado-form");
		Empleado empleado = empleadoService.getEmpleado(id);
		modelAndView.addObject("empleado",empleado);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingEmpleado(@ModelAttribute Empleado empleado, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/empleado/list");
		
		empleadoService.updateEmpleado(empleado);
		
		String message = "El Empleado fue satisfactoriamente editado.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteEmpleado(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empleado/list");
		empleadoService.deleteEmpleado(id);
		String message = "El Empleado fue satisfactoriamente borrado.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/permiso/{id}", method=RequestMethod.GET)
	public ModelAndView permisoEmpleadoPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("empleado/permiso-empleado-form");
		Empleado empleado = empleadoService.getEmpleadoPermiso(id);
		modelAndView.addObject("empleado", empleado);
		return modelAndView;
	}
	
	@RequestMapping(value = "/guardaPermiso", method = RequestMethod.GET)
	public void permisoEmpleadoPage1(@RequestParam(value = "empleado_id", required = true) int empleado_id,
			@RequestParam(value = "permiso_id", required = true) int permiso_id, 
			@RequestParam(value = "activo", required = true) boolean activo, 
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		empleadoService.guardarPermiso(empleado_id, permiso_id, activo);
		
	}


}
