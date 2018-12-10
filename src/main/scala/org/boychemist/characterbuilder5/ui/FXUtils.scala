package org.boychemist.characterbuilder5.ui

import java.util.concurrent

import scalafx.application.Platform
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ScrollPane}
import scalafx.scene.layout.BorderPane
import scalafx.stage.{Modality, Stage, StageStyle}
import scalafx.Includes.handle

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

  def showDialogPane(dialogTitle: String, rootNode: ScrollPane): Unit = {
    val dialogStage = new Stage {
      outer =>
      initStyle(StageStyle.Undecorated)
      title = dialogTitle
      initModality(Modality.ApplicationModal)
      scene = new Scene {
        root = new BorderPane {
          padding = Insets(5)
          center = rootNode
          bottom = new Button("Close") {
            onAction = handle{outer.close}
          }
          minHeight = rootNode.width.toDouble + 20.0
          minWidth = rootNode.height.toDouble + 20.0
        }
      }
    }
    // Show dialog and wait till it is closed
    dialogStage.showAndWait()
  }
}
