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
import com.cibertec.proyectoMovilesII.models.Hotel;
import com.cibertec.proyectoMovilesII.service.HotelService;

@RestController
@RequestMapping("/api/hotel")
@CrossOrigin("*")
public class HotelController {
	@Autowired
	private HotelService service;
	
	@GetMapping
	public ResponseEntity<List<Hotel>> listarHotel(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> obtenerHotel(@PathVariable Long id){
		return service.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<Hotel> registrarHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(hotel));
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<List<Hotel>> buscarPorNombre(@PathVariable String nombre) {
	    return ResponseEntity.ok(service.buscarHotelPorNombre(nombre));
	}
}
