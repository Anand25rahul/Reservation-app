package org.jsp.reservationapp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusResponse {
	private String name;
	private LocalDate dept_date;
	private int bus_number;
	private String from_location;
	private String to_location;
	private int seat_number;
}
