/* Database: PostgreSql. Generation date: 2022-10-19 08:58:14:321 */
/* Entity Patient */
create table patient (
	id UUID NOT NULL,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255),
	address VARCHAR(255) NOT NULL,
	phone NUMERIC(19) NOT NULL,
	is_ativo BOOLEAN /* isAtivo */,
	ext JSONB
);


/* Creating index for customization column */
create index patient_ext on patient using gin (ext);

/* Entity Doctor */
create table doctor (
	id UUID NOT NULL,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255) NOT NULL,
	crm_number NUMERIC(19) NOT NULL /* crmNumber */,
	crm_state VARCHAR(255) NOT NULL /* crmState */,
	especiality VARCHAR(255) NOT NULL,
	ext JSONB
);


/* Creating index for customization column */
create index doctor_ext on doctor using gin (ext);

/* Entity Prescription */
create table prescription (
	id UUID NOT NULL,
	drug VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	data DATE NOT NULL,
	doctor_responsible UUID /* doctorResponsible */,
	type VARCHAR(255) NOT NULL,
	statement_of_reponsability BOOLEAN /* statementOfReponsability */,
	patient UUID,
	ext JSONB
);


/* Creating index for customization column */
create index prescription_ext on prescription using gin (ext);

/* Entity ResponsibleFamilyMember */
create table responsible_family_member (
	id UUID NOT NULL,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255) NOT NULL,
	kinship VARCHAR(255),
	ext JSONB
);


/* Creating index for customization column */
create index responsible_family_member_ext on responsible_family_member using gin (ext);

/* Join Tables */
/* master: Patient as patient, detail: Doctor as doctor */
create table patient_responsible_doctors (
	patient_id UUID NOT NULL,
	responsible_doctors_id UUID NOT NULL
);

/* master: Patient as patient, detail: ResponsibleFamilyMember as responsible_family_member */
create table patient_responsible_fam (
	patient_id UUID NOT NULL,
	responsible_family_members_id UUID NOT NULL
);

/* master: Patient as patient, detail: Prescription as prescription */
create table patient_prescriptions (
	patient_id UUID NOT NULL,
	prescriptions_id UUID NOT NULL
);

/* master: Doctor as doctor, detail: Prescription as prescription */
create table doctor_prescriptions (
	doctor_id UUID NOT NULL,
	prescriptions_id UUID NOT NULL
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
alter table patient_responsible_doctors add constraint fkfhicswsqfsqnpyocsplv2kpvglij foreign key (patient_id) references patient (id);
alter table patient_responsible_doctors add constraint fkr4ivzimybbzf9r993jxme4rmgbpm foreign key (responsible_doctors_id) references doctor (id);
alter table patient_responsible_fam add constraint fkqol5uzzcicucdjvgufsw584gmm8c foreign key (patient_id) references patient (id);
alter table patient_responsible_fam add constraint fk2cxjzxa9a34mcci64u23zrn74px9 foreign key (responsible_family_members_id) references responsible_family_member (id);
alter table patient_prescriptions add constraint fk79nhcmpbpna5hqofl9qkb9rzp1iv foreign key (patient_id) references patient (id);
alter table patient_prescriptions add constraint fkotg1qqdgr0vrkeqvvwhyryszzkxh foreign key (prescriptions_id) references prescription (id);
alter table doctor_prescriptions add constraint fknzy7rin6obkrirbhxo86dw5eblzy foreign key (doctor_id) references doctor (id);
alter table doctor_prescriptions add constraint fki339cqd3mrsulyaoxurfuqr3nxes foreign key (prescriptions_id) references prescription (id);
alter table prescription add constraint fkk2h55i1pm4k3xee3sr9stdg1cuxx foreign key (doctor_responsible) references doctor (id);
alter table prescription add constraint fkphc5cvd3omaxwq2px0f4jpnr4rma foreign key (patient) references patient (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
