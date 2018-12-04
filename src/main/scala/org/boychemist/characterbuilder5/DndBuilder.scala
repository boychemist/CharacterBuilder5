package org.boychemist.characterbuilder5

import slick.jdbc.JdbcBackend.Database
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import ui.BuilderUI

object DndBuilder extends JFXApp {

  val db = Database.forURL("jdbc:h2:~/character5",
                           "sa",
                           keepAliveConnection = true,
                           driver = "org.h2.Driver")

  stage = new PrimaryStage {
    title = "Dungeons and Dragons V5 Character Builder"
  }
  val uiBuilder = new BuilderUI(db, stage)
}
