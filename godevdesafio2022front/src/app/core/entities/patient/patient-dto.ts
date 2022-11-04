/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export interface PatientDto {
    id?: string;
    name: string;
    cpf?: string;
    address: string;
    phone: number;
    responsibleDoctors?: any[];
    responsibleFamilyMembers?: any[];
    prescriptions?: any[];
    isAtivo?: boolean;
    custom?: any;
    /*{CA:INTERFACE_ATTRIBUTES:START}*/
    /*{CA:INTERFACE_ATTRIBUTES:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
