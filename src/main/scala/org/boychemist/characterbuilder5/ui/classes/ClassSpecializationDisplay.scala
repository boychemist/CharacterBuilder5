package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.geometry.Pos
import scalafx.scene.control._
import scalafx.scene.layout.{GridPane, HBox}
import scalafx.scene.text.{Font, FontWeight}
import slick.jdbc.JdbcBackend.Database

object ClassSpecializationDisplay {

  def buildSpecializationGrid(db: Database, specName: String): ScrollPane = {
    val specGrid = new GridPane {
      minWidth = 730
      maxWidth = 1000
      minHeight = 700
      maxHeight = 1000
    }
    specGrid.style = "-fx-background-color: skyblue"
    specGrid.vgap = 2

    val specNameLabel = new Label(specName) {
      font = Font.font("Sans Serif", FontWeight.Bold, 14)
    }
    val centeredBox = new HBox {
      alignment = Pos.Center
      children = specNameLabel
    }

    val classInfo = DbClassInfo.getSpecializationDataByName(db, specName)
    val specId: Int = classInfo.head._1
    val description: String = classInfo.head._2
    var rowNum = 0

    specGrid.add(centeredBox, 0, rowNum, 3, 1)
    rowNum += 1

    val specDescArea = variableTextArea(description, 400, 300)
    specGrid.add(specDescArea, 1, rowNum, 2, 1)
    rowNum += 1

    // add a blank row
    specGrid.addRow(rowNum, enhancedLabel(" "))
    rowNum += 1

    specGrid.addRow(rowNum,
      enhancedLabel("Class Level"),
      enhancedLabel("    Name"),
      enhancedLabel("Description"))
    rowNum += 1

    val specializationFeatures =
      DbClassInfo.getSpecilalizationFeaturesBySpecID(db, specId)
    val specFeaturesIter = specializationFeatures.iterator
    while (specFeaturesIter.hasNext) {
      val featureInfo = specFeaturesIter.next()
      val featureLevel = enhancedLabel(featureInfo.level.toString)
      val featureName = enhancedLabel(featureInfo.name)
      val featureDescription =
        variableTextArea(featureInfo.description, 350, 105)
      specGrid.addRow(rowNum, featureLevel, featureName, featureDescription)
      rowNum += 1
    }
    // add a blank row
    specGrid.addRow(rowNum, enhancedLabel(" "))
    rowNum += 1

    val thePane = new ScrollPane {
      content = specGrid
      minWidth = 680
      prefWidth = specGrid.width.toDouble + 50
      minHeight = specGrid.height.toDouble + 50
    }
    thePane
  }

}
