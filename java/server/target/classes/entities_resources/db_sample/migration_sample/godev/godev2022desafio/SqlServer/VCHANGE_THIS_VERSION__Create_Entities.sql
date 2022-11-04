/* Database: SqlServer. Generation date: 2022-10-19 08:58:14:335 */
/* Entity Patient */
create table patient (
	id UNIQUEIDENTIFIER NOT NULL,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255),
	address VARCHAR(255) NOT NULL,
	phone NUMERIC(19) NOT NULL,
	is_ativo BIT /* isAtivo */,
	ext VARCHAR(4000)
);


/* Creating index for customization column */
/* column type JSON not supported */

/* Entity Doctor */
create table doctor (
	id UNIQUEIDENTIFIER NOT NULL,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255) NOT NULL,
	crm_number NUMERIC(19) NOT NULL /* crmNumber */,
	crm_state VARCHAR(255) NOT NULL /* crmState */,
	especiality VARCHAR(255) NOT NULL,
	ext VARCHAR(4000)
);


/* Creating index for customization column */
/* column type JSON not supported */

/* Entity Prescription */
create table prescription (
	id UNIQUEIDENTIFIER NOT NULL,
	drug VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	data DATE NOT NULL,
	doctor_responsible UNIQUEIDENTIFIER /* doctorResponsible */,
	type VARCHAR(255) NOT NULL,
	statement_of_reponsability BIT /* statementOfReponsability */,
	patient UNIQUEIDENTIFIER,
	ext VARCHAR(4000)
);


/* Creating index for customization column */
/* column type JSON not supported */

/* Entity ResponsibleFamilyMember */
create table responsible_family_member (
	id UNIQUEIDENTIFIER NOT NULL,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255) NOT NULL,
	kinship VARCHAR(255),
	ext VARCHAR(4000)
);


/* Creating index for customization column */
/* column type JSON not supported */

/* Join Tables */
/* master: Patient as patient, detail: Doctor as doctor */
create table patient_responsible_doctors (
	patient_id UNIQUEIDENTIFIER NOT NULL,
	responsible_doctors_id UNIQUEIDENTIFIER NOT NULL
);

/* master: Patient as patient, detail: ResponsibleFamilyMember as responsible_family_member */
create table patient_responsible_fam (
	patient_id UNIQUEIDENTIFIER NOT NULL,
	responsible_family_members_id UNIQUEIDENTIFIER NOT NULL
);

/* master: Patient as patient, detail: Prescription as prescription */
create table patient_prescriptions (
	patient_id UNIQUEIDENTIFIER NOT NULL,
	prescriptions_id UNIQUEIDENTIFIER NOT NULL
);

/* master: Doctor as doctor, detail: Prescription as prescription */
create table doctor_prescriptions (
	doctor_id UNIQUEIDENTIFIER NOT NULL,
	prescriptions_id UNIQUEIDENTIFIER NOT NULL
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
alter table patient_responsible_doctors add constraint fkg0wxby8ezinmowgawpv6evwgufac foreign key (patient_id) references patient (id);
alter table patient_responsible_doctors add constraint fkmiowbfnflniwlf8gctngqhudiy0k foreign key (responsible_doctors_id) references doctor (id);
alter table patient_responsible_fam add constraint fkmlun6swjw3nwukxjrjxpphgykkfv foreign key (patient_id) references patient (id);
alter table patient_responsible_fam add constraint fkxsvfgtznfq4uefya3hnjvntxdxnk foreign key (responsible_family_members_id) references responsible_family_member (id);
alter table patient_prescriptions add constraint fkwgj0h9xaiew1574bvizgje3ptvka foreign key (patient_id) references patient (id);
alter table patient_prescriptions add constraint fkrctdfgymcn7e9h86t8mqqcqxgqbh foreign key (prescriptions_id) references prescription (id);
alter table doctor_prescriptions add constraint fk6jlanqhqcl6t8x3bgsb339xembcc foreign key (doctor_id) references doctor (id);
alter table doctor_prescriptions add constraint fkmw6ytadti2xuczslxwbjp8hppjye foreign key (prescriptions_id) references prescription (id);
alter table prescription add constraint fk2xxeele9nqgavnukezj2nlbjdqtw foreign key (doctor_responsible) references doctor (id);
alter table prescription add constraint fkkd5gilmadkynuvqxqbzta3xbq58n foreign key (patient) references patient (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
