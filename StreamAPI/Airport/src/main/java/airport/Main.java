package airport;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        return airport.getAllAircrafts()
                .stream()
                .map(Aircraft::getModel)
                .filter(aircraftModel -> aircraftModel.contains(model))
                .count();
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        return airport.getTerminals()
                .stream()
                .collect(Collectors.toMap(Terminal :: getName, terminal -> terminal.getParkedAircrafts().size()));
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        Instant currentTime = Instant.now();
        Instant timeList = currentTime.plus(hours, ChronoUnit.HOURS);
        List<Flight> deportingFlights = airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .filter(flight -> flight.getDate().isBefore(timeList))
                .filter(flight -> flight.getDate().isAfter(currentTime))
                .collect(Collectors.toList());
        return deportingFlights;
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        Optional<Flight> firstFlightArrived = airport
                .getTerminals()
                .stream()
                .filter(terminal -> terminal.getName().equals(terminalName))
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.ARRIVAL))
                .min(Comparator.comparing(flight -> flight.getDate()));
        return firstFlightArrived;
    }
}