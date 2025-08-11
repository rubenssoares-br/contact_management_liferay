package com.liferay.contact.management.model;

public class Entry {
    private String _name;
    private String _email;
    private String _phone;
    private String _address;

    public Entry() {
        _name = null;
        _email = null;
        _phone = null;
        _address = null;
    }

    public Entry(String _name, String _email, String _phone, String _address) {
        this._name = _name;
        this._email = _email;
        this._phone = _phone;
        this._address = _address;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }
}
