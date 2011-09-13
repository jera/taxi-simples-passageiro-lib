package br.com.taxisimples.passageiro;

import org.orman.mapper.C;
import org.orman.mapper.Model;
import org.orman.mapper.ModelQuery;
import org.orman.mapper.annotation.Entity;
import org.orman.mapper.annotation.PrimaryKey;

@Entity
public class Place extends Model<Place> implements Comparable<Place> {

	@PrimaryKey(autoIncrement = true)
	private int id;
	private String city;
	private String address;
	private String number;
	private float latitude;
	private float longitude;
	private String name;

	public Place() {
	}
	
	public Place(String city, String address, String number, String name) {
		super();
		this.city = city;
		this.address = address;
		this.number = number;
		this.name = name;
	}

	@Override
	public String toString() {
		return (name == null || name.equals("")) ? address + " " + number : name;
	}

	public static Place find(int id) {
		return Model.fetchSingle(ModelQuery.select().from(Place.class).where(C.eq("id", id)).getQuery(), Place.class);
	}

	@Override
	public int compareTo(Place another) {
		return toString().compareTo(another.toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}