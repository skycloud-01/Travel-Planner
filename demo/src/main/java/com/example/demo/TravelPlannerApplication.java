package com.example.demo;

import com.example.demo.entity.Agency;
import com.example.demo.entity.Client;
import com.example.demo.entity.Trip;
import com.example.demo.repository.AgencyRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.TripRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TravelPlannerApplication {

	private final ClientRepository clientRepository;
	private final AgencyRepository agencyRepository;
	private final TripRepository tripRepository;

	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);
	}

	@PostConstruct
	void setup(){

		clientRepository.save(Client.builder()
				.email("zdrengheaiulia01@gmail.com")
				.password("1234")
				.username("iulia")
				.picture("")
				.build()
		);
		clientRepository.save(Client.builder()
				.email("orianatrif@gmail.com")
				.password("8583460")
				.username("oriana")
				.picture("")
				.build()
		);
		clientRepository.save(Client.builder()
				.email("andreimarian@gmail.com")
				.password("059583")
				.username("andrei")
				.picture("")
				.build()
		);


		Agency agency1 = agencyRepository.save(Agency.builder()
				.email("blueTravel@yahoo.com")
				.pass("0987")
				.name("BlueTravel")
				.picture("")
				.description("Best Agency")
				.build()
		);

		Agency agency2 = agencyRepository.save(Agency.builder()
				.email("destineHolidays@yahoo.com")
				.pass("04820502")
				.name("DestineHolidays")
				.picture("")
				.description("Amazing Agency")
				.build()
		);

		Agency agency3 = agencyRepository.save(Agency.builder()
				.email("christianTour@yahoo.com")
				.pass("7025379")
				.name("ChristianTour")
				.picture("")
				.description("Wonderful Agency")
				.build()
		);
		Agency agency4 = agencyRepository.save(Agency.builder()
				.email("gotTravel@yahoo.com")
				.pass("t9t3490")
				.name("GotTravel")
				.picture("")
				.description("Outstanding Agency")
				.build()
		);


		tripRepository.save(Trip.builder()
						.destination("Turcia")
						.address("Istambul")
						.hotelName("Grand Hotel")
						.price("285")
						.startDate("2024-03-25")
						.endDate("2024-03-30")
						.description("Spring break")
						.photo("")
						.agency(agency1)
				.build()
		);
		tripRepository.save(Trip.builder()
						.destination("Ungaria")
						.address("Budapesta")
						.hotelName("Grand Hotel")
						.price("175")
						.startDate("2024-04-19")
						.endDate("2024-04-21")
						.description("Spring break")
						.photo("")
						.agency(agency1)
				.build()
		);
		tripRepository.save(Trip.builder()
						.destination("Turcia")
						.address("Antalya")
						.hotelName("Amara Family Resort")
						.price("755")
						.startDate("2024-05-25")
						.endDate("2024-06-02")
						.description("Vacation")
						.photo("")
						.agency(agency2)
				.build()
		);
		tripRepository.save(Trip.builder()
						.destination("Greece")
						.address("Zakynthos")
						.hotelName("Grand Hotel")
						.price("755")
						.startDate("2024-03-29")
						.endDate("2024-04-06")
						.description("Spring break")
						.photo("")
						.agency(agency2)
				.build()
		);
		tripRepository.save(Trip.builder()
				.destination("Italy")
				.address("Sardinia")
				.hotelName("Amara Family Resort")
				.price("755")
				.startDate("2024-05-25")
				.endDate("2024-06-02")
				.description("Vacation")
				.photo("")
				.agency(agency3)
				.build()
		);
		tripRepository.save(Trip.builder()
				.destination("Egipt")
				.address("Hurghada")
				.hotelName("Meta Hotel Santa Teresa Gallura")
				.price("837")
				.startDate("2024-09-03")
				.endDate("2024-09-10")
				.description("Vacation")
				.photo("")
				.agency(agency3)
				.build()
		);
		tripRepository.save(Trip.builder()
				.destination("Tunisia")
				.address("Djerba")
				.hotelName("Club Lella Meriam")
				.price("798")
				.startDate("2024-05-28")
				.endDate("2024-06-06")
				.description("Vacation")
				.photo("")
				.agency(agency4)
				.build()
		);
		tripRepository.save(Trip.builder()
				.destination("Emiratele Arabe Unite")
				.address("Abu Dhabi")
				.hotelName("Villaggio Hotel")
				.price("829")
				.startDate("2024-10-22")
				.endDate("2024-10-29")
				.description("Vacation")
				.photo("")
				.agency(agency4)
				.build()
		);
	}

}
