package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import beans.ReservationSearchQueryBean;
import beans.ReservationSearchResultBean;
import managers.HotelManager;
import models.Hotel;
import models.HotelAmenity;
import models.HotelRoom;

public class SearchService {

	public static List<ReservationSearchResultBean> searchHotels(ReservationSearchQueryBean queryBean) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		if (!queryBean.getCity().equals("")) {
			hotels = HotelManager.getHotels(null, null, queryBean.getCity(), null, null, null, null, null);
		} else {
			hotels = HotelManager.getHotels(null, null, null, null, null, null, null, null);
		}
		List<ReservationSearchResultBean> hotelBeans = new ArrayList<ReservationSearchResultBean>();
		
		hotels: for (Iterator<Hotel> iterator = hotels.iterator(); iterator.hasNext();) {
			Hotel h = iterator.next();
			String hAmenities = "";
			amenities: for (String a : queryBean.getAmenities()) {
				for (HotelAmenity ha : h.getAmenities()) {
					if (ha.getAmenity().getName().equals(a)) {
						continue amenities;
					}
				}
				iterator.remove();
				continue hotels;
			}
			for (HotelRoom r : h.getRooms()) {
				if (queryBean.getCheckIn().after(r.getStartDate()) && 
						queryBean.getCheckOut().before(r.getEndDate()) && 
						queryBean.getNumRooms() < r.getAvailableNumber() &&
						r.getRoomType().getRoomType().equals(queryBean.getRoomType())) {
					hotelBeans.add(new ReservationSearchResultBean(h.getId(), h.getName(), h.getAddress(), h.getDescription(), r.getRoomType().getRoomType(), 4.0, r.getPricePerNight(), h.getAmenitiesString()));
				}
			}
		}
		
		return hotelBeans;
	}
}
