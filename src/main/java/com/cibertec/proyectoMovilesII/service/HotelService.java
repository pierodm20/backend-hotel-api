package com.cibertec.proyectoMovilesII.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.proyectoMovilesII.models.Hotel;
import com.cibertec.proyectoMovilesII.repository.HotelRepository;


@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepo;
	
	public List<Hotel> listar(){
		return hotelRepo.findAll();
	}
	
	public Optional<Hotel> obtenerPorId(Long id) {
		return hotelRepo.findById(id);
	}
	
	public Hotel registrar(Hotel hotel) {
		Optional<Hotel> existe = hotelRepo.findByNombre(hotel.getNombre());
		if(existe.isPresent()) {
			throw new RuntimeException("Ya existe un hotel con este nombre");
		}
		return hotelRepo.save(hotel);
	}
	
	public List<Hotel> buscarHotelPorNombre(String nombre) {
	    return hotelRepo.findByNombreContainingIgnoreCase(nombre);
	}
}
