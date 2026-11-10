create table CTMG_Contact (
	uuid_ VARCHAR(75) null,
	contactId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	phone LONG,
	address VARCHAR(75) null
);

create table CTMG_ContactEntry (
	entryId LONG not null primary key,
	familyRelationship VARCHAR(75) null,
	phone LONG,
	address VARCHAR(75) null,
	contactId LONG
);