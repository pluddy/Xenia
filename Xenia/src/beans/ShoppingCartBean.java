package beans;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartBean {
	List<ReservationBean> reservations;
	
	/**
	 * @return the reservations
	 */
	public List<ReservationBean> getReservations() {
		return reservations;
	}

	/**
	 * @param reservations the reservations to set
	 */
	public void setReservations(List<ReservationBean> reservations) {
		this.reservations = reservations;
	}
	
	/**
	 * @param reservation the reservations to add
	 */
	public void addReservation(ReservationBean reservation) {
		if (this.reservations == null) {
			this.reservations = new ArrayList<ReservationBean>();
		}
		this.reservations.add(reservation);
	}
	
	public double getTotalPrice() {
		double total = 0;
		for (ReservationBean res : reservations) {
			total += res.getPrice();
		}
		return total;
	}
}
