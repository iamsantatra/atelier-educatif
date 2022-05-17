const express = require("express");
const bodyParser = require("body-parser");
const mongoose = require("mongoose");
const db = require("./configs/db.config")
const utilisateurRoutes = require("./routes/utilisateur.routes");
const recitationRoutes = require("./routes/recitation.routes");
const terreRoutes = require("./routes/terre.routes");
path = require('path')


const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
mongoose.connect(db.url)
  .then(() => {
    console.log('Connected to database!')
  })
  .catch((error) => {
    console.log('Connection failed!')
    console.log(error)
  })

app.use((req, res, next) => {
  res.setHeader("Access-Control-Allow-Origin", "*");
  res.setHeader(
    "Access-Control-Allow-Headers",
    "Origin, X-Requested-With, Content-Type, Accept, Authorization"
  );
  res.setHeader(
    "Access-Control-Allow-Methods",
    "GET, POST, PATCH, PUT, DELETE, OPTIONS"
  );
  next();
});

app.use("/api/utilisateur", utilisateurRoutes);
app.use("/api/recitation", recitationRoutes);
app.use("/api/terre", terreRoutes);
module.exports = app;
