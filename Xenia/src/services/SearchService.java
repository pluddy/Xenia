package services;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import managers.HotelManager;
import models.Hotel;
import models.HotelAmenity;
import models.HotelRoom;

public class SearchService {

	public static List<Hotel> searchHotels(Calendar checkIn, Calendar checkOut, String city, int numRooms, String roomType, List<String> amenities) {
		List<Hotel> hotels = HotelManager.getHotels(null, null, city, null, null, null, null, null);
		
		hotels: for (Iterator<Hotel> iterator = hotels.iterator(); iterator.hasNext();) {
			Hotel h = iterator.next();
			for (HotelRoom r : h.getRooms()) {
				if (checkIn.before(r.getStartDate()) || 
						checkOut.after(r.getEndDate()) || 
						numRooms > r.getAvailableNumber() ||
						!r.getRoomType().getRoomType().equals(roomType)) {
					iterator.remove();
					continue hotels;
				}
			}
			amenities: for (String a : amenities) {
				for (HotelAmenity ha : h.getAmenities()) {
					if (ha.getAmenity().getName().equals(a)) {
						continue amenities;
					}
				}
				iterator.remove();
				continue hotels;
			}
		}
		
		return hotels;
	}
}
