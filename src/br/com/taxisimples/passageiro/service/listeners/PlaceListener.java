package br.com.taxisimples.passageiro.service.listeners;

import java.util.List;

import br.com.taxisimples.passageiro.Place;

public interface PlaceListener extends NamedListener {

	void placeCreated(Place place);
	void myPlacesListed(List<Place> places);
	
}
