/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import * as project from "~root/package.json";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export const environment: any = {
    version: (project as any).version,
    name: (project as any).name,
    project: (project as any).project,
    production: false,
    ignorePermissions: false,
    /*{CA:ENV:START}*/
    /*{CA:ENV:END}*/
};

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
