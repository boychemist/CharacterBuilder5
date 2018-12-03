package org.boychemist.characterbuilder5.ui

import java.util.concurrent

import scalafx.Includes._
import scalafx.application.Platform
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ScrollPane}
import scalafx.scene.layout.BorderPane
import scalafx.stage.{Modality, Stage}

object FXUtils {

  /**
    * Run operation `op` on FX application thread and wait for completion.
    * If the current thread is the FX application, the operation will be run on it.
    *
    * @param op operation to be performed.
    */
  def onFXAndWait[R](op: => R): R = {
    if (Platform.isFxApplicationThread) {
      op
    } else {
      val callable = new concurrent.Callable[R] {
        override def call(): R = op
      }
      val future = new concurrent.FutureTask(callable)
      Platform.runLater(future)
      future.get()
    }
  }

  def showDialogPane(specType: String, rootNode: ScrollPane) = {
    val dialogStage = new Stage {
      outer =>
      title = specType
      initModality(Modality.ApplicationModal)
      scene = new Scene {
        root = new BorderPane {
          padding = Insets(5)
          center = rootNode
          minHeight = rootNode.width.toDouble + 20.0
          minWidth = rootNode.height.toDouble + 20.0
        }
      }
    }
    // Show dialog and wait till it is closed
    dialogStage.showAndWait()
  }

  /** Show a `message` in a dialog box, wait till dialog is closed */
  def showInDialog(message: String) {
    // Create dialog
    val dialogStage = new Stage {
      outer =>
      title = "Stand-Alone Dialog - runAndWait"
      initModality(Modality.ApplicationModal)
      scene = new Scene {
        root = new BorderPane {
          padding = Insets(25)
          bottom = new Button {
            text = message
            onAction = handle {
              outer.close()
            }
          }
        }
      }
    }

    // Show dialog and wait till it is closed
    dialogStage.showAndWait()


  }
}
