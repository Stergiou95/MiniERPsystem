package com.example.finalproj.mapper;

import com.example.finalproj.dto.ShiftsDTO;
import com.example.finalproj.model.Shifts;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class ShiftsMapper {

    // Ορίστε έναν DateTimeFormatter για τη διαχείριση του format της ώρας
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public ShiftsDTO toDTO(Shifts shift) {
        return new ShiftsDTO(
                shift.getShiftID(),
                shift.getStartTime().format(String.valueOf(TIME_FORMATTER)),
                shift.getEndTime().format(String.valueOf(TIME_FORMATTER))
        );
    }

    public Shifts toEntity(ShiftsDTO dto) {
        Shifts shift = new Shifts();
        shift.setShiftID(dto.getShiftID());
        try {
            // Χρησιμοποιήστε τον DateTimeFormatter για την μετατροπή από string σε LocalTime
            shift.setStartTime(String.valueOf(LocalTime.parse(dto.getStartTime(), TIME_FORMATTER)));
            shift.setEndTime(String.valueOf(LocalTime.parse(dto.getEndTime(), TIME_FORMATTER)));
        } catch (DateTimeParseException e) {
            // Διαχειριστείτε την περίπτωση όπου το format δεν είναι σωστό
            System.err.println("Invalid time format: " + e.getMessage());
        }
        return shift;
    }
}
