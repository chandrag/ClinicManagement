package com.icare.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.icare.beans.MedicineBean;
import com.icare.beans.PatientBean;
import com.icare.beans.PrescriptionBean;
import com.icare.beans.VisitBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PrescriptionSlipGenerator {

	private static String outputPath = "F:/Workspaces/Slips/";
	private static String outputFileName = "VisitSlip.pdf";

	public static void generateUsingHtml(InputStream iStream)
			throws DocumentException, IOException {
		System.out.println("Creating PDF...");
		Document document = new Document();
		File file = new File(outputPath + outputFileName);
		file.createNewFile();
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(file));
		document.open();
		// "classpath:templates/slips/PrescriptionSlipTemplate.html"

		// XMLWorkerHelper.getInstance().parseXHtml(writer, document,
		// new FileInputStream(resource.getFile()));
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, iStream);
		document.close();
		System.out.println("PDf Created...");
	}

	public static void generateUsingCode(List<VisitBean> visits) {
		try {
			OutputStream os = new FileOutputStream(new File("VisitSlip1.pdf"));
			Document document = new Document();
			PdfWriter.getInstance(document, os);

			// Inserting Image in PDF
			Image image = Image
					.getInstance("F:/Workspaces/GitWS/ProductICare/HospitalManagement/src/main/webapp/WEB-INF/resources/images/RxSymbol.png");
			image.scaleAbsolute(60f, 60f);// image width,height

			// Inserting Table in PDF

			PdfPTable table = new PdfPTable(5);
			PdfPCell cell = new PdfPCell(new Paragraph("Medicines Details"));
			cell.setColspan(5);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(10.0f);
			cell.setBackgroundColor(new BaseColor(140, 221, 8));
			table.addCell(cell);

			// Table Header
			final float padding = 5.0f;
			PdfPCell srNoCell = new PdfPCell(new Phrase("Sr.No"));
			srNoCell.setPadding(padding);

			PdfPCell mediCell = new PdfPCell(new Phrase("Medicine"));
			mediCell.setPadding(padding);

			PdfPCell frequencyCell = new PdfPCell(new Phrase("Frequency"));
			frequencyCell.setPadding(padding);

			PdfPCell quantityCell = new PdfPCell(new Phrase("Quantity"));
			quantityCell.setPadding(padding);

			PdfPCell maxCell = new PdfPCell(new Phrase("Max"));
			maxCell.setPadding(padding);

			table.addCell(srNoCell);
			table.addCell(mediCell);
			table.addCell(frequencyCell);
			table.addCell(quantityCell);
			table.addCell(maxCell);

			VisitBean visitBean = visits.get(0);
			List<PrescriptionBean> prescriptions = visitBean.getPrescriptions();

			for (int i = 0; i < prescriptions.size(); i++) {
				PrescriptionBean prescriptionBean = prescriptions.get(i);

				PdfPCell srNoValCell = new PdfPCell(new Phrase(
						String.valueOf(i + 1)));
				srNoValCell.setPadding(padding);
				table.addCell(srNoValCell);

				PdfPCell mediValCell = new PdfPCell(new Phrase(prescriptionBean
						.getMedicine().getName()));
				mediValCell.setPadding(padding);
				table.addCell(mediValCell);

				PdfPCell freqValCell = new PdfPCell(new Phrase(
						prescriptionBean.getFrequency()));
				freqValCell.setPadding(padding);
				table.addCell(freqValCell);

				PdfPCell mediQuantityValCell = new PdfPCell(new Phrase(
						prescriptionBean.getMedQuantity()));
				mediQuantityValCell.setPadding(padding);
				table.addCell(mediQuantityValCell);

				PdfPCell totValCell = new PdfPCell(new Phrase("20 Tablets"));
				totValCell.setPadding(padding);
				table.addCell(totValCell);
			}

			table.setSpacingBefore(30.0f); // Space Before table starts, like
											// margin-top in CSS
			table.setSpacingAfter(30.0f); // Space After table starts, like
											// margin-Bottom in CSS

			// Doctor Name
			Font font = new Font();
			BaseColor color = new BaseColor(0, 121, 255);
			font.setColor(color);
			font.setSize(15f);
			Paragraph doctorName = new Paragraph(4f, "Dr. Ugale", font);
			doctorName.setIndentationLeft(70f);
			doctorName.setAlignment(Paragraph.ALIGN_TOP);

			// Now Insert Every Thing Into PDF Document
			document.open();

			document.add(image);
			document.add(doctorName);

			document.add(Chunk.NEWLINE);

			document.add(new Paragraph("Dear Java4s.com"));
			document.add(new Paragraph("Document Generated On - "
					+ new Date().toString()));

			document.add(table);

			document.add(Chunk.NEWLINE);

			// document.newPage(); // Opened new page

			document.close();
			os.close();

			System.out.println("Pdf created successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// generateUsingCode(generateData());
		try {
			ClassPathResource resource = new ClassPathResource(
					"templates/slips/PrescriptionSlipTemplate.html");
			generateUsingHtml(new FileInputStream(resource.getFile()));
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public static List<VisitBean> generateData() {
		List<VisitBean> visits = new ArrayList<>();
		VisitBean visitBean = new VisitBean();
		visitBean.setAllergies("Allergic to Calcium");
		visitBean.setId(201);

		PatientBean patient = new PatientBean();
		patient.setFirstName("Aron");
		patient.setId(329);
		patient.setLastName("Johnson");
		patient.setMiddleName("David");

		visitBean.setPatient(patient);

		List<PrescriptionBean> prescriptions = new ArrayList<>();
		PrescriptionBean pres1 = new PrescriptionBean();
		pres1.setFreqType(MedicineFrequency.DAILY.name());
		// pres1.setFrequency("2 times a day");

		MedicineBean medicine = new MedicineBean();
		medicine.setId(101);
		medicine.setManufacturer("Manuf Delton");
		medicine.setName("Crocin");
		medicine.setType(MedicineType.CAPSULE.name());
		medicine.setUnit("1");

		pres1.setMedicine(medicine);
		pres1.setMedicineId(medicine.getId());
		// pres1.setMedQuantity("1 Tablet");

		prescriptions.add(pres1);

		visitBean.setPrescriptions(prescriptions);
		visitBean.setProblems("Sore Eyes");
		visitBean.setSymptoms("Unblurred vision");
		visitBean.setTestResults("Blood Test Negative");
		Date visitDt = new Date();
		visitBean.setVisitDt(visitDt.toString());
		visits.add(visitBean);
		return visits;
	}

}
