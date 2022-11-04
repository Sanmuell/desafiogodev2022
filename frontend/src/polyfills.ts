import "core-js/es";
import "core-js/es/reflect";
import "zone.js/dist/zone";
import "core-js/es/array";
(window as any).global = window;
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

// Necessary for IE10
Object.setPrototypeOf =
    Object.setPrototypeOf ||
    function(obj, proto) {
        obj.__proto__ = proto;
        return obj;
    };

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
