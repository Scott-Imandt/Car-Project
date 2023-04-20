package Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class GeneratePDF {
	
	String filePath;
	String completedFilePath;
	Car selectedCar;
	
	public GeneratePDF(Car selectedCar) {
		filePath ="src/Data/" + selectedCar.getCarName() + "-CarLog.pdf";
		completedFilePath = "src/Data/" + selectedCar.getCarName() + "-CompletedCarLog.pdf";
		this.selectedCar = selectedCar;
		
	}
	
	
	public void CreatePDFFileCompletedJobs() {
		
		Document document = new Document();
		
		document.setPageSize(new Rectangle(1398, 1080));
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(completedFilePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
		document.open();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		
		Paragraph header1 = new Paragraph(selectedCar.getCarName() + "     " + selectedCar.getCurrentMileage());
		Paragraph header2 = new Paragraph("Completed Jobs" + "     " + LocalDate.now().format(formatter));
		
		PdfPTable table = new PdfPTable(5);
		
		PdfPCell c1 = new PdfPCell(new Phrase("Job Name"));
		table.addCell(c1);	
		c1 = new PdfPCell(new Phrase("Completed Date"));
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Completed Mileage"));
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Product Name"));
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Product Link"));
		table.addCell(c1);
		
		table.setHeaderRows(1);
		
		
		for(CompletedJob job : selectedCar.getCompletedJobs()) {
			table.addCell(job.getJobName());
			table.addCell(job.getCompletedDate());
			table.addCell(String.valueOf(job.getCompletedMileage()));
			table.addCell(job.getReplacementProductName());
			table.addCell(job.getReplacementProductLink());
		}
		
		try {
			
			document.add(header1);
			document.add(header2);
			document.add(table);
			
			
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Completed Jobs Document Created");
		
		document.close();
	}
	
	public void CreatePDFFileJobs() {
		
		Document document = new Document();
		
		document.setPageSize(new Rectangle(1398, 1080));
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
		document.open();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		
		Paragraph header1 = new Paragraph(selectedCar.getCarName() + "     " + selectedCar.getCurrentMileage());
		Paragraph header2 = new Paragraph("Jobs" + "     " + LocalDate.now().format(formatter));
		
		PdfPTable table = new PdfPTable(9);
		
		PdfPCell c1 = new PdfPCell(new Phrase("Job Name"));
		table.addCell(c1);	
		c1 = new PdfPCell(new Phrase("Mileage Interval"));
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Month Interval"));
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Last Date Preformed"));
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Expected Date to Preform"));
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("last Preformed Miles"));
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Job Type"));
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Reason For Repair"));
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Maintenance Needed"));
		table.addCell(c1);
		
		table.setHeaderRows(1);
		
		BaseColor myColor = WebColors.getRGBColor("#ff8080");
		
		for(Job job : selectedCar.getJobs()) {
			if(!(job.getRepairReason().equals("NO_REPAIR"))) {
				PdfPCell cell;
				
				cell = new PdfPCell(new Phrase(job.getJobName()));
				cell.setBackgroundColor(myColor);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(job.getMileagInterval())));
				cell.setBackgroundColor(myColor);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(job.getMonthTimeInterval())));
				cell.setBackgroundColor(myColor);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(job.getLastPreformedDate()));
				cell.setBackgroundColor(myColor);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(job.getExpectedDatetoPreform()));
				cell.setBackgroundColor(myColor);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(job.getLastPreformedMiles()));
				cell.setBackgroundColor(myColor);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(job.getJobEnum()));
				cell.setBackgroundColor(myColor);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(job.getRepairReason()));
				cell.setBackgroundColor(myColor);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(job.getNeedMaintence()));
				cell.setBackgroundColor(myColor);
				table.addCell(cell);
				
			}
			else {
						
			table.addCell(job.getJobName());
			table.addCell(String.valueOf(job.getMileagInterval()));
			table.addCell(String.valueOf(job.getMonthTimeInterval()));
			table.addCell(job.getLastPreformedDate());
			table.addCell(job.getExpectedDatetoPreform());
			table.addCell(job.getLastPreformedMiles());
			table.addCell(job.getJobEnum());
			table.addCell(job.getRepairReason());
			table.addCell(job.getNeedMaintence());
			}
		}
		
		try {
			
			document.add(header1);
			document.add(header2);
			document.add(table);
			
			
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		System.out.println("Jobs Document Created");
		
		document.close();
	}
	
}
