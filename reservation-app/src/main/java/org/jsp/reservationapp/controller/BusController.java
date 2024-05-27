package org.jsp.reservationapp.controller;

import org.jsp.reservationapp.dto.BusRequest;
import org.jsp.reservationapp.dto.BusResponse;
import org.jsp.reservationapp.dto.ResponseStructure;
import org.jsp.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bus")
public class BusController {
	@Autowired
	private BusService busService;

	@PostMapping
	public ResponseEntity<ResponseStructure<BusResponse>> saveBus(@RequestBody BusRequest busRequest){
		return busService.saveBus(busRequest);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<BusResponse>> updateAdmin(@RequestBody BusRequest busRequest, @PathVariable int id) {
		return busService.update(busRequest,id);
	}

	@GetMapping("{id}")
	public ResponseEntity<ResponseStructure<BusResponse>> saveBus(@PathVariable int id) {
		return busService.findById(id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> delete(@PathVariable int id) {
		return busService.delete(id);
	}
}
