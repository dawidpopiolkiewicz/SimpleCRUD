package pl.simplecrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull(message="Podaj ulicę")
	@Length(min=2,message="*Nazwa ulicy musi składać się min. z dwóch znaków")
	@Column(name = "street")
	private String street;
	@NotNull(message="Podaj miasto")
	@Length(min=2,message="Nazwa miasta musi składać się min. z dwóch znaków")
	@Column(name = "city")
	private String city;
	@NotNull(message="Podaj kod pocztowy")
	@Pattern(regexp="\\d{2}-\\d{3}",message="Format kodu pocztowego to 00-000")
	@Column(name = "zip_code")
	private String zipCode;

	
	public Address() {

	}

	public Address(String street, String city, String zipCode) {
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", zipCode=" + zipCode + "]";
	}

}
