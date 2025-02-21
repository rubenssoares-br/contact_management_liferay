create index IX_434E2812 on CTMG_Contact (address[$COLUMN_LENGTH:75$]);
create index IX_4EFF98BA on CTMG_Contact (email[$COLUMN_LENGTH:75$]);
create index IX_CF33BC91 on CTMG_Contact (name[$COLUMN_LENGTH:75$]);
create index IX_8D235E0C on CTMG_Contact (phone);
create index IX_AB785722 on CTMG_Contact (uuid_[$COLUMN_LENGTH:75$]);

create index IX_A3E03A3F on CTMG_ContactEntry (contactId);