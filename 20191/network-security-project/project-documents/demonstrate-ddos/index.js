const http = require("http");
const fs = require("fs");
http
  .createServer(function(req, res) {
    let data = fs.readFileSync("data.json", "utf8");
    let datajson = JSON.parse(data);
    console.log(datajson);
    datajson.counter += 1;
    data = JSON.stringify(datajson);
    fs.writeFileSync("data.json", data, "utf8");
    res.end("Hello world");
  })
  .listen(8080);
console.log(`app listen at 8080`);
