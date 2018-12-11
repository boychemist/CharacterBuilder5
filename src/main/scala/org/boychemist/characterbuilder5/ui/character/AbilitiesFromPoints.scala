package org.boychemist.characterbuilder5.ui.character

import scalafx.scene.control.{ScrollPane, Spinner, TextArea, TextField}
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.scene.layout.{GridPane, HBox}

import scala.collection.immutable.TreeMap

/**
  * Create a dialog panel to set character abilities from a fixed number of points.
  */
object AbilitiesFromPoints {

  private val points = integerTextField()

  val abilityCostMap: Map[Int, Int] = TreeMap(8 -> 0, 9 -> 1, 10 -> 2, 11 -> 3, 12 -> 4, 13 -> 5, 14 -> 7, 15 -> 9)
  val maxPointsToSpend: Int = 27


  private def calculatePointChange(oldVal: Int, newVal: Int): Int = abilityCostMap(newVal) - abilityCostMap(oldVal)

  private def createSpinner(dependent: TextField): Spinner[Int] = {
    val theSpinner = new Spinner[Int](8, 15, 8) {
      maxWidth = 60
    }
    val spinVal: ReadOnlyObjectProperty[Int] = theSpinner.value
    spinVal.onChange((_, oldVal: Int, newVal: Int) => {
      val userData = theSpinner.userData
      val pointsVal = points.text.value.toInt
      val change = calculatePointChange(oldVal, newVal)
      if (change > pointsVal) {
        theSpinner.userData = oldVal.asInstanceOf[AnyRef]
        theSpinner.valueFactory.value.setValue(oldVal)
      } else if (pointsVal != 0 && userData != null && change < 0) {
        theSpinner.userData = null // provide a no spinner value change action for rejecting a change using a change
      } else if (pointsVal != 0) {
        points.text = (pointsVal - change).toString
        dependent.text = newVal.toString
      } else if (pointsVal == 0 && userData.asInstanceOf[Int] != newVal) {
        points.text = (pointsVal - change).toString
        dependent.text = newVal.toString
      }
    })
    theSpinner
  }

  def abilitiesFromPointsPanel: ScrollPane = {
    val spinGrid = new GridPane {
      maxWidth = 200
      prefWidth = 150
      maxHeight = 700
    }
    var rowNum = 0

    spinGrid.add(enhancedLabel("Adjust Values"),0, rowNum, 2, 1)
    rowNum += 1

    spinGrid.addRow(rowNum, enhancedLabel("Strength"), createSpinner(NewCharacterUI.LeftSide.strength))
    rowNum += 1

    spinGrid.addRow(rowNum, enhancedLabel("Constitution"), createSpinner(NewCharacterUI.LeftSide.constitution))
    rowNum += 1

    spinGrid.addRow(rowNum, enhancedLabel("Dexterity"), createSpinner(NewCharacterUI.LeftSide.dexterity))
    rowNum += 1

    spinGrid.addRow(rowNum, enhancedLabel("Intelligence"), createSpinner(NewCharacterUI.LeftSide.intelligence))
    rowNum += 1

    spinGrid.addRow(rowNum, enhancedLabel("Wisdom"), createSpinner(NewCharacterUI.LeftSide.wisdom))
    rowNum += 1

    spinGrid.addRow(rowNum, enhancedLabel("Charisma"), createSpinner(NewCharacterUI.LeftSide.charisma))

    val pointsGrid = new GridPane {
      maxWidth = 200
      prefWidth = 150
      maxHeight = 700
    }
    var pRowNum = 0

    points.text = maxPointsToSpend.toString
    pointsGrid.addRow(pRowNum, enhancedLabel("Points Remaining  "), points)
    pRowNum += 1

    val keys = abilityCostMap.keys
    val keyCostString = new StringBuilder
    keyCostString.append("Ability Score Costs\nScore\tCost")
    val keyIter = keys.iterator
    while (keyIter.hasNext) {
      val score = keyIter.next()
      keyCostString.append (s"\n  $score\t\t   ${abilityCostMap(score)}")
    }
    pointsGrid.add(new TextArea(keyCostString.mkString){maxWidth = 150}, 0, rowNum, 2, 1)

    val theBox = new HBox()
    {
      children = List(spinGrid, pointsGrid)
    }

    new ScrollPane {
      style = "-fx-background-color: cyan"
      content = theBox
    }
  }

}
