const os = require("os");
const cli = require("@angular/cli").default;

const HOST = `${os.hostname().toLowerCase()}.interno.senior.com.br`;
cli({ cliArgs: ["serve", "--open", "--host", HOST, "--publicHost", HOST, "--port", "0", ...process.argv.slice(2)] });
