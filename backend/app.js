const express = require("express");
const bodyParser = require("body-parser");
const mongoose = require("mongoose");
const db = require("./configs/db.config")
const utilisateurRoutes = require("./routes/utilisateur.routes");
const restaurantRoutes = require("./routes/restaurant.routes");
const platRoutes = require("./routes/plat.routes");
const commandeRoutes = require("./routes/commande.routes");
const recitationRoutes = require("./routes/recitation.routes");
// const uploadRoutes = require("./routes/upload.routes");
// const Commandes = require("./models/commande.model")
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
app.use("/api/restaurant", restaurantRoutes);
app.use("/api/plat", platRoutes);
app.use("/api/commande", commandeRoutes);
app.use("/api/recitation", recitationRoutes);
module.exports = app;
