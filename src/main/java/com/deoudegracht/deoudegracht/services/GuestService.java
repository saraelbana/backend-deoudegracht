package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.GuestResponseDTO;
import com.deoudegracht.deoudegracht.mappers.GuestMapper;
import com.deoudegracht.deoudegracht.models.Guest;
import com.deoudegracht.deoudegracht.repositories.GuestRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuestService {

    private final GuestRepository guestRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    public GuestService(GuestRepository guestRepository,UserService userService, PasswordEncoder passwordEncoder) {
        this.guestRepository = guestRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    public GuestResponseDTO createGuest(Guest guest) {
        String username = guest.getUser().getUsername();
        String encryptedPassword = passwordEncoder.encode(guest.getUser().getPassword());
        guest.getUser().setPassword(encryptedPassword);
        if (userService.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        try {
            Guest savedGuest = guestRepository.save(guest);
            return GuestMapper.mapGuestToGuestResponseDTO(savedGuest);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create guest: " + e.getMessage());
        }

    }

    public List<GuestResponseDTO> getAllGuests() {
        try {
            List <GuestResponseDTO> guestsResponseDtoList;
            List <Guest>guestsList = guestRepository.findAll();
            if(guestsList.isEmpty()) {
                throw new RuntimeException("No Guests found");
            }
            else {
                guestsResponseDtoList = new ArrayList<>();
                for (Guest guest  : guestsList) {
                    guestsResponseDtoList.add(GuestMapper.mapGuestToGuestResponseDTO(guest));

                }
                return guestsResponseDtoList;
            }
        }catch (Exception e) {
            throw new RuntimeException("No Guests found");
        }
    }
    public GuestResponseDTO getGuestByUsername(String username) {
        try {

            Optional<Guest> guest = guestRepository.findByUser_Username(username);
            if (guest.isEmpty()) {
                throw new RuntimeException("Guest not found");
            }

            System.out.println(guest.get().getUser().getFirstname() + " " + guest.get().getUser().getLastname());
            return GuestMapper.mapGuestToGuestResponseDTO(guest.get());
        } catch (Exception e) {
            throw new RuntimeException("Geust not found");
        }
    }
    public GuestResponseDTO updateGuest(Guest newDataGuest) {
        try {
            Optional<Guest> existingGuestOptional = guestRepository.findByUser_Username(newDataGuest.getUser().getUsername());


            if (!existingGuestOptional.isPresent()) {
                throw new RuntimeException("guest not found");
            }

            System.out.println(existingGuestOptional.get().getUser().getFirstname() + " " + existingGuestOptional.get().getUser().getLastname());
            Guest existingGuest = existingGuestOptional.get();
            existingGuest.getUser().setFirstname(newDataGuest.getUser().getFirstname());
            existingGuest.getUser().setLastname(newDataGuest.getUser().getLastname());
            existingGuest.getUser().setEmail(newDataGuest.getUser().getEmail());
            existingGuest.getUser().setPhone(newDataGuest.getUser().getPhone());
            existingGuest.getUser().setPassword(newDataGuest.getUser().getPassword());
            existingGuest.getUser().setUsername(newDataGuest.getUser().getUsername());
            System.out.println(existingGuest.getUser().getFirstname() + " " + existingGuest.getUser().getLastname());


            Guest updatedGuest = guestRepository.save(existingGuest);
            System.out.println("Guest Data updated successfully");
            return GuestMapper.mapGuestToGuestResponseDTO(updatedGuest);

        } catch (Exception e) {
            throw new RuntimeException("Failed to update guest: " + e.getMessage());
        }
    }
    public void deleteGuest(String username) {

        Optional<Guest> guest = guestRepository.findByUser_Username(username);
        if (guest.isEmpty()) {
            throw new RuntimeException("Guest not found");
        } else {
            try {
                guestRepository.deleteById(guest.get().getID());
                System.out.println("Guest deleted");
            } catch (Exception e) {
                throw new RuntimeException("Deleting Guest process failed");
            }
        }
    }
}
