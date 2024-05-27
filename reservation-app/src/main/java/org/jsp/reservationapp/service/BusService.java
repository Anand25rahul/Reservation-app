package org.jsp.reservationapp.service;

import java.util.Optional;

import org.jsp.reservationapp.dao.BusDao;
import org.jsp.reservationapp.dto.BusRequest;
import org.jsp.reservationapp.dto.BusResponse;
import org.jsp.reservationapp.dto.ResponseStructure;
import org.jsp.reservationapp.exception.BusNotFoundException;
import org.jsp.reservationapp.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
	@Autowired
	private BusDao busDao;

	public ResponseEntity<ResponseStructure<BusResponse>> saveBus(BusRequest busRequest) {
		ResponseStructure<BusResponse> structure = new ResponseStructure<>();
		structure.setMessage("Bus saved");
		Bus bus = busDao.saveBus(mapToBus(busRequest));
		structure.setData(mapToBusResponse(bus));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
	}

	public ResponseEntity<ResponseStructure<BusResponse>> update(BusRequest busRequest, int id) {
		Optional<Bus> recBus = busDao.findById(id);
		ResponseStructure<BusResponse> structure = new ResponseStructure<>();
		if (recBus.isPresent()) {
			Bus dbBus = recBus.get();
			dbBus.setBus_number(busRequest.getBus_number());
			dbBus.setDept_date(busRequest.getDept_date());
			dbBus.setFrom_location(busRequest.getFrom_location());
			dbBus.setName(busRequest.getName());
			dbBus.setSeat_number(busRequest.getSeat_number());
			dbBus.setTo_location(busRequest.getTo_location());
			structure.setData(mapToBusResponse(busDao.saveBus(dbBus)));
			structure.setMessage("Bus Updated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(structure);
		}
		throw new BusNotFoundException("Cannot Update Bus as Id is Invalid");
	}

	public ResponseEntity<ResponseStructure<BusResponse>> findById(int id) {
		ResponseStructure<BusResponse> structure = new ResponseStructure<>();
		Optional<Bus> dbBus = busDao.findById(id);
		if (dbBus.isPresent()) {
			structure.setData(mapToBusResponse(dbBus.get()));
			structure.setMessage("Bus Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new BusNotFoundException("Invalid Bus Id");
	}
	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Bus> dbBus = busDao.findById(id);
		if (dbBus.isPresent()) {
			busDao.delete(id);
			structure.setData("Bus Found");
			structure.setMessage("Bus deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new BusNotFoundException("Cannot delete Bus as Id is Invalid");
	}
	
	private Bus mapToBus(BusRequest busRequest) {
		return Bus.builder().name(busRequest.getName()).dept_date(busRequest.getDept_date()).bus_number(busRequest.getBus_number())
				.from_location(busRequest.getFrom_location()).to_location(busRequest.getTo_location()).seat_number(busRequest.getSeat_number()).build();
	}
	private BusResponse mapToBusResponse(Bus bus) {
		return BusResponse.builder().name(bus.getName()).dept_date(bus.getDept_date()).bus_number(bus.getBus_number())
				.from_location(bus.getFrom_location()).to_location(bus.getTo_location()).seat_number(bus.getSeat_number()).build();
	}
}

