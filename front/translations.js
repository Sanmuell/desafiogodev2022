const fs = require("fs");
const fallback = require("./src/locale/pt-BR.json");
const translationPath = "src/locale/fallback.ts";

fs.writeFile(
    `${translationPath}`,
    `export const fallback: any = ${JSON.stringify(fallback, null, 4)};
`,
    err => err && console.error(`Error writing file ${translationPath}: ${err}`)
);
