package org.jsp.reservationapp.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class BusRequest {
private String name;
private LocalDate dept_date;
private int bus_number;
private String from_location;
private String to_location;
private int seat_number;
}
