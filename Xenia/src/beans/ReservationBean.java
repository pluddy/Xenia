package beans;

import java.util.Calendar;
import models.Hotel;
import models.HotelRoom;

public class ReservationBean {
	private Hotel hotel;
	private HotelRoom room;
	private ReservationSearchQueryBean query;
	/**
	 * @param hotel
	 * @param room
	 * @param query
	 */
	public ReservationBean(Hotel hotel, HotelRoom room, ReservationSearchQueryBean query) {
		super();
		this.hotel = hotel;
		this.room = room;
		this.query = query;
	}
	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}
	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	/**
	 * @return the room
	 */
	public HotelRoom getRoom() {
		return room;
	}
	/**
	 * @param room the room to set
	 */
	public void setRoom(HotelRoom room) {
		this.room = room;
	}
	/**
	 * @return the query
	 */
	public ReservationSearchQueryBean getQuery() {
		return query;
	}
	/**
	 * @param query the query to set
	 */
	public void setQuery(ReservationSearchQueryBean query) {
		this.query = query;
	}
	
	
}
