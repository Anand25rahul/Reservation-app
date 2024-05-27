package org.jsp.reservationapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminResponse {
	private String name;
	private long phone;
	private String email;
	private String gst_number;
	private String travels_name;
	private String password;
}
