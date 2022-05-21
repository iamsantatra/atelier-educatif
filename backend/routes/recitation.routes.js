const express = require("express")

const recitationController = require("../controllers/recitation.controller")
const router = express.Router();

router.get("/liste", recitationController.listeRecitation)
router.get("/liste-youtube", recitationController.listeYoutube)
router.get("/detail/:lien", recitationController.detailRecitation)
module.exports = router;
