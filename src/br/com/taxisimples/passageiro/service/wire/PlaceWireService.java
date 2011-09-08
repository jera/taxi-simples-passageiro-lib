package br.com.taxisimples.passageiro.service.wire;

import br.com.taxisimples.passageiro.Place;

public interface PlaceWireService {

	void createPlace(Place place);
	void requestMyPlaces();
	
}
