const express = require("express")

const terreController = require("../controllers/terre.controller")
const router = express.Router();

router.get("/liste", terreController.listeTerre)
module.exports = router;
