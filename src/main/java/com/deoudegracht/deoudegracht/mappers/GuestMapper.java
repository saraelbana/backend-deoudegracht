package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.dtos.GuestRequestDTO;
import com.deoudegracht.deoudegracht.dtos.GuestResponseDTO;
import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.models.Guest;

public class GuestMapper {
    static public Guest mapGuestRequestDTOToGuest(GuestRequestDTO guestRequestDTO){
        return new Guest(guestRequestDTO.getFirstname(), guestRequestDTO.getLastname(), guestRequestDTO.getEmail(), guestRequestDTO.getUsername(), guestRequestDTO.getPassword(), guestRequestDTO.getPhone());

    }
    static public GuestResponseDTO mapGuestToGuestResponseDTO(Guest guest) {
        return new GuestResponseDTO(
                guest.getID(),
                guest.getUser().getFirstname(),
                guest.getUser().getLastname(),
                guest.getUser().getEmail(),
                guest.getUser().getUsername(),
                guest.getUser().getPhone());
    }

    static public Guest mapGuestRequestDTOToGuest(GuestRequestDTO guestRequestDTO, long id) {
        Guest guest = mapGuestRequestDTOToGuest(guestRequestDTO);
        guest.setID(id);
        return guest;
    }
}
