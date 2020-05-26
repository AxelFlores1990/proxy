package com.ml.proxy.httpmock.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class MockController {

	private final AtomicLong counter = new AtomicLong();
	
	private final String response = "{\"id\":\"MLA1743\",\"name\":\"Autos, Motos y Otros\",\"picture\":\"http://resources.mlstatic.com/category/images/e1a43666-ad57-4b8b-b405-f9d04dbbd8fc.png\",\"permalink\":\"http://www.mercadolibre.com.ar/vehiculos/\",\"total_items_in_this_category\":166189,\"path_from_root\":[{\"id\":\"MLA1743\",\"name\":\"Autos, Motos y Otros\"}],\"children_categories\":[{\"id\":\"MLA93412\",\"name\":\"Autos Chocados y Averiados\",\"total_items_in_this_category\":1467},{\"id\":\"MLA1745\",\"name\":\"Autos de Colección\",\"total_items_in_this_category\":2845},{\"id\":\"MLA1744\",\"name\":\"Autos y Camionetas\",\"total_items_in_this_category\":97194},{\"id\":\"MLA58254\",\"name\":\"Camiones\",\"total_items_in_this_category\":3131},{\"id\":\"MLA51547\",\"name\":\"Colectivos\",\"total_items_in_this_category\":622},{\"id\":\"MLA7312\",\"name\":\"Maquinaria Agrícola\",\"total_items_in_this_category\":3502},{\"id\":\"MLA405183\",\"name\":\"Maquinaria Vial\",\"total_items_in_this_category\":2435},{\"id\":\"MLA80579\",\"name\":\"Motorhomes\",\"total_items_in_this_category\":968},{\"id\":\"MLA1763\",\"name\":\"Motos\",\"total_items_in_this_category\":35500},{\"id\":\"MLA1785\",\"name\":\"Náutica\",\"total_items_in_this_category\":7207},{\"id\":\"MLA1784\",\"name\":\"Planes de Ahorro\",\"total_items_in_this_category\":1648},{\"id\":\"MLA93430\",\"name\":\"Semirremolques\",\"total_items_in_this_category\":1165},{\"id\":\"MLA1907\",\"name\":\"Otros Vehículos\",\"total_items_in_this_category\":8322}],\"attribute_types\":\"none\",\"settings\":{\"adult_content\":false,\"buying_allowed\":false,\"buying_modes\":[\"classified\"],\"catalog_domain\":null,\"coverage_areas\":\"not_allowed\",\"currencies\":[\"USD\",\"ARS\"],\"fragile\":false,\"immediate_payment\":\"optional\",\"item_conditions\":[\"used\",\"not_specified\",\"new\"],\"items_reviews_allowed\":false,\"listing_allowed\":false,\"max_description_length\":50000,\"max_pictures_per_item\":15,\"max_pictures_per_item_var\":6,\"max_sub_title_length\":70,\"max_title_length\":60,\"maximum_price\":null,\"minimum_price\":null,\"mirror_category\":null,\"mirror_master_category\":null,\"mirror_slave_categories\":[],\"price\":\"required\",\"reservation_allowed\":\"mandatory\",\"restrictions\":[],\"rounded_address\":false,\"seller_contact\":\"optional\",\"shipping_modes\":[\"not_specified\",\"custom\"],\"shipping_options\":[],\"shipping_profile\":\"not_allowed\",\"show_contact_information\":true,\"simple_shipping\":\"not_allowed\",\"stock\":\"required\",\"sub_vertical\":null,\"subscribable\":false,\"tags\":[],\"vertical\":\"motors\",\"vip_subdomain\":\"vehiculo\",\"buyer_protection_programs\":[\"delivered\",\"undelivered\"],\"status\":\"enabled\"},\"meta_categ_id\":null,\"attributable\":false,\"date_created\":\"2018-04-25T08:12:56.000Z\"}";

	@GetMapping(path = "MLA1743", produces = MediaType.APPLICATION_JSON_VALUE)
	public String mock() {
		System.out.println(counter.incrementAndGet());
		return this.response;
	}
}