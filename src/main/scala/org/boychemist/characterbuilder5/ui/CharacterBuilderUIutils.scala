package org.boychemist.characterbuilder5.ui

import javafx.scene.layout.{Border => JBorder, BorderStroke => JBorderStroke, BorderStrokeStyle => JBorderStrokeStyle, CornerRadii => JCornerRadii}
import javafx.scene.paint.Color
import javafx.scene.input.TransferMode
import scalafx.geometry.Pos
import scalafx.scene.control.{Label, TextArea, TextField}
import scalafx.scene.input.ClipboardContent
import scalafx.scene.layout._
import scalafx.scene.text.{Font, FontWeight}

import scala.collection.mutable.ArrayBuffer

object CharacterBuilderUIutils {

  private var border: Border = _

  def getBorder:Border = {
    if (border == null) {
      val strokes = new ArrayBuffer[JBorderStroke]
      strokes += new JBorderStroke(Color.SKYBLUE, JBorderStrokeStyle.SOLID,
        JCornerRadii.EMPTY, JBorderStroke.THICK)
      strokes += new JBorderStroke(Color.SKYBLUE, JBorderStrokeStyle.SOLID,
        JCornerRadii.EMPTY, JBorderStroke.THICK)
      strokes += new JBorderStroke(Color.SKYBLUE, JBorderStrokeStyle.SOLID,
        JCornerRadii.EMPTY, JBorderStroke.THICK)
      strokes += new JBorderStroke(Color.SKYBLUE, JBorderStrokeStyle.SOLID,
        JCornerRadii.EMPTY, JBorderStroke.THICK)
      border = new Border(new JBorder(strokes:_*))
    }
    border
  }

  def enhancedLabel(text: String): Label = {
    val aLabel = new Label(text + " ") {
      font = Font.font("Sans Serif", FontWeight.Bold, 12)
    }
    aLabel
  }

  /**
    * Create a 4 column GridPane where each column take 25% of the width of the pane
    * @return
    */
  def wideGrid4(): GridPane = {
    val col1Constraints = new ColumnConstraints {
      percentWidth = 25
    }
    val col2Constraints = new ColumnConstraints {
      percentWidth = 25
    }
    val col3Constraints = new ColumnConstraints {
      percentWidth = 25
    }
    val col4Constraints = new ColumnConstraints {
      percentWidth = 25
    }
    val theGrid = new GridPane() {
      columnConstraints =
        List(col1Constraints, col2Constraints, col3Constraints, col4Constraints)
      minWidth = 700
      maxWidth = 1000
      minHeight = 650
    }
    theGrid.style = "-fx-background-color: skyblue"
    theGrid.vgap = 2

    theGrid
  }

  def wideTextArea(theText: String): TextArea = {
    val textArea = new TextArea() {
      text = theText
      editable = false
      maxWidth = 500
      maxHeight = 75
      minHeight = 50
      wrapText = true
    }
    textArea
  }

  def variableTextArea(theText: String,
                       labelWidth: Int,
                       labelHeight: Int): TextArea = {
    val textArea = new TextArea() {
      text = theText
      editable = false
      maxWidth = labelWidth
      maxHeight = labelHeight
      wrapText = true
    }
    textArea
  }

  def easyTextField(theText: String, fieldWidth: Int = 30): TextField = {

    val textField = new TextField {
      text = theText
      maxWidth = fieldWidth
      editable = false
    }

    textField
  }

  def add3ColTextArea(grid: GridPane,
                      rowNum: Int,
                      theText: String,
                      startCol: Int = 1): Unit = {
    val area = wideTextArea(theText)
    grid.add(area, startCol, rowNum, 3, 1)
  }

  def levelAndName(level: Int, name: String): VBox = {
    val theBox = new VBox {
      spacing = 4
      children = List(
        enhancedLabel("Level " + level),
        enhancedLabel(name)
      )
    }
    theBox
  }

  def integerTextField(defWidth: Double = 30): TextField = {
    val intField = new TextField {
      maxWidth = defWidth
      maxHeight = Region.USE_COMPUTED_SIZE
    }
    intField.text.onChange((_, _, newVal) =>
      if (!newVal.toString.matches("""\d*""""))
        intField.text = newVal.toString.replaceAll("""[^\d]""", ""))

    intField
  }

  /**
    * Create a TextField that can be either the source or destination of drag
    * and drop actions.  It will only act as the target of a drag if the field
    * is empty and will only act as the source of a drag if it is not empty.
    *
    * @param initialText initial text for the field, default to empty string
    * @param defWidth width for the field, default is for small integers
    * @return the new TextField with all the necessary event handlers
    */
  def dragToIfEmptyTextField(initialText: String = "", defWidth: Double = 30): TextField = {
    val theField = new TextField {
      maxWidth = defWidth
      minWidth = defWidth
      text = initialText
    }

    theField.onDragDetected = { evt => {
      if (!theField.text.isEmpty.getValue) {
        // field has something to drag, show it is ready to drag
        theField.style = "-fx-background-color: red"
        val db = theField.startDragAndDrop(TransferMode.MOVE)
        val content = new ClipboardContent()
        content.putString(theField.text.value)
        db.setContent(content)
      }
      evt.consume()
    }
    }
    theField.onDragDone = { evt => {
      // this is where the drag started, clear the color and the content
      if (evt.getGestureSource == theField.delegate) {
        if (evt.getTransferMode == TransferMode.MOVE) {
          theField.text = "" // only clear the text if transfer successful
        }
        theField.style = ""
      }
      theField.style = ""
      evt.consume()
    }
    }
    theField.onDragOver = { evt => {
      // accept it only if it is not dragged from the same node, this field is
      // empty, and if the event has string data
      if (evt.getGestureSource != theField.delegate && evt.getDragboard.hasString &&
        theField.text.isEmpty.getValue) {
        // allow moving only
        evt.acceptTransferModes(TransferMode.MOVE)
      }
      evt.consume()
    }
    }
    theField.onDragEntered = { evt => {
      // show the user that this is a gesture target
      if (evt.getGestureSource != theField.delegate && evt.getDragboard.hasString &&
        theField.text.isEmpty.getValue) {
        theField.style = "-fx-background-color: green"
      }
      evt.consume()
    }
    }
    theField.onDragExited = { evt => {
      // mouse moved away, remove graphical cues
      theField.style = ""
      evt.consume()
    }
    }
    theField.onDragDropped = { evt => {
      val db = evt.getDragboard
      var success = false
      if (db.hasString && evt.getGestureTarget == theField.delegate) {
        val dragged = new TextField(
          evt.getGestureSource.asInstanceOf[javafx.scene.control.TextField])
        theField.text = dragged.text.value
        success = true
        theField.style = ""
      }
      // let the source know whether the string was successfully transferred and used
      evt.setDropCompleted(success)
      evt.consume()
    }
    }

    // value to return
    theField
  }

  /**
    * Create a TextField that will act as the destination of a drag.  Any value in the
    * field will be replaced with the dragged value.  The field only accept COPY mode
    * drag and drop.
    */
  def dragCopyToField(initialText: String = "", defWidth: Double = 60): TextField = {
    val theField = new TextField {
      maxWidth = defWidth
      minWidth = defWidth
      editable = false
      text = initialText
      alignment = Pos.Center
    }

    theField.onDragOver = { evt => {
      // accept it only if it is not dragged from the same node, this field is
      // empty, and if the event has string data
      if (evt.getGestureSource != theField.delegate && evt.getDragboard.hasString) {
        // allow copy only
        evt.acceptTransferModes(TransferMode.COPY)
      }
      evt.consume()
    }
    }

    theField.onDragDropped = { evt => {
      val db = evt.getDragboard
      var success = false
      if (db.hasString && evt.getGestureTarget == theField.delegate) {
        val dragged = new TextField(
          evt.getGestureSource.asInstanceOf[javafx.scene.control.TextField])
        theField.text = dragged.text.value
        success = true
      }
      // let the source know whether the string was successfully transferred and used
      evt.setDropCompleted(success)
      evt.consume()
    }
    }

    theField
  }

  /**
    * Create a TextField that will act as the source of a drag.  The field only performs COPY mode
    * drag and drop.
    */
  def dragCopyFromField(initialText: String, defWidth: Double = 60): TextField = {
    val theField = new TextField {
      maxWidth = defWidth
      minWidth = defWidth
      text = initialText
      editable = false
      alignment = Pos.Center
    }

    theField.onDragDetected = { evt => {
      if (!theField.text.isEmpty.getValue) {
        val db = theField.startDragAndDrop(TransferMode.COPY)
        val content = new ClipboardContent()
        content.putString(theField.text.value)
        db.setContent(content)
      }
      evt.consume()
    }
    }

    theField
  }
}
