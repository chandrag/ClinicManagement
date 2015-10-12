package com.icare.beans;

public class PrescriptionBean {

	private int medicineId;
	private MedicineBean medicine;
	private VisitBean visit;
	private int frequency;
	private int medQuantity;
	private String freqType;

	public PrescriptionBean() {

	}

	public PrescriptionBean(int medicineId, MedicineBean medicine,
			VisitBean visit, int frequency, int medQuantity, String freqType) {
		super();
		this.medicineId = medicineId;
		this.medicine = medicine;
		this.visit = visit;
		this.frequency = frequency;
		this.medQuantity = medQuantity;
		this.freqType = freqType;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public MedicineBean getMedicine() {
		return medicine;
	}

	public void setMedicine(MedicineBean medicine) {
		this.medicine = medicine;
	}

	public VisitBean getVisit() {
		return visit;
	}

	public void setVisit(VisitBean visit) {
		this.visit = visit;
	}

	public String getFreqType() {
		return freqType;
	}

	public void setFreqType(String freqType) {
		this.freqType = freqType;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getMedQuantity() {
		return medQuantity;
	}

	public void setMedQuantity(int medQuantity) {
		this.medQuantity = medQuantity;
	}

	@Override
	public String toString() {
		return "PrescriptionBean [medicineId=" + medicineId + ", medicine="
				+ medicine + ", visit=" + visit + ", frequency=" + frequency
				+ ", medQuantity=" + medQuantity + ", freqType=" + freqType
				+ "]";
	}

}
