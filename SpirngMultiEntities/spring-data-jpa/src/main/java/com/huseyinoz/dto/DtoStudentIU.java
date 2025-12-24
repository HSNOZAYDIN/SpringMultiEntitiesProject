package com.huseyinoz.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	
	@NotEmpty(message = "First Name alanı boş bırakılamaz")
	@Min(value = 3)
	@Max(value = 10)
    private String firstName;
	
	@Size(min = 3 , max = 30)
	private String lastName;
	
	private Date birthOfDate;
	
	@Email(message = "Email formatında bir adres giriniz!")
	private String email;
	
	@Size(min = 11, max = 11, message = "Tckn alanı 11 karakter olmalıdır.")
	@NotEmpty(message = "Tckn alanı boş bırakılamaz")
	private String tckn;
	
}
