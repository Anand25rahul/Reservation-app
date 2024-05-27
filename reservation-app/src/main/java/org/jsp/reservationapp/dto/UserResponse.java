package org.jsp.reservationapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
	private String name;
	private long phone;
	private String email;
	private int age;
	private String gender;
	private String password;
}
