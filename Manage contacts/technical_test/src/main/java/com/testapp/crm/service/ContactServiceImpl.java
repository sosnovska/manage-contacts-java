package com.testapp.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testapp.crm.model.Contact;
import com.testapp.crm.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public Iterable<Contact> getContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Optional<Contact> getContactById(Long id) {
		return contactRepository.findById(id);
	}
	
	@Override
	public Contact createOrUpdateContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	@Override
	public void deleteContact(Long id) {
		contactRepository.deleteById(id);
	}

}