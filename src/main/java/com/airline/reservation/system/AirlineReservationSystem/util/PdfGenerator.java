package com.airline.reservation.system.AirlineReservationSystem.util;


import com.airline.reservation.system.AirlineReservationSystem.entity.ReservationEntity;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.itextpdf.text.Document;

import java.io.FileOutputStream;


@Component
@Slf4j
public class PdfGenerator {
    public  void initiatePdf(ReservationEntity reservation ,String filePath ){
        Document document = new Document();
        try {
            log.info("going to initiate pdf");
            PdfWriter.getInstance(document , new FileOutputStream(filePath));
            document.open();
            document.add(generateTable(reservation));
            document.close();
            log.info("pdf initiated successfully!");
        }
        catch (Exception e){

        }

    }
    public PdfPTable generateTable(ReservationEntity reservation){
        log.info("going to generate table for pdf with flight and passengers details");
        PdfPTable pdfPTable = new PdfPTable(2);
        PdfPCell pdfPCell ;
        pdfPCell = new PdfPCell(new Phrase("Flights Itinerary"));
        pdfPCell.setColspan(2);
        pdfPTable.addCell(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase("Flights Details"));
        pdfPCell.setColspan(2);
        pdfPTable.addCell(pdfPCell);

        pdfPTable.addCell("Departure city");
        pdfPTable.addCell(reservation.getFlight().getDepartureCity());
        pdfPTable.addCell("Arrival City");
        pdfPTable.addCell(reservation.getFlight().getArrivalCity());
        pdfPTable.addCell("Departure date");
        pdfPTable.addCell(reservation.getFlight().getDepartureDate().toString());
        pdfPTable.addCell("Estimated departure time");
        pdfPTable.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

        pdfPCell = new PdfPCell(new Phrase("Passenger Details"));
        pdfPCell.setColspan(2);
        pdfPTable.addCell(pdfPCell);

        pdfPTable.addCell("First Name");
        pdfPTable.addCell(reservation.getPassenger().getFirstName());
        pdfPTable.addCell("Last Name");
        pdfPTable.addCell(reservation.getPassenger().getLastName());
        pdfPTable.addCell("Email");
        pdfPTable.addCell(reservation.getPassenger().getEmail());
        pdfPTable.addCell("Phone");
        pdfPTable.addCell(reservation.getPassenger().getPhone());

        log.info("pdf generated successfully!");
        return  pdfPTable;

    }
}
