package com.icare.utils;

import com.icare.beans.AddressBean;
import com.icare.beans.AppointmentBean;
import com.icare.beans.AppointmentTypeBean;
import com.icare.beans.ContactBean;
import com.icare.beans.MedicineBean;
import com.icare.beans.PatientBean;
import com.icare.beans.PrescriptionBean;
import com.icare.beans.VisitBean;
import com.icare.entities.AddressEntity;
import com.icare.entities.AppointmentEntity;
import com.icare.entities.AppointmentTypeEntity;
import com.icare.entities.ContactEntity;
import com.icare.entities.MedicineEntity;
import com.icare.entities.PatientEntity;
import com.icare.entities.PrescriptionEntity;
import com.icare.entities.VisitEntity;

public final class BeanCreatorUtil {

	public static VisitBean visit(VisitEntity entity) {
		String visitDt = DateUtil.toString(entity.getVisitDt(),
				AppConstants.DD_MMM_YYYY);
		VisitBean bean = new VisitBean(entity.getId(),
				patient(entity.getPatient()), entity.getProblems(),
				entity.getSymptoms(), entity.getAllergies(),
				entity.getTestResults(), visitDt);
		return bean;
	}

	public static PatientBean patient(PatientEntity patientModel) {
		ContactBean contactBean = contact(patientModel.getContact());
		PatientBean patientBean = new PatientBean(patientModel.getFirstName(),
				patientModel.getMiddleName(), patientModel.getLastName());
		patientBean.setContact(contactBean);
		patientBean.setId(patientModel.getId());

		if (null != patientModel.getProfilePic()) {
			patientBean.setProfileImageBytes(patientModel.getProfilePic());
		}

		return patientBean;
	}

	public static ContactBean contact(ContactEntity contact) {
		ContactBean contactBean = null;
		if (contact != null) {
			AddressBean addressBean = address(contact.getAddress());
			contactBean = new ContactBean(contact.getMobileNo(),
					contact.getLandline(), contact.getPersonalEmail(),
					contact.getOfficialEmail());
			contactBean.setAddress(addressBean);
		}
		return contactBean;
	}

	public static AddressBean address(AddressEntity address) {
		AddressBean addressBean = new AddressBean(address.getAddrLine1(),
				address.getAddrLine2(), address.getCity(), address.getState(),
				address.getPinCode());
		return addressBean;
	}

	public static AppointmentBean appointment(AppointmentEntity model) {
		String appointmentDate = DateConverterUtil.toString(model.getDate(),
				AppConstants.DD_MMM_YYYY);
		String appointmentTimeStr = null;
		if (null != model.getTime()) {
			appointmentTimeStr = DateConverterUtil.toString(model.getTime(),
					AppConstants.DD_MMM_YYYY_HH_MM_SS);
		}
		AppointmentBean bean = new AppointmentBean(appointmentDate,
				appointmentTimeStr, model.getDetails(),
				appointmentType(model.getType()), patient(model.getPatient()),
				model.getStatus());
		bean.setAppointmentTime(model.getTime());
		bean.setId(model.getId());
		return bean;
	}

	public static AppointmentTypeBean appointmentType(
			AppointmentTypeEntity model) {
		AppointmentTypeBean bean = new AppointmentTypeBean();
		bean.setId(model.getId());
		bean.setName(model.getName());
		return bean;
	}

	public static MedicineBean medicine(MedicineEntity entity) {
		MedicineBean bean = new MedicineBean(entity.getId(), entity.getName(),
				entity.getManufacturer(), entity.getType(), entity.getUnit());
		return bean;
	}

	public static PrescriptionBean prescription(PrescriptionEntity entity) {
		PrescriptionBean bean = new PrescriptionBean(entity.getMedicineId(),
				medicine(entity.getMedicine()), visit(entity.getVisit()),
				entity.getFrequency(), entity.getMedQuantity(),
				entity.getFreqType());
		return bean;
	}
}
