package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.dtos.ReservationResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.mappers.ReservationMapper;
import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.models.Reservation;
import com.deoudegracht.deoudegracht.repositories.EmployeeRepository;
import com.deoudegracht.deoudegracht.repositories.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserService userService;

    public ReservationService(ReservationRepository reservationRepository, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
    }

    public ReservationResponseDTO createReservation(Reservation reservation) {
       return null;
    }

    public Object getAllReservations() {
        try {
            List <ReservationResponseDTO> reservationsResponseDtoList;
            List <Reservation> resrvationsList = reservationRepository.findAll();
            if(resrvationsList.isEmpty()) {
                throw new RuntimeException("No reservations found");
            }
            else {
                reservationsResponseDtoList = new ArrayList<>();
                for (Reservation resrvation : resrvationsList) {
                    reservationsResponseDtoList.add(ReservationMapper.mapReservationToReservationResponseDTO(resrvation));
                }
                return reservationsResponseDtoList;
            }
        }catch (Exception e) {
            throw new RuntimeException("No reservations found");
        }
    }

    public Object getReservationByUsername(String username) {
        try {

            Optional<Reservation> reservation = reservationRepository.findByUser_Username(username);
            if (reservation.isEmpty()) {
                throw new RuntimeException("no reservations found for this user: " + username);
            }

            //System.out.println(employee.get().getUser().getFirstname() + " " + employee.get().getUser().getLastname());
            return ReservationMapper.mapReservationToReservationResponseDTO(reservation.get());
        } catch (Exception e) {
            throw new RuntimeException("reservation not found");
        }
    }

    public void deleteReservation(long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isEmpty()) {
            throw new RuntimeException("Reservation not found");
        } else {
            try {
                reservationRepository.deleteById(reservation.get().getID());
                System.out.println("Reservation is deleted");
            } catch (Exception e) {
                throw new RuntimeException("Deleting reservation process failed");
            }
        }
    }
}