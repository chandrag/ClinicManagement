package com.icare.utils;

import com.icare.beans.AddressBean;
import com.icare.beans.AppointmentTypeBean;
import com.icare.beans.ContactBean;
import com.icare.beans.MedicineBean;
import com.icare.entities.AddressEntity;
import com.icare.entities.AppointmentTypeEntity;
import com.icare.entities.ContactEntity;
import com.icare.entities.MedicineEntity;

public final class BeanCreatorUtil {

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

}
