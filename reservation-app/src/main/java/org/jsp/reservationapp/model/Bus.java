package org.jsp.reservationapp.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@Column(nullable = false)
private String name;
	@Column(nullable = false)
private LocalDate dept_date;
	@Column(nullable = false)
private int bus_number;
	@Column(nullable = false)
private String from_location;
	@Column(nullable = false)
private String to_location;
	@Column(nullable = false)
private int seat_number;
}