/* Database: Oracle. Generation date: 2022-10-19 08:58:14:342 */
/* Entity Patient */
create table patient (
	id RAW(16) NOT NULL,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255),
	address VARCHAR(255) NOT NULL,
	phone NUMBER(19) NOT NULL,
	is_ativo NUMBER(1) /* isAtivo */,
	ext CLOB,
	CONSTRAINT patient_JSON_ext CHECK (ext IS JSON)
);


/* Creating index for customization column */
CREATE INDEX patient_ext ON patient (ext) INDEXTYPE IS CTXSYS.CONTEXT PARAMETERS ('section group CTXSYS.JSON_SECTION_GROUP SYNC (ON COMMIT)');

/* Entity Doctor */
create table doctor (
	id RAW(16) NOT NULL,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255) NOT NULL,
	crm_number NUMBER(19) NOT NULL /* crmNumber */,
	crm_state VARCHAR(255) NOT NULL /* crmState */,
	especiality VARCHAR(255) NOT NULL,
	ext CLOB,
	CONSTRAINT doctor_JSON_ext CHECK (ext IS JSON)
);


/* Creating index for customization column */
CREATE INDEX doctor_ext ON doctor (ext) INDEXTYPE IS CTXSYS.CONTEXT PARAMETERS ('section group CTXSYS.JSON_SECTION_GROUP SYNC (ON COMMIT)');

/* Entity Prescription */
create table prescription (
	id RAW(16) NOT NULL,
	drug VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	data DATE NOT NULL,
	doctor_responsible RAW(16) /* doctorResponsible */,
	type VARCHAR(255) NOT NULL,
	statement_of_reponsability NUMBER(1) /* statementOfReponsability */,
	patient RAW(16),
	ext CLOB,
	CONSTRAINT prescription_JSON_ext CHECK (ext IS JSON)
);


/* Creating index for customization column */
CREATE INDEX prescription_ext ON prescription (ext) INDEXTYPE IS CTXSYS.CONTEXT PARAMETERS ('section group CTXSYS.JSON_SECTION_GROUP SYNC (ON COMMIT)');

/* Entity ResponsibleFamilyMember */
create table responsible_family_member (
	id RAW(16) NOT NULL,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255) NOT NULL,
	kinship VARCHAR(255),
	ext CLOB,
	CONSTRAINT responsible_family_member_JSON_ext CHECK (ext IS JSON)
);


/* Creating index for customization column */
CREATE INDEX responsible_family_member_ext ON responsible_family_member (ext) INDEXTYPE IS CTXSYS.CONTEXT PARAMETERS ('section group CTXSYS.JSON_SECTION_GROUP SYNC (ON COMMIT)');

/* Join Tables */
/* master: Patient as patient, detail: Doctor as doctor */
create table patient_responsible_doctors (
	patient_id RAW(16) NOT NULL,
	responsible_doctors_id RAW(16) NOT NULL
);

/* master: Patient as patient, detail: ResponsibleFamilyMember as responsible_family_member */
create table patient_responsible_fam (
	patient_id RAW(16) NOT NULL,
	responsible_family_members_id RAW(16) NOT NULL
);

/* master: Patient as patient, detail: Prescription as prescription */
create table patient_prescriptions (
	patient_id RAW(16) NOT NULL,
	prescriptions_id RAW(16) NOT NULL
);

/* master: Doctor as doctor, detail: Prescription as prescription */
create table doctor_prescriptions (
	doctor_id RAW(16) NOT NULL,
	prescriptions_id RAW(16) NOT NULL
);

/* Primary Key Constraints */
alter table patient_responsible_doctors add constraint pk_patient_responsible_doctors primary key(patient_id, responsible_doctors_id);
alter table patient_responsible_fam add constraint pk_patient_responsible_fam primary key(patient_id, responsible_family_members_id);
alter table patient_prescriptions add constraint pk_patient_prescriptions primary key(patient_id, prescriptions_id);
alter table patient add constraint pk_patient_id primary key(id);
alter table doctor_prescriptions add constraint pk_doctor_prescriptions primary key(doctor_id, prescriptions_id);
alter table doctor add constraint pk_doctor_id primary key(id);
alter table prescription add constraint pk_prescription_id primary key(id);
alter table responsible_family_member add constraint pk_responsible_f_id primary key(id);

/* Foreign Key Constraints */
alter table patient_responsible_doctors add constraint fkkyu6axjssfae0h7h9ifrailpsdlo foreign key (patient_id) references patient (id);
alter table patient_responsible_doctors add constraint fk9wc7ql5p1u1leomy0gryyosulgxg foreign key (responsible_doctors_id) references doctor (id);
alter table patient_responsible_fam add constraint fksnoii5fhp46r1ccgikopbuqn9w3h foreign key (patient_id) references patient (id);
alter table patient_responsible_fam add constraint fkpedlwza6i7fs7g0i31rnovoqgbip foreign key (responsible_family_members_id) references responsible_family_member (id);
alter table patient_prescriptions add constraint fkwubw2cokacdz0s2otcs4cdh02doy foreign key (patient_id) references patient (id);
alter table patient_prescriptions add constraint fklvigjfwxqvrj5vzdhnltndwbktrk foreign key (prescriptions_id) references prescription (id);
alter table doctor_prescriptions add constraint fkubvzhmdpqwsd3mjdtaytnyloldce foreign key (doctor_id) references doctor (id);
alter table doctor_prescriptions add constraint fk6czbaxg8fgwtbxyo8mxrvlpaghwn foreign key (prescriptions_id) references prescription (id);
alter table prescription add constraint fkx7ta80iqmvheavbsopxx0xbb1hcb foreign key (doctor_responsible) references doctor (id);
alter table prescription add constraint fkgdcgch0edspdwc4xxdpabmj5b4mn foreign key (patient) references patient (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
