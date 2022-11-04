
/* Entity Patient */
create table patient (
	id UUID,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	phone NUMERIC(19) NOT NULL,
	is_ativo BOOLEAN /* isAtivo */,
	ext JSONB
);


/* Creating index for customization column */
create index patient_ext on patient using gin (ext);

/* Entity Doctor */
create table doctor (
	id UUID,
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
	id UUID,
	drug VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	data DATE NOT NULL,
	doctor_responsible UUID /* doctorResponsible */,
	type VARCHAR(255) NOT NULL,
	ext JSONB
);


/* Creating index for customization column */
create index prescription_ext on prescription using gin (ext);

/* Entity ResponsibleFamilyMember */
create table responsible_family_member (
	id UUID,
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
	patient_id UUID,
	responsible_doctors_id UUID
);

/* master: Patient as patient, detail: ResponsibleFamilyMember as responsible_family_member */
create table patient_responsible_fam (
	patient_id UUID,
	responsible_family_members_id UUID
);

/* master: Patient as patient, detail: Prescription as prescription */
create table patient_prescriptions (
	patient_id UUID,
	prescriptions_id UUID
);

/* master: Doctor as doctor, detail: Prescription as prescription */
create table doctor_prescriptions (
	doctor_id UUID,
	prescriptions_id UUID
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
alter table patient_responsible_doctors add constraint fk6m0y4wjwdrf3xpiuzraukjspnsre foreign key (patient_id) references patient (id);
alter table patient_responsible_doctors add constraint fkvnqzu341fdi3o1jgj3nt4f21qg8p foreign key (responsible_doctors_id) references doctor (id);
alter table patient_responsible_fam add constraint fkzbxslzdjzypsixarhixjjnh5zdpj foreign key (patient_id) references patient (id);
alter table patient_responsible_fam add constraint fkvmho2c8iqgkqlnoibpivtlkv6cd5 foreign key (responsible_family_members_id) references responsible_family_member (id);
alter table patient_prescriptions add constraint fkfic02lf7s2p3giseqsimmokbzvg2 foreign key (patient_id) references patient (id);
alter table patient_prescriptions add constraint fkzmjwcfxagroaou5udpb1tdicmeuw foreign key (prescriptions_id) references prescription (id);
alter table doctor_prescriptions add constraint fkgauhvevc3yks4qa4suu4mmb8fpkd foreign key (doctor_id) references doctor (id);
alter table doctor_prescriptions add constraint fkhxlr0ss0yfak2dtghekqctdpxkjt foreign key (prescriptions_id) references prescription (id);
alter table prescription add constraint fk1mqoepfatbu79iuw0qsctt5fhocj foreign key (doctor_responsible) references doctor (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
