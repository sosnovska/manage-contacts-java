package com.testapp.crm.service;

import java.util.Optional;

import com.testapp.crm.model.Contact;

public interface ContactService {

	public Iterable<Contact> getContacts();

	public Optional<Contact> getContactById(Long id);

	Contact createOrUpdateContact(Contact contact);

	void deleteContact(Long id);

}