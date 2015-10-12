package com.icare.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(schema = "icare", name = "prescription")
public class PrescriptionEntity {

	@Id
	@Column(name = "medicine_id")
	@GeneratedValue(generator = "prescriptionGen")
	@GenericGenerator(name = "prescriptionGen", strategy = "foreign", parameters = @Parameter(name = "property", value = "medicine"))
	private int medicineId;
	@OneToOne
	@PrimaryKeyJoinColumn
	private MedicineEntity medicine;
	@ManyToOne
	@JoinColumn(name = "visit_id")
	private VisitEntity visit;
	private int frequency;
	@Column(name = "med_quantity")
	private int medQuantity;
	@Column(name = "freq_type")
	private String freqType;

	public PrescriptionEntity() {

	}

	public PrescriptionEntity(int medicineId, int frequency, int medQuantity,
			String freqType, VisitEntity visit) {
		super();
		this.medicineId = medicineId;
		this.frequency = frequency;
		this.medQuantity = medQuantity;
		this.freqType = freqType;
		this.visit = visit;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public MedicineEntity getMedicine() {
		return medicine;
	}

	public void setMedicine(MedicineEntity medicine) {
		this.medicine = medicine;
	}

	public VisitEntity getVisit() {
		return visit;
	}

	public void setVisit(VisitEntity visit) {
		this.visit = visit;
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

	public String getFreqType() {
		return freqType;
	}

	public void setFreqType(String freqType) {
		this.freqType = freqType;
	}

	@Override
	public String toString() {
		return "PrescriptionEntity [medicineId=" + medicineId + ", frequency="
				+ frequency + ", medQuantity=" + medQuantity + ", freqType="
				+ freqType + "]";
	}

}
