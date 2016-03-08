package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import beans.ReservationSearchResultBean;
import managers.HotelManager;
import models.Hotel;
import models.HotelAmenity;
import models.HotelRoom;

public class SearchService {

	public static List<ReservationSearchResultBean> searchHotels(Calendar checkIn, Calendar checkOut, String city, int numRooms, String roomType, List<String> amenities) {
		List<Hotel> hotels = HotelManager.getHotels(null, null, city, null, null, null, null, null);
		List<ReservationSearchResultBean> hotelBeans = new ArrayList<ReservationSearchResultBean>();
		
		hotels: for (Iterator<Hotel> iterator = hotels.iterator(); iterator.hasNext();) {
			Hotel h = iterator.next();
			String hAmenities = "";
			amenities: for (String a : amenities) {
				for (HotelAmenity ha : h.getAmenities()) {
					if (ha.getAmenity().getName().equals(a)) {
						continue amenities;
					}
				}
				iterator.remove();
				continue hotels;
			}
			for (HotelRoom r : h.getRooms()) {
				if (checkIn.after(r.getStartDate()) && 
						checkOut.before(r.getEndDate()) && 
						numRooms < r.getAvailableNumber() &&
						r.getRoomType().getRoomType().equals(roomType)) {
					hotelBeans.add(new ReservationSearchResultBean(h.getName(), h.getAddress(), h.getDescription(), r.getRoomType().getRoomType(), 4.0, r.getPricePerNight(), h.getAmenitiesString()));
				}
			}
		}
		
		return hotelBeans;
	}
}
