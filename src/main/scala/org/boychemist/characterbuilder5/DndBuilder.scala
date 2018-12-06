package org.boychemist.characterbuilder5

import org.boychemist.characterbuilder5.dbInterface.CharacterDatabaseConnection
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.Includes.handle
import ui.BuilderUI

object DndBuilder extends JFXApp {

//  val db = Database.forURL("jdbc:h2:~/character5",
//                           "sa",
//                           keepAliveConnection = true,
//                           driver = "org.h2.Driver")
  CharacterDatabaseConnection.connectToDB("jdbc:h2:~/character5")

  stage = new PrimaryStage {
    title = "Dungeons and Dragons V5 Character Builder"
    onCloseRequest = handle {
      CharacterDatabaseConnection.close()
    }
  }
  val uiBuilder = new BuilderUI(stage)
}
