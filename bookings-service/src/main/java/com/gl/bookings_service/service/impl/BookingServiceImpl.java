package com.gl.bookings_service.service.impl;

import com.gl.bookings_service.BookingsServiceApplication;
import com.gl.bookings_service.client.OpenFeignPackage;
import com.gl.bookings_service.client.OpenFeignUser;
import com.gl.bookings_service.entity.Booking;
import com.gl.bookings_service.exception.ResourceNotFoundException;
import com.gl.bookings_service.payload.BookingDTO;
import com.gl.bookings_service.payload.PackagesDTO;
import com.gl.bookings_service.payload.UpdateBookingDTO;
import com.gl.bookings_service.payload.UsersDTO;
import com.gl.bookings_service.repository.BookingRepository;
import com.gl.bookings_service.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    BookingRepository bookingRepository;
    OpenFeignUser openFeignUser;
    OpenFeignPackage openFeignPackage;
    @Override
    public List<BookingDTO> createBooking(BookingDTO bookingDTO) {
//        UsersDTO usersDTO = openFeignUser.getUserById(bookingDTO.getUserId());
//        if (usersDTO==null){
//            throw new ResourceNotFoundException("User","User Id", bookingDTO.getUserId());
//        }
//        PackagesDTO packagesDTO = openFeignPackage.getPackageById(bookingDTO.getPackageID());
//        if (packagesDTO==null){
//            throw new ResourceNotFoundException("Package","Package Id", bookingDTO.getPackageID());
//        }
            bookingDTO.setBookingId(generateBookingId());

        bookingRepository.save(mapToBooking(bookingDTO));
        return bookingRepository.findByUserId(bookingDTO.getUserId()).stream().map(booking -> mapToBookingDTO(booking)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> getBookingsByUserId(String userId) {
//        UsersDTO usersDTO = openFeignUser.getUserById(userId);
//        if (usersDTO==null){
//            throw new ResourceNotFoundException("User","User Id",userId);
//        }
        return bookingRepository.findByUserId(userId).stream().map(booking -> mapToBookingDTO(booking)).collect(Collectors.toList());
    }

    @Override
    public BookingDTO updateBooking(UpdateBookingDTO updateBookingDTO) {
        Booking booking = bookingRepository.findById(updateBookingDTO.getBookingId()).orElseThrow(()->new ResourceNotFoundException("Booking","Booking Id", updateBookingDTO.getBookingId()));

        booking.setBookingDate(updateBookingDTO.getBookingDate());
        booking.setBookingPerson(updateBookingDTO.getBookingPerson());
        booking.setBookingRooms(updateBookingDTO.getBookingRooms());

        return mapToBookingDTO(bookingRepository.save(booking));
    }

    @Override
    public List<BookingDTO> deleteBooking(String userId, String bookingId) {
//        UsersDTO usersDTO = openFeignUser.getUserById(userId);
//        if (usersDTO==null){
//            throw new ResourceNotFoundException("User","User Id",userId);
//        }
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking","Booking Id", bookingId));

        if (booking.getUserId()!=userId){
            throw new ResourceNotFoundException("Booking with Booking Id:"+bookingId+" is not found in User having User Id:"+userId);
        }

        bookingRepository.delete(booking);

        return bookingRepository.findByUserId(userId).stream().map( booking1-> mapToBookingDTO(booking1)).collect(Collectors.toList());
    }
    @Override
    public long getBookingsCount() {
        return bookingRepository.count();
    }

    public Booking mapToBooking(BookingDTO bookingDTO){
        return BookingsServiceApplication.mapper().map(bookingDTO,Booking.class);
    }
    public BookingDTO mapToBookingDTO(Booking booking){
        return BookingsServiceApplication.mapper().map(booking,BookingDTO.class);
    }
    public String generateBookingId(){
        long id = bookingRepository.count()+100;
        id = id+1;
        return "B" + id;
    }
}
