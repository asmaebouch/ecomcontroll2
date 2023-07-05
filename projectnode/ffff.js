/** saans express var http=require("http");
//jee vaiss demarrer un seerveur http
var url=require('url');
var queryString=require("querystring");
var httpServer=http.createServer(function (req,resp) {
 console.log(url.parse(req.url).path);
 query=url.parse(req.url).query;
 params=queryString.parse(query);
 nom=params['nom'];
 // le nom et undifined =manque query=rul .parse
    //parsse devient un objeet js
 //books et /faavicon.ico
 //  resp.status(200);
    resp.writeHead(200,{'content-type':'text/html'});
    resp.end("<h2>Bonjour Mm  "+nom+"</h2>");

});
httpServer.listen(8889,function (){
    console.log("Node server started");
})
//on lui donner des calback
**/
// avec express
var express = require("express");
var app= express();
//pour la geestion des routee
app.get("/", (req,resp)=>{
    resp.setHeader("content-type","text/html");
    resp.send("<h3>  hello Express</h3>");
});
app.get("/books/:code",(req,resp)=>{
    resp.setHeader("content-type","application/json");
    var info={
        name:"med",email:"meed@smee.net",code:req.params.code
    }
    resp.send(JSON.stringify(info));
});
app.listen(7000,()=>{
    console.log("Server started");
})
