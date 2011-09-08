package br.com.taxisimples.passageiro.service.wire.mock;

import java.util.ArrayList;
import java.util.List;

import br.com.taxisimples.passageiro.Place;
import br.com.taxisimples.passageiro.service.PlaceService;
import br.com.taxisimples.passageiro.service.wire.PlaceWireService;

public class MockPlaceWireService implements PlaceWireService {

	private List<Place> places = new ArrayList<Place>();
	private PlaceService service = PlaceService.getInstance();
	
	@Override
	public void createPlace(Place place) {
		places.add(place);
		service.notifyPlaceCreated(place);
	}

	@Override
	public void requestMyPlaces() {
		service.notifyMyPlacesListed(places);
	}

}
