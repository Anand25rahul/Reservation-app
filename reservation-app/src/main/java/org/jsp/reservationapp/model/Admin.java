package org.jsp.reservationapp.model;

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
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@Column(nullable = false)
private String name;
	@Column(nullable = false,unique = true)
private long phone;
	@Column(nullable = false,unique = true)
private String gst_number;
	@Column(nullable = false)
private String travels_name;
	@Column(nullable = false,unique = true)
private String email;
	@Column(nullable = false)
private String password;
}