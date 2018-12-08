package org.boychemist

import javafx.scene.input.TransferMode
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.{Orientation, Pos}
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.input.ClipboardContent
import scalafx.scene.layout.FlowPane

object HelloDragAndDrop extends JFXApp {
  stage = new PrimaryStage {
    title = "Hello Drag and Drop"
  }

  private val source = new TextField {
    text = "Drag Me"
  }
  source.onDragDetected = { evt =>
    {
      println("source.onDragDetected")
      source.style = "-fx-background-color: red"
      /* allow any transfer mode */
      val db = source.startDragAndDrop(TransferMode.MOVE)
      /* put a string on dragboard */
      val content = new ClipboardContent()
      content.putString(source.text.toString())
      db.setContent(content)
      evt.consume()
    }
  }
  source.onDragDone = { evt =>
    {
      println("source.onDragDone")  // todo -- improve by checking that drag was from here
      /* if data was succesfully moved, clear it */
      if (evt.getTransferMode == TransferMode.MOVE) {
        source.text = ""
      }
      source.style = ""
      evt.consume()
    }
  }

  private val target = new TextField {
    text = "Drop Here"
    minWidth = 200
  }
  private val targetCSS = target.style
  target.onDragOver = { evt =>
    {
      // accept it only if it is not dragged from the same node and if it has string data
      if (evt.getGestureSource != target && evt.getDragboard.hasString) {
        // allow moving only
        evt.acceptTransferModes(TransferMode.MOVE)
      }
      evt.consume()
    }
  }
  target.onDragEntered = { evt =>
    {
      // show the user that this is a gesture target
      if (evt.getGestureSource != target && evt.getDragboard.hasString) {
        target.style = "-fx-background-color: green"
      }
    }
    evt.consume()
  }
  target.onDragExited = { evt =>
    {
      println("target.onDragExited")
      // mouse moved away, remove graphical cues
      target.style = targetCSS.toString()
    }
    evt.consume()
  }
  target.onDragDropped = { evt =>
    {
      println("target.onDragDropped")
      // if there is string data in on the dragboard, read it and use it
      val db = evt.getDragboard
      var success = false
      if (db.hasString && evt.getGestureTarget == target.delegate) {
        val dragged = new TextField(
          evt.getGestureSource.asInstanceOf[javafx.scene.control.TextField])
        target.text = dragged.text.value
        success = true
      }
      // let the source know whether the string was successfully transferred and used
      evt.setDropCompleted(success)
      evt.consume()
    }
  }

  target.onDragDone = { evt =>
    {
      println("target.onDragDone")
      // if the data was successfully moved, clear it
      // clearing source is done in source
//      val src = new TextField(
//        evt.getSource.asInstanceOf[javafx.scene.control.TextField])
      if (evt.getTransferMode == TransferMode.MOVE) {
//        src.text = ""
      }
//      src.style = ""

      evt.consume()
    }
  }
  target.onDragOver = { evt =>
    {
      // accept it only if it is not dragged from the same node and if it has string data
      if (evt.getGestureSource != target && evt.getDragboard.hasString) {
        // allow moving only
        evt.acceptTransferModes(TransferMode.MOVE)
      }
      evt.consume()
    }
  }
  target.onDragEntered = { evt =>
    {
      // show the user that this is a gesture target
      if (evt.getGestureSource != target && evt.getDragboard.hasString) {
        target.style = "-fx-background-color: green"
      }
    }
    evt.consume()
  }
  target.onDragExited = { evt =>
    {
      println("target.onDragExited")
      // mouse moved away, remove graphical cues
      target.style = targetCSS.toString()
    }
    evt.consume()
  }
  target.onDragDropped = { evt =>
    {
      println("target.onDragDropped")
      // if there is string data in on the dragboard, read it and use it
      val db = evt.getDragboard
      var success = false
      if (db.hasString && evt.getGestureTarget == target.delegate) {
        val dragged = new TextField(
          evt.getGestureSource.asInstanceOf[javafx.scene.control.TextField])
        target.text = dragged.text.value
        success = true
      }
      // let the source know whether the string was successfully transferred and used
      evt.setDropCompleted(success)
      evt.consume()
    }
  }

  target.onDragDone = { evt =>
    {
      println("target.onDragDone")
      // if the data was successfully moved, clear it
      if (evt.getTransferMode == TransferMode.MOVE) {
        // clearing source is done in source
//        val src = new TextField(
//          evt.getSource.asInstanceOf[javafx.scene.control.TextField])
//        src.text = ""
//        src.style = ""
      }

      evt.consume()
    }
  }

  private val target2 = new TextField {
    text = "Or Drop Here"
    minWidth = 200
  }
  target2.onDragOver = { evt =>
    {
      // accept it only if it is not dragged from the same node and if it has string data
      if (evt.getGestureSource != target2.delegate && evt.getDragboard.hasString) {
        // allow moving only
        evt.acceptTransferModes(TransferMode.MOVE)
      }
      evt.consume()
    }
  }
  target2.onDragEntered = { evt =>
    {
      // show the user that this is a gesture target
      if (evt.getGestureSource != target && evt.getDragboard.hasString) {
        target2.style = "-fx-background-color: green"
      }
    }
    evt.consume()
  }
  target2.onDragExited = { evt =>
    {
      println("target2.onDragExited")
      // mouse moved away, remove graphical cues
      target2.style = targetCSS.toString()
    }
    evt.consume()
  }
  target2.onDragDropped = { evt =>
    {
      println("target.onDragDropped")
      // if there is string data in on the dragboard, read it and use it
      val db = evt.getDragboard
      var success = false
      if (db.hasString && evt.getGestureTarget == target2.delegate) {
        val dragged = new TextField(
          evt.getGestureSource.asInstanceOf[javafx.scene.control.TextField])
        target2.text = dragged.text.value
        success = true
      }
      // let the source know whether the string was successfully transferred and used
      evt.setDropCompleted(success)
      evt.consume()
    }
  }

  target2.onDragDone = { evt =>
    {
      println("target2.onDragDone")
      // if the data was successfully moved, clear it
      if (evt.getTransferMode == TransferMode.MOVE) {
        val src = new TextField(
          evt.getSource.asInstanceOf[javafx.scene.control.TextField])
//      src.text = ""
//      src.style = ""
      }

      evt.consume()
    }
  }
  target2.onDragOver = { evt =>
    {
      // accept it only if it is not dragged from the same node and if it has string data
      if (evt.getGestureSource != target2 && evt.getDragboard.hasString) {
        // allow moving only
        evt.acceptTransferModes(TransferMode.MOVE)
      }
      evt.consume()
    }
  }
  target2.onDragEntered = { evt =>
    {
      // show the user that this is a gesture target
      if (evt.getGestureSource != target2.delegate && evt.getDragboard.hasString) {
        target2.style = "-fx-background-color: green"
      }
    }
    evt.consume()
  }
  target2.onDragExited = { evt =>
    {
      println("target.onDragExited")
      // mouse moved away, remove graphical cues
      target2.style = targetCSS.toString()
    }
    evt.consume()
  }
  target2.onDragDropped = { evt =>
    {
      println("target.onDragDropped")
      // if there is string data in on the dragboard, read it and use it
      val db = evt.getDragboard
      var success = false
      if (db.hasString && evt.getGestureTarget == target2.delegate) {
        val dragged = new TextField(
          evt.getGestureSource.asInstanceOf[javafx.scene.control.TextField])
        target2.text = dragged.text.value
        success = true
      }
      // let the source know whether the string was successfully transferred and used
      evt.setDropCompleted(success)
      evt.consume()
    }
  }

  target2.onDragDone = { evt =>
    {
      println("target2.onDragDone")
      // if the data was successfully moved, clear it
      if (evt.getTransferMode == TransferMode.MOVE) {
        // clearing source is done in source
//        val src = new TextField(
//          evt.getSource.asInstanceOf[javafx.scene.control.TextField])
//        src.text = ""
//        src.style = ""
      }

      evt.consume()
    }
  }

  stage.scene = new Scene (250, 300) {
    root = new FlowPane(Orientation.Vertical, 50, 50) {
      alignment = Pos.Center
      children = List(source, target, target2)
    }
  }
}
