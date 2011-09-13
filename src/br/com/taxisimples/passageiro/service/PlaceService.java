package br.com.taxisimples.passageiro.service;

import ioc.TaxiSimplesIoC;

import java.util.ArrayList;
import java.util.List;

import br.com.taxisimples.passageiro.Place;
import br.com.taxisimples.passageiro.service.listeners.PlaceListener;
import br.com.taxisimples.passageiro.service.wire.PlaceWireService;

public class PlaceService {

	protected List<PlaceListener> listeners;

	protected PlaceWireService wire;
	protected static PlaceService instance;

	protected PlaceService(PlaceWireService wire) {
		this.wire = wire;
		this.listeners = new ArrayList<PlaceListener>();
	}

	public static synchronized PlaceService getInstance() {
		if (instance == null) {
			PlaceWireService wire = (PlaceWireService) TaxiSimplesIoC.lookup(PlaceWireService.class);
			instance = new PlaceService(wire);
		}
		return instance;
	}

	public void createPlace(Place place) {
		wire.createPlace(place);
	}

	public void requestMyPlaces() {
		wire.requestMyPlaces();
	}

	public void addListener(PlaceListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void removeListener(PlaceListener listener) {
		listeners.remove(listener);
	}

	public void notifyPlaceCreated(Place place) {
		for (PlaceListener listener : listeners) {
			listener.placeCreated(place);
		}
	}

	public void notifyMyPlacesListed(List<Place> places) {
		for (PlaceListener listener : listeners) {
			listener.myPlacesListed(places);
		}
	}
}
