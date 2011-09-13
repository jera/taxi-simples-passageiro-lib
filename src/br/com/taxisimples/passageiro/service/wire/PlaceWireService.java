package br.com.taxisimples.passageiro.service.wire;

import br.com.taxisimples.passageiro.Place;
import br.com.taxisimples.passageiro.service.PlaceService;

public interface PlaceWireService {

	void createPlace(Place place);
	void requestMyPlaces();
	void setService(PlaceService service);
	
}
