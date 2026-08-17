package com.cibertec.proyectoMovilesII.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.proyectoMovilesII.enums.EstadoReserva;
import com.cibertec.proyectoMovilesII.models.Reserva;
import com.cibertec.proyectoMovilesII.service.ReservaService;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin("*")
public class ReservaController {
	
	@Autowired
	private ReservaService service;
	
	@GetMapping
	public ResponseEntity<List<Reserva>> listarReserva(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reserva> obtenerReserva(@PathVariable Long id){
		return service.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<Reserva> registrarReserva(@RequestBody Reserva reserva){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(reserva));
	}
	
	@GetMapping("/usuario/{usuario}")
	public ResponseEntity<List<Reserva>> obtenerReservaPorUsuario(@PathVariable String usuario){
		return ResponseEntity.ok(service.listarPorUsuario(usuario));
	}
	
	@GetMapping("/usuario/{usuario}/estado/{estado}")
	public ResponseEntity<List<Reserva>> obtenerReservaPorUsuarioEstado(@PathVariable String usuario, @PathVariable EstadoReserva estado){
		return ResponseEntity.ok(service.listarPorUsuarioEstado(usuario, estado));
	}
}
